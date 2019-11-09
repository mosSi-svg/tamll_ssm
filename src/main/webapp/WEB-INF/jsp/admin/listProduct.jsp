<%--
  Created by IntelliJ IDEA.
  User: LaoMO
  Date: 2019/11/2
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>产品管理</title>
</head>
<body>
<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="/admin_category_list">全部分类</a></li>
        <li class="active">产品管理</li>
    </ol>

<div class="ListDataTableDiv">
    <table  class="table table-striped table-bordered table-hover  table-condensed">
        <thead>
           <tr class="success">
               <th>ID</th>
               <th>图片</th>
               <th>产品名称</th>
               <th>产品小标题</th>
               <th width="53px">原价格</th>
               <th width="80px">优惠价格</th>
               <th width="80px">库存数量</th>
               <th width="80px">图片管理</th>
               <th width="80px">设置属性</th>
               <th width="42px">编辑</th>
               <th width="42px">删除</th>
           </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td> <%--<c:if test="${!empty p.firstProductImage}">--%>
                        <%--<img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg">--%>
                        <%--</c:if>--%>
                </td>
                <td>${product.name}</td><td>${product.subTitle}</td><td> ${product.originalPrice}</td>
                <td>${product.promatePrice}</td><td>${product.stock}</td>
                <td> <a href="admin_productImage_list?pid=${product.id}"><span class="glyphicon glyphicon-picture"></span></a></td>
                <td><a href="admin_propertyValue_edit?pid=${product.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                <td>
                    <a href="admin_product_edit?id=${product.id}"><span
                            class="glyphicon glyphicon-edit"></span></a>
                </td>
                <td><a  deleteLink="true" href="/admin_product_delete?id=${product.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>

        </tbody>


    </table>


</div>
</div>
<div class="pageDiv">
    <%@include file="../include/admin/adminPage.jsp"%>
</div>
<div class="panel panel-warning addDiv">
<div class="panel-heading">新增产品</div>
<div class="panel-body">
<form id="addForm" method="post" action="/admin_product_add">

    <table class="addTable">
    <tr>
        <td>产品名称</td>
        <td><input type="text" name="name" id="name" class="form-control"></td>
    </tr>
    <tr>
        <td>产品小标题</td>
        <td><input type="text" name="subTitle" id="subTitle" class="form-control"></td>
    </tr>
        <tr>
            <td>原价格</td>
            <td><input type="text" name="originalPrice" id="originalPrice" class="form-control"></td>
        </tr>
        <tr>
            <td>优惠价格</td>
            <td><input type="text" name="promatePrice" id="promatePrice" class="form-control"></td>
        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" name="stock" id="stock" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="cid" value="${c.id}">
                <input type="submit" class="btn btn-success" value="提交">
            </td>
        </tr>

    </table>

</form>
</div>
</div>
<%@include file="../include/admin/adminFooter.jsp"%>
</body>
</html>
