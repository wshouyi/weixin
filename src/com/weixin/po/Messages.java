package com.weixin.po;

public class Messages {
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("лл��Ĺ�ע��\n");
		sb.append("�ظ� ? ��ȡ�����˵�");
		return sb.toString();
	}
	public static String helpMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("�����˵���\n");
		sb.append("�ظ� 1 �����~\n");
		sb.append("�ظ� 2 ������~");
		return sb.toString();
	}
	public static String jiesMenu(){
		return "���ǵ�һ��΢�Ź��ں�~";
	}

}
