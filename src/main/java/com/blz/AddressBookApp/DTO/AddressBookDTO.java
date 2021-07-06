package com.blz.AddressBookApp.DTO;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}[ ][A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid FullName")
	public String fullName;
	@Pattern(regexp = "^[A-Za-z0-9-,\\.]{3,}([\\s][A-Za-z0-9-,\\.]{3,}){0,}$", message = "Invalid Address")
	public String address;
	public String city;
	public String state;
	public String zip;
	@Pattern(regexp = "((^\\+?)(([0-9]{2,3})(\\s))?)[1-9]{1}[0-9]{9}$", message = "Invalid Phone Number")
	public String phoneNumber;
	
	public AddressBookDTO(String fullName, String address, String city, String state, String zip, String phoneNumber) {
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}
}