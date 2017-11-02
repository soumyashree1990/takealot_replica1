package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Model.Customer;

public interface AddressService {
    public void saveAddress(AddressForm address, Customer customer);
    AddressForm getAddressById(Long addressId);
}
