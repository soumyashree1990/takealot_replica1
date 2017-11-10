package za.co.reverside.takealot_replica.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Service.CartData;
import za.co.reverside.takealot_replica.Service.CartService;
import za.co.reverside.takealot_replica.Utils.SessionUtils;
import za.co.reverside.takealot_replica.controller.Constants.ControllerConstants;

@RestController
public class CartController {

    private CartService cartService;
//	@Autowired
//	private ProductConfigService productService;
//	@Autowired
//	private WishListService wishListService;
//	@Autowired
//	private CartData cartData;

    private final static String cartPage = "cart";
    private final static String redirectView = "redirect:/cart";

    /**
     * Method to Add Products to the Shopping Cart First Check if the Product is
     * available in the Wishlist, if available, remove the product from Wishlist
     *
     * @param ProductID
     * @param HttpServletRequest
     * @return Product Page View
     */
    @GetMapping("/addProduct")
    public String addProducts(Model model,
                              @RequestParam(value = "productId") Long productId,
                              HttpServletRequest request) {
        // When a customer adds a product to the cart, we have to check
        // if he is a registered or an anonymous customer.
        Customer customer = SessionUtils.getSessionVariables(request,
                ControllerConstants.CUSTOMER);
        if (customer != null) {
            // Customer is anonymous, so create a shared cart and add it to
            // session
            // Creates a new cart for the anonymous customer
            CartData anonymousCartData = cartService.getShoppingCart();
            SessionUtils.setSessionVariables(anonymousCartData, request,
                    ControllerConstants.CART);
            cartService.addProduct(anonymousCartData, productId);
        } else {

            CartData customerCartData = null;
            customerCartData = SessionUtils.getSessionVariables(request,
                    ControllerConstants.CART);
            if (customerCartData == null) {
                customerCartData = cartService.getShoppingCart();
                SessionUtils.setSessionVariables(customerCartData, request,
                        ControllerConstants.CART);
                cartService.addProduct(customerCartData, productId);
            } else {
                cartService.addProduct(customerCartData, productId);
            }
            // TODO: Extend the add to cart functionality

            // When the customer is registered, cart contents must be
            // stored in the database, and stored in the session.
        }
        return getRedirectview();

    }

    /**
     * Method to View the Items of Shopping Cart Retrieves the items to display
     * in the shopping cart page
     *
     * @param Model
     * @param ProductID
     * @param HttpServletRequest
     * @return Shopping Cart View
     */
    @GetMapping("/cart")
    public String viewCart(Model model, HttpServletRequest request) {
        return getCartpage();
    }

    /**
     * Method to Update the shopping cart page
     *
     * @author Sai Upadhyayula
     *
     * @param Model
     * @param ProductID
     * @param HttpServletRequest
     * @return Shopping Cart View
     */

    // TODO- Implement BindingResult and FormValidations
    @PostMapping("/update")
    public String updateCart(Model model, HttpServletRequest request) {
        Long productId = Long.parseLong(request.getParameter("productid"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartData cartData = SessionUtils.getSessionVariables(request,
                ControllerConstants.CART);
        cartService.updateProduct(cartData, productId, quantity);
        return "redirect:/cart";
    }

    /**
     * Method to Remove the Products from shopping cart
     *
     * @param Model
     * @param ProductID
     * @param HttpServletRequest
     * @return Shopping Cart View
     */
    @GetMapping("/remove")
    public String removeProduct(
            @RequestParam(value = "productId") Long productId, Model model,
            HttpServletRequest request) {
        CartData cartData = SessionUtils.getSessionVariables(request,
                ControllerConstants.CART);
        cartService.removeProduct(cartData, productId);
        return getRedirectview();
    }

    /**
     * Method to Clear the Products from shopping cart
     *
     *
     * @param Model
     * @param ProductID
     * @param HttpServletRequest
     * @return Shopping Cart View
     */
    @GetMapping("/clear")
    public String clearCart(Model model, HttpServletRequest request) {
        CartData cartData = SessionUtils.getSessionVariables(request,
                ControllerConstants.CART);
        cartService.clearCart(cartData);
        return getRedirectview();
    }

    public static String getRedirectview() {
        return redirectView;
    }

    public static String getCartpage() {
        return cartPage;
    }
}