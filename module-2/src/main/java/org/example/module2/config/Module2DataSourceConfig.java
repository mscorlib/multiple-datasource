package org.example.module2.config;

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
@MapperScan(basePackages = {"org.example.module2.mapper"}, sqlSessionTemplateRef = "module2SqlSessionTemplate")
public class Module2DataSourceConfig {
    @Bean(name = "module2DataSource")
    @Qualifier("module2DataSource")
    @ConfigurationProperties("spring.datasource.druid.module2")
    public DataSource module2() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "module2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("module2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.example.module2.domain");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db2/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "module2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("module2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "module2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("module2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
