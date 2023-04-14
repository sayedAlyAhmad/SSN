package com.ssn.serviceimpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.common.User;
import com.ssn.dao.CityDao;
import com.ssn.dao.UserDao;
import com.ssn.dto.UserDto;
import com.ssn.exception.NotFoundException;
import com.ssn.mapper.UserMapper;
import com.ssn.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserDao userDao;
	@Autowired
	CityDao cityDao;
 

	@Override
	public ListResponse<UserDto> getAll() {
	
 		return new ListResponse<>(userMapper.listToDto(userDao.findAll()));
	}

	@Override
	public UserDto getById(Long id) {
		return userMapper
				.entityToDto(userDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "user-01")));
	}

	@Override
	public UserDto save(UserDto userDto) throws Exception {
		User user = userMapper.dtoToEntity(userDto);
//		City city = cityDao.findById(userDto.getCityId())
//				.orElseThrow(() -> new Exception("no city founded!"));
//		if (userDto.getCityId() != null) {
//			 user.setCity(city);
//		}
		if (!user.getNPass().equals(user.getCPass())) {
			throw new Exception("Enter Vaild pass");
		}
		user = userDao.save(user);
		return userMapper.entityToDto(user);
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);

	}

	@Override
	public UserDto update(UserDto userDto, Long id) throws Exception {
		User user = userDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "user-01"));
		userMapper.updateEntityFromDto(userDto, user);
		user = userDao.save(user);
		return userMapper.entityToDto(user);
	}

	@Override
	public UserDto signIn( String emailOrPhone,String nPass) {
		System.out.println("Before s IN Sign In");
		User user = userDao.findUserByNPassAndEmailOrPhone(nPass, emailOrPhone);
		System.out.println("IN Sign In");
		System.out.println("USer Details"+ user.getNPass() + " " + user.getEmailOrPhone());
	return	userMapper.entityToDto(userDao.findUserByNPassAndEmailOrPhone(nPass, emailOrPhone));
 	}

}
