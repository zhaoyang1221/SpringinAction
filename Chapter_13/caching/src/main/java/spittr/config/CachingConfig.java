package spittr.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>Title: CachingConfig</p>
 *
 * @description: 缓存配置文件
 * @author: xiongzy
 * @date: 2018-10-31
 **/
@Configuration
@EnableCaching   // 启用缓存
public class CachingConfig {
    /**
     * spring 内置的五个缓存管理器的实现
     * SimpleCacheManager
     * NoOpCacheManager
     * ConcurrentMapCacheManager
     * CompositeCacheManager
     * EhCacheCacheManager
     *
     * @return
     */
    // @Bean
    // public CacheManager cacheManager() {
    //     return new ConcurrentMapCacheManager();  // 生命周期和应用一样，应用挂了，缓存也会消失
    // }
    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(
                new ClassPathResource("ehcache.xml")
        );
        return ehCacheManagerFactoryBean;
    }
}