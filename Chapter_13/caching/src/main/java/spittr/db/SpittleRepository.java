package spittr.db;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import spittr.domain.Spittle;

import java.util.List;

/**
 * <p>Title: SpittleRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-31
 **/
public interface SpittleRepository {

    long count();

    @Cacheable("spittleCache") //添加在接口上，其所有实现都有缓存功能
    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    @Cacheable("spittleCache")
    Spittle findOne(long id);

    @CachePut(value="spittleCache", key="#result.id")
    Spittle save(Spittle spittle);

    @Cacheable("spittleCache")
    List<Spittle> findBySpitterId(long spitterId);

    @CacheEvict(value="spittleCache",condition="") // condition值为false，禁用缓存
    void delete(long id);

}