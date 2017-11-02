package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;

import java.util.List;

public interface WishListService {
    boolean addProductToWishList(Long productId,Customer customer);

    List<Product> getProductsInWishList(Customer customer);

    boolean checkIfProductAvailableInWishList(Long productId);

    void deleteProductFromWishList(Long productId);
}