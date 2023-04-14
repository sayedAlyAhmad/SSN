package com.ssn.service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.dto.CityDto;

public interface CityService {
	ListResponse<CityDto> getAll();
	CityDto getById(Long id);
	CityDto save(CityDto cityDto);
	void delete(Long id);
	CityDto update(CityDto cityDto, Long id) throws Exception;

}
