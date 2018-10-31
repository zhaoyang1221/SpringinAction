package orders.db;

import orders.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author zhaoyang on 2018/10/31/0031.
 *
 * mongoRepository可以提供内置的一些CRUD操作；
 * 另外，还可以添加自定义额查询方法，只需要满足spring data jpa 方法命名约束
 * 在运行时，任何扩展了Repository接口的将会自动生成实现。
 * 如下，我们只需声明这些满足约束的接口，无需给出实现。它们会由spring data mongoDB自动实现
 *
 */

public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations{

    List<Order> findByCustomer(String c);

    List<Order> findByCustomerLike(String c);

    List<Order> findByCustomerAndType(String c, String t);

    List<Order> findByCustomerLikeAndType(String c, String t);

    // 第一个动词不是固定的，find get read 都是同样的效果，都是查询
    List<Order> getByType(String type);

    /**
     * query注解可以为Repository方法指定自定义的查询。在mongoDB中，query会接受一个JSON查询，而不是JPA查询
     * ?0表示type属性与查询方法的第0个参数相等，即string t。
     * @return
     */
    @Query("{'customer' : 'Chuck Wagon', 'type': ?0}")
    List<Order> findChucksOrders(String t);
}
