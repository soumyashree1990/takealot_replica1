package za.co.reverside.takealot_replica.Repository.Impl;

import za.co.reverside.takealot_replica.Model.*;
import za.co.reverside.takealot_replica.Repository.OrderRepository;

import java.util.List;

public class OrderRepositoryHibernateImpl implements OrderRepository {

    @Override
    public void createOrder(Order order, List<OrderItem> orderItemsList,
                            AddressForm address) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Product> readAllOrderItems(Order order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Order> readAllOrdersForCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order readOrderById(Long orderId) {
        // TODO Auto-generated method stub
        return null;
    }

}