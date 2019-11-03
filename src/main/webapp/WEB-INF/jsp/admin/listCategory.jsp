<%--
  Created by IntelliJ IDEA.
  User: LaoMO
  Date: 2019/10/17
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"
  %>
<html>
<head>
    <title>分类管理</title>
</head>
<script>
  $( function () {
      $("#button").click( function () {
         if(! checkEmpty("name","分类名称")){
             return false;
         }
          if(! checkEmpty("image","分类图片")){
              return false;
          }
      });

  })
</script>

<body>
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cs}" var="c">

                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>

                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pageDiv" align="center">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
</div>


 <div   class="panel panel-warning addDiv" >

<div class="panel-heading">
新增分类
</div>
     <div class="panel-heading">
<form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">

    <table class="addTable">
<tr>
    <td> 分类名称</td><td><input type="text" id="name" name="name" class="form-control"></td>
</tr>
        <tr>
            <td>分类图片</td><td><input type="file" id="categoryPic" accept="image/*" name="image"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加分类"  class="btn-success" id="button">
            </td>
        </tr>
    </table>
</form>
     </div>
 </div>

<%@include file="../include/admin/adminFooter.jsp"%>
</body>
</html>
