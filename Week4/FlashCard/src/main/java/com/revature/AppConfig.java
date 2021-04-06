package com.revature;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
public class AppConfig {

	// DataSource info
	public static final String DATASOURCE_SCHEMA = System.getenv("POS_DB_SCHEMA");
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("POS_DB_URL") + ":5432/"
			+ System.getenv("FLASH_CARD_DB_NAME") + "?currentSchema=" + DATASOURCE_SCHEMA;
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
	public static final String DATASOURCE_USERNAME = System.getenv("POS_DB_USERNAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("POS_DB_PASSWORD");

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		System.out.println(DATASOURCE_URL);
		PoolingDataSource dataSource = new PoolingDataSource();
		dataSource.setClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUniqueName("PostGresDB");
		dataSource.setMaxPoolSize(10);
		dataSource.setAllowLocalTransactions(true);
		dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
		dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
		dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
		dataSource.init();
		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}

	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	@Bean
	public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(primaryTransactionManager);
		return jtaTransactionManager;
	}

}
