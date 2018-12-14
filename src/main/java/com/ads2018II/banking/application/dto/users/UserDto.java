package com.ads2018II.banking.application.dto.users;

import com.ads2018II.banking.application.dto.users.deserializer.UserDtoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = UserDtoDeserializer.class)
public class UserDto {

	private long id;
	private String name;
	private String password;
	
	public UserDto() {		
	}
	
	public UserDto(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
