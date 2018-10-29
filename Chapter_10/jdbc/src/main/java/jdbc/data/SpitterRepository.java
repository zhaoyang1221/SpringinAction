package jdbc.data;


import jdbc.domain.Spitter;

/**
 * <p>Title: SpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-23
 **/
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    long count();


}