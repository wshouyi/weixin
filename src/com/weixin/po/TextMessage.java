package com.weixin.po;

public class TextMessage extends BaseMessage {
	private String Content; 
	private long MsgId;

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	} 

}
