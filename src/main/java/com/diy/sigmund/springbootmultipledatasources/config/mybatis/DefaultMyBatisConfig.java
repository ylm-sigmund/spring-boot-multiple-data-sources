package com.diy.sigmund.springbootmultipledatasources.config.mybatis;

import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.AutoMappingUnknownColumnBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;

/**
 * @author ylm-sigmund
 * @since 2020/8/25 21:55
 */
public class DefaultMyBatisConfig {

    public static final String ORACLE = "oracle";
    public static final String MYSQL = "mysql";

    /**
     * mybatis配置数据
     * 
     * @param databaseId
     *            databaseId
     * @return Configuration
     */
    public static Configuration getDefaultConfiguration(String databaseId) {
        Configuration configuration = new Configuration();
        setSettings(configuration);
        setVariables(configuration);
        configuration.setDatabaseId(databaseId);
        return configuration;
    }

    private static void setSettings(Configuration configuration) {
        configuration.setCacheEnabled(true);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMultipleResultSetsEnabled(true);
        configuration.setUseColumnLabel(true);
        configuration.setUseGeneratedKeys(false);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
        configuration.setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior.WARNING);
        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
        configuration.setDefaultStatementTimeout(30);
        configuration.setDefaultFetchSize(200);
        configuration.setSafeRowBoundsEnabled(false);
        configuration.setMapUnderscoreToCamelCase(false);
        configuration.setLocalCacheScope(LocalCacheScope.SESSION);
        configuration.setJdbcTypeForNull(JdbcType.OTHER);
        configuration.setLazyLoadTriggerMethods(
            Stream.of("equals", "clone", "hashCode", "toString").collect(Collectors.toSet()));
    }

    /**
     * 设置mybatis全局变量
     * 
     * @param configuration
     *            configuration
     */
    private static void setVariables(Configuration configuration) {
        Properties properties = new Properties();
        properties.setProperty("web", "web.");
        configuration.setVariables(properties);
    }
}
