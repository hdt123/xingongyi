package com.xgy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

public class SendCode {
	public static String sendUrl(String r_url) throws Exception{
		// 创建url对象
		URL url = new URL(r_url);
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("GET");
		// 发送
		InputStream is =url.openStream();
		//转化结果
		String returnStr = convertStreamToString(is);
		// 返回发送结果
		return returnStr;
	}
	/**
	 * 获取验证码
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static String getCode(){
		Random ran = new Random();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i++<6){
			int str = ran.nextInt(10);
			sb.append(str);
		}
		return sb.toString();
	}
	/**
	 * 发送验证码
	 * @param mobile
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String sendCode(String mobile,String code) throws Exception{
		String content = "本次验证码："+code+"，三分钟内有效。";
		String sign = "高明新公益";
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");
		// 向StringBuffer追加用户名
		sb.append("name=13535685354");
		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=3449F798C4B65064C26E73ED3086");
		// 向StringBuffer追加手机号码
		sb.append("&mobile="+mobile);
		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
		//追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");
		//加签名
		sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
		//type为固定值pt  extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		//转换返回值
		String returnStr = sendUrl(sb.toString());
		return returnStr;
	}
	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;
        try {
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
}
