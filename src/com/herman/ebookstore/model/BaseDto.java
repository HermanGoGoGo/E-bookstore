package com.herman.ebookstore.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class BaseDto {

	// 返回前端当前用户最新消息
	@JsonProperty("listNewMessage")
	private List<MessageDto> listNewMessage = null;

	// 返回前端当前用户全部最新消息
	@JsonProperty("listAllMessage")
	private List<MessageDto> listAllMessage = null;

	// 返回前端当前用户全部关于书的最新消息
	@JsonProperty("listAllBookMessage")
	private List<MessageDto> listAllBookMessage = null;

	public BaseDto listNewMessage(List<MessageDto> listNewMessage) {
		this.listNewMessage = listNewMessage;
		return this;
	}

	/**
	 * 返回前端当前用户最新消息
	 * 
	 * @return listNewMessage
	 **/
	@ApiModelProperty(value = "返回前端当前用户最新消息")

	public List<MessageDto> getListNewMessage() {
		return listNewMessage;
	}

	public void setListNewMessage(List<MessageDto> listNewMessage) {
		this.listNewMessage = listNewMessage;
	}

	public BaseDto listAllMessage(List<MessageDto> listAllMessage) {
		this.listAllMessage = listAllMessage;
		return this;
	}

	/**
	 * 返回前端当前用户全部最新消息
	 * 
	 * @return listNewMessage
	 **/
	@ApiModelProperty(value = "返回前端当前用户最新消息")

	public List<MessageDto> getListAllMessage() {
		return listAllMessage;
	}

	public void setListAllMessage(List<MessageDto> listAllMessage) {
		this.listAllMessage = listAllMessage;
	}

	
	
	public BaseDto listAllBookMessage(List<MessageDto> listAllBookMessage) {
		this.listAllBookMessage = listAllBookMessage;
		return this;
	}

	/**
	 * 返回前端当前用户全部最新消息
	 * 
	 * @return listNewMessage
	 **/
	@ApiModelProperty(value = "返回前端当前用户最新消息")
	
	public List<MessageDto> getListAllBookMessage() {
		return listAllBookMessage;
	}

	public void setListAllBookMessage(List<MessageDto> listAllBookMessage) {
		this.listAllBookMessage = listAllBookMessage;
	}
	
	@Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    BaseDto baseDto = (BaseDto) o;
	    return Objects.equals(this.listNewMessage, baseDto.listNewMessage) &&
	    		Objects.equals(this.listAllMessage, baseDto.listAllMessage) &&
	    		Objects.equals(this.listAllBookMessage, baseDto.listAllBookMessage);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(listNewMessage, listAllMessage, listAllBookMessage);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class BaseDto {\n");
	    
	    sb.append("    listNewMessage: ").append(toIndentedString(listNewMessage)).append("\n");
	    sb.append("    listAllMessage: ").append(toIndentedString(listAllMessage)).append("\n");
	    sb.append("    listAllBookMessage: ").append(toIndentedString(listAllBookMessage)).append("\n");
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
