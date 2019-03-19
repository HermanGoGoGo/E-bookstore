package com.herman.ebookstore.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HomeReq
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-19T05:48:02.736Z")

public class HomeReq   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("usercode")
  private String usercode = null;

  @JsonProperty("university")
  private String university = null;

  @JsonProperty("campus")
  private String campus = null;

  @JsonProperty("allBookSum")
  private String allBookSum = null;

  @JsonProperty("campusBookSum")
  private String campusBookSum = null;

  @JsonProperty("universityBookSum")
  private String universityBookSum = null;

  @JsonProperty("showLoad")
  private String showLoad = null;

  public HomeReq username(String username) {
    this.username = username;
    return this;
  }

  /**
   * 学校名称
   * @return username
  **/
  @ApiModelProperty(value = "学校名称")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public HomeReq usercode(String usercode) {
    this.usercode = usercode;
    return this;
  }

  /**
   * 学校名称
   * @return usercode
  **/
  @ApiModelProperty(value = "学校名称")


  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }

  public HomeReq university(String university) {
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

  public HomeReq campus(String campus) {
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

  public HomeReq allBookSum(String allBookSum) {
    this.allBookSum = allBookSum;
    return this;
  }

  /**
   * 所有书籍数量
   * @return allBookSum
  **/
  @ApiModelProperty(value = "所有书籍数量")


  public String getAllBookSum() {
    return allBookSum;
  }

  public void setAllBookSum(String allBookSum) {
    this.allBookSum = allBookSum;
  }

  public HomeReq campusBookSum(String campusBookSum) {
    this.campusBookSum = campusBookSum;
    return this;
  }

  /**
   * 校区书籍数量
   * @return campusBookSum
  **/
  @ApiModelProperty(value = "校区书籍数量")


  public String getCampusBookSum() {
    return campusBookSum;
  }

  public void setCampusBookSum(String campusBookSum) {
    this.campusBookSum = campusBookSum;
  }

  public HomeReq universityBookSum(String universityBookSum) {
    this.universityBookSum = universityBookSum;
    return this;
  }

  /**
   * 学校书籍数量
   * @return universityBookSum
  **/
  @ApiModelProperty(value = "学校书籍数量")


  public String getUniversityBookSum() {
    return universityBookSum;
  }

  public void setUniversityBookSum(String universityBookSum) {
    this.universityBookSum = universityBookSum;
  }

  public HomeReq showLoad(String showLoad) {
    this.showLoad = showLoad;
    return this;
  }

  /**
   * 显示加载内容属性
   * @return showLoad
  **/
  @ApiModelProperty(value = "显示加载内容属性")


  public String getShowLoad() {
    return showLoad;
  }

  public void setShowLoad(String showLoad) {
    this.showLoad = showLoad;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HomeReq homeReq = (HomeReq) o;
    return Objects.equals(this.username, homeReq.username) &&
        Objects.equals(this.usercode, homeReq.usercode) &&
        Objects.equals(this.university, homeReq.university) &&
        Objects.equals(this.campus, homeReq.campus) &&
        Objects.equals(this.allBookSum, homeReq.allBookSum) &&
        Objects.equals(this.campusBookSum, homeReq.campusBookSum) &&
        Objects.equals(this.universityBookSum, homeReq.universityBookSum) &&
        Objects.equals(this.showLoad, homeReq.showLoad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, usercode, university, campus, allBookSum, campusBookSum, universityBookSum, showLoad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HomeReq {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    usercode: ").append(toIndentedString(usercode)).append("\n");
    sb.append("    university: ").append(toIndentedString(university)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    allBookSum: ").append(toIndentedString(allBookSum)).append("\n");
    sb.append("    campusBookSum: ").append(toIndentedString(campusBookSum)).append("\n");
    sb.append("    universityBookSum: ").append(toIndentedString(universityBookSum)).append("\n");
    sb.append("    showLoad: ").append(toIndentedString(showLoad)).append("\n");
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

