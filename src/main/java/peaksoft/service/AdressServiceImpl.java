package peaksoft.service;

import peaksoft.entity.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.AddressRepositoryImpl;

import java.util.List;

public class AdressServiceImpl implements AddressService {
    AddressRepository addressRepository = new AddressRepositoryImpl();
    @Override
    public void saveAddress(Address address) {
        addressRepository.saveAddress(address);
    }

    @Override
    public List<Address> saveAllAddress(List<Address> address) {
        return addressRepository.saveAllAddress(address);
    }

    @Override
    public String assignAddressToCountry(Long addressId) {
        return addressRepository.assignAddressToCountry(addressId);
    }

    @Override
    public Address findById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public String deletedById(Long addressId) {
        return addressRepository.deletedById(addressId);
    }

    @Override
    public void deletedAll() {
        addressRepository.deletedAll();
    }

    @Override
    public String updated(Address address, Long addressId) {
        return addressRepository.updated(address,addressId);
    }
}