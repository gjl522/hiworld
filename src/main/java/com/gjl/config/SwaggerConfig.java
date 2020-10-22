package com.gjl.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /***
     * 创建API应用
     * apiInfo()增加相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，用来空置哪些接口暴露给swagger来展现
     */
    @Bean
    public Docket createRest(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
               // .apis(RequestHandlerSelectors.basePackage("com.gjl.config"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

    }
    /***
     * 创建swagger的基本信息
     * 访问地址： http://项目实际地址/swagger-ui.html
     */

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("测试文档接口")
                .description("更多请关注http://baidu.com")
                .termsOfServiceUrl("")
                .contact("58")
                .version("1.0")
                .build();
    }

}
