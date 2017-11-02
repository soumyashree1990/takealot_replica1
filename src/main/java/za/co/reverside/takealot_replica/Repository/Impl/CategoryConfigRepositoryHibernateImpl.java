package za.co.reverside.takealot_replica.Repository.Impl;

import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.SubCategory;
import za.co.reverside.takealot_replica.Repository.CategoryConfigRepository;

import java.util.List;

public class CategoryConfigRepositoryHibernateImpl implements
        CategoryConfigRepository {

    @Override
    public List<Category> readAllCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubCategory> readAllSubCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long readCategoryByProductId(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category readCategoryBySubCategoryId(Long subCategoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category readCategoryBySubCategoryName(String subCategoryName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubCategory> readSubCategoryByCategoryId(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubCategory readSubCategoryByCategoryName(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long readSubCategoryByProductId(Product Product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubCategory> readAllSubCategoriesByCategoryId(Long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProductsBySubCategory(String subCategoryName) {
        // TODO Auto-generated method stub
        return null;
    }

}