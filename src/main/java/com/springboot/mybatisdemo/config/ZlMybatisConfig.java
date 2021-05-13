package com.springboot.mybatisdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.mybatisdemo.dao.zl", sqlSessionTemplateRef = "zlSqlSessionTemplate")
public class ZlMybatisConfig {


    // DataSource有Primary注解标注的Bean，必须要指定某一个，不然注入的是@Primary的Bean
    @Bean("zlSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("zlDataSource") DataSource zlDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(zlDataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/zl/*.xml"));
        return factoryBean.getObject();
    }

    @Bean("zlSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Autowired @Qualifier("zlSqlSessionFactory") SqlSessionFactory zlSqlSessionFactory) {
        return new SqlSessionTemplate(zlSqlSessionFactory);
    }
}
