package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.Product;

import java.util.List;

public interface ProductConfigService {
    List<Product> getFeaturedProducts();

    Product getProductById(Long productId);
}