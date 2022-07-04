package br.com.fcxlabs.project.test.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fcxlabs.project.test.ProjectTestApplication;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket api() {
		String pkgName = ProjectTestApplication.class.getPackage().getName();
        return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage(pkgName))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
        .title("FCxLabs Test")
        .description("FCxLabs Avaliation Rest Server")
        .version("0.0.1-SNAPSHOT")
        .build();
    }
    
}

