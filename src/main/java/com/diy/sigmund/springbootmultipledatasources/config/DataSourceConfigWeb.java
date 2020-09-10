package com.diy.sigmund.springbootmultipledatasources.config;

import javax.sql.DataSource;

import com.diy.sigmund.springbootmultipledatasources.config.mybatis.DefaultMyBatisConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 主数据源配置 basePackages：mapper java文件所在包 sqlSessionTemplateRef：表示mapper使用的SqlSessionTemplate
 * 
 * @author ylm-sigmund
 * @since 2020/8/19 21:54
 */
@Configuration
@MapperScan(basePackages = "com.diy.sigmund.springbootmultipledatasources.mapper.web",
    sqlSessionTemplateRef = "webSqlSessionTemplate")
public class DataSourceConfigWeb {

    /**
     * Bean注解：定义bean名称 ConfigurationProperties注解：自定义数据源前缀
     * Primary注解：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者（主库）,否则将抛出异常;从库不需要加该注解
     * 
     * @return DataSource
     */
    @Bean(name = "webDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.web")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 给一份mapper文件路径
     *
     * @param dataSource
     *            dataSource
     * @return SqlSessionFactory
     * @throws Exception
     *             Exception
     */
    @Bean(name = "webSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("webDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/web/*.xml"));
        //设置mybatis配置数据
        bean.setConfiguration(DefaultMyBatisConfig.getDefaultConfiguration(DefaultMyBatisConfig.ORACLE));
        return bean.getObject();
    }

    /**
     * 创建事务
     */
    @Bean(name = "webTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("webDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 用于注入mapper
     * 
     * @param sqlSessionFactory
     *            sqlSessionFactory
     * @return SqlSessionTemplate
     * @throws Exception
     *             Exception
     */
    @Bean(name = "webSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("webSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
        throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
