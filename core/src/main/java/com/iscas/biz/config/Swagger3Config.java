package com.iscas.biz.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2020/08/28
 * @since jdk1.8
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Value("${swagger.enable: true}")
    private boolean swaggerEnable;

    @Bean
    public Docket apiCore() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("基础")
                .apiInfo(apiInfo())
                .enable(swaggerEnable)
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.iscas.biz.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket apiBusiness() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("业务")
                .apiInfo(apiInfo())
                .enable(swaggerEnable)
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.iscas.supervision.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger3-文档")
                .description("")
                //服务条款网址
                //.termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                //.contact(new Contact("帅呆了", "url", "email"))
                .build();
    }
}
