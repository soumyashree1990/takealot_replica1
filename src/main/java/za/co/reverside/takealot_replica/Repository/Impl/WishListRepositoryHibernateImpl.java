package za.co.reverside.takealot_replica.Repository.Impl;

import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Repository.WishListRepository;

import java.util.List;

public class WishListRepositoryHibernateImpl implements WishListRepository {

    @Override
    public boolean addProductToWishList(Product product, Customer customer) {
        return false;
    }

    @Override
    public List<Product> readProductsInWishList(Customer customer) {
        return null;
    }

    @Override
    public boolean checkIfProductAvailableInWishList(Product product) {
        return false;
    }

    @Override
    public void deleteProductFromWishList(Product product) {

    }

}