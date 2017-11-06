package za.co.reverside.takealot_replica.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Service.AddressService;
import za.co.reverside.takealot_replica.Service.CartService;
import za.co.reverside.takealot_replica.Util.SessionUtils;

@RestController
public class CheckoutController {

    private CartService cartService;
    //	@Autowired
//	private ProductConfigService productService;
    private AddressService addressService;
//	@Autowired
//	private PaymentService paymentService;

    private HttpSession session;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView checkOutCart(Model model, HttpServletRequest request) {
        session = SessionUtils.createSession(request);
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
//			SessionUtils.setSessionVariables(cartService,request,"cart");
//			int numberOfItems = cartService.getNumberOfItems();
//			model.addAttribute("prodList", cartService.getProductsList());
//			model.addAttribute("numberOfItems", numberOfItems);
            return new ModelAndView("checkout");
        } else {
            SessionUtils.setSessionVariables(cartService,request,"cartInfo");
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String validateAddressInformation(
            @ModelAttribute("addressForm") AddressForm address, Model model,
            HttpServletRequest request) {
        String fullName = request.getParameter("fullName");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zipCode");
        String state = request.getParameter("state");

        address.setFullName(fullName);
        address.setAddress1(address1);
        address.setAddress2(address2);
        address.setCity(city);
        address.setZipCode(zipCode);
        address.setState(state);
        session = SessionUtils.createSession(request);
        Customer customer = SessionUtils.getSessionVariables(request, "customer");
        addressService.saveAddress(address, customer);
        SessionUtils.setSessionVariables(address, request, "address");
//		model.addAttribute("prodList", cartService.getProductsList());
        return "redirect:checkout";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String getPaymentForm(Model model, HttpServletRequest request) {
        return "payment";
    }

}