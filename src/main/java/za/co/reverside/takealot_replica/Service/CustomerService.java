package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.Customer;

public interface CustomerService {

    public Customer validateUsers(String userName, String password);

    public Integer registerUser(Customer customer);

    public boolean changePassword(String password1, Customer customer);

    public Customer getCustomerById(String customerId);

    public String getCustomerId(String userName);

}