package orders;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>Title: Item</p>
 *
 * @description: 未设置document注解，表示只是order的内嵌成员，不会持久化到文档中
 * @author: xiongzy
 * @date: 2018-10-31
 **/
public class Item {

    private Long id;

    private Order order;

    private String product;

    private double price;

    private int quantity;

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}