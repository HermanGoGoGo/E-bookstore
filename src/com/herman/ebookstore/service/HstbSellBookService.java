package com.herman.ebookstore.service;

import com.herman.ebookstore.pojo.HstbSellBook;
import com.herman.ebookstore.common.core.Service;

/**
 * 售书历史表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-04-16 10:55:43
 */
public interface HstbSellBookService extends Service<HstbSellBook> {

	
	/** 
	 * @Method_Name: passBook 
	 * @Description: TODO(审核通过书籍)
	 * @Description: * @param hstbSellBook void
	 * @date 2019年4月16日
	 * @author 黄金宝 
	 */
	public void passBook(HstbSellBook hstbSellBook);
}