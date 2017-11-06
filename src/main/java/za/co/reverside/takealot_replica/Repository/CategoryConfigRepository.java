package za.co.reverside.takealot_replica.Repository;

import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.SubCategory;

import java.util.List;

@Repository
public interface CategoryConfigRepository {

    List<Category> readAllCategories();

    List<SubCategory> readAllSubCategories();

    Long readCategoryByProductId(Product product);

    Category readCategoryBySubCategoryId(Long subCategoryId);

    Category readCategoryBySubCategoryName(String subCategoryName);

    List<SubCategory> readSubCategoryByCategoryId(Category category);

    SubCategory readSubCategoryByCategoryName(Category category);

    Long readSubCategoryByProductId(Product Product);

    List<SubCategory> readAllSubCategoriesByCategoryId(
            Long categoryId);

    List<Product> getProductsByCategory(String categoryName);

    List<Product> getProductsBySubCategory(String subCategoryName);

}