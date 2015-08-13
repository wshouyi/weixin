package com.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class CheckUtil {
	private static final String token = "hah";
	public static boolean checkSignature(String signature,String timestamp,String nonce) {
		String[] arr = {token,timestamp,nonce};
		Arrays.sort(arr);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++)
		{
			sb.append(arr[i]);
		}
		
		String s = getSha1(sb.toString());
		return s.equals(signature);
	}

	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

}
