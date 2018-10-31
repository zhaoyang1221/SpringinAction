package orders.db;

import orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * <p>Title: OrderRepositoryImpl</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-31
 **/
public class OrderRepositoryImpl implements OrderOperations {
    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findOrdersByType(String t) {
        String type = t.equals("NET") ? "WEB" : t;

        // 创建查询
        Criteria where = Criteria.where("type").is(t);
        Query query = Query.query(where);

        // 执行
        return mongo.find(query, Order.class);
    }
}