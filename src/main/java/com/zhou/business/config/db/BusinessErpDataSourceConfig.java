package com.zhou.business.config.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 10:44
 */
@Configuration
@MapperScan(basePackages = "com.zhou.business.dal.business.mapper", sqlSessionFactoryRef = "businessSqlSessionFactory")
public class BusinessErpDataSourceConfig {

    /**
     * 扫描的mapper包结构
     */
    private static final String PACKAGE_URL = "classpath:com/zhou/business/dal/business/mapper/xml/*.xml";

    @Value("${spring.businessDatasource.url}")
    private String dbUrl;
    @Value("${spring.businessDatasource.username}")
    private String dbUser;
    @Value("${spring.businessDatasource.password}")
    private String dbPassWord;
    @Value("${spring.businessDatasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "businessDataSource")
    @LiquibaseDataSource
    public DataSource businessDataSource() {
        DataSourceBuilder<HikariDataSource> dataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        HikariConfig hikariConfig = dataSourceBuilder.password(dbPassWord).url(dbUrl).username(dbUser).driverClassName(driverClassName).build();
        hikariConfig.setConnectionTestQuery("SELECT 1");
        return (DataSource)hikariConfig;
    }

    @Bean(name = "businessTransactionManager")
    public DataSourceTransactionManager businessTransactionManager() {
        return new DataSourceTransactionManager(businessDataSource());
    }

    @Bean(name = "businessSqlSessionFactory")
    @Primary
    public SqlSessionFactory businessSqlSessionFactory(@Qualifier("businessDataSource") DataSource businessDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(businessDataSource);
        sessionFactory.setTypeAliasesPackage("com.zhou.business.dal.business.entity");
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(BusinessErpDataSourceConfig.PACKAGE_URL);
        sessionFactory.setMapperLocations(resources);

        return sessionFactory.getObject();
    }

    @Bean(name = "businessSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("businessSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}