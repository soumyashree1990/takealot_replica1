package za.co.reverside.takealot_replica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Repository.ProductConfigRepository;

import java.util.List;

@Service
public class ProductConfigServiceImpl implements ProductConfigService {

    @Autowired
    private ProductConfigRepository productConfigRepository;

    public List<Product> getFeaturedProducts() {
        List<Product> featuredProdList = productConfigRepository
                .readFeaturedProducts();
        return featuredProdList;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productConfigRepository.readProductById(productId);
        return product;
    }

}