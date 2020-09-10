package com.diy.sigmund.springbootmultipledatasources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMultipleDataSourcesApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultipleDataSourcesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>服务启动执行");
        showConnection();
    }

    /**
     * 默认使用HikariDataSource ；
     * TODO Driver does not support get/set network timeout for connections.
     * (oracle.jdbc.driver.T4CConnection.getNetworkTimeout()I)
     */
    private void showConnection() throws SQLException {
        System.out.println("dataSource:" + dataSource.getClass().getName());
        Connection connection = dataSource.getConnection();
        System.out.println("connection:" + connection.toString());
    }

}
