package spittr.db.jpa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spittr.db.JpaSpitterRepository;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import static org.junit.Assert.assertEquals;

/**
 * <p>Title: SpitterRepositoryTest</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-30
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class SpitterRepositoryTest {

    @Autowired
    SpitterRepository spitterRepository;

    @Test
    @Transactional
    public void testFindByUsername() {
        assertEquals(SPITTERS[0], spitterRepository.findByUsername("habuma"));
    }



    private static Spitter[] SPITTERS = new Spitter[6];

    @BeforeClass
    public static void before() {
        SPITTERS[0] = new Spitter(1L, "habuma", "password", "Craig Walls", "craig@habuma.com", false);
        SPITTERS[1] = new Spitter(2L, "mwalls", "password", "Michael Walls", "mwalls@habuma.com", true);
        SPITTERS[2] = new Spitter(3L, "chuck", "password", "Chuck Wagon", "chuck@habuma.com", false);
        SPITTERS[3] = new Spitter(4L, "artnames", "password", "Art Names", "art@habuma.com", true);
        SPITTERS[4] = new Spitter(5L, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        SPITTERS[5] = new Spitter(4L, "arthur", "letmein", "Arthur Names", "arthur@habuma.com", false);
    }
}