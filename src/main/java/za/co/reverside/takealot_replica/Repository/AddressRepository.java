package za.co.reverside.takealot_replica.Repository;

import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.AddressForm;

@Repository
public interface AddressRepository {

    public void saveAddress(AddressForm address);

    public AddressForm readAddressById(Long addressId);
}