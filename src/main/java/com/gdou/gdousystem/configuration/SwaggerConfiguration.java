package com.gdou.gdousystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Meng
 * @date 2019/12/22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo("工程教育专业认证信息管理系统接口"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gdou.gdousystem.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(String title){
        return new ApiInfoBuilder()
                .title(title)
                .description("工程教育专业认证信息管理系统")
                .version("1.0").build();
    }
}
