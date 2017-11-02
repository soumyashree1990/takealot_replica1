package za.co.reverside.takealot_replica.Repository.Impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Repository.ProductConfigRepository;
import za.co.reverside.takealot_replica.Util.ProductMapper;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductConfigRepositoryJdbcImpl implements ProductConfigRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
    }

    @Override
    public List<Product> readFeaturedProducts() {
        int number = 1;
        String sql = "SELECT * FROM product p where p.Featured= :number";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                "number", number);
        List<Product> productsList = namedParameterJdbcTemplate.query(sql,
                sqlParameterSource, new ProductMapper());
        return productsList;
    }

    @Override
    public Product readProductById(Long productId) {
        String sql = "SELECT * FROM product p where p.Product_Id= :productId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                "productId", productId);
        Product product = namedParameterJdbcTemplate.queryForObject(sql,
                sqlParameterSource, new ProductMapper());
        return product;
    }

}
