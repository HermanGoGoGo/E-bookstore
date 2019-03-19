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
 * UniversityDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-18T06:37:17.877Z")

public class UniversityDto   {
  @JsonProperty("id")
  private String id = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTime")
  private Date  createTime = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("updateTime")
  private Date  updateTime = null;

  @JsonProperty("universityId")
  private String universityId = null;

  @JsonProperty("university")
  private String university = null;

  @JsonProperty("campus")
  private String campus = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("deleteFlag")
  private String deleteFlag = null;

  public UniversityDto id(String id) {
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

  public UniversityDto createTime(Date createTime) {
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

  public UniversityDto updateTime(Date updateTime) {
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

  public UniversityDto universityId(String universityId) {
    this.universityId = universityId;
    return this;
  }

  /**
   * 学校ID
   * @return universityId
  **/
  @ApiModelProperty(value = "学校ID")


  public String getUniversityId() {
    return universityId;
  }

  public void setUniversityId(String universityId) {
    this.universityId = universityId;
  }

  public UniversityDto university(String university) {
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

  public UniversityDto campus(String campus) {
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

  public UniversityDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * 城市
   * @return city
  **/
  @ApiModelProperty(value = "城市")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UniversityDto province(String province) {
    this.province = province;
    return this;
  }

  /**
   * 省份
   * @return province
  **/
  @ApiModelProperty(value = "省份")


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public UniversityDto address(String address) {
    this.address = address;
    return this;
  }

  /**
   * 详细地址
   * @return address
  **/
  @ApiModelProperty(value = "详细地址")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UniversityDto deleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
    return this;
  }

  /**
   * 是否删除，0：未删除；1：已删除
   * @return deleteFlag
  **/
  @ApiModelProperty(value = "是否删除，0：未删除；1：已删除")


  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UniversityDto universityDto = (UniversityDto) o;
    return Objects.equals(this.id, universityDto.id) &&
        Objects.equals(this.createTime, universityDto.createTime) &&
        Objects.equals(this.updateTime, universityDto.updateTime) &&
        Objects.equals(this.universityId, universityDto.universityId) &&
        Objects.equals(this.university, universityDto.university) &&
        Objects.equals(this.campus, universityDto.campus) &&
        Objects.equals(this.city, universityDto.city) &&
        Objects.equals(this.province, universityDto.province) &&
        Objects.equals(this.address, universityDto.address) &&
        Objects.equals(this.deleteFlag, universityDto.deleteFlag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, universityId, university, campus, city, province, address, deleteFlag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UniversityDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    universityId: ").append(toIndentedString(universityId)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    deleteFlag: ").append(toIndentedString(deleteFlag)).append("\n");
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

