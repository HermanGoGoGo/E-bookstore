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
 * RoleDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T06:30:13.068Z")

public class RoleDto   {
  @JsonProperty("id")
  private String id = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTime")
  private Date  createTime = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("updateTime")
  private Date  updateTime = null;

  @JsonProperty("roleId")
  private String roleId = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("remarks")
  private String remarks = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("deleteFlag")
  private String deleteFlag = null;

  public RoleDto id(String id) {
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

  public RoleDto createTime(Date createTime) {
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

  public RoleDto updateTime(Date updateTime) {
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

  public RoleDto roleId(String roleId) {
    this.roleId = roleId;
    return this;
  }

  /**
   * 角色ID
   * @return roleId
  **/
  @ApiModelProperty(value = "角色ID")


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public RoleDto role(String role) {
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

  public RoleDto remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

  /**
   * 备注
   * @return remarks
  **/
  @ApiModelProperty(value = "备注")


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public RoleDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * 状态，是否启用1：启用；0：禁用
   * @return status
  **/
  @ApiModelProperty(value = "状态，是否启用1：启用；0：禁用")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public RoleDto deleteFlag(String deleteFlag) {
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
    RoleDto roleDto = (RoleDto) o;
    return Objects.equals(this.id, roleDto.id) &&
        Objects.equals(this.createTime, roleDto.createTime) &&
        Objects.equals(this.updateTime, roleDto.updateTime) &&
        Objects.equals(this.roleId, roleDto.roleId) &&
        Objects.equals(this.role, roleDto.role) &&
        Objects.equals(this.remarks, roleDto.remarks) &&
        Objects.equals(this.status, roleDto.status) &&
        Objects.equals(this.deleteFlag, roleDto.deleteFlag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, roleId, role, remarks, status, deleteFlag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

