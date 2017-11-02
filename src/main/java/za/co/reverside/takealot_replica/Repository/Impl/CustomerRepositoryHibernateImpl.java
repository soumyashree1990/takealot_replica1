package za.co.reverside.takealot_replica.Repository.Impl;

import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.CustomerRepository;

public class CustomerRepositoryHibernateImpl implements CustomerRepository {

    @Override
    public Customer validateUsers(String userName, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer registerUser(Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean changePassword(String password, Customer customer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long getCustomerById(String userName) {
        // TODO Auto-generated method stub
        return null;
    }
}