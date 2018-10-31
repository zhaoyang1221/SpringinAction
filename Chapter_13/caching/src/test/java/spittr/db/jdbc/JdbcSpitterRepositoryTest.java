package spittr.db.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.RootConfig;
import spittr.db.SpitterRepository;
import spittr.db.SpittleRepository;
import spittr.domain.Spitter;

import static org.junit.Assert.assertEquals;

/**
 * JdbcSpitterRepository Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/31/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class JdbcSpitterRepositoryTest {

    @Autowired
    private SpitterRepository spitterRepository;

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

    @After
    public void after() throws Exception {
    }

    /**
     * Method: count()
     */
    @Test
    public void testCount() throws Exception {
        assertEquals(4, spitterRepository.count());
    }

    /**
     * Method: save(Spitter spitter)
     */
    @Test
    public void testSave() throws Exception {
    }

    /**
     * Method: findOne(long id)
     */
    @Test
    public void testFindOne() throws Exception {
    }

    /**
     * Method: findByUsername(String username)
     */
    @Test
    public void testFindByUsername() throws Exception {
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
    }


} 
