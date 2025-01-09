package top.hyperplasma.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import top.hyperplasma.interceptor.JwtTokenAdminInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import top.hyperplasma.interceptor.JwtTokenUserInterceptor;
import top.hyperplasma.json.JacksonObjectMapper;

import java.util.List;

/**
 * 配置类，注册web层相关组件
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
    @Autowired
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    /**
     * 注册自定义拦截器
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器（管理端、用户端）...");

        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/employee/login");

        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/user/login")
                .excludePathPatterns("/user/shop/status");
    }

    /**
     * 通过knife4j生成接口文档（管理端）
     *
     * @return
     */
    @Bean
    public Docket docket1() {
        log.info("开始注册knife4j，准备生成接口文档（管理端）...");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Hyplus Foodie")
                .contact(new Contact("Akira37", "www.hyperplasma.top", "akira37@foxmail.com"))
                .license("Hyperplasma")
                .licenseUrl("www.hyperplasma.top")
                .version("1.0")
                .description("项目仓库：<a href=\"https://github.com/Akira37R/Hyplus-Foodie\" target=\"_blank\">Akira37R/Hyplus-Foodie</a>\n 官网：<a href=\"https://www.hyperplasma.top\" target=\"_blank\">www.hyperplasma.top</a>")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.hyperplasma.controller.admin"))    // 指定生成接口需要扫描的包（管理端）
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 通过knife4j生成接口文档（用户端）
     *
     * @return
     */
    @Bean
    public Docket docket2() {
        log.info("开始注册knife4j，准备生成接口文档（用户端）...");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Hyplus Foodie")
                .contact(new Contact("Akira37", "www.hyperplasma.top", "akira37@foxmail.com"))
                .license("Hyperplasma")
                .licenseUrl("www.hyperplasma.top")
                .version("1.0")
                .description("项目仓库：<a href=\"https://github.com/Akira37R/Hyplus-Foodie\" target=\"_blank\">Akira37R/Hyplus-Foodie</a>\n 官网：<a href=\"https://www.hyperplasma.top\" target=\"_blank\">www.hyperplasma.top</a>")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.hyperplasma.controller.user"))    // 指定生成接口需要扫描的包（用户端）
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置静态资源映射
     *
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始注册静态资源映射...");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 扩展Spring MVC框架的消息转换器
     *
     * @param converters
     */
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        // 创建消息转换器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // 为消息转换器设置对象转换器，底层使用Jackson将Java对象转为json（即序列化）
        converter.setObjectMapper(new JacksonObjectMapper());
        // 将消息转换器添加到转换器列表中（头插以优先使用）
        converters.add(0, converter);
    }
}
