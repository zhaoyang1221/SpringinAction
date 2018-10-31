package orders;

import orders.config.MongoConfig;
import orders.db.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * <p>Title: MongoDbTest</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MongoDbTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Before
    public void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    public void testMongoRepository() {
        assertEquals(0, orderRepository.count());

        Order order = createAnOrder();
        Order saveOrder = orderRepository.save(order);
        assertEquals(1, orderRepository.count());

        Order findOrder = orderRepository.findOne(saveOrder.getId());
        assertEquals("Chuck Wagon", findOrder.getCustomer());
        assertEquals(2, findOrder.getItems().size());
        System.out.println(findOrder);
    }

    private Order createAnOrder() {
        Order order = new Order();
        order.setCustomer("Chuck Wagon");
        order.setType("WEB");
        Item item1 = new Item();
        item1.setProduct("Spring in Action");
        item1.setQuantity(2);
        item1.setPrice(29.99);
        Item item2 = new Item();
        item2.setProduct("Module Java");
        item2.setQuantity(31);
        item2.setPrice(29.95);
        order.setItems(Arrays.asList(item1, item2));
        return order;
    }
}