package com.herman.ebookstore.mapper;

import java.util.List;

import com.herman.ebookstore.pojo.BookVo;

/**
* @ClassName: BookVoMapper
* @Description: TODO()
* @author 黄金宝
* @date 2019年1月11日
*
*/
public interface BookVoMapper {
	/** 
	 * @Method_Name: getBooKVoList 
	 * @Description: TODO(查询书本信息)
	 * @Description: * @param bookVo
	 * @Description: * @return List<BookVo>
	 * @date 2019年1月11日
	 * @author 黄金宝 
	 */
	List<BookVo> getBooKVoList(BookVo bookVo);
}
