package za.co.reverside.takealot_replica.Repository.Impl;

import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.ReviewForm;
import za.co.reverside.takealot_replica.Repository.ReviewRepository;

import java.util.List;

@Repository
public class ReviewRepositoryHibernateImpl implements ReviewRepository {

    @Override
    public void reviewProduct(ReviewForm reviewForm) {

    }

    @Override
    public List<ReviewForm> getProductReviews(Long productId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReviewForm> getReviewByCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

}