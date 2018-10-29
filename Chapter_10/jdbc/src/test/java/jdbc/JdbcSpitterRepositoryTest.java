package jdbc;

import jdbc.config.JdbcConfig;
import jdbc.data.JdbcSpitterRepository;
import jdbc.domain.Spitter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * <p>Title: JdbcSpitterRepositoryTest</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-29
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcSpitterRepositoryTest {

    @Autowired
    JdbcSpitterRepository spitterRepository;

    @Test
    public void count() {
        assertEquals(4, spitterRepository.count());
    }

    @Test
    @Transactional
    public void findOne() {
        assertEquals(SPITTERS[0], spitterRepository.findOne(1L));
    }

    @Test
    @Transactional
    public void findByUsername() {
        assertEquals(SPITTERS[0], spitterRepository.findByUsername("habuma"));
        assertEquals(SPITTERS[1], spitterRepository.findByUsername("mwalls"));
        assertEquals(SPITTERS[2], spitterRepository.findByUsername("chuck"));
        assertEquals(SPITTERS[3], spitterRepository.findByUsername("artnames"));
    }

    private static Spitter[] SPITTERS = new Spitter[6];

    @BeforeClass
    public static void before() {
        SPITTERS[0] = new Spitter(1L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);
        SPITTERS[1] = new Spitter(2L, "mwalls", "password", "Michael Walls",
                "mwalls@habuma.com", true);
        SPITTERS[2] = new Spitter(3L, "chuck", "password", "Chuck Wagon",
                "chuck@habuma.com", false);
        SPITTERS[3] = new Spitter(4L, "artnames", "password", "Art Names",
                "art@habuma.com", true);
        SPITTERS[4] = new Spitter(5L, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        SPITTERS[5] = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);
    }



}