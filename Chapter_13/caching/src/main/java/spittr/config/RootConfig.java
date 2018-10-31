package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>Title: RootConfig</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-31
 **/
@Configuration
@ComponentScan("spittr.db")
@Import({DataConfig.class, CachingConfig.class})
public class RootConfig {

}
