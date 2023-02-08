package peaksoft.repository;

import peaksoft.entity.Address;
import peaksoft.entity.Country;

import java.util.List;

public interface AddressRepository {
    void saveAddress(Address address);
    List<Address> saveAllAddress(List<Address> address);
    String assignAddressToCountry(Long addressId);
    Address findById(Long addressId);
    String deletedById(Long addressId);
    void deletedAll();
    String updated(Address address,Long addressId);


}
