package com.blz.AddressBookApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blz.AddressBookApp.Model.AddressBookData;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBookData, Integer> {
	
	@Query(value = "select * from address_book, where name LIKE %:keyword%", nativeQuery = true)
	List<AddressBookData> getAddressByKeywordName(String keyword);

}