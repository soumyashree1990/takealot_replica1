package za.co.reverside.takealot_replica.Util;

import org.springframework.stereotype.Component;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.CustomerRepository;

@Component
public class CustomerMapper {
    private CustomerRepository customerRepository;
    public CustomerMapper(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public void run(Customer rs) throws Exception {

        Customer customer = new Customer();
        customer.setCustomerId(rs.getCustomerId());
        customer.setEmailAddress(rs.getEmailAddress());
        customer.setFirstName(rs.getFirstName());
        customer.setLastName(rs.getLastName());
        customer.setPassword(rs.getPassword());
        customer.setPhoneNumber(rs.getPhoneNumber());
        customer.setUserName(rs.getUserName());

        //add our hotel to database
        this.customerRepository.save(customer);
    }





}