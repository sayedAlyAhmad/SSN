package com.ssn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssn.common.User;

public interface UserDao extends JpaRepository<User, Long> {
	@Query(nativeQuery = true,
			value="SELECT * FROM user as u WHERE u.NEW_PASSWORD  = ?1 and u.USER_EMAIL_OR_PHONE = ?2")
	User findUserByNPassAndEmailOrPhone(String NEW_PASSWORD, String USER_EMAIL_OR_PHONE);
	
//	Optional<User> findOneByNEW_PASSWORDAndUSER_EMAIL_OR_PHONE(String email, String password);
}
