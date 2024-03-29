package com.monteiro.gerenciador.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
        		.select()
				.apis(RequestHandlerSelectors.basePackage("com.monteiro.gerenciador.api"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
    }
    public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Gerenciador API")
				.description("API aberta para gerenciamento de pessoas")
				.version("1")
				.contact(new Contact("Gerenciador de Pessoas", "https://www.monteiro.com", "juniormonteiroti@gmail.com"))
				.build();
	}

}
