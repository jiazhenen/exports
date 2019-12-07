<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
</head>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            货运管理
            <small>发票管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">发票管理</a></li>
            <li class="active">发票表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">发票信息</div>
<%--            <form id="invoice" action="${ctx}/cargo/invoice/edit.do" method="post">--%>
<%--                <input type="hidden" name="id" value="${invoice.id}">--%>
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">发票号</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.invoiceId}
                    </div>

                    <div class="col-md-2 title">合同号</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.scNo}
                    </div>

                    <div class="col-md-2 title">创建日期</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        <div class="input-group date">
                            <fmt:formatDate value="${invoice.createTime}" pattern="yyyy-MM-dd"/>
                        </div>
                    </div>

                    <div class="col-md-2 title">提单号</div>
                    <div class="col-md-4 data" style="line-height:34px">
                       ${invoice.tradeTerms}
                    </div>

                    <div class="col-md-2 title">创建人</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.createBy}
                    </div>

                    <div class="col-md-2 title">总金额</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.amount}
                    </div>


                    <div class="col-md-2 title">状态</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.state==0?'草稿':'已上报'}
                    </div>


                    <div class="col-md-2 title">贸易条款</div>
                    <div class="col-md-4 data" style="line-height:34px">
                        ${invoice.tradeTerms}
                    </div>
<%--                    --%>
                </div>
<%--          </form>--%>
        </div>
        <!--订单信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
<%--            <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>--%>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
</html>