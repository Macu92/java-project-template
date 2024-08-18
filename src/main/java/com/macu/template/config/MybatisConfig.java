package com.macu.template.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(

  annotationClass = Mapper.class,
  basePackages = {"com.macu.template"},
  sqlSessionFactoryRef = "sqlSessionFactory"
)
@RequiredArgsConstructor
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisConfig {

  private final DataSource dataSource;
  private final ResourceLoader resourceLoader;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setVfs(SpringBootVFS.class);
    factoryBean.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
    factoryBean.setTypeAliasesPackage("com.selfup");
    return factoryBean.getObject();
  }
}
