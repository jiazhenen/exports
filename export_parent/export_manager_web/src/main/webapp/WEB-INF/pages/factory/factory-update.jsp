<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
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
<div id="frameContent">
    <!-- 内容头部 -->
    <section class="content-header" class="content-wrapper" style="margin-left:0px;">
        <h1>
            订单管理
            <small>订单表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">订单管理</a></li>
            <li class="active">订单表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">订单信息</div>
            <form id="editForm" action="/factory/edit.do" method="post" class="uk-form">
                <input type="hidden" name="id" value="${factory.id}">

                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">厂家全称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="厂家全称" name="fullname" value="${factory.fullName}">
                    </div>

                    <div class="col-md-2 title">厂家简称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="厂家简称" name="factoryName" value="${factory.factoryName}">
                    </div>

                    <div class="col-md-2 title">厂家类型</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" name="ctype" style="width: 100%;">
                            <option value="货物" ${factory.ctype== "货物" ? 'selected':''}>货物</option>
                            <option value="附件" ${factory.ctype== "附件" ? 'selected':''}>附件</option>
                        </select>
                    </div>

                    <div class="col-md-2 title">联系人</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="联系人" name="city" value="${factory.contacts}">
                    </div>

                    <div class="col-md-2 title">电话</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="电话" name="phone" value="${factory.phone}">
                    </div>

                    <div class="col-md-2 title">手机</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="手机" name="mobile" value="${factory.mobile}">
                    </div>

                    <div class="col-md-2 title">传真</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="传真" name="fax" value="${factory.fax}">
                    </div>

                    <div class="col-md-2 title">地址</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="地址" name="address" value="${factory.address}">
                    </div>

                    <div class="col-md-2 title">验货员</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="验货员" name="inspector" value="${factory.inspector}">
                    </div>

                    <div class="col-md-2 title">说明</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="说明" name="remark" value="${factory.remark}">
                    </div>

                    <div class="col-md-2 title">排序号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="排序号" name="orderNo" value="${factory.orderNo}">
                    </div>

                    <div class="col-md-2 title">状态</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" name="state" style="width: 100%;">
                            <option value="0" ${factory.state==0 ? 'selected':''}>停用</option>
                            <option value="1" ${factory.state==1 ? 'selected':''}>正常</option>
                        </select>
                    </div>

                </div>
            </form>
        </div>
        <!--订单信息/-->
        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script type="text/javascript">
    $(function () {
        $(".datepicker").datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            clearBtn: true,//清除按钮
            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
        });
    });
</script>
</html>