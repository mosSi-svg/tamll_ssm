<%--
  Created by IntelliJ IDEA.
  User: LaoMO
  Date: 2019/11/1
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
    $(function() {

        $("#addForm").submit(function() {
            if (checkEmpty("name", "属性名称"))
                return true;
            return false;
        });
    });
</script>
<html>
<head>
    <title>属性管理</title>
</head>
<body>
<div class="workingArea">
  <ol class="breadcrumb">
<li>
    <a href="/admin_category_list">所有分类</a>
</li>
<li class="active">
属性管理
</li>
  </ol>
    <div class="ListDataTableDiv">
    <table class="table table-striped table-bordered table-hover  table-condensed">
   <thead>
    <tr class="success">
        <th>
            ID
        </th>
        <th>
            属性名称
        </th>
        <th>
            编辑
        </th>
        <th>
            删除
        </th>
    </tr>
   </thead>
        <tbody>
<c:forEach varStatus="st" items="${ps}" var="p">
    <tr>

       <td>
           ${p.id}
       </td>
        <td>
            ${p.name}
        </td>
        <td>
          <a href="/admin_property_edit?id=${p.id}&cid=${c.id}"><span class="glyphicon glyphicon-edit"></span></a>
        </td>
        <td>
            <a deleteLink="true" href="/admin_property_delete?id=${p.id}&cid=${c.id}"><span class="glyphicon glyphicon-trash"></span></a>
        </td>

    </tr>
</c:forEach>

        </tbody>

    </table>

    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>
    <div class="panel panel-warning addDiv">
    <div class="panel-heading">
        新增属性
    </div>
        <div class="panel-body">
            <form method="post" action="/admin_property_add?cid=${c.id}" id="addForm">
           <table>
               <tr>
                   <td>属性名称</td>
                   <td>
                       <input type="text" name="name" id="name" class="form-control">
                   </td>
               </tr>
               <tr class="submitTR">
               <td colspan="2" align="center">
               <input type="hidden" value="${c.id}">
                   <input type="submit" value="提交属性" class=" btn btn-success">
               </td>
               </tr>

           </table>

            </form>
        </div>
    </div>

    <div>

    </div>
</div>
<%@include file="../include/admin/adminFooter.jsp"%>
</body>
</html>
