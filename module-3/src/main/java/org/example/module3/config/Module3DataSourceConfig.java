package org.example.module3.config;

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
@MapperScan(basePackages = {"org.example.module3.mapper"}, sqlSessionTemplateRef = "module3SqlSessionTemplate")
public class Module3DataSourceConfig {
    @Bean(name = "module3DataSource")
    @Qualifier("module3DataSource")
    @ConfigurationProperties("spring.datasource.druid.module3")
    public DataSource module3() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "module3SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("module3DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.example.module3.domain");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db3/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "module3TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("module3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "module3SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("module3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
