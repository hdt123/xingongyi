<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>益客申请</title>
    <link href="<%=path %>/admin/css/zui.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/common.css" rel="stylesheet">
    <script src="<%=path %>/admin/js/jquery-1.8.3.min.js"></script>
	<script src="<%=path %>/admin/js/zui.min.js"></script>
    <script type="text/javascript">
     	$('table.datatable').datatable({sortable: true});
   	 	function editNick(param){
   	 		if(confirm('确定通过益客申请？')){
   	 			$.post('NickAction!editNick.action',{nickId:param},function(data){
    				if(data){
    					window.location.href='NickAction!findNew.action';
    				}
    			});
   	 		}
    	}
	</script>
    <style>
        .mar-top-15 { margin-top: 15px }
    </style>
</head>
<body>
<h3 class="header-dividing mar-top-0">管理</h3>
<table class="table datatable">
    <thead>
        <tr>
            <th>申请时间</th>
            <th>姓名</th>
            <th>联系方式</th>
            <th>身份证</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>
                ${list.getRegisterTime() }
            </td>
            <td>
                ${list.getRealName()}
            </td>
            <td>
                ${list.getCellphone()}
            </td>
            <td>
                <span>${list.getIdcard()}</span>
            </td>
            <td>
                <button type="button" class="btn btn-sm btn-success">查看</button>
                <button type="button" onclick="editNick(${list.getNickId()})" class="btn btn-sm btn-primary">通过</button>
            </td>
        </tr>
      </c:forEach>  
    </tbody>
</table>
<ul class="pager">
    <c:choose>
 		<c:when test="${page==1}">
 		<li class="previous disabled">
 		<a href="#">«</a>
   	 	</li></c:when>
 		<c:otherwise><li class="previous">
 		<a href="NickAction!findNew.action?page=${page-1}">«</a>
    	</li></c:otherwise>
 	</c:choose>
 	<c:forEach var="plist" items="${pList}">
 	<c:choose>
 		<c:when test="${plist.toString()==page}">
 		<li class="active"></c:when>
 		<c:otherwise><li></c:otherwise>
 	</c:choose>
        <a href="NickAction!findNew.action?page=${plist.toString()}">${plist.toString()}</a>
    </li>
 	</c:forEach>
 	<c:choose>
 		<c:when test="${totalPage==page}">
 		<li class="next disabled">
 		<a href="#">»</a>
   		</li></c:when>
 		<c:otherwise><li class="next">
 		<a href="NickAction!findNew.action?page=${page+1}">»</a>
    	</li></c:otherwise>
 	</c:choose>
</ul>
</body>
</html>