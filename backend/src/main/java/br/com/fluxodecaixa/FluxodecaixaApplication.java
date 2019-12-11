package br.com.fluxodecaixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "br.com.fluxodecaixa")
@ComponentScan("br.com.fluxodecaixa")
public class FluxodecaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxodecaixaApplication.class, args);
	}

}
