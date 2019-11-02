package br.com.fluxodecaixa.configuration.multitenant;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MultiTenantConfig {

    private final DataSource dataSource;
    private final MultiTenantConnectionProvider multiTenantConnectionProvider;
    private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

    @Autowired
    public MultiTenantConfig(DataSource dataSource,
                             MultiTenantConnectionProvider multiTenantConnectionProvider,
                             CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
        this.dataSource = dataSource;
        this.multiTenantConnectionProvider = multiTenantConnectionProvider;
        this.currentTenantIdentifierResolver = currentTenantIdentifierResolver;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Properties properties = new Properties();
        properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
        properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
        properties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
        properties.put(Environment.NON_CONTEXTUAL_LOB_CREATION, true);

        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setDataSource(dataSource);
        result.setPackagesToScan("br.com.fluxodecaixa");
        result.setJpaVendorAdapter(jpaVendorAdapter());
        result.setJpaProperties(properties);

        return result;
    }

}
