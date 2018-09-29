package com.xzy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhaoyang on 2018/9/4/0004.
 * spring 的java 配置文件
 */
@Configuration
public class ExplicitConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notepad notepad() {
        return new Notepad();
    }

    public UniqueThing uniqueThing() {
        return new UniqueThing();
    }
}
