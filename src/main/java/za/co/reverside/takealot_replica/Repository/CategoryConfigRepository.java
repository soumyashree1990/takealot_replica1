package za.co.reverside.takealot_replica.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.SubCategory;

import java.util.List;

@Repository
public interface CategoryConfigRepository extends MongoRepository{

    List<Category> readAllCategories();

    Object readCategoryByProductId(Product product);
    List<Product> getProductsByCategory(String categoryName);


}