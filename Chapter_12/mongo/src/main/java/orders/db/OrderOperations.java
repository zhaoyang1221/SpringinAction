package orders.db;

import orders.Order;

import java.util.List;

/**
 * <p>Title: OrderOperations</p>
 *
 * @description: 混合自定义功能的中间接口
 * @author: xiongzy
 * @date: 2018-10-31
 **/
public interface OrderOperations {
    List<Order> findOrdersByType(String t);
}
