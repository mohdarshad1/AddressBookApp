package com.blz.AddressBookApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.DTO.ResponseDTO;
import com.blz.AddressBookApp.Model.AddressBookData;
import com.blz.AddressBookApp.Service.IAddressBookService;

@CrossOrigin
@RestController
@RequestMapping(value = "/addressbookservice")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;

	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookContactData() {
		List<AddressBookData> contactDataList = addressBookService.getAddressBookContactData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contactDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookContactData(@PathVariable("id") int id) {
		AddressBookData contactData = null;
		contactData = addressBookService.getAddressBookContactDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull for id: " + id, contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookContactData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.createAddressBookContactData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookContactData(@PathVariable("id") int id,
			@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.updateAddressBookContactData(id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookContactData(@PathVariable("id") int id) {
		addressBookService.deleteAddressBookContactData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book Contact Data Successfully", "Deleted id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}