package peaksoft.service;

import peaksoft.entity.Address;

import java.util.List;

public interface AddressService {
    void saveAddress(Address address);
    List<Address> saveAllAddress(List<Address> address);
    String assignAddressToCountry(Long addressId);
    Address findById(Long addressId);
    String deletedById(Long addressId);
    void deletedAll();
    String updated(Address address,Long addressId);
}
