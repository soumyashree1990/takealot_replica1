package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.ReviewForm;

import java.util.List;

public interface ReviewRepository {
    void reviewProduct(ReviewForm reviewForm);

    List<ReviewForm> getProductReviews(Long productId);

    List<ReviewForm> getReviewByCustomer(Customer customer);
}