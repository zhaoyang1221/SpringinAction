package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * <p>Title: SpittleRepository</p>
 *
 * @description: ${description}
 * @author: xiongzy
 * @date: 2018-10-19
 **/
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
