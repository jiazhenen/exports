<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <small>装箱管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">装箱管理</a></li>
            <li class="active">装箱单查看</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--装箱单单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">查看装箱单</div>
                <input type="hidden" name="packingListId" value="${packing.packingListId}">
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">卖方:</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="卖方" name="seller" value="${packing.seller}">
                    </div>

                    <div class="col-md-2 title">买方:</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="买方" name="packing" value="${packing.buyer}">
                    </div>

                    <div class="col-md-2 title">发票号:</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="发票号" name="invoiceNo" value="${packing.invoiceNo}" >
                        <!-- 发票号选择还是直接填? **** -->
                        <%--<select name="invoiceNo">
                            <option value="">请选择</option>
                            <option ${o.invoiceNo == "02136666" ?'selected':''} value="02136666">发票号码1</option>
                            <option ${o.invoiceNo == "02137777" ?'selected':''} value="02137777">发票号码2</option>
                            <option ${o.invoiceNo == "02138888" ?'selected':''} value="02138888">发票号码3</option>
                        </select>--%>
                    </div>

                    <div class="col-md-2 title">发票日期:</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="发票日期"  name="invoiceDate" class="form-control pull-right"
                                   value="<fmt:formatDate value="${packing.invoiceDate}" pattern="yyyy-MM-dd"/>" id="invoiceDate">
                        </div>
                    </div>

                    <div class="col-md-2 title">唛头:</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="唛头" name="marks" value="${packing.marks}">
                    </div>

                    <div class="col-md-2 title">状态:</div>
                    <div class="col-md-4 data">
                        <input class="disabled" type="text" name="state" value="${o.state == 1 ? "已上报" : "草稿"}" />
                        <%--<c:if test="${o.state==0}">草稿</c:if>
                        <c:if test="${o.state==1}"><font color="green">已上报</font></c:if>--%>
                    </div>

                    <div class="col-md-2 title rowHeight2x">描述</div>
                    <div class="col-md-10 data rowHeight2x">
                        <textarea class="form-control" rows="3" placeholder="描述" name="descriptions">${packing.descriptions}</textarea>
                    </div>

                </div>
            </div>
            <!--订单信息/-->

            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/-->
        </section>

</div>
<!-- 内容区域 /-->
</body>
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../../css/style.css">
<script>
    $('#invoiceDate').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>

</html>