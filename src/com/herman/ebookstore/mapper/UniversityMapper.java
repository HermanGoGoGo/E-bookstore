package com.herman.ebookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.pojo.University;
import com.herman.ebookstore.pojo.User;

/**
 * 学校表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
public interface UniversityMapper extends Mapper<University> {
	@Select("SELECT t.* from MSTB_UNIVERSITY t WHERE delete_flag='0'")
	public List<University> findAll();
}
