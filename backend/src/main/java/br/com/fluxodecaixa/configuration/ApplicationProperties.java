package br.com.fluxodecaixa.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private int asyncCorePoolSize;

    private int asyncMaxPoolSize;

    private int asyncQueueCapacity;

}
