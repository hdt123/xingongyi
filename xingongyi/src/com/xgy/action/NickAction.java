package com.xgy.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.xgy.entity.Nick;
import com.xgy.service.NickService;
import com.xgy.utils.PageUtil;

@Action(value="NickAction",
	results={@Result(name="all_success",location="/admin/page/goods-list2.jsp"),
		@Result(name="new_success",location="/admin/page/goods-list.jsp")})
public class NickAction extends BaseAction<Nick>{
	@Autowired
	private NickService nickService;
	/**
	 * 全部
	 */
	@Action(value="findAll")
	public String findAll(){
		response.setContentType("text/html");
		int page = 1;//默认是返回第一页数据，当前页
		int pageSize = 10;//页面大小，每页数据条数
		String pageStr = request.getParameter("page");
		if(pageStr!=null){
			page = Integer.parseInt(pageStr);//获取页码
		}
		List<Nick> list = new ArrayList<Nick>();
		list = nickService.findAll(page, pageSize,"T");//查询当前page页数据
		int total = nickService.findTotal("T");
		int totalPage = total/pageSize;
		if(total%pageSize>0){
			totalPage++;
		}
		List pList = new ArrayList();
		pList = PageUtil.pageTools(totalPage, pageSize);
		request.setAttribute("list",list);//结果集
		request.setAttribute("page",page);//当前页码
		request.setAttribute("totalPage",totalPage);//总页数
		request.setAttribute("pList",pList);//分页信息
		return "all_success";
	}
	/**
	 * 待审核
	 */
	@Action(value="findNew")
	public String findNew(){
		response.setContentType("text/html");
		int page = 1;//默认是返回第一页数据，当前页
		int pageSize = 10;//页面大小，每页数据条数
		String pageStr = request.getParameter("page");
		if(pageStr!=null){
			page = Integer.parseInt(pageStr);//获取页码
		}
		int total = nickService.findTotal("F");//获取总条数
		int totalPage = total/pageSize;//计算总页码
		if(total%pageSize>0){
			totalPage++;
		}
		List<Nick> list = new ArrayList<Nick>();
		List pList = new ArrayList();
		list = nickService.findAll(page, pageSize,"F");//获取结果集
		pList = PageUtil.pageTools(totalPage, pageSize);//获得分页信息
		request.setAttribute("page",page);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("list",list);
		request.setAttribute("pList",pList);
		return "new_success";
	}
	/**
	 * 更改
	 * @throws IOException
	 */
	@Action(value="editNick")
	public void editNick() throws IOException{
		String nickId = request.getParameter("nickId");
		if(nickId!=null){
			nickService.update(Integer.parseInt(nickId));
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);
		}
		response.getWriter().close();
	}
}
