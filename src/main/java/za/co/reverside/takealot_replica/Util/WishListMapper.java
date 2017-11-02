package za.co.reverside.takealot_replica.Util;

import org.springframework.jdbc.core.RowMapper;
import za.co.reverside.takealot_replica.Model.WishList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WishListMapper implements RowMapper<WishList> {

    @Override
    public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
        WishList wishList = new WishList();
        wishList.setCustomerId(rs.getLong("Customer_Id"));
        wishList.setProductId(rs.getLong("Product_Id"));
        return wishList;
    }

}