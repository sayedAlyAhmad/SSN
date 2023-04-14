package com.ssn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CVBuilderDto  {
	private Long id;
	private String name;
	private String objective;
	private String skills;
	private String experience;
	private String education;
//	private Long userId;
 	private UserDto user_id;
}
