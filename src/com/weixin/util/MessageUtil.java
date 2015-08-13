package com.weixin.util;

import java.awt.font.TextMeasurer;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.weixin.po.TextMessage;



public class MessageUtil {
	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_VIDEO="video";
	public static final String MESSAGE_LOCATION="location";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_SHORTVIDEO="shortvideo";
	public static final String MESSAGE_SUBSCRIBE="subscribe";

	/*
	 * XML转换成Map
	 * */
	public static Map<String,String> xml2Map(HttpServletRequest request){
		Map<String, String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream is = null;
		try {
			is = request.getInputStream();
			Document dcm = reader.read(is);
			Element root = dcm.getRootElement();
			List<Element> list = root.elements();
			
			for(Element e:list)
			{
				map.put(e.getName(), e.getText());
				
			}
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	/*
	 * 文本转换成XML
	 * */
	public static String text2XML(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static TextMessage initText(String toUserName,String fromUserName,String content){
		TextMessage tm = new TextMessage();
		tm.setFromUserName(toUserName);
		tm.setToUserName(fromUserName);
		tm.setContent(content);
		tm.setMsgType(MessageUtil.MESSAGE_TEXT);
		tm.setCreateTime(new Date().getTime());
		
		return tm;
	}
	
	

}
