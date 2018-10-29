package jdbc.data;

import jdbc.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>Title: JdbcSpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-29
 **/
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcOperations.queryForObject(SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbcOperations.queryForObject(SELECT_SPITTER + " where username=?", new SpitterRowMapper(), username);
    }

    @Override
    public long count() {
        return jdbcOperations.queryForObject("select count(id) from Spitter", Long.class);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullName"),
                    rs.getString("email"),
                    rs.getBoolean("updateByEmail")
            );
        }
    }

}