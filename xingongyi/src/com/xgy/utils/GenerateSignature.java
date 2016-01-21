package com.xgy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateSignature {

	public static Map<String,Object> getSignature(String jspi_ticket,String url){
		StringBuffer sb = new StringBuffer();
		String nonceStr = getNonceStr();
		long s = DateUtils.getTimeStamp();
		Map<String,Object> map = new HashMap<String, Object>();
		String[] ArrTmp = { "jsapi_ticket="+jspi_ticket, "timestamp="+s, "noncestr="+nonceStr,"url="+url };  
        Arrays.sort(ArrTmp);  
		
        for (int i = 0; i < ArrTmp.length; i++) {  
            sb.append(ArrTmp[i]+"&");  
            
        }  
        System.out.println(sb.toString());
        String str = sb.deleteCharAt(sb.length()-1).toString();  
        System.out.println(str);
       
        str = Encrypt(str);
        System.out.println(str);
        map.put("signature", str);
        map.put("nonceStr", nonceStr);
        map.put("timestamp", s+"");
		return map;
	}
	
	public static String getNonceStr(){
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//含有字符和数字的字符串
		Random random = new Random();//随机类初始化
		StringBuffer sb = new StringBuffer();//StringBuffer类生成，为了拼接字符串

		for (int i = 0; i < 16; ++i) {
			int number = random.nextInt(62);// [0,62)

			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(Encrypt("jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com"));
		getSignature("OezXcEiiBSKSxW0eoylIeCyl0ZRP5vZdBf1Q6c90WT4mgpnawpP-qcN1I7yeekqz6ZEGvUgfvQmUuZK7vcYA_qLhAWW2ZSWGgRvQpQYJnRbYLVZbuslscRAlB5w5m2x14nPCqgVnh2QYx0Jd6z3bgA", 
				"http:www.baidu.com");
	}
	
	 public  static String Encrypt(String strSrc) {  
	        MessageDigest md = null;  
	        String strDes = null;  
	  
	        byte[] bt = strSrc.getBytes();  
	        try {  
	            md = MessageDigest.getInstance("SHA-1");  
	            md.update(bt);  
	            strDes = bytes2Hex(md.digest()); //to HexString  
	        } catch (NoSuchAlgorithmException e) {  
	            System.out.println("Invalid algorithm.");  
	            return null;  
	        }  
	        return strDes;  
	    }  
	  
	    public static String bytes2Hex(byte[] bts) {  
	        String des = "";  
	        String tmp = null;  
	        for (int i = 0; i < bts.length; i++) {  
	            tmp = (Integer.toHexString(bts[i] & 0xFF));  
	            if (tmp.length() == 1) {  
	                des += "0";  
	            }  
	            des += tmp;  
	        }  
	        return des;  
	    }
}
