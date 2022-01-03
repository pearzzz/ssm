package com.pearz.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:50 2022/1/3
 */

@Configuration
@ComponentScan(basePackages = {"com.pearz.annotation"})
public class SpringConfig {
}
