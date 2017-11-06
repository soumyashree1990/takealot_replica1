package za.co.reverside.takealot_replica.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WishList")
public class WishList {

    private Long productId;
    private Long customerId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
