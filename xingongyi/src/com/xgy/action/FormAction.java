package com.xgy.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.xgy.entity.Nick;
import com.xgy.service.NickService;
import com.xgy.utils.SendCode;

@Action(value="FormAction")
public class FormAction extends BaseAction<Nick>{
	private String verCode;
	public String getVerCode() {
		return verCode;
	}
	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}
	@Autowired
	private NickService nickService;
	
	@Action(value="getCode")
	public void getCode(){
		try {
			String code = SendCode.getCode();
//			String send_str = SendCode.sendCode(model.getCellphone(),code);
//			int len = send_str.length();
//			System.out.println(send_str.substring(len-4,len));
			System.out.println(code);
			request.getSession().setAttribute(model.getCellphone(),code);//存进session域
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Action(value="register")
	public void register() throws IOException{
		response.setContentType("text/html;charset=UTF-8"); 
		request.getSession().removeAttribute("realName");//移除
		request.getSession().removeAttribute("idcard");//移除
		request.getSession().removeAttribute("cellphone");//移除
		String verCode = request.getParameter("verCode");//获取验证码
		//获取存进session域的验证码
		String code = (String) request.getSession().getAttribute(model.getCellphone());
		if(verCode!=null&&verCode.equals(code)){//匹配两者相同才能注册成功
			Timestamp registerTime = new Timestamp(new Date().getTime());
			model.setRegisterTime(registerTime);//注册时间当前时间
			model.setFlag("F");//默认未处理
			nickService.saveNick(model);//存进数据库
			request.getSession().removeAttribute(model.getCellphone());//移除验证码
			response.getWriter().print("<script>alert('注册成功');window.location='http://www.baidu.com'</script>");
		}else{//验证码不正确
			request.getSession().setAttribute("realName",model.getRealName());
			request.getSession().setAttribute("idcard",model.getIdcard());
			request.getSession().setAttribute("cellphone",model.getCellphone());
			response.getWriter().print("<script>alert('验证码不正确');window.location='form.jsp';</script>");
		}
		response.getWriter().close();
	}
}
