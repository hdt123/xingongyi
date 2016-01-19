package com.xgy.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 所有action层都会继承baseAction 
 * 这个类实现了modelDriven 和 servlet的个域
 * 可以方便的获取到各个域和接受参数
 * @author huduo
 *
 * @param <T>
 */
public class BaseAction<T> implements ModelDriven<T>,ServletRequestAware,ServletResponseAware,ServletContextAware{

	protected T model;
	
	protected HttpServletRequest request;

	protected ServletContext servletContext;

	protected HttpServletResponse response;
	
	protected int page;
	
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void outJsonString(String str) {
		response.setContentType("text/json;charset=UTF-8");
		outString(str);
	}
	
	public void outString(String str) {
		try {
			
			System.out.println(str);
			PrintWriter out = response.getWriter();
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setServletContext(ServletContext servletcontext) {
		
		this.servletContext = servletcontext;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;
	
	}

	@Override
	public T getModel() {
		return model;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
