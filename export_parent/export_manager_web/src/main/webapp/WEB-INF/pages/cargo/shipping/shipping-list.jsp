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
    <script src="${ctx}/plugins/jQuery/jquery-2.2.3.min.js"></script>
</head>
<script>
    function deleteById() {
        var id = getCheckId();
        if(id) {
            if(confirm("你确认要驳回此条记录吗？")) {
                location.href="${ctx}/cargo/shipping/delete.do?id="+id;
            }

        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }

    function submit() {
        var id = getCheckId();
            if(id) {
                $.get('/cargo/shipping/submit.do?id='+id).done(function (data) {
                    if (data==1||data==2||data==3||data==4) {
                        alert("此条记录正在被处理,不需要再次进行提交!");
                    }else {
                        location.href="${ctx}/cargo/shipping/list.do";
                    }
                })
                <%--location.href="${ctx}/cargo/shipping/submit.do?id="+id;--%>
            }else{
                    alert("请勾选待处理的记录，且每次只能勾选一个")
            }
    }

    function cancel() {
        var id = getCheckId();
        if(id) {
            $.get('/cargo/shipping/cancel.do?id='+id).done(function (data) {
                if (data==0||data==2||data==3||data==4||data==5) {
                    alert("此条记录正在被处理,不可以取消!");
                }else {
                    location.href="${ctx}/cargo/shipping/list.do";

                }
            })
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }

    function view() {
        var id = getCheckId();
        if(id) {
            location.href="${ctx}/cargo/shipping/toView.do?id="+id;
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }


</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
<section class="content-header">
    <h1>
        货运管理
        <small>委托单</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
    </ol>
</section>
<!-- 内容头部 /-->

<!-- 正文区域 -->
<section class="content">

    <!-- .box-body -->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">委托单列表</h3>
        </div>

        <div class="box-body">

            <!-- 数据表格 -->
            <div class="table-box">

                <!--工具栏-->
                <div class="pull-left">
                    <div class="form-group form-inline">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" title="新建" onclick='location.href="${ctx}/cargo/shipping/toAdd.do"'><i class="fa fa-file-o"></i> 新建</button>
                            <%--<button type="button" class="btn btn-default" title="查看" onclick='view()'><i class="fa  fa-eye-slash"></i> 查看</button>--%>
                            <button type="button" class="btn btn-default" title="驳回" onclick="deleteById()"><i class="fa fa-trash-o"></i> 驳回</button>
                            <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>

                            <button type="button" class="btn btn-default" title="提交" onclick="submit()"><i class="fa fa-retweet"></i> 提交</button>
                            <button type="button" class="btn btn-default" title="取消" onclick="cancel()"><i class="fa fa-remove"></i> 取消</button>

                            <%--<button type="button" class="btn btn-default" title="取消" onclick="cancel()"><i class="fa fa-remove"></i> 取消</button>--%>
                        </div>
                    </div>
                </div>
                <div class="box-tools pull-right">
                    <div class="has-feedback">
                        <input type="text" class="form-control input-sm" placeholder="搜索">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </div>
                <!--工具栏/-->

                <!--数据列表-->
                <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                    <thead>
                    <tr>
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
                            <td><c:if test="${o.state==0}">草稿</c:if>
                                <c:if test="${o.state==1}"><font color="blue">已提交</font></c:if>
                                <c:if test="${o.state==5}"><font color="green">审核成功</font></c:if>
                                        <%--2--%>
                                <c:if test="${o.state==3}"><font color="#ffc0cb">待修正</font></c:if>
                                            <%--3--%>
                                <c:if test="${o.state==2}"><font color="orange">审核中</font></c:if>
                                <c:if test="${o.state==4}"><font color="red">被驳回</font></c:if>
                            </td>
                            <%--<td>${o.createBy}</td>--%>
                            <%--<td>${o.createTime}</td>--%>
                            <%--<td>
                                &lt;%&ndash;<a href="${ctx }/cargo/contract/toView.do?id=${o.id}">[查看详情]</a>&ndash;%&gt;
                                <c:if test="${o.state==0||o.state==4}">
                                    <a href="${ctx}/cargo/shipping/toUpdate.do?id=${o.shippingOrderId}">[编辑]</a>
                                </c:if>
                                <c:if test="${o.state==1}">
                                    <a href="${ctx}/cargo/shipping/exportPdf.do?id=${o.shippingOrderId}">[下载]</a>
                                </c:if>
                            </td>--%>
                            <td class="text-center">

                                <c:if test="${o.state==0||o.state==3||o.state==4}">
                                    <button type="button" class="btn bg-danger btn-xs"
                                            onclick='location.href="${ctx}/cargo/shipping/toUpdate.do?id=${o.shippingOrderId}"'>
                                        编辑
                                    </button>
                                </c:if>
                                <button type="button" class="btn bg-olive btn-xs"
                                        onclick='location.href="${ctx}/cargo/shipping/toView.do?id=${o.shippingOrderId}"'>
                                    查看
                                </button>
                            <%--需要修改为4--%>
                                <c:if test="${o.state==2||o.state==5}">
                                    <button type="button" class="btn bg-blue btn-xs"
                                            onclick='location.href="${ctx}/cargo/shipping/exportPdf.do?id=${o.shippingOrderId}"'>
                                        下载
                                    </button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <!--
                <tfoot>
                <tr>
                <th>Rendering engine</th>
                <th>Browser</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
                </tr>
                </tfoot>-->
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
                <jsp:param value="/cargo/shipping/list.do" name="pageUrl"/>
            </jsp:include>
        </div>
        <!-- /.box-footer-->

    </div>

</section>
</div>
</body>

</html>