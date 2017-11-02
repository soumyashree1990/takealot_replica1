package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.Product;

import java.util.List;

public interface ProductConfigRepository {

    List<Product> readFeaturedProducts();

    Product readProductById(Long productId);

}