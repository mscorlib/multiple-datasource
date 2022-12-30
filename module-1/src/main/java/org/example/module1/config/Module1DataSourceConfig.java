package org.example.module1.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"org.example.module1.mapper"}, sqlSessionTemplateRef = "module1SqlSessionTemplate")
public class Module1DataSourceConfig {
    @Bean(name = "module1DataSource")
    @Qualifier("module1DataSource")
    @ConfigurationProperties("spring.datasource.druid.module1")
    public DataSource module1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "module1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("module1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.example.module1.domain");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db1/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "module1TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("module1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "module1SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("module1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
