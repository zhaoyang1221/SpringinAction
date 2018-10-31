package spittr.db.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.RootConfig;
import spittr.db.SpitterRepository;
import spittr.db.SpittleRepository;
import spittr.domain.Spittle;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JdbcSpittleRepository Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/31/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class JdbcSpittleRepositoryTest {

    @Autowired
    private SpittleRepository spittleRepository;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: count()
     */
    @Test
    public void testCount() throws Exception {
        assertEquals(15, spittleRepository.count());
    }

    /**
     * Method: findRecent()
     */
    @Test
    public void testFindRecent() throws Exception {
        // default case
        {
            List<Spittle> recent = spittleRepository.findRecent();
            assertRecent(recent, 10);
        }

        // specific count case
        {
            List<Spittle> recent = spittleRepository.findRecent(5);
            assertRecent(recent, 5);
        }
    }

    /**
     * Method: findRecent(int count)
     */
    @Test
    public void testFindRecentCount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findOne(long id)
     */
    @Test
    public void testFindOne() throws Exception {
        Spittle thirteen = spittleRepository.findOne(13);
        assertEquals(13, thirteen.getId().longValue());
        assertEquals("Bonjour from Art!", thirteen.getMessage());
        assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
        assertEquals(4, thirteen.getSpitter().getId().longValue());
        assertEquals("artnames", thirteen.getSpitter().getUsername());
        assertEquals("password", thirteen.getSpitter().getPassword());
        assertEquals("Art Names", thirteen.getSpitter().getFullName());
        assertEquals("art@habuma.com", thirteen.getSpitter().getEmail());
        assertTrue(thirteen.getSpitter().isUpdateByEmail());
    }

    /**
     * Method: save(Spittle spittle)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findBySpitterId(long spitterId)
     */
    @Test
    public void testFindBySpitterId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(long id)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    private void assertRecent(List<Spittle> recent, int count) {
        long[] recentIds = new long[] {3,2,1,15,14,13,12,11,10,9};
        assertEquals(count, recent.size());
        for (int i = 0; i < count; i++) {
            assertEquals(recentIds[i], recent.get(i).getId().longValue());
        }
    }


} 
