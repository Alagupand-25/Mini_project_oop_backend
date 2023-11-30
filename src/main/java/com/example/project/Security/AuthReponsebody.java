package com.example.project.Security;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthReponsebody {
	String email;
    String token;
    Date expiredata;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpiredata() {
		return expiredata;
	}
	public void setExpiredata(Date expiredata) {
		this.expiredata = expiredata;
	}
}
