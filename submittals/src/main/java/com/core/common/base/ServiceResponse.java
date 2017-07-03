package com.core.common.base;

import java.util.List;

public class ServiceResponse<T> {
	boolean messagePresent;
	List<ServiceMessage> messageList;
	T data;

	public ServiceResponse() {
		super();
	}

	public boolean isMessagePresent() {
		return messagePresent;
	}

	
	public ServiceResponse(List<ServiceMessage> listMessage, T data) {
		this.messageList = listMessage;
		this.data = data;
		
		if(listMessage!=null && listMessage.size()>0){
			messagePresent=true;
		}
		
	}

	public ServiceResponse(T data) {	
		this.data = data;
		messagePresent=false;
	}

	public T getData() {
		return data;
	}

	public void setMessagePresent(boolean messagePresent) {
		this.messagePresent = messagePresent;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<ServiceMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<ServiceMessage> messages) {
		this.messageList = messages;
	}
	
	
}
