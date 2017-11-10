package za.co.reverside.takealot_replica.Repository.Impl;


import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl{

    private CustomerRepository repository;

    public Customer validateUsers(String userName, String password) {
        Customer customer=repository.findCustomerByUserName(userName);
        if(customer!=null){
            if(customer.getPassword()==password)
            return customer;
            else
                return null;
        }
        else return null;
    }


    public boolean registerUser(Customer customer) {
        repository.save(customer);
        return true;
    }

    public boolean changePassword(String password, Customer customer) {
       Customer old=repository.findCustomerByUserName(customer.getUserName());
       old.setPassword(password);
        try{
            repository.save(old);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}