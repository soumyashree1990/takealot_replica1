package za.co.reverside.takealot_replica.Repository.Impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.WishList;
import za.co.reverside.takealot_replica.Repository.WishListRepository;
import za.co.reverside.takealot_replica.Util.ProductMapper;

import javax.sql.DataSource;
import java.util.List;

public class WishListRepositoryJdbcImpl implements WishListRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
    }

    @Override
    public boolean addProductToWishList(Product product, Customer customer) {
        String sqlSelect = "SELECT COUNT(*) FROM wishlistdetails w where w.Product_Id = :productId";
        SqlParameterSource sqlParameterSource1 = new MapSqlParameterSource(
                "productId", product.getProductId());
        int result = namedParameterJdbcTemplate.queryForInt(sqlSelect,
                sqlParameterSource1);
        if (result == 0) {
            WishList wishList = new WishList();
            wishList.setCustomerId(customer.getCustomerId());
            wishList.setProductId(product.getProductId());
            String sql = "insert into wishlistdetails(Product_Id,Customer_Id) values(:productId,:customerId)";
            SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
                    wishList);
            namedParameterJdbcTemplate.update(sql, sqlParameterSource);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Product> readProductsInWishList(Customer customer) {
        String sql = "Select * from product p where p.product_Id IN (select w.Product_Id from wishlistdetails w where w.Customer_Id = :customerId);";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                "customerId", customer.getCustomerId());
        List<Product> productsList = namedParameterJdbcTemplate.query(sql,
                sqlParameterSource, new ProductMapper());
        return productsList;
    }

    @Override
    public boolean checkIfProductAvailableInWishList(Product product) {
        String sqlSelect = "SELECT COUNT(*) FROM wishlistdetails w where w.Product_Id = :productId";
        SqlParameterSource sqlParameterSource1 = new MapSqlParameterSource(
                "productId", product.getProductId());
        int result = namedParameterJdbcTemplate.queryForInt(sqlSelect,
                sqlParameterSource1);
        if (result == 1) {
            String sql = "DELETE FROM wishlistdetails where Product_Id=:productId";
            SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
                    product);
            namedParameterJdbcTemplate.update(sql, sqlParameterSource);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteProductFromWishList(Product product) {
        String sql = "DELETE FROM wishlistdetails where Product_Id=:productId";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
                product);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);

    }

}