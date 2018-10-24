package spittr.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.IOException;

;

/**
 * <p>Title: WebConfig</p>
 *
 * @description: dispatchServlet配置类
 * @author: xiongzy
 * @date: 2018-10-19
 **/

@Configuration
@EnableWebMvc //启用SpringMvc
@ComponentScan("spittr.web") //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // // 配置jsp视图解析器
    // @Bean
    // public ViewResolver viewResolver() {
    //     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    //     resolver.setPrefix("/WEB-INF/views/");
    //     resolver.setSuffix(".jsp");
    //     resolver.setExposeContextBeansAsAttributes(true);
    //     return resolver;
    // }

    /**
     * Thymeleaf视图解析器
     *
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    /**
     * 模板引擎
     *
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 模板解析器
     * springResourceTemplateResolver 是3.0版本的新特性对spring资源优先用这个
     */
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    // 配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 处理文件上传
     *
     * 从Spring 3.1开始，Spring内置了两个MultipartResolver的实现供我们选择:
     * 1. CommonsMultipartResolver：使用Jakarta Commons FileUpload解析multipart请求;
     * 2. StandardServletMultipartResolver：依赖于Servlet 3.0对multipart请求的支持（始于Spring 3.1）;
     *
     * 如果我们需要将应用部署到Servlet 3.0之前的容器中，或者还没有使用Spring 3.1或更高版本，那么可能就需要
     * CommonsMultipartResolver了
     *
     * 另外，必须在web.xml或者Servlet初始化类中，将multipart的具体配置细节作为DispatcherServlet配置的一部分
     * 否则，multipart无法工作
     *
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
    }

    // @Bean
    // public MultipartResolver multipartResolver() throws IOException {
    //     CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    //     multipartResolver.setUploadTempDir(
    //             new FileSystemResource("/tmp/spittr/uploads"));
    //     return multipartResolver;
    // }
}