package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * <p>Title: SpittrWebAppInitializer</p>
 *
 * 支持servlet3.0的容器是可以通过重写AbstractAnnotationConfigDispatcherServletInitializer类来实现注册Servlet、
 * Filter和Listener，而不必创建web.xml文件。
 *
 * 若容器不支持servlet3.0或者只是想通过传统的web.xml来注册，则需要在web.xml文件中配置DispatcherServlet等
 *
 * 个人感觉，这个类就等价于web.xml文件，都用来加载spring-mvc和applicationContext配置项等
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-19
 **/
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     *  应用上下文 ContextLoaderListener 配置类
     *  通常是驱动应用后端的中间层和数据层组件
     *
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     *  DispatchServlet 配置类
     *  DispatchServlet加载应用上下文时，使用定义在WebConfig配置类中的bean
     *  Web组件的bean，如控制器、视图解析器以及处理器映射
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 启用multipart，配合WebConfig.java中的multipart Bean使用
     * 设置上传文件的临时储存目录
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0)
        );
    }

    /*
     * 注册Filter到DispatchServlet
     */
    // @Override
    // protected Filter[] getServletFilters() {
    //     return new Filter[] {new myFilter()};
    // }
}