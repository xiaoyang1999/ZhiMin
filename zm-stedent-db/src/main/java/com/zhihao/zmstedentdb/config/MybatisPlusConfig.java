package com.zhihao.zmstedentdb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis配置
 *
 * @Date 2017/5/20 21:58
 */
@MapperScan("com.zhihao.zmstedentdb.mapper")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisPlusConfig {



}

