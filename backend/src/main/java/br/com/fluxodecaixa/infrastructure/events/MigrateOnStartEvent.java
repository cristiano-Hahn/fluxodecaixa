package br.com.fluxodecaixa.infrastructure.events;

import br.com.fluxodecaixa.configuration.multitenant.MultiTenantContext;
import br.com.fluxodecaixa.domain.model.Empresa;
import br.com.fluxodecaixa.domain.repository.EmpresaRepository;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MigrateOnStartEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final DataSource dataSource;
    private final EmpresaRepository empresaRepository;

    @Autowired
    public MigrateOnStartEvent(DataSource dataSource,
                               EmpresaRepository empresaRepository) {
        this.dataSource = dataSource;
        this.empresaRepository = empresaRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Flyway.configure()
                .locations("db/migration/public")
                .dataSource(dataSource)
                .schemas("public")
                .baselineOnMigrate(true)
                .load()
                .migrate();

        List<Empresa> empresas = empresaRepository.findAll();

        for (Empresa empresa : empresas) {

            Flyway.configure()
                    .locations("db/migration/schema/ddl")
                    .table("flyway_ddl_history")
                    .dataSource(dataSource)
                    .schemas(empresa.getSchema())
                    .baselineOnMigrate(true)
                    .load()
                    .migrate();
        }

        if (empresas.size() == 1) {
            Flyway.configure()
                    .locations("db/migration/schema/initialdata")
                    .table("flyway_initialdata_history")
                    .dataSource(dataSource)
                    .schemas(empresas.get(0).getSchema())
                    .baselineOnMigrate(true)
                    .load()
                    .migrate();
        }
    }

}
