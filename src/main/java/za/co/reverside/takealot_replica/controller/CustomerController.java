package za.co.reverside.takealot_replica.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Service.CartData;
import za.co.reverside.takealot_replica.Service.CartService;
import za.co.reverside.takealot_replica.Service.CustomerService;
import za.co.reverside.takealot_replica.Service.MailSenderService;
import za.co.reverside.takealot_replica.Util.SessionUtils;
import za.co.reverside.takealot_replica.controller.Constants.ControllerConstants;


@RestController

public class CustomerController {

    private HttpSession session;
    private CustomerService customerService;
    private MailSenderService mailSenderService;
    private StringBuffer sb = new StringBuffer();

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
        Customer customer = customerService.validateUsers(userName, password);
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
    public String registerUser(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "emailAddress", required = true) String email,
            @ModelAttribute("customerForm") Customer customer, Model model,
            RedirectAttributes redir, HttpServletRequest request) {
        if (validateCustomer(userName, password) == null) {
            int result = customerService.registerUser(customer);
            if (result > 0) {
                sb.append("Hello " + customer.getUserName() + "\n");
                sb.append("Thank you for registering at eShopper.Happy Shopping!!\n");
                mailSenderService.sendEmail(
                        customer.getEmailAddress(), userName, sb.toString(),"Activation mail for "+userName);
            }
            redir.addFlashAttribute("result", result);
        } else {
            redir.addFlashAttribute("regStatus", "FAIL");
        }
        redir.addFlashAttribute("registerFlag", true);
        return "redirect:login";

    }

    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request, Model model) {
        Boolean registerFlag = (Boolean) model.asMap().get("registerFlag");
        Integer result = (Integer) model.asMap().get("result");
        if (registerFlag != null && registerFlag != false) {
            // String regStatus = (String) model.asMap().get("regStatus");
            if (result != null && result != 0) {
                return "redirect:successSignUp";
            } else {
                return "redirect:failureSignUp";
            }
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        session = SessionUtils.createSession(request);
        SessionUtils.removeSessionVariables("customer", request);
        session.invalidate();
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