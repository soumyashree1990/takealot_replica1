package za.co.reverside.takealot_replica.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.ReviewForm;
import za.co.reverside.takealot_replica.Service.CartData;
import za.co.reverside.takealot_replica.Service.CustomerService;
import za.co.reverside.takealot_replica.Service.ProductConfigService;
import za.co.reverside.takealot_replica.Service.ReviewService;
import za.co.reverside.takealot_replica.Util.SessionUtils;
import za.co.reverside.takealot_replica.controller.Constants.ControllerConstants;


@RestController
public class ProductController {

    //	@Autowired
//	private CartService cartService;

    private ProductConfigService productConfigurationService;
    //	@Autowired
//	private CategoryConfigService categoryConfigurationService;

    private ReviewService reviewService;

    private CustomerService customerService;

    /**
     * Product Controller method which retrieves the information required in the
     * product page
     *
     *
     * @param Model
     * @param ProductId
     * @return Product Page View
     * @throws ParseException
     */
    @GetMapping(value = "/product/{productId}")
    public String handleRequest(Model model,
                                @RequestParam(value = "productId") Long productId,
                                HttpServletRequest request) throws ParseException {
        Product product = productConfigurationService.getProductById(productId);
        model.addAttribute("product", product);

        CartData cartData = SessionUtils.getSessionVariables(request,ControllerConstants.CART);
        if(cartData != null)
            model.addAttribute(ControllerConstants.NUMBER_OF_ITEMS, cartData.getNumberOfItems());

        Customer customer = SessionUtils.getSessionVariables(request,
                ControllerConstants.CUSTOMER);
        // Retrieve Reviews of a particular product
        Map<Customer, ReviewForm> reviewMap = new HashMap<Customer, ReviewForm>();
        if (customer != null) {
            List<ReviewForm> reviewsList = reviewService
                    .getProductReviews(productId);
            for (ReviewForm reviewForm : reviewsList) {
                String customerId = reviewForm.getCustomerId();
                reviewMap.put(customerService.getCustomerById(customerId),
                        reviewForm);
            }
            model.addAttribute("reviewsList", reviewMap);
        }
        return "product";
    }
}