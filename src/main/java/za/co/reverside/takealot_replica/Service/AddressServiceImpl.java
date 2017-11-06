package za.co.reverside.takealot_replica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.AddressRepository;
import za.co.reverside.takealot_replica.Util.Utility;

@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    public void saveAddress(AddressForm address, Customer customer) {
        Long addressId = Utility.generateAddressNumber(address, customer);
        address.setAddressId(addressId);
        addressRepository.saveAddress(address);
    }

    @Override
    public AddressForm getAddressById(Long addressId) {
        return addressRepository.readAddressById(addressId);
    }

}