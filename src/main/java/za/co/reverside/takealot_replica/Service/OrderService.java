package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Order;
import za.co.reverside.takealot_replica.Model.Product;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface OrderService {
    public Order createOrder(CartService cartService,
                             Customer customer, AddressForm address, HttpServletRequest request) throws ParseException;
    public List<Product> getAllOrderItems(Order order);

    public List<Order> getAllOrdersForCustomer(Customer customer);

    Order getOrderById(Long orderId);

}