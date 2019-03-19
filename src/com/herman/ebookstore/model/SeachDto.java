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
 * SeachDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-18T06:37:17.877Z")

public class SeachDto   {
  @JsonProperty("bookName")
  private String bookName = null;

  @JsonProperty("universityId")
  private String universityId = null;

  @JsonProperty("campusId")
  private String campusId = null;

  public SeachDto bookName(String bookName) {
    this.bookName = bookName;
    return this;
  }

  /**
   * 书名字
   * @return bookName
  **/
  @ApiModelProperty(value = "书名字")


  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public SeachDto universityId(String universityId) {
    this.universityId = universityId;
    return this;
  }

  /**
   * 学校名字
   * @return universityId
  **/
  @ApiModelProperty(value = "学校名字")


  public String getUniversityId() {
    return universityId;
  }

  public void setUniversityId(String universityId) {
    this.universityId = universityId;
  }

  public SeachDto campusId(String campusId) {
    this.campusId = campusId;
    return this;
  }

  /**
   * 学校校区id
   * @return campusId
  **/
  @ApiModelProperty(value = "学校校区id")


  public String getCampusId() {
    return campusId;
  }

  public void setCampusId(String campusId) {
    this.campusId = campusId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeachDto seachDto = (SeachDto) o;
    return Objects.equals(this.bookName, seachDto.bookName) &&
        Objects.equals(this.universityId, seachDto.universityId) &&
        Objects.equals(this.campusId, seachDto.campusId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookName, universityId, campusId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeachDto {\n");
    
    sb.append("    bookName: ").append(toIndentedString(bookName)).append("\n");
    sb.append("    universityId: ").append(toIndentedString(universityId)).append("\n");
    sb.append("    campusId: ").append(toIndentedString(campusId)).append("\n");
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

