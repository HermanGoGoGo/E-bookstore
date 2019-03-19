package com.herman.ebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.UniversityMapper;
import com.herman.ebookstore.pojo.University;
import com.herman.ebookstore.service.UniversityService;




/**
 * 学校表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
@Service
@Transactional
public class UniversityServiceImpl extends AbstractService<University> implements UniversityService {

	@Autowired
	private UniversityMapper universityMapper;
	@Override
	public List<University> selectAll() {
		// TODO Auto-generated method stub
		return this.universityMapper.findAll();
	}

}