package com.ssn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssn.common.City;


public interface CityDao extends JpaRepository<City, Long> {

}
