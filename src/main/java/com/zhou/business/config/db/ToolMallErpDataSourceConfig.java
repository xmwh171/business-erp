package com.zhou.business.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
@MapperScan(basePackages = "com.zhou.business.dal.toolmall.mapper", sqlSessionFactoryRef = "toolMallSqlSessionFactory")
public class ToolMallErpDataSourceConfig {

    /**
     * 扫描的mapper包结构
     */
    private static final String PACKAGE_URL = "classpath:com/zhou/business/dal/toolmall/mapper/xml/*.xml";

    @Value("${spring.toolMallDatasource.url}")
    private String dbUrl;
    @Value("${spring.toolMallDatasource.username}")
    private String dbUser;
    @Value("${spring.toolMallDatasource.password}")
    private String dbPassWord;
    @Value("${spring.toolMallDatasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "toolMallDataSource")
    public DataSource toolMallDataSource() {
        DataSourceBuilder<HikariDataSource> dataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        return dataSourceBuilder.password(dbPassWord).url(dbUrl).username(dbUser).driverClassName(driverClassName).build();
    }

    @Bean(name = "toolMallTransactionManager")
    public DataSourceTransactionManager toolMallTransactionManager() {
        return new DataSourceTransactionManager(toolMallDataSource());
    }

    @Bean(name = "toolMallSqlSessionFactory")
    public SqlSessionFactory toolMallSqlSessionFactory(@Qualifier("toolMallDataSource") DataSource toolMallDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(toolMallDataSource);
        sessionFactory.setTypeAliasesPackage("com.zhou.business.dal.toolmall.entity");
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(ToolMallErpDataSourceConfig.PACKAGE_URL);
        sessionFactory.setMapperLocations(resources);

        return sessionFactory.getObject();
    }

    @Bean(name = "toolMallSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("toolMallSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
