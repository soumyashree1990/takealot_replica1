package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.AddressForm;

public interface AddressRepository {

    public void saveAddress(AddressForm address);

    public AddressForm readAddressById(Long addressId);
}