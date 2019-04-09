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
 * MessageDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-03T07:28:43.218Z")

public class MessageDto   {
  @JsonProperty("messInfo")
  private String messInfo = null;

  @JsonProperty("receiveUserId")
  private String receiveUserId = null;

  @JsonProperty("sendUserId")
  private String sendUserId = null;

  @JsonProperty("sendUserName")
  private String sendUserName = null;

  @JsonProperty("sendUserImage")
  private String sendUserImage = null;
  
  @JsonProperty("chatUser")
  private String chatUser = null;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonProperty("createTime")
  private Date  createTime = null;

  @JsonProperty("showTime")
  private String showTime = null;

  @JsonProperty("status")
  private String status = null;

  public MessageDto messInfo(String messInfo) {
    this.messInfo = messInfo;
    return this;
  }

  /**
   * 消息内容
   * @return messInfo
  **/
  @ApiModelProperty(value = "消息内容")


  public String getMessInfo() {
    return messInfo;
  }

  public void setMessInfo(String messInfo) {
    this.messInfo = messInfo;
  }

  public MessageDto receiveUserId(String receiveUserId) {
    this.receiveUserId = receiveUserId;
    return this;
  }

  /**
   * 接收人学号
   * @return receiveUserId
  **/
  @ApiModelProperty(value = "接收人学号")


  public String getReceiveUserId() {
    return receiveUserId;
  }

  public void setReceiveUserId(String receiveUserId) {
    this.receiveUserId = receiveUserId;
  }

  public MessageDto sendUserId(String sendUserId) {
    this.sendUserId = sendUserId;
    return this;
  }

  /**
   * 发送人学号
   * @return sendUserId
  **/
  @ApiModelProperty(value = "发送人学号")


  public String getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(String sendUserId) {
    this.sendUserId = sendUserId;
  }

  public MessageDto sendUserName(String sendUserName) {
    this.sendUserName = sendUserName;
    return this;
  }

  /**
   * 发送人姓名
   * @return sendUserName
  **/
  @ApiModelProperty(value = "发送人姓名")


  public String getSendUserName() {
    return sendUserName;
  }

  public void setSendUserName(String sendUserName) {
    this.sendUserName = sendUserName;
  }

  public MessageDto chatUser(String chatUser) {
    this.chatUser = chatUser;
    return this;
  }

  /**
   * 聊天用户
   * @return chatUser
  **/
  @ApiModelProperty(value = "聊天用户")


  public String getChatUser() {
    return chatUser;
  }

  public void setChatUser(String chatUser) {
    this.chatUser = chatUser;
  }
  
  public MessageDto sendUserImage(String sendUserImage) {
	    this.sendUserImage = sendUserImage;
	    return this;
	  }

	  /**
	   * 发送人照片
	   * @return sendUserImage
	  **/
	  @ApiModelProperty(value = "发送人照片")


	  public String getSendUserImage() {
	    return sendUserImage;
	  }

	  public void setSendUserImage(String sendUserImage) {
	    this.sendUserImage = sendUserImage;
	  }

  public MessageDto createTime(Date createTime) {
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

  public MessageDto showTime(String showTime) {
    this.showTime = showTime;
    return this;
  }

  /**
   * 显示时间
   * @return showTime
  **/
  @ApiModelProperty(value = "显示时间")


  public String getShowTime() {
    return showTime;
  }

  public void setShowTime(String showTime) {
    this.showTime = showTime;
  }

  public MessageDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * 状态，是否已读 1：已读；0：未读
   * @return status
  **/
  @ApiModelProperty(value = "状态，是否已读 1：已读；0：未读")


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
    MessageDto messageDto = (MessageDto) o;
    return Objects.equals(this.messInfo, messageDto.messInfo) &&
        Objects.equals(this.receiveUserId, messageDto.receiveUserId) &&
        Objects.equals(this.sendUserId, messageDto.sendUserId) &&
        Objects.equals(this.sendUserName, messageDto.sendUserName) &&
        Objects.equals(this.sendUserImage, messageDto.sendUserImage) &&
        Objects.equals(this.chatUser, messageDto.chatUser) &&
        Objects.equals(this.createTime, messageDto.createTime) &&
        Objects.equals(this.showTime, messageDto.showTime) &&
        Objects.equals(this.status, messageDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messInfo, receiveUserId, sendUserId, sendUserName, sendUserImage, chatUser, createTime, showTime, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDto {\n");
    
    sb.append("    messInfo: ").append(toIndentedString(messInfo)).append("\n");
    sb.append("    receiveUserId: ").append(toIndentedString(receiveUserId)).append("\n");
    sb.append("    sendUserId: ").append(toIndentedString(sendUserId)).append("\n");
    sb.append("    sendUserName: ").append(toIndentedString(sendUserName)).append("\n");
    sb.append("    sendUserImage: ").append(toIndentedString(sendUserImage)).append("\n");
    sb.append("    chatUser: ").append(toIndentedString(chatUser)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    showTime: ").append(toIndentedString(showTime)).append("\n");
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

