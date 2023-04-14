package com.ssn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.PlayLoad.ListResponse;
import com.ssn.common.CVBuilder;
import com.ssn.common.User;
import com.ssn.dao.CVBuilderDao;
import com.ssn.dao.UserDao;
import com.ssn.dto.CVBuilderDto;
import com.ssn.exception.NotFoundException;
import com.ssn.mapper.CVBuilderMapper;
import com.ssn.service.CVBuilderService;

@Service
public class CVBuilderServiceImpl implements CVBuilderService{

	@Autowired
	CVBuilderMapper cvBuilderMapper;
	@Autowired
	CVBuilderDao cvBuilderDao;
	@Autowired
	UserDao userDao;
	@Override
	public ListResponse<CVBuilderDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(cvBuilderMapper.listToDto(cvBuilderDao.findAll()));
 
	}
	@Override
	public CVBuilderDto getById(Long id) {
		// TODO Auto-generated method stub
		return cvBuilderMapper
				.entityToDto(cvBuilderDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "cv-01")));
	}

	@Override
	public CVBuilderDto save(CVBuilderDto cvBuilderDto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Save User :: ");
		CVBuilder cvBuilder = cvBuilderMapper.dtoToEntity(cvBuilderDto);
		//System.out.println("user id :: "+ cvBuilder.getUser_id().getId());
		long userId =cvBuilder.getUser_id().getId();
		User user = userDao.findById(userId)
				.orElseThrow(() -> new Exception("no user founded!"));
		
		if (cvBuilderDto.getId() != null) {
		     cvBuilder.setUser_id(user);
		}
		cvBuilder = cvBuilderDao.save(cvBuilder);
		return cvBuilderMapper.entityToDto(cvBuilder);
		}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cvBuilderDao.deleteById(id);
	}

	@Override
	public CVBuilderDto update(CVBuilderDto cvBuilderDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		CVBuilder cvBuilder = cvBuilderDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "cv-01"));
		cvBuilderMapper.updateEntityFromDto(cvBuilderDto, cvBuilder);
		cvBuilder = cvBuilderDao.save(cvBuilder);
		return cvBuilderMapper.entityToDto(cvBuilder);	}

}
