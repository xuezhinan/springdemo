package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//启动事务的注解
@EnableTransactionManagement
//@PropertySource("classpath:"),这个注解可以指定启动时加载的配置文件
//必须加上下面的注解，以扫描到Controller的注解,注意写多个包时候的格式
@ComponentScan({"com.example.controller","com.example.pojo","com.example.service.impl"})
//这里添加basePackages 会出现异常 ，这个注解不能少，自动生成mapper实现类
@MapperScan("com.example.mapper")
//如果配置文件不在默认的位置，就要加上下面这个注解指定配置文件的位置
//@PropertySource("classpath:")
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }
}
