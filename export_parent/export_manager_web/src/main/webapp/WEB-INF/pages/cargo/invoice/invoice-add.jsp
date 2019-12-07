<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../../base.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Saas外贸进出口云平台</title>
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
            <li><a href="all-order-manage-list.html">货运管理</a></li>
            <li class="active">新增发票及委托单列表</li>
        </ol>
    </section>

    <!-- 正文区域 -->
    <section class="content">
        <form id="editForm" action="${ctx}/cargo/invoice/edit.do" method="post">

            <!--订单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">编辑新增发票</div>

                <input type="hidden" id="id" name="invoiceId" value="${invoice.invoiceId}">



                <div class="row data-type" style="margin: 0px">

<%--                    <div class="col-md-2 title">发票号</div>--%>
<%--                    <div class="col-md-4 data">--%>
<%--                        <input type="text" class="form-control" placeholder="发票号" name="scNo" value="${invoice.invoiceId}">--%>
<%--                    </div>--%>

                    <div class="col-md-2 title">贸易条款</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="贸易条款" name="tradeTerms" value="${invoice.tradeTerms}">
                    </div>

                    <div class="col-md-2 title">提单号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="提单号" name="blNo" value="${invoice.blNo}">
                    </div>
                </div>

            </div>
            <!--订单信息-->



            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/-->
            <%--    </section>
                <!-- 正文区域 /-->

                <section class="content">--%>

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">委托单列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr class="text-center">
                                <th class="" style="padding-right:0px;">

                                </th>
                                <th class="sorting">货主</th>
                                <th class="sorting">委托单号</th>
                                <th class="sorting">提单抬头</th>
                                <%--<th class="sorting">正本通知人</th>--%>
                                <th class="sorting">货运方式</th>
                                <%--<th class="sorting">信用证</th>--%>
                                <%--<th class="sorting">装运港</th>--%>
                                <%--<th class="sorting">转船港</th>--%>
                                <%--<th class="sorting">卸货港</th>--%>
                                <th class="sorting">装期</th>
                                <%--<th class="sorting">效期</th>--%>
                                <%--<th class="sorting">是否分批</th>--%>
                                <%--<th class="sorting">是否转船</th>--%>
                                <%--<th class="sorting">份数</th>--%>
                                <%--<th class="sorting">扼要说明</th>--%>
                                <%--<th class="sorting">运输要求</th>--%>
                                <th class="sorting">运费说明</th>
                                <%--<th class="sorting">复核人</th>--%>
                                <th class="sorting">状态</th>
                                <%--<th class="sorting">创建人</th>--%>
                                <%--<th class="sorting">创建时间</th>--%>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.list}" var="o" varStatus="status">
                                <tr>
                                    <td><input type="checkbox" name="id" value="${o.shippingOrderId}"/></td>
                                    <td>${o.shipper}</td>
                                    <td><a href="${ctx}/cargo/shipping/toView.do?id=${o.shippingOrderId}">${o.shippingOrderId}</a></td>
                                    <td>${o.consignee}</td>
                                        <%--<td>${o.notifyParty}</td>--%>
                                    <td>${o.orderType}</td>
                                        <%--<td>${o.lcNo}</td>--%>
                                        <%--<td>${o.portOfLoading}</td>--%>
                                        <%--<td>${o.portOfTrans}</td>--%>
                                        <%--<td>${o.portOfDischarge}</td>--%>
                                    <td><fmt:formatDate value="${o.loadingDate}" pattern="yyyy-MM-dd"/></td>
                                        <%--<td><fmt:formatDate value="${o.limitDate}" pattern="yyyy-MM-dd"/></td>--%>
                                        <%--<td><c:if test="${o.isBatch==1}"><font color="green">是</font></c:if>--%>
                                        <%--<c:if test="${o.isBatch==2}"><font color="red">否</font></c:if>--%>
                                        <%--</td>--%>
                                        <%--<td><c:if test="${o.isTrans==1}"><font color="green">是</font></c:if>--%>
                                        <%--<c:if test="${o.isTrans==2}"><font color="red">否</font></c:if>--%>
                                        <%--</td>--%>
                                        <%--<td>${o.copyNum}</td>--%>
                                        <%--<td>${o.remark}</td>--%>
                                        <%--<td>${o.specialCondition}</td>--%>
                                    <td>${o.freight}</td>
                                        <%--<td>${o.checkBy}</td>--%>
                                    <td><c:if test="${o.state==0}"><font color="red">草稿</font></c:if>
                                        <c:if test="${o.state==1}"><font color="green">提交</font></c:if>
                                        <c:if test="${o.state==2}"><font color="grey">作废</font></c:if>
                                    </td>
                                        <%--<td>${o.createBy}</td>--%>
                                        <%--<td>${o.createTime}</td>--%>
                                    <td>
                                            <%--<a href="${ctx }/cargo/contract/toView.do?id=${o.id}">[查看详情]</a>--%>
                                        <c:if test="${o.state==0}">
                                            <a href="${ctx}/cargo/shipping/toUpdate.do?id=${o.shippingOrderId}">[编辑]</a>
                                        </c:if>
<%--                                        <c:if test="${o.state==1}">--%>
<%--                                            <a href="/cargo/shipping/exportPdf.do?id=${o.shippingOrderId}">[下载]</a>--%>
<%--                                        </c:if>--%>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!--数据列表/-->
                        <!--工具栏/-->
                    </div>
                    <!-- 数据表格 /-->
                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <jsp:include page="../../common/page.jsp">
                        <jsp:param value="/cargo/shipping/toAdd.do" name="pageUrl"/>
                    </jsp:include>
                </div>
                <!-- /.box-footer-->
            </div>
        </form>

    </section>
    <!-- 提交表单 -->
    <script>
        function submitFun() {
            let checkedIdValue = $('#checkedId').val();
            if (checkedIdValue == null || '' === checkedIdValue) {
                alert("委托单不能为空!");
            } else {
                $('#editForm').submit();
            }
        }
    </script>

</div>
<!-- 内容区域 /-->
</body>

</html>