package com.herman.ebookstore.mapper;

import com.herman.ebookstore.pojo.Book;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.HomeReq;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.model.UserDto;

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
			+ "LEFT JOIN MSTB_UNIVERSITY s ON s.id = u.campus_id " + "WHERE b.`status` ='0' "
			+ "order by b.update_time desc,b.id desc")
	public List<BookDto> findAllBookList();
	
	@Select("SELECT b.id,b.create_time,b.update_time,b.user_id,b.name,b.author,b.original_price,b.price,b.edition,b.description,b.course,b.semester,b.image,b.browse_times,"
			+ "CASE " + 
			"         WHEN b.conditions = '0' THEN '全新' " + 
			"         WHEN b.conditions = '1' THEN '9.9成新' " + 
			"         WHEN b.conditions = '2' THEN '6成新' " + 
			"         ELSE '出错了' "
			+ " END AS conditions, "
			+ "CASE " + 
			"         WHEN b.transaction = '0' THEN '校区当面交易' " + 
			"         WHEN b.transaction = '1' THEN '邮寄' " + 
			"         WHEN b.transaction = '2' THEN '校区当面交易或者邮寄' " + 
			"         ELSE '出错了' " + 
			"  END AS transaction, "
			+ "u.username, s.id, s.campus, s.city "		
	        + "FROM MSTB_SELL_BOOK b "
			+ "LEFT JOIN MSTB_USER u ON u.usercode=b.user_id "
			+ "LEFT JOIN MSTB_UNIVERSITY s ON s.id = u.campus_id " + "WHERE b.`status` ='0' and b.id= #{id} "
			+ "order by b.update_time desc,b.id desc")
	public BookDto findOneBook(Book book);
	
	@Select("SELECT b.*, b.create_time as createTimeCompare," + "u.username, " + "s.id, " + "s.campus, " + "s.city " 
	        + "FROM MSTB_SELL_BOOK b "
			+ "LEFT JOIN MSTB_USER u ON u.usercode=b.user_id "
			+ "LEFT JOIN MSTB_UNIVERSITY s ON s.id = u.campus_id " + "WHERE b.`status` ='0' "
			+ "order by b.browse_times desc,b.id limit 10")
	public List<BookDto> findHotBookList();
	

	@SelectProvider(type = BookSqlBuilder.class, method = "selectByBookName")
	public List<BookDto> selectByBookName(SeachDto seachDto);
	
	@SelectProvider(type = BookSqlBuilder.class, method = "selectBookSum")
	public HomeReq selectBookSum(UserDto currentUser);
	
	@Update("UPDATE MSTB_SELL_BOOK SET browse_times = browse_times+1 WHERE id= #{id}")
	public Integer addHotBrowseTimes(Book book);

	class BookSqlBuilder {
		public String selectByBookName(SeachDto seachDto) {
			return new SQL() {
				{
					SELECT("b.id,b.create_time,b.name,b.author,b.original_price,b.price,b.edition,b.semester,"
							+ "CASE " + 
							"         WHEN b.conditions = '0' THEN '全新' " + 
							"         WHEN b.conditions = '1' THEN '9.9成新' " + 
							"         WHEN b.conditions = '2' THEN '6成新' " + 
							"         ELSE '出错了' "
							+ " END AS conditions, "
							+ "CASE " + 
							"         WHEN b.transaction = '0' THEN '校区当面交易' " + 
							"         WHEN b.transaction = '1' THEN '邮寄' " + 
							"         WHEN b.transaction = '2' THEN '校区当面交易或者邮寄' " + 
							"         ELSE '出错了' " + 
							"  END AS transaction, "
							+ "u.username, s.id, s.campus, s.city");
					FROM("MSTB_SELL_BOOK b");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=b.user_id");
					LEFT_OUTER_JOIN("MSTB_UNIVERSITY s ON s.id = u.campus_id");
					if (null != seachDto.getBookName()) {
						WHERE("b.name LIKE CONCAT('%',#{bookName},'%')");
					}
					if (null != seachDto.getUniversityId()) {
						WHERE("s.university_id = #{universityId}");
					}
					if (null != seachDto.getCampusId()) {
						WHERE("s.id = #{campusId}");
					}
					WHERE("b.`status` ='0' ");
					ORDER_BY("b.update_time desc,b.id desc");
				}
			}.toString();
		}
		
		public String selectBookSum(UserDto currentUser) {
			return new SQL() {
				{
					StringBuilder select =new StringBuilder();
					select.append("COUNT(1) AS allBookSum,");
					if (null != currentUser.getCampusId()) {
						select.append("COUNT(CASE WHEN s.id = #{campusId} THEN 1 END) AS campusBookSum,");
					}
					if (null != currentUser.getUniversityId()) {
						select.append("COUNT(CASE WHEN s.university_id = #{universityId} THEN 1 END) AS universityBookSum,");
					}
					select.append("u.username,u.usercode,s.university,s.campus ");
					SELECT(select.toString());
					FROM("MSTB_SELL_BOOK b");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=b.user_id");
					LEFT_OUTER_JOIN("MSTB_UNIVERSITY s ON s.id = u.campus_id");
					WHERE("b.`status` ='0' ");
				}
			}.toString();
		}
	}
}