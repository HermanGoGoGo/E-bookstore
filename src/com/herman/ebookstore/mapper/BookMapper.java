package com.herman.ebookstore.mapper;

import com.herman.ebookstore.pojo.Book;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.SeachDto;

/**
 * 售书表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-15 10:23:30
 */

public interface BookMapper extends Mapper<Book> {

	@Select("SELECT t.* FROM MSTB_SELL_BOOK t WHERE t.`status` ='0'")
	public List<Book> findAllBooks();

	@Select("SELECT b.*, " + "u.username, " + "s.id, " + "s.campus, " + "s.city " 
	        + "FROM MSTB_SELL_BOOK b "
			+ "LEFT JOIN MSTB_USER u ON u.usercode=b.user_id "
			+ "LEFT JOIN MSTB_UNIVERSITY s ON s.id = u.university_id " + "WHERE b.`status` ='0' "
			+ "order by b.create_time desc,b.id desc")
	public List<BookDto> findAllBookList();
	

	@SelectProvider(type = BookSqlBuilder.class, method = "selectByBookName")
	public List<BookDto> selectByBookName(SeachDto seachDto);

	class BookSqlBuilder {
		public String selectByBookName(SeachDto seachDto) {
			return new SQL() {
				{
					SELECT("b.*, u.username, s.id, s.campus, s.city");
					FROM("MSTB_SELL_BOOK b");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=b.user_id");
					LEFT_OUTER_JOIN("MSTB_UNIVERSITY s ON s.id = u.university_id");
					if (null != seachDto.getBookName()) {
						WHERE("b.name LIKE CONCAT('%',#{bookName},'%')");
					}
					if (null != seachDto.getUniversityId()) {
						WHERE("s.id = #{universityId}");
					}
					WHERE("b.`status` ='0' ");
					ORDER_BY("b.create_time desc,b.id desc");
				}
			}.toString();
		}
	}
}