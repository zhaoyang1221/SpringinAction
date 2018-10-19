package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p>Title: RootConfig</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-19
 **/
@Configuration
@ComponentScan(basePackages = {"spittr"},
        excludeFilters = {
        @Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {
}