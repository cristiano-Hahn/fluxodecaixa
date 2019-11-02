package br.com.fluxodecaixa.configuration.multitenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class MultiTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = MultiTenantContext.getCurrentTenant();
        if (tenant != null) {
            return tenant;
        }
        return "public";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
