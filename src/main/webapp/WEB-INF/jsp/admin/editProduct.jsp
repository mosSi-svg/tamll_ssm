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
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${product.cid}">分类产品</a></li>
        <li class="active">编辑产品</li>
    </ol>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">编辑产品</div>
        <div class="panel-body">
            <form id="addForm" method="post" action="/admin_product_update">

                <table class="addTable">
                    <tr>
                        <td>产品名称</td>
                        <td><input type="text" name="name" id="name" class="form-control" value="${product.name}"></td>
                    </tr>
                    <tr>
                        <td>产品小标题</td>
                        <td><input type="text" name="subTitle" id="subTitle" class="form-control" value="${product.subTitle}"></td>
                    </tr>
                    <tr>
                        <td>原价格</td>
                        <td><input type="text" name="originalPrice" id="originalPrice" class="form-control" value="${product.originalPrice}"></td>
                    </tr>
                    <tr>
                        <td>优惠价格</td>
                        <td><input type="text" name="promatePrice" id="promatePrice" class="form-control" value="${product.promatePrice}"></td>
                    </tr>
                    <tr>
                        <td>库存</td>
                        <td><input type="text" name="stock" id="stock" class="form-control" value="${product.stock}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="hidden" name="cid" value="${product.cid}">
                            <input type="hidden" name="id" value="${product.id}">
                            <input type="submit" class="btn btn-success" value="提交">
                        </td>
                    </tr>

                </table>

            </form>
        </div>
    </div>
</div>
