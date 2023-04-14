package com.ssn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.dto.CityDto;
import com.ssn.serviceimpl.CityServiceImpl;

@RestController
@RequestMapping("${api.prefix.ssn}" + "/city")
public class CityController {
	@Autowired
	CityServiceImpl cityServiceImpl;
	
	@GetMapping
	public ListResponse<CityDto> getAllCities(){
		return cityServiceImpl.getAll();
	}
	
	@PostMapping
	public CityDto saveCity(@RequestBody CityDto cityDto) {
		return cityServiceImpl.save(cityDto);
	}
	
	@GetMapping("/{id}")
	public CityDto getCityById(@PathVariable(value = "id") Long id) {
		return cityServiceImpl.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCityById(@PathVariable(value = "id") Long id) {
		cityServiceImpl.delete(id);
	}
	
	@PatchMapping("/{id}")
	public CityDto updateCity( @RequestBody CityDto cityDto, @PathVariable(value = "id") Long id) throws Exception {
		return cityServiceImpl.update(cityDto, id);
	}
	

}
