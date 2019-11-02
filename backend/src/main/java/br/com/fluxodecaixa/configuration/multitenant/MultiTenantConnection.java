package br.com.fluxodecaixa.configuration.multitenant;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MultiTenantConnection implements MultiTenantConnectionProvider {

    private final DataSource dataSource;

    @Autowired
    public MultiTenantConnection(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenant) throws SQLException {
        final Connection connection = getAnyConnection();
        try {
            if (MultiTenantContext.getCurrentTenant() != null) {
                connection.setSchema(MultiTenantContext.getCurrentTenant());
            } else {
                connection.setSchema("public");
            }
        } catch (SQLException e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenant + "]", e);
        }
        return connection;
    }

    @Override
    public void releaseConnection(String tenant, Connection connection) throws SQLException {
        try {
            connection.setSchema("public");
        } catch (SQLException e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema public", e);
        }
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

}
