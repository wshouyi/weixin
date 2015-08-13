package com.weixin.po;

public class Messages {
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("谢谢你的关注！\n");
		sb.append("回复 ? 获取帮助菜单");
		return sb.toString();
	}
	public static String helpMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("帮助菜单：\n");
		sb.append("回复 1 ：简介~\n");
		sb.append("回复 2 ：猜你~");
		return sb.toString();
	}
	public static String jiesMenu(){
		return "这是第一个微信公众号~";
	}

}
