package za.co.reverside.takealot_replica.Repository;

import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;

import java.util.List;

@Repository
public interface WishListRepository {

    boolean addProductToWishList(Product product, Customer customer);

    List<Product> readProductsInWishList(Customer customer);

    boolean checkIfProductAvailableInWishList(Product product);

    void deleteProductFromWishList(Product product);
}