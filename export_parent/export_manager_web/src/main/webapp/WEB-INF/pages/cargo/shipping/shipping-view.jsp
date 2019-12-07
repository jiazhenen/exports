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
            <small>委托管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">委托管理</a></li>
            <li class="active">委托单查看</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

            <!--委托单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">查看委托单</div>
                <form id="editForm" action="${ctx}/cargo/shipping/edit.do" method="post" >
                    <input type="hidden" name="shippingOrderId" value="${shipping.shippingOrderId}">
                    <div class="row data-type" style="margin: 0px">
                        <div class="col-md-2 title">货运类型:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="货运类型" name="orderType" value="${shipping.orderType}">
                        </div>

                        <div class="col-md-2 title">托运方:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="托运方" name="shipper" value="${shipping.shipper}">
                        </div>

                        <div class="col-md-2 title">收货方:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="收货方" name="consignee" value="${shipping.consignee}">
                        </div>



                        <div class="col-md-2 title">通知人:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="通知人" name="notifyParty" value="${shipping.notifyParty}" >
                        </div>

                        <div class="col-md-2 title">信用证号:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="信用证号" name="lcNo" value="${shipping.lcNo}">
                        </div>

                        <div class="col-md-2 title">装货港:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="装货港" name="portOfLoading" value="${shipping.portOfLoading}">
                        </div>

                        <div class="col-md-2 title">转运港:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="转运港" name="portOfTrans" value="${shipping.portOfTrans}">
                        </div>

                        <div class="col-md-2 title">目的港:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="目的港" name="portOfDischarge" value="${shipping.portOfDischarge}">
                        </div>

                        <div class="col-md-2 title">装货日期:</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" placeholder="装货日期"  name="loadingDate" class="form-control pull-right"
                                       value="<fmt:formatDate value="${shipping.loadingDate}" pattern="yyyy-MM-dd"/>" id="loadingDate">
                            </div>
                        </div>

                        <div class="col-md-2 title">有效日期:</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" placeholder="有效日期"  name="limitDate" class="form-control pull-right"
                                       value="<fmt:formatDate value="${shipping.limitDate}" pattern="yyyy-MM-dd"/>" id="limitDate">
                            </div>
                        </div>

                        <div class="col-md-2 title">分批装运:</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="isBatch">
                                <option value="">请选择</option>
                                <option ${o.isBatch == "0" ?'selected':''} value="0">否</option>
                                <option ${o.isBatch == "1" ?'selected':''} value="1">是</option>
                            </select>
                        </div>

                        <div class="col-md-2 title">是否交易:</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="isTrans">
                                <option value="">请选择</option>
                                <option ${o.isTrans == "0" ?'selected':''} value="0">否</option>
                                <option ${o.isTrans == "1" ?'selected':''} value="1">是</option>
                            </select>
                        </div>

                        <div class="col-md-2 title">提单份数:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="提单份数" name="copyNum" value="${shipping.copyNum}">
                        </div>

                        <div class="col-md-2 title">特殊条款:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="特殊条款" name="specialCondition" value="${shipping.specialCondition}">
                        </div>

                        <div class="col-md-2 title">运费:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="运费" name="freight" value="${shipping.freight}">
                        </div>

                        <div class="col-md-2 title">校验人:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="校验人" name="checkBy" value="${shipping.checkBy}">
                        </div>

                        <div class="col-md-2 title">状态:</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="state" value="${o.state == 1 ? "已上报" : "草稿"}" />
                            <%--<c:if test="${o.state==0}">草稿</c:if>
                            <c:if test="${o.state==1}"><font color="green">已上报</font></c:if>--%>
                        </div>

                        <div class="col-md-2"></div>
                        <div class="col-md-4 data"></div>

                        <div class="col-md-2 title rowHeight2x">备注</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="备注" name="remark">${shipping.remark}</textarea>
                        </div>

                    </div>
                </form>
            </div>
            <!--订单信息/-->

            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/-->

        </section>
        <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../../css/style.css">
<script>
    $('#loadingDate').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>
<script>
    $('#limitDate').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>

</html>