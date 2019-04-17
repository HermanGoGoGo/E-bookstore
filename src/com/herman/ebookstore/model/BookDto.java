package com.herman.ebookstore.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-15T06:24:20.119Z")

public class BookDto   {
  @JsonProperty("id")
  private String id = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTime")
  private Date  createTime = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTimeCompare")
  private String  createTimeCompare = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("originalPrice")
  private String originalPrice = null;

  @JsonProperty("price")
  private String price = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("conditions")
  private String conditions = null;

  @JsonProperty("edition")
  private String edition = null;

  @JsonProperty("semester")
  private String semester = null;

  @JsonProperty("course")
  private String course = null;

  @JsonProperty("transaction")
  private String transaction = null;


  @JsonProperty("purchaserId")
  private String purchaserId = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("universityId")
  private String universityId = null;
  
  @JsonProperty("campusId")
  private String campusId = null;

  @JsonProperty("campus")
  private String campus = null;

  @JsonProperty("city")
  private String city = null;
  
  @JsonProperty("browseTimes")
  private String browseTimes = null;
  
  @JsonProperty("image")
  private String image = null;

  public BookDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * 主键
   * @return id
  **/
  @ApiModelProperty(value = "主键")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BookDto createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")

  @Valid

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public BookDto createTimeCompare(String createTimeCompare) {
    this.createTimeCompare = createTimeCompare;
    return this;
  }

  /**
   * 创建时间与现在时间比较
   * @return createTimeCompare
  **/
  @ApiModelProperty(value = "创建时间与现在时间比较")

  @Valid

  public String getcreateTimeCompare() {
    return createTimeCompare;
  }

  public void setcreateTimeCompare(String createTimeCompare) {
    this.createTimeCompare = createTimeCompare;
  }

  public BookDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 书名
   * @return name
  **/
  @ApiModelProperty(value = "书名")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BookDto author(String author) {
    this.author = author;
    return this;
  }

  /**
   * 作者
   * @return author
  **/
  @ApiModelProperty(value = "作者")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BookDto originalPrice(String originalPrice) {
    this.originalPrice = originalPrice;
    return this;
  }

  /**
   * 原价
   * @return originalPrice
  **/
  @ApiModelProperty(value = "原价")


  public String getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(String originalPrice) {
    this.originalPrice = originalPrice;
  }

  public BookDto price(String price) {
    this.price = price;
    return this;
  }

  /**
   * 现价
   * @return price
  **/
  @ApiModelProperty(value = "现价")


  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public BookDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * 描述
   * @return description
  **/
  @ApiModelProperty(value = "描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BookDto conditions(String conditions) {
    this.conditions = conditions;
    return this;
  }

  /**
   * 商品状态：0：全新；1：9.9成新； 2：6成新
   * @return conditions
  **/
  @ApiModelProperty(value = "商品状态：0：全新；1：9.9成新； 2：6成新")


  public String getConditions() {
    return conditions;
  }

  public void setConditions(String conditions) {
    this.conditions = conditions;
  }

  public BookDto edition(String edition) {
    this.edition = edition;
    return this;
  }

  /**
   * 版本
   * @return edition
  **/
  @ApiModelProperty(value = "版本")


  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public BookDto semester(String semester) {
    this.semester = semester;
    return this;
  }

  /**
   * 学期
   * @return semester
  **/
  @ApiModelProperty(value = "学期")


  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public BookDto course(String course) {
    this.course = course;
    return this;
  }

  /**
   * 课程
   * @return course
  **/
  @ApiModelProperty(value = "课程")


  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public BookDto transaction(String transaction) {
    this.transaction = transaction;
    return this;
  }

  /**
   * 交易方式：0：校区当面交易；1：邮寄；2：校区当面交易或者邮寄
   * @return transaction
  **/
  @ApiModelProperty(value = "交易方式：0：校区当面交易；1：邮寄；2：校区当面交易或者邮寄")


  public String getTransaction() {
    return transaction;
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }


  public BookDto purchaserId(String purchaserId) {
    this.purchaserId = purchaserId;
    return this;
  }

  /**
   * 购买人id
   * @return purchaserId
  **/
  @ApiModelProperty(value = "购买人id")


  public String getPurchaserId() {
    return purchaserId;
  }

  public void setPurchaserId(String purchaserId) {
    this.purchaserId = purchaserId;
  }

  public BookDto userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 拥有者id
   * @return userId
  **/
  @ApiModelProperty(value = "拥有者id")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public BookDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * 拥有者名称
   * @return username
  **/
  @ApiModelProperty(value = "拥有者名称")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public BookDto universityId(String universityId) {
    this.universityId = universityId;
    return this;
  }

  /**
   * 学校id
   * @return universityId
  **/
  @ApiModelProperty(value = "学校id")


  public String getUniversityId() {
    return universityId;
  }

  public void setUniversityId(String universityId) {
    this.universityId = universityId;
  }

  public BookDto campus(String campus) {
    this.campus = campus;
    return this;
  }

  /**
   * 学校校区名称
   * @return campus
  **/
  @ApiModelProperty(value = "学校校区名称")


  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public BookDto browseTimes(String browseTimes) {
    this.browseTimes = browseTimes;
    return this;
  }

  /**
      * 浏览次数 
   * @return browseTimes
  **/
  @ApiModelProperty(value = "浏览次数")


  public String getBrowseTimes() {
    return browseTimes;
  }

  public void setBrowseTimes(String browseTimes) {
    this.browseTimes = browseTimes;
  }
  
  public BookDto city(String city) {
	    this.city = city;
	    return this;
	  }

	  /**
	      * 所在城市
	   * @return city
	  **/
	  @ApiModelProperty(value = "所在城市")


	  public String getCity() {
	    return city;
	  }

	  public void setCity(String city) {
	    this.city = city;
	  }

	  public BookDto image(String image) {
		    this.image = image;
		    return this;
		  }

		  /**
		      * 照片url
		   * @return image
		  **/
		  @ApiModelProperty(value = "所在城市")


		  public String getImage() {
		    return image;
		  }

		  public void setImage(String image) {
		    this.image = image;
		  }
		  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookDto bookDto = (BookDto) o;
    return Objects.equals(this.id, bookDto.id) &&
        Objects.equals(this.createTime, bookDto.createTime) &&
        Objects.equals(this.createTimeCompare, bookDto.createTimeCompare) &&
        Objects.equals(this.name, bookDto.name) &&
        Objects.equals(this.author, bookDto.author) &&
        Objects.equals(this.originalPrice, bookDto.originalPrice) &&
        Objects.equals(this.price, bookDto.price) &&
        Objects.equals(this.description, bookDto.description) &&
        Objects.equals(this.conditions, bookDto.conditions) &&
        Objects.equals(this.edition, bookDto.edition) &&
        Objects.equals(this.semester, bookDto.semester) &&
        Objects.equals(this.course, bookDto.course) &&
        Objects.equals(this.transaction, bookDto.transaction) &&
        Objects.equals(this.purchaserId, bookDto.purchaserId) &&
        Objects.equals(this.userId, bookDto.userId) &&
        Objects.equals(this.username, bookDto.username) &&
        Objects.equals(this.universityId, bookDto.universityId) &&
        Objects.equals(this.campus, bookDto.campus) &&
        Objects.equals(this.city, bookDto.city) &&
        Objects.equals(this.image, bookDto.image) &&
        Objects.equals(this.browseTimes, bookDto.browseTimes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, createTimeCompare, name, author, originalPrice, price, description, conditions, edition, semester, course, transaction, purchaserId, userId, username, universityId, campus, city , browseTimes, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createTimeCompare: ").append(toIndentedString(createTimeCompare)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    originalPrice: ").append(toIndentedString(originalPrice)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
    sb.append("    semester: ").append(toIndentedString(semester)).append("\n");
    sb.append("    course: ").append(toIndentedString(course)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("    purchaserId: ").append(toIndentedString(purchaserId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    universityId: ").append(toIndentedString(universityId)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    browseTimes: ").append(toIndentedString(browseTimes)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

