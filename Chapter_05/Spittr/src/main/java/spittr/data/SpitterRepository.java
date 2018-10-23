package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spitter;

/**
 * <p>Title: SpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-23
 **/
@Component
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}