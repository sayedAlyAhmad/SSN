package com.ssn.service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.dto.UserDto;

public interface UserService {
	ListResponse<UserDto> getAll();
	UserDto getById(Long id);
	UserDto save(UserDto userDto) throws Exception;
	void delete(Long id);
	UserDto update(UserDto userDto, Long id) throws Exception;
	UserDto signIn(String emailOrPhone,String nPass);

}
