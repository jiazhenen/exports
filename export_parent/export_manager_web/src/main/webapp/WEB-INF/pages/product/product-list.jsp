<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
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
    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
</head>
<script>
    function deleteById() {
        var id = getCheckId()
        if(id) {
            if(confirm("你确认要删除此条记录吗？")) {
                location.href="/product/delete.do?id="+id;
            }
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }
</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
<section class="content-header">
    <h1>
        货物管理
        <small>货物列表</small>
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
            <h3 class="box-title">列表</h3>
        </div>

        <div class="box-body">

            <!-- 数据表格 -->
            <div class="table-box">

                <!--工具栏-->
                <div class="pull-left">
                    <div class="form-group form-inline">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" title="新建" onclick='location.href="/product/toAdd.do"'><i class="fa fa-file-o"></i> 新建</button>
                            <button type="button" class="btn btn-default" title="删除" onclick='deleteById()'><i class="fa fa-trash-o"></i> 删除</button>
                            <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
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
                        <th class="sorting">编号</th>
                        <th class="sorting">描述</th>
                        <th class="sorting">厂家简称</th>
                        <th class="sorting">市场价</th>
                        <th class="sorting">尺寸长</th>
                        <th class="sorting">尺寸宽</th>
                        <th class="sorting">尺寸高</th>
                        <th class="sorting">颜色</th>
                        <th class="sorting">包装</th>
                        <th class="sorting">包装单位</th>
                        <th class="sorting">集装箱类别</th>
                        <th class="sorting">数量</th>
                        <th class="sorting">体积</th>
                        <th class="sorting">大箱尺寸长</th>
                        <th class="sorting">大箱尺寸宽</th>
                        <th class="sorting">大箱尺寸高</th>
                        <th class="sorting">备注</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="item">
                    <tr>
<%--
    private String id;
    private String number;//编号
    private String photo;//照片
    private String describe;//描述
    private String factoryid;//
    private String factoryname;//厂家简称
    private Long price;//市场价
    private BigDecimal length;//尺寸长
    private BigDecimal width;//尺寸宽
    private BigDecimal height;//尺寸高
    private String color;//颜色
    private String packaging;//包装
    private String packages;//包装单位
    private BigDecimal containertype;//集装箱类别 20GP/40GP/40HC
    private Integer amount;//数量
    private BigDecimal volume;//体积
    private BigDecimal bigboxlength;//大箱尺寸长
    private BigDecimal bigboxwidth;//大箱尺寸宽
    private BigDecimal bigboxheight;//大箱尺寸高
    private String remark;//备注
    private Date entry;//录入时间
    private String creator;//创建人
    private String createdept;//创建部门
    private Date createdate;//创建日期
--%>
                        <td><input name="ids" value="${item.id}" type="checkbox"></td>

                        <td>${item.number}</td>
                        <td>${item.description}</td>
                        <td>${item.factoryname}</td>
                        <td>${item.price}</td>
                        <td>${item.length}</td>
                        <td>${item.width}</td>
                        <td>${item.height}</td>
                        <td>${item.color}</td>
                        <td>${item.packaging}</td>
                        <td>${item.packages}</td>
                        <td>${item.containertype}</td>
                        <td>${item.amount}</td>
                        <td>${item.volume}</td>
                        <td>${item.bigboxlength}</td>
                        <td>${item.bigboxwidth}</td>
                        <td>${item.bigboxheight}</td>
                        <td>${item.remark}</td>

                        <td class="text-center">
                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/product/toUpdate.do?id=${item.id}"'>编辑</button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /.box-body -->

        <!-- .box-footer-->
        <%--<div class="box-footer">
            

            <div class="box-tools pull-right">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">首页</a>
                    </li>
                    <li><a href="#">上一页</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">下一页</a></li>
                    <li>
                        <a href="#" aria-label="Next">尾页</a>
                    </li>
                </ul>
            </div>

        </div>--%>


        <div class="box-footer">
            <jsp:include page="../common/page.jsp">
                <jsp:param value="${ctx}/product/list.do" name="pageUrl"/>
            </jsp:include>
        </div>
        <!-- /.box-footer-->

    </div>
</section>
</div>
</body>

</html>