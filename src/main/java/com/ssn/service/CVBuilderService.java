package com.ssn.service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.common.CVBuilder;
import com.ssn.dto.CVBuilderDto;

public interface CVBuilderService {
	ListResponse<CVBuilderDto> getAll();
	CVBuilderDto getById(Long id);
	CVBuilderDto save(CVBuilderDto cvBuilderDto) throws Exception;
	void delete(Long id);
	CVBuilderDto update(CVBuilderDto cvBuilderDto, Long id) throws Exception;
}
