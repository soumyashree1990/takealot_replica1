package za.co.reverside.takealot_replica.Repository.Impl;

import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.SubCategory;
import za.co.reverside.takealot_replica.Repository.CategoryConfigRepository;
import za.co.reverside.takealot_replica.Util.CategoryMapper;
import za.co.reverside.takealot_replica.Util.ProductMapper;
import za.co.reverside.takealot_replica.Util.SubCategoryMapper;


@Repository
public class CategoryConfigRepositoryImpl implements CategoryConfigRepository {

    @Override
    public List<Category> readAllCategories() {

        return findAll();
    }

    @Override
    public Object readCategoryByProductId(Product productId) {
        return findOne(productId);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return null;

    }

}