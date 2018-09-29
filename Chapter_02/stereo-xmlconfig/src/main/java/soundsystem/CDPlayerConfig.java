package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoyang on 2018/7/16/0016.
 */

@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer CDPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
