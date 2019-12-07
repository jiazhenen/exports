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
            <li class="active">装箱单编辑</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

            <!--装箱单单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">编辑装箱单</div>
                <form id="editForm" action="${ctx}/cargo/packing/edit.do" method="post" >
                    <input type="hidden" name="packingListId" value="${packing.packingListId}">
                    <input id="checkedId" type="hidden" name="exportId" value="${packing.exportId}">
                    <div class="row data-type" style="margin: 0px">
                        <div class="col-md-2 title">卖方:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="卖方" name="seller" value="${packing.seller}">
                        </div>

                        <div class="col-md-2 title">买方:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="买方" name="buyer" value="${packing.buyer}">
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
                        <div class="col-md-2 title rowHeight2x">描述</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="描述" name="descriptions">${packing.descriptions}</textarea>
                        </div>

                    </div>
                </form>
            </div>
            <!--订单信息/-->

            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" onclick='submitFun()' class="btn bg-maroon">保存</button>
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/-->

        </section>
        <!-- 正文区域 /-->

        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">报运单列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 ** 报运单 状态为2 已报运 ** -->
                    <div class="table-box">
                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <td><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
                                <th class="sorting">报运号</th>
                                <th class="sorting">货物/附件</th>
                                <th class="sorting">信用证号</th>
                                <th class="sorting">收货地址</th>
                                <th class="sorting">装运港</th>
                                <th class="sorting">目的港</th>
                                <th class="sorting">运输方式</th>
                                <th class="sorting">价格条件</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.list}" var="o" varStatus="status">
                                <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
                                    <td><input type="checkbox" onclick="clickCheck()" name="id" value="${o.id}"/></td>
                                    <td>${o.id}</td>
                                    <td align="center">
                                            ${o.proNum}/${o.extNum}
                                    </td>
                                    <td>${o.lcno}</td>
                                    <td>${o.consignee}</td>
                                    <td>${o.shipmentPort}</td>
                                    <td>${o.destinationPort}</td>
                                    <td>${o.transportMode}</td>
                                    <td>${o.priceCondition}</td>
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
                        <jsp:param value="/cargo/export/list.do?" name="pageUrl"/>
                    </jsp:include>
                </div>
                <!-- /.box-footer-->
            </div>
        </form>
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

<!-- 获取选中的报运单id, 存放到表单的隐藏域中 -->
<script>
    function clickCheck() {

        let size = $("input:checkbox:checked").length;
        if (1 !== size) {
            alert("请勾选待处理的记录，且每次只能勾选一个");
            $("input:checkbox:checked").prop("checked", false)
        } else {
            $('#checkedId').val($('input[type=checkbox]:checked').val());
        }
    }

</script>
<%--<script>
    function clickCheck() {
        let pIds = document.getElementsByName("id");
        let arrs = [];
        for (pid of pIds) {
            if (pid.checked) {
                arrs.push(pid.value);
            }
        }
        $('#checkedId').val(arrs.join(","));
    }
</script>--%>

<!-- 提交表单 -->
<script>
    function submitFun() {
        let checkedIdValue = $('#checkedId').val();
        if (checkedIdValue == null || '' === checkedIdValue) {
            alert("报运单不能为空!");
        } else {
            $('#editForm').submit();
        }
    }
</script>

</html>