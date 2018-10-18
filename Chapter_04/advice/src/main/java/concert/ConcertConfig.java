package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>Title: ConcertConfig</p>
 *
 * @description: 配置类
 * @author: xiongzy
 * @date: 2018-10-18
 **/
@Configuration
@EnableAspectJAutoProxy // 启用AspectJ自动代理
@ComponentScan
public class ConcertConfig {
    @Bean
    public Performance performance() {
        return new Performer();
    }

    // @Bean
    // public Audience audience() {
    //     return new Audience();
    // }

    @Bean
    public AudienceForAround audienceForAround() {
        return new AudienceForAround();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}