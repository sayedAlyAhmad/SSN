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
import com.ssn.dto.CVBuilderDto;
import com.ssn.serviceimpl.CVBuilderServiceImpl;
@RestController
@RequestMapping("${api.prefix.ssn}" + "/cv")
public class CVBuilderController {
	@Autowired
	CVBuilderServiceImpl cvBuilderServiceImpl;
	
	@GetMapping
	public ListResponse<CVBuilderDto> getAllCvs() throws Exception{
		return cvBuilderServiceImpl.getAll();
	}
	@PostMapping
	public CVBuilderDto saveCV(@RequestBody CVBuilderDto cvBuilderDto) throws Exception {
		System.out.println("Hallo from controller");
		return cvBuilderServiceImpl.save(cvBuilderDto);
	}
	@GetMapping("/{id}")
	public CVBuilderDto getCVById(@PathVariable(value = "id") Long id) {
		return cvBuilderServiceImpl.getById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteCVById(@PathVariable(value = "id") Long id) {
		cvBuilderServiceImpl.delete(id);
	}
	@PatchMapping("/{id}")
	public CVBuilderDto updateCV( @RequestBody CVBuilderDto cvBuilderDto, @PathVariable(value = "id") Long id) throws Exception {
		return cvBuilderServiceImpl.update(cvBuilderDto, id);
	}
}
