package com.eldorado.userservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User implements Serializable {
	
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="isVerified")
	private boolean isVerified;
	
	@Column(name="accountNonExpired")
	private int accountNonExpired;
	
	@Column(name="credentialsNonExpired")
	private int credentialsNonExpired;
	
	@Column(name="accountNonLocked")
	private int accountNonLocked;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public int getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(int accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public int getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(int credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public int getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(int accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

}
