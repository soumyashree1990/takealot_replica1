package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.Customer;

public interface CustomerRepository {

    public Customer validateUsers(String userName, String password);

    public Integer registerUser(Customer customer);

    public boolean changePassword(String password,Customer customer);

    public Customer getCustomerById(Long customerId);

    Long getCustomerById(String userName);
}