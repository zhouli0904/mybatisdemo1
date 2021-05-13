package com.springboot.mybatisdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.mybatisdemo.dao.test", sqlSessionTemplateRef = "testSqlSessionTemplate")
public class TestMyBatisConfig {

    @Bean("testSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("testDataSource") DataSource testDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(testDataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/test/*.xml"));
        return factoryBean.getObject();
    }

    @Bean("testSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Autowired @Qualifier("testSqlSessionFactory") SqlSessionFactory testSqlSessionFactory) {
        return new SqlSessionTemplate(testSqlSessionFactory);
    }
}
