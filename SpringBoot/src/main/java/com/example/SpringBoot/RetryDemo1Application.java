package com.example.SpringBoot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value= {"com/example/SpringBoot/dao"})
public class RetryDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(RetryDemo1Application.class, args);
	}
	@Bean
	public SqlSessionFactory sqlSEssionFacoty(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
		sessionFactory.setMapperLocations(res);
		
		return sessionFactory.getObject();
				
	}

}