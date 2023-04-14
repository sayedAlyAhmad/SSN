package com.ssn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.common.City;
import com.ssn.dao.CityDao;
import com.ssn.dto.CityDto;
import com.ssn.exception.NotFoundException;
import com.ssn.mapper.CityMapper;
import com.ssn.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityMapper cityMapper;
	@Autowired
	CityDao cityDao;
	

	@Override
	public ListResponse<CityDto> getAll() {
 		return new ListResponse<>(cityMapper.listToDto(cityDao.findAll()));
	}

	@Override
	public CityDto getById(Long id) {
		return cityMapper
				.entityToDto(cityDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "city-01")));
	}

	@Override
	public CityDto save(CityDto cityDto) {
		City city = cityMapper.dtoToEntity(cityDto);
		city = cityDao.save(city);
		return cityMapper.entityToDto(city);
	}

	@Override
	public void delete(Long id) {
		cityDao.deleteById(id);	

		
	}

	@Override
	public CityDto update(CityDto cityDto, Long id) throws Exception {
		City city=cityDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "city-01"));
		cityMapper.updateEntityFromDto(cityDto, city);
		city = cityDao.save(city);
		return cityMapper.entityToDto(city);
	}

}
