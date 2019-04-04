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
 * 详细用户
 */
@ApiModel(description = "详细用户")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-02T09:53:51.203Z")

public class UserDto   {
  @JsonProperty("id")
  private String id = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTime")
  private Date  createTime = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("updateTime")
  private Date  updateTime = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("usercode")
  private String usercode = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phonenumber")
  private String phonenumber = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("roleId")
  private String roleId = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("campusId")
  private String campusId = null;

  @JsonProperty("campus")
  private String campus = null;

  @JsonProperty("degree")
  private String degree = null;

  @JsonProperty("secondDegree")
  private String secondDegree = null;

  @JsonProperty("yearStarted")
  private String yearStarted = null;

  @JsonProperty("yearEnd")
  private String yearEnd = null;

  @JsonProperty("universityId")
  private String universityId = null;

  @JsonProperty("university")
  private String university = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("status")
  private String status = null;

  public UserDto id(String id) {
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

  public UserDto createTime(Date createTime) {
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

  public UserDto updateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  /**
   * 更新时间
   * @return updateTime
  **/
  @ApiModelProperty(value = "更新时间")

  @Valid

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public UserDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * 用户名称
   * @return username
  **/
  @ApiModelProperty(value = "用户名称")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserDto usercode(String usercode) {
    this.usercode = usercode;
    return this;
  }

  /**
   * 一卡通账号
   * @return usercode
  **/
  @ApiModelProperty(value = "一卡通账号")


  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }

  public UserDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(value = "密码")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserDto phonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    return this;
  }

  /**
   * 电话
   * @return phonenumber
  **/
  @ApiModelProperty(value = "电话")


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public UserDto image(String image) {
    this.image = image;
    return this;
  }

  /**
   * 头像地址
   * @return image
  **/
  @ApiModelProperty(value = "头像地址")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public UserDto roleId(String roleId) {
    this.roleId = roleId;
    return this;
  }

  /**
   * 角色id
   * @return roleId
  **/
  @ApiModelProperty(value = "角色id")


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public UserDto role(String role) {
    this.role = role;
    return this;
  }

  /**
   * 角色名称
   * @return role
  **/
  @ApiModelProperty(value = "角色名称")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public UserDto campusId(String campusId) {
    this.campusId = campusId;
    return this;
  }

  /**
   * 校区id
   * @return campusId
  **/
  @ApiModelProperty(value = "校区id")


  public String getCampusId() {
    return campusId;
  }

  public void setCampusId(String campusId) {
    this.campusId = campusId;
  }

  public UserDto campus(String campus) {
    this.campus = campus;
    return this;
  }

  /**
   * 校区名称
   * @return campus
  **/
  @ApiModelProperty(value = "校区名称")


  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public UserDto degree(String degree) {
    this.degree = degree;
    return this;
  }

  /**
   * 专业
   * @return degree
  **/
  @ApiModelProperty(value = "专业")


  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public UserDto secondDegree(String secondDegree) {
    this.secondDegree = secondDegree;
    return this;
  }

  /**
   * 第二专业
   * @return secondDegree
  **/
  @ApiModelProperty(value = "第二专业")


  public String getSecondDegree() {
    return secondDegree;
  }

  public void setSecondDegree(String secondDegree) {
    this.secondDegree = secondDegree;
  }

  public UserDto yearStarted(String yearStarted) {
    this.yearStarted = yearStarted;
    return this;
  }

  /**
   * 开始学年
   * @return yearStarted
  **/
  @ApiModelProperty(value = "开始学年")


  public String getYearStarted() {
    return yearStarted;
  }

  public void setYearStarted(String yearStarted) {
    this.yearStarted = yearStarted;
  }

  public UserDto yearEnd(String yearEnd) {
    this.yearEnd = yearEnd;
    return this;
  }

  /**
   * 结束学年
   * @return yearEnd
  **/
  @ApiModelProperty(value = "结束学年")


  public String getYearEnd() {
    return yearEnd;
  }

  public void setYearEnd(String yearEnd) {
    this.yearEnd = yearEnd;
  }

  public UserDto universityId(String universityId) {
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

  public UserDto university(String university) {
    this.university = university;
    return this;
  }

  /**
   * 学校名称
   * @return university
  **/
  @ApiModelProperty(value = "学校名称")


  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public UserDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * 学校所在城市
   * @return city
  **/
  @ApiModelProperty(value = "学校所在城市")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UserDto province(String province) {
    this.province = province;
    return this;
  }

  /**
   * 学校所在省市
   * @return province
  **/
  @ApiModelProperty(value = "学校所在省市")


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public UserDto address(String address) {
    this.address = address;
    return this;
  }

  /**
   * 学校所在详细地址
   * @return address
  **/
  @ApiModelProperty(value = "学校所在详细地址")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * 是否激活，0：未激活；1：已激活
   * @return status
  **/
  @ApiModelProperty(value = "是否激活，0：未激活；1：已激活")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDto userDto = (UserDto) o;
    return Objects.equals(this.id, userDto.id) &&
        Objects.equals(this.createTime, userDto.createTime) &&
        Objects.equals(this.updateTime, userDto.updateTime) &&
        Objects.equals(this.username, userDto.username) &&
        Objects.equals(this.usercode, userDto.usercode) &&
        Objects.equals(this.password, userDto.password) &&
        Objects.equals(this.phonenumber, userDto.phonenumber) &&
        Objects.equals(this.image, userDto.image) &&
        Objects.equals(this.roleId, userDto.roleId) &&
        Objects.equals(this.role, userDto.role) &&
        Objects.equals(this.campusId, userDto.campusId) &&
        Objects.equals(this.campus, userDto.campus) &&
        Objects.equals(this.degree, userDto.degree) &&
        Objects.equals(this.secondDegree, userDto.secondDegree) &&
        Objects.equals(this.yearStarted, userDto.yearStarted) &&
        Objects.equals(this.yearEnd, userDto.yearEnd) &&
        Objects.equals(this.universityId, userDto.universityId) &&
        Objects.equals(this.university, userDto.university) &&
        Objects.equals(this.city, userDto.city) &&
        Objects.equals(this.province, userDto.province) &&
        Objects.equals(this.address, userDto.address) &&
        Objects.equals(this.status, userDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, username, usercode, password, phonenumber, image, roleId, role, campusId, campus, degree, secondDegree, yearStarted, yearEnd, universityId, university, city, province, address, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    usercode: ").append(toIndentedString(usercode)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phonenumber: ").append(toIndentedString(phonenumber)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    campusId: ").append(toIndentedString(campusId)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    degree: ").append(toIndentedString(degree)).append("\n");
    sb.append("    secondDegree: ").append(toIndentedString(secondDegree)).append("\n");
    sb.append("    yearStarted: ").append(toIndentedString(yearStarted)).append("\n");
    sb.append("    yearEnd: ").append(toIndentedString(yearEnd)).append("\n");
    sb.append("    universityId: ").append(toIndentedString(universityId)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

