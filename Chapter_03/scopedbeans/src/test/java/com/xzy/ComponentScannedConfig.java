package com.xzy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author zhaoyang on 2018/9/4/0004.
 */
@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value=Configuration.class)})
public class ComponentScannedConfig {
}
