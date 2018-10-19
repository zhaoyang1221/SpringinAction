package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * <p>Title: SpittrWebAppInitializer</p>
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
}