package za.co.reverside.takealot_replica.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.CustomerRepository;
import za.co.reverside.takealot_replica.Service.CartData;
import za.co.reverside.takealot_replica.Service.CartService;
import za.co.reverside.takealot_replica.Utils.SessionUtils;
import za.co.reverside.takealot_replica.controller.Constants.ControllerConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@RestController

public class CustomerController {

    private HttpServletRequest session;
    private CustomerRepository customerRepo;


    /**
     * This method used to Validate the customer and login to the application
     *
     * If the user wants to login after adding items into the shopping cart, by
     * clicking on Checkout Link, the user will be redirected to checkout page
     * else the user will be redirected to home page.
     *
     * @param model
     * @param request
     * @return checkout/home page
     */

    @PostMapping("/login")
    public String checkForUserLogin(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            Model model, HttpServletRequest request) {

        Customer customer = validateCustomer(userName, password);
        session = SessionUtils.createSession(request);
        CartService cartService = SessionUtils.getSessionVariables(request,
                "cartInfo");
        SessionUtils.setSessionVariables(customer, request, "customer");
        if (cartService != null && customer != null) {
            CartData cartData = SessionUtils.getSessionVariables(request, ControllerConstants.CART);
            int numberOfItems = cartService.getNumberOfItems(cartData);
            model.addAttribute("numberOfItems", numberOfItems);
            return "redirect:checkout";
        } else if (customer != null) {
            model.addAttribute("status", "home");
            return "redirect:home";
        } else {
            model.addAttribute("loginStatus", "fail");
        }
        return "redirect:login";

    }


    private Customer validateCustomer(String userName, String password) {
        Customer customer = customerRepo.validateUsers(userName, password);
        return customer;
    }

    /**
     * This method used to Register the Customer in Application On successfully
     * registration, a unique key will be generated and stored in the database.
     *
     * An Activation email is sent to the customer's emailID and if the user
     * clicks on the link which contains the activation key, the customer will
     * be activated.
     *
     * @param customer
     * @param model
     * @param request
     * @return login
     */

    @PostMapping("/register")
    public boolean registerUser(
            @ModelAttribute("customerForm") Customer customer) {

        return customerRepo.registerUser(customer);


    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) throws ServletException {
        session = SessionUtils.createSession(request);
        SessionUtils.removeSessionVariables("customer", request);
        session.logout();
        return "redirect:home";
    }

    @GetMapping("/successSignUp")
    public String signupSuccess(Model model) {
        model.addAttribute("result", 1);
        return "login";
    }

    @GetMapping("/failureSignUp")
    public String signupFailure(Model model) {
        model.addAttribute("result", 0);
        return "login";
    }

}