package net.codejava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("net.codejava"))
				.paths(PathSelectors.any())
				.build();
	}
	
	
//	http://localhost:8080/swagger-ui.html
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("This is new Swagger")
				.description("swagger info !!!!!!!!!!!!!!!!!!!!!!!!!!!!")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.contact(new Contact("","",""))
				.build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
