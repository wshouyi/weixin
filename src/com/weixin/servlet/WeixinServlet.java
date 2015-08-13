package com.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.po.Messages;
import com.weixin.po.TextMessage;
import com.weixin.util.CheckUtil;
import com.weixin.util.MessageUtil;

public class WeixinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce))
			out.print(echostr);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Map<String, String> map = MessageUtil.xml2Map(req);
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String msgType = map.get("MsgType");
		String content = map.get("Content");
		
		PrintWriter out = resp.getWriter();
		if(msgType.equals(MessageUtil.MESSAGE_TEXT))
		{
			if(content.equals("1"))
			{
				TextMessage tm = MessageUtil.initText(toUserName, fromUserName, Messages.jiesMenu());
				String s = MessageUtil.text2XML(tm);
				out.print(s);
			}else if(content.equals("？")||content.equals("?")){
				TextMessage tm = MessageUtil.initText(toUserName, fromUserName, Messages.helpMenu());
				String s = MessageUtil.text2XML(tm);
				out.print(s);
			}else if(content.equals("2")){
				TextMessage tm = MessageUtil.initText(toUserName, fromUserName, "这个功能还在建设...\ue418");
				String s = MessageUtil.text2XML(tm);
				out.print(s);
			}else{				
				TextMessage tm = MessageUtil.initText(toUserName, fromUserName, "你输入的指令有误\ue418");
				String s = MessageUtil.text2XML(tm);
				out.print(s);
			}
			
		}else if(msgType.equals(MessageUtil.MESSAGE_EVENT)){
			String event = map.get("Event");
			if(event.equals(MessageUtil.MESSAGE_SUBSCRIBE)){
				TextMessage tm = MessageUtil.initText(toUserName, fromUserName, Messages.firstMenu());
				String s = MessageUtil.text2XML(tm);
				out.print(s);
			}
		}
		out.close();
		
		
	}

}
