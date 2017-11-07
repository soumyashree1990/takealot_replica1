package za.co.reverside.takealot_replica.Service;

import org.springframework.stereotype.Service;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;

    @Override
    public Customer validateUsers(String userName, String password) {
        Customer customer = customerRepository
                .validateUsers(userName, password);
        return customer;
    }

    @Override
    public Integer registerUser(Customer customer) {
        return customerRepository.registerUser(customer);
    }

    @Override
    public boolean changePassword(String password, Customer customer) {
        return customerRepository.changePassword(password, customer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public String getCustomerId(String userName){ return customerRepository.getCustomerByUsername(userName);}
    }


