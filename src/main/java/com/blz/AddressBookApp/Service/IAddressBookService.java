package com.blz.AddressBookApp.Service;

import java.util.List;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.Model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookContactData();

	AddressBookData getAddressBookContactDataById(int id);

	AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO);

	void deleteAddressBookContactData(int id);
}