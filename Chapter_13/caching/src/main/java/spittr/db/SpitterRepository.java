package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * <p>Title: SpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-31
 **/
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}
