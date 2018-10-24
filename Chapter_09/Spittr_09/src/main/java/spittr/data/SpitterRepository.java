package spittr.data;

import spittr.Spitter;

/**
 * <p>Title: SpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-23
 **/
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}