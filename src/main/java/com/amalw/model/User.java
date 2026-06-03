package com.amalw.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString(exclude = {"password", "confirmPassword"})
public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String company;
	private String password;
	private String confirmPassword;

}
