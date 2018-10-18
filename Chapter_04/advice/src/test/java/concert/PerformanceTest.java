package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title: PerformanceTest</p>
 *
 * @description: 测试类
 * @author: xiongzy
 * @date: 2018-10-18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class PerformanceTest {

    @Autowired
    Performance performance;

    @Autowired
    AudienceForAround audience;

    @Autowired
    EncoreableIntroducer encoreableIntroducer;
    @Test
    public void testPerformance() {
        // audience.applause();
        performance.perform();
    }

}