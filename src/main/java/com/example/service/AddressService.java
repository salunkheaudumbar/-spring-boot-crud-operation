package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Employee;
@Service
public interface AddressService {
	public Address getAddressById(long id);
	   public List<Address> getAllAddresses();
	   public Address saveAddress(Address address);
	   public void deleteAddress(long id);
	   public void updateAddress(Address a,long id);
	   
}
