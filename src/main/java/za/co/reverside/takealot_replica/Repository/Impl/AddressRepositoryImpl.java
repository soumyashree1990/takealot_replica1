package za.co.reverside.takealot_replica.Repository.Impl;


import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Repository.AddressRepository;


@Repository
public abstract class AddressRepositoryImpl implements AddressRepository{


    @Override
    public AddressForm readAddressById(Long addressId) {
        String sql = "SELECT * FROM address a where a.Address_Id=:addressId";
        AddressForm a = (AddressForm) findOne(addressId);
        return a;


    }
}