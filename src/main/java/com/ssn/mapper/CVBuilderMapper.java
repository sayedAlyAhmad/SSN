package com.ssn.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.ssn.common.CVBuilder;
import com.ssn.dto.CVBuilderDto;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CVBuilderMapper extends BasicMapper<CVBuilder, CVBuilderDto>{
//	@Override
//	@Mapping(source = "user_id.id", target = "userId")
//	CVBuilderDto entityToDto(CVBuilder entity);
	
	
	
	
//	@Mapping(source = "userId", target = "user")
//	CVBuilder dtoToEntity(CVBuilderDto cvBuilderDto);
	 
}
