package com.ads2018II.banking.domain.entity.users;

import java.util.Set;

public class User {
	
	private long id;
	private String name;
	private String password;
	private Set<UserClaim> claims;
	
	public User() {
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

	public Set<UserClaim> getClaims() {
		return claims;
	}

	public void setClaims(Set<UserClaim> claims) {
		this.claims = claims;
	}


}
