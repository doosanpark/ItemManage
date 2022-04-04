package com.item.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
 
    @Autowired
    @Qualifier(value = "bootdb1DataSource")
    private DataSource bootdb1DataSource;
 
    @Autowired
    @Qualifier(value = "bootdb2DataSource")
    private DataSource bootdb2DataSource;
 
    @Bean
    @Primary
    public SqlSessionFactory bootdb1SqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(bootdb1DataSource);
        /* 맵퍼 xml 파일 경로 설정 */
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
 
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
 
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(true);
 
        return sqlSessionFactory;
    }
 
    @Bean
    public SqlSessionFactory bootdb2SqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(bootdb2DataSource);
        /* 맵퍼 xml 파일 경로 설정 */
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
 
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
 
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(true);
 
        return sqlSessionFactory;
    }
 
    @Bean
    @Primary
    public SqlSession bootdb1SqlSession() throws Exception {
        return new SqlSessionTemplate(bootdb1SqlSessionFactoryBean());
    }
 
    @Bean
    public SqlSession bootdb2SqlSession() throws Exception {
        return new SqlSessionTemplate(bootdb2SqlSessionFactoryBean());
    }
}