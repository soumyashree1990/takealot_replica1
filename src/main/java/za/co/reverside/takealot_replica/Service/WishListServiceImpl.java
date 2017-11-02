package za.co.reverside.takealot_replica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Repository.WishListRepository;

import java.util.List;

public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private ProductConfigService productConfigService;

    @Override
    public boolean addProductToWishList(Long productId, Customer customer) {
        Product product = productConfigService.getProductById(productId);
        return wishListRepository.addProductToWishList(product, customer);

    }

    @Override
    public List<Product> getProductsInWishList(Customer customer) {
        List<Product> productsInWishList = wishListRepository.readProductsInWishList(customer);
        return productsInWishList;
    }

    @Override
    public boolean checkIfProductAvailableInWishList(Long productId) {
        Product product = productConfigService.getProductById(productId);
        return wishListRepository.checkIfProductAvailableInWishList(product);
    }

    public void deleteProductFromWishList(Long productId) {
        Product product = productConfigService.getProductById(productId);
        wishListRepository.deleteProductFromWishList(product);
    }


}
