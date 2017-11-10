package za.co.reverside.takealot_replica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Order;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Service.AddressService;
import za.co.reverside.takealot_replica.Service.OrderService;
import za.co.reverside.takealot_replica.Utils.SessionUtils;

@RestController
public class OrderHistoryController {

    private static String orderHistoryPage = "template/ordersList";
    private static String orderDetailsPage = "template/orderDetails";
    @SuppressWarnings("unused")
    private HttpSession session;
    private OrderService orderService;
    private AddressService addressService;

    @GetMapping("/orderHistory")
    public String getOrderHistoryPage(HttpServletRequest request, Model model) {
        model.addAttribute("page", orderHistoryPage);
        session = SessionUtils.createSession(request);
        Customer customer = SessionUtils.getSessionVariables(request, "customer");
        if (customer != null) {
            List<Order> orderList = orderService
                    .getAllOrdersForCustomer(customer);
            Map<List<Order>, List<Product>> orderMap = new HashMap<List<Order>, List<Product>>();
            for (Order o : orderList) {
                List<Product> orderItemsList = orderService.getAllOrderItems(o);
                orderMap.put(orderList, orderItemsList);
            }
            model.addAttribute(orderList);
        }
        return "account";
    }

    @GetMapping("/orderDetail")
    public String getOrderDetails(HttpServletRequest request, Model model,
                                  @RequestParam(value = "id") Long id) {
        Order order = orderService.getOrderById(id);
        AddressForm address = addressService.getAddressById(order
                .getAddressId());
        List<Product> orderItemsList = orderService.getAllOrderItems(order);
        model.addAttribute("order", order);
        model.addAttribute("addressDetails", address);
        model.addAttribute("orderItemsList", orderItemsList);
        model.addAttribute("page", orderDetailsPage);
        return "account";
    }

}