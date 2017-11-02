package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.ReviewForm;

import java.text.ParseException;
import java.util.List;

public interface ReviewService {
    void reviewProduct(ReviewForm reviewForm) throws ParseException;

    List<ReviewForm> getProductReviews(
            Long productId) throws ParseException;

    List<ReviewForm> getReviewByCustomer(Customer customer);
}