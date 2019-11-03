<%--
  Created by IntelliJ IDEA.
  User: LaoMO
  Date: 2019/10/31
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
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

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="/admin_category_list">所有分类</a> </li>
        <li><a href="admin_property_list?cid=${c.id}">属性管理</a></li>
        <li class="active">编辑属性</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑属性</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_property_update"  >
                <table class="editTable">
                    <tr>
                        <td>属性名称</td>
                        <td><input  id="name" name="name" value="${property.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${property.id}">
                            <input type="hidden" name="cid" value="${property.cid}">
                            <button  id="button"type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>