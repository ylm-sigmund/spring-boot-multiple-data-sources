package com.diy.sigmund.springbootmultipledatasources.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.diy.sigmund.springbootmultipledatasources.config.mybatis.DefaultMyBatisConfig;

/**
 * 从数据源配置
 * basePackages：mapper java文件所在包
 * sqlSessionTemplateRef：表示mapper使用的SqlSessionTemplate
 *
 * @author ylm-sigmund
 * @since 2020/8/19 21:54
 */
@Configuration
@MapperScan(basePackages = "com.diy.sigmund.springbootmultipledatasources.mapper.deploy",
    sqlSessionTemplateRef = "deploySqlSessionTemplate")
public class DataSourceConfigDeploy {

    /**
     * Bean注解：定义bean名称
     * ConfigurationProperties注解：自定义数据源前缀
     *
     * @return DataSource
     */
    @Bean(name = "deployDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.deploy")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 给一份mapper文件路径
     *
     * @param dataSource dataSource
     * @return SqlSessionFactory
     * @throws Exception Exception
     */
    @Bean(name = "deploySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("deployDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:mapper/deploy/*.xml"));
        // 设置mybatis配置数据
        bean.setConfiguration(DefaultMyBatisConfig.getDefaultConfiguration(DefaultMyBatisConfig.ORACLE));
        return bean.getObject();
    }

    /**
     * 创建事务
     */
    @Bean(name = "deployTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("deployDataSource") DataSource dataSource) {
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
    @Bean(name = "deploySqlSessionTemplate")
    public SqlSessionTemplate
        sqlSessionTemplate(@Qualifier("deploySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
