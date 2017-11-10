package za.co.reverside.takealot_replica.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.AddressForm;

@Repository
public interface AddressRepository extends MongoRepository{

    public void save(AddressForm address);

    public AddressForm readAddressById(Long addressId);
}