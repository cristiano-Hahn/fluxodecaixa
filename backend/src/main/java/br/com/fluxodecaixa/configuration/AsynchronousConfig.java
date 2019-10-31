package br.com.fluxodecaixa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsynchronousConfig extends AsyncConfigurerSupport {

    private final ApplicationProperties applicationProperties;

    @Autowired
    public AsynchronousConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(applicationProperties.getAsyncCorePoolSize());
        executor.setMaxPoolSize(applicationProperties.getAsyncMaxPoolSize());
        executor.setQueueCapacity(applicationProperties.getAsyncQueueCapacity());
        executor.setThreadNamePrefix("fluxodecaixa-executor-");
        executor.initialize();
        return executor;
    }

}
