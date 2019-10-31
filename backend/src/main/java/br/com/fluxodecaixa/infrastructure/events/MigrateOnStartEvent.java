package br.com.fluxodecaixa.infrastructure.events;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MigrateOnStartEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final DataSource dataSource;

    @Autowired
    public MigrateOnStartEvent(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Flyway.configure()
            .locations("db/migration/public")
            .dataSource(dataSource)
            .schemas("public")
            .load()
            .migrate();
    }

}
