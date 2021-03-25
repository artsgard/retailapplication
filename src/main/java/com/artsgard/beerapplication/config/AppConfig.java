
package com.artsgard.beerapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


@Configuration
@EnableSwagger2 //http://localhost:8085/retailApplication/swagger-ui.html
@Import(BeanValidatorPluginsConfiguration.class) // javax.validation not working with swagger2
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("beer")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.artsgard.beerapplication"))
                //.paths(postPaths())
                //.paths( PathSelectors.any())
                .paths(PathSelectors.ant("/beer/**")) //swagger-ui.html#
                //.paths(PathSelectors.regex("/beer.*"))
                .build()
                .apiInfo(info())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("German Beer API")
                .description("Beer API reference for developers")
                .termsOfServiceUrl("http://artsgard.com")
                .licenseUrl("wfdragstra@gmail.com").version("1.0").build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}