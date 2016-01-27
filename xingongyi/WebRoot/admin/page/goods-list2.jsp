<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有益客</title>
    <link href="<%=path %>/admin/css/zui.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/common.css" rel="stylesheet">
    <script src="<%=path %>/admin/js/jquery-1.8.3.min.js"></script>
	<script src="<%=path %>/admin/js/zui.min.js"></script>
	<script>
   	 	$('table.datatable').datatable({sortable: true});
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
 		<a href="NickAction!findAll.action?page=${page-1}">«</a>
    	</li></c:otherwise>
 	</c:choose>
 	<c:forEach var="plist" items="${pList}">
 	<c:choose>
 		<c:when test="${plist.toString()==page}">
 		<li class="active"></c:when>
 		<c:otherwise><li></c:otherwise>
 	</c:choose>
        <a href="NickAction!findAll.action?page=${plist.toString()}">${plist.toString()}</a>
    </li>
 	</c:forEach>
 	<c:choose>
 		<c:when test="${totalPage==page}">
 		<li class="next disabled">
 		<a href="#">»</a>
   		</li></c:when>
 		<c:otherwise><li class="next">
 		<a href="NickAction!findAll.action?page=${page+1}">»</a>
    	</li></c:otherwise>
 	</c:choose>
</ul>
</body>
</html>