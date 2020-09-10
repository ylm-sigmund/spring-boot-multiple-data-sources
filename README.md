# spring-boot-multiple-data-sources

#### 介绍
- spring-boot 2.3.3.RELEASE 整合oracle、mysql多数据源
- 主数据源配置为web（oracle），其他为从数据源（oracle、mysql）
- 单元测试通过，支持查询，更新
- 数据源连接池由默认com.zaxxer.hikari.HikariDataSource改为org.apache.tomcat.jdbc.pool.DataSource
- tomcat连接池默认配置org.apache.tomcat.jdbc.pool.PoolProperties

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### TODO
- Driver does not support get/set network timeout for connections.

#### Log
- 2020-08-25 mybatis-config.xml配置文件无法设置databaseId属性，所以mybatis的配置使用的是配置类com.diy.sigmund.springbootmultipledatasources.config.mybatis.DefaultMyBatisConfig
- 2020-08-25 fix Invalid bound statement (not found)；集成mybatis-cofnig配置到deploy数据源，已支持全局变量，待优化代码
- 2020-08-23 初版，自定义多数据源，OK；整合mybatis-config.xml，配置全局变量，待解决报错

#### 资料参考
- [springboot整合mybatis（多数据源、mysql/Oracle数据库版）](https://blog.csdn.net/weixin_37769855/article/details/89335792)
- [springboot整合mybatis并配置多数据源](https://blog.csdn.net/weixin_44892460/article/details/108165933)
- [mybatis3.5.5资料](https://blog.csdn.net/qq_41907418/article/details/108230762)