package com.item.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 	//config 파일이라고 명시함. 빈 설정 담당
@MapperScan(value="com.item.mapper.mysql", sqlSessionFactoryRef="masterSqlSessionFactory") 
@EnableTransactionManagement 
public class MasterDataBaseConfig {
	
	@Primary
	@Bean(name="masterDataSource")
	@ConfigurationProperties(prefix="spring.master.datasource")			//aplicaiton.yml에서 설정 가져옴
	public DataSource masterDataSource() {
		//application.properties에서 정의한 DB 연결 정보를 빌드
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="masterSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory(
		@Qualifier("masterDataSource") DataSource masterDataSource, ApplicationContext applicationContext) throws Exception{
		
		//세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다. 
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(masterDataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/master/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name="masterSqlSessionTemplate")
	public SqlSessionTemplate masterSqlSessionTemplate(SqlSessionFactory masterSqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(masterSqlSessionFactory);
	}
}