package spring.boot.first.config.jpaOrder;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import spring.boot.first.config.AtomikosJtaPlatform;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "spring.boot.first.dao.dbOrder", entityManagerFactoryRef = "orderEntityManagerFactoryBean", transactionManagerRef = "transactionManager")
@EnableConfigurationProperties(OrderDatasourceProperties.class)
public class OrderConfig {

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private OrderDatasourceProperties orderDatasourceProperties;

	@Primary
	@Bean(name = "orderDataSource", initMethod = "init", destroyMethod = "close")
	public DataSource orderDataSource() {
		 MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		 mysqlXaDataSource.setUrl(orderDatasourceProperties.getUrl());
		 mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		 mysqlXaDataSource.setPassword(orderDatasourceProperties.getPassword());
		 mysqlXaDataSource.setUser(orderDatasourceProperties.getUsername());
		 mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		
		 AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		 xaDataSource.setXaDataSource(mysqlXaDataSource);
		 xaDataSource.setUniqueResourceName("xads2");
		 return xaDataSource;
	}

	@Primary
	@Bean(name = "orderEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean orderEntityManagerFactoryBean() throws Throwable {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
		properties.put("javax.persistence.transactionType", "JTA");

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(orderDataSource());
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setPackagesToScan("spring.boot.first.dao.dbOrder.po");
		entityManager.setPersistenceUnitName("orderPersistenceUnit");
		entityManager.setJpaPropertyMap(properties);
		return entityManager;
	}

	/*@DependsOn("orderEntityManagerFactoryBean")
	@Bean(name = "orderEntityManager")
	public EntityManager orderEntityManager() throws Throwable{
		return orderEntityManagerFactoryBean().getNativeEntityManagerFactory().createEntityManager();
	}*/
	
}
