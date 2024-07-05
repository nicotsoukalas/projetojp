package br.com.nico.AppPessoaContatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("basicScheme",
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
								.scheme("basic")
								)
						)
				.info(
						new Info()
							.title("App de Cadastro de Pessoas e Contatos")
							.description("Este app faz controle de cadastro de pessoas e seus contatos.")
							.contact(new Contact()
									.name("Nicolaos de Freitas Tsoukalas")
									.email("nicotsoukalas@gmail.com")
									.url("http://localhost:8080")
									)
							.version("Versão 0.0.1-SNAPSHOT")
						);
				
				
	}
}
