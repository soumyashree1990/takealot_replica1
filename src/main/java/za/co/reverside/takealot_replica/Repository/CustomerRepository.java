package za.co.reverside.takealot_replica.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer validateUsers(String userName, String password);

    public boolean registerUser(Customer customer);

    public boolean changePassword(String password,Customer customer);

    public Customer findCustomerByUserName(String userName);

}