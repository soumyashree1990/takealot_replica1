package za.co.reverside.takealot_replica.Util;

import org.springframework.jdbc.core.RowMapper;
import za.co.reverside.takealot_replica.Model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("Category_Id"));
        category.setCategoryName(rs.getString("Name"));
        return category;
    }

}
