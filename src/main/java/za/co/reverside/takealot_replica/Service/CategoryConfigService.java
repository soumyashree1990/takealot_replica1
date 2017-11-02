package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.SubCategory;

import java.util.List;
import java.util.Map;

public interface CategoryConfigService {

    List<Product> getProductsByCategory(String categoryName);

    List<Product> getProductsBySubCategory(String subCategoryName);

    List<Category> getAllCategories();

    List<SubCategory> getAllSubCategories();

    Long getCategoryByProductId(Product product);

    Category getCategoryBySubCategoryId();

    Category getCategoryBySubCategoryName();

    SubCategory getSubCategoryByCategoryId();

    SubCategory getSubCategoryByCategoryName();

    Long getSubCategoryByProductId(Product product);

    List<SubCategory> getAllSubCategoriesByCategoryId(Long long1);

    Map<Category, List<SubCategory>> getCategoriesMap();

}