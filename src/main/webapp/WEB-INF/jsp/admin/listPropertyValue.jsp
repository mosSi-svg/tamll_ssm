<%--
  Created by IntelliJ IDEA.
  User: LaoMO
  Date: 2019/11/10
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>属性编辑</title>
</head>
<body>
<div class="workingArea">
    <ol class="breadcrumb">
        <li>
           <a href="/admin_category_list">分类管理</a>
        </li>
        <li><a href="/admin_product_list?cid=${product.cid}">产品管理</a> </li>
        <li class="active">属性编辑</li>
    </ol>
    <div>
        <c:forEach items="${pvs}" var="pv" varStatus="st">
            <div>
                <span> ${pv.property.name}</span><input type="text" value="${pv.value}" name="divValue">
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
