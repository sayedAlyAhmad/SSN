package com.ssn.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssn.common.CVBuilder;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private Long id;
	private String fName;
	private String lName;
	private String emailOrPhone;
	private String nPass;
	private String cPass;
	private String gender;
	//private Long cityId;
	//private CVBuilder user_id;

}
