package jdbc.data;

import jdbc.domain.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title: JdbcSpittleRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-29
 **/
@Repository
public class JdbcSpittleRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }

    @Override
    public void save(Spittle spittle) {

    }
}