package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.*;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order, List<OrderItem> orderItemsList, AddressForm address);

    List<Product> readAllOrderItems(Order order);

    List<Order> readAllOrdersForCustomer(Customer customer);

    Order readOrderById(Long orderId);
}