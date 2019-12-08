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
            货物管理
            <small>货物表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">货物管理</a></li>
            <li class="active">货物表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">
        <%--货物信息--%>
        <div class="panel panel-default">
            <div class="panel-heading">编辑货物</div>
            <%--enctype="multipart/form-data"--%>
            <form id="editForm" action="${ctx}/product/edit.do" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${product.id}">
                <input type="hidden"  name="factoryname" id="factoryName" value="${product.factoryname}">

                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">厂家名称</div>
                    <div class="col-md-4 data">
<%--                        --%>
                        <select class="form-control" name="factoryid" id="factoryInfo" onchange="document.getElementById('factoryName').value=this.options[this.selectedIndex].text">
                            <option value="">请选择</option>
                            <c:forEach items="${factoryList}" var="factory">
                                <option value="${factory.id}"  ${product.factoryid eq factory.id ? "selected" : ""}>
                                        ${factory.factoryName}
                                </option>
                            </c:forEach>
                        </select>

                    </div>

                    <div class="col-md-2 title">货号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="货号" name="number" value="${product.number}">
                    </div>

                    <div class="col-md-2 title">货物照片</div>
                    <div class="col-md-4 data">
                        <input type="file" class="form-control" placeholder="请选择" name="productPhoto" >
                    </div>

                    <c:if test="${not empty product.photo && !(product.photo eq null) }">
                        <div class="col-md-2 title">货物照片</div>
                        <div class="col-md-4 data">
                            <c:if test="${not empty product.photo && !(product.photo eq null) }">
                                <a href="${product.photo}" target="_blank"> <img src="${product.photo}" width="300px" height="180px"></a>
                                <input type="hidden" name="photo" value="${product.photo}">
                            </c:if>

                        </div>
                    </c:if>
                    <c:if test="${empty product.photo || (product.photo eq null) }">
                        <div class="col-md-2 title">货物照片</div>
                        <div class="col-md-4 data">
                            还没有照片
                        </div>
                    </c:if>

                    <div class="col-md-2 title">描述</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="描述" name="description" value="${product.description}">
                    </div>

                    <div class="col-md-2 title">市场价</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="市场价" name="price" value="${product.price}">
                    </div>

                    <div class="col-md-2 title">尺寸长</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="尺寸长" name="length" value="${product.length}">
                    </div>

                    <div class="col-md-2 title">尺寸宽</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="尺寸宽" name="width" value="${product.width}">
                    </div>

                    <div class="col-md-2 title">尺寸高</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="尺寸高" name="height" value="${product.height}">
                    </div>

                    <div class="col-md-2 title">体积</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="体积" name="volume" value="${product.volume}">
                    </div>

                    <div class="col-md-2 title">颜色</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="颜色" name="color" value="${product.color}">
                    </div>

                    <div class="col-md-2 title">包装</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="包装" name="packaging" value="${product.packaging}">
                    </div>

                    <div class="col-md-2 title">包装单位</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" ${product.packages=="PCS"?'checked':''} name="packages" value="PCS">PCS</label></div>
                            <div class="radio"><label><input type="radio" ${product.packages=="SETS"?'checked':''} name="packages" value="SETS">SETS</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">集装箱类别</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" name="ctype" style="width: 100%;">
                            <option value="20GP" ${factory.ctype== "20GP" ? 'selected':''}>20GP</option>
                            <option value="40GP" ${factory.ctype== "40GP" ? 'selected':''}>40GP</option>
                            <option value="40HC" ${factory.ctype== "40HC" ? 'selected':''}>40HC</option>
                        </select>
                    </div>

                    <div class="col-md-2 title">数量</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="数量" name="amount" value="${product.amount}">
                    </div>

                    <div class="col-md-2 title">大箱尺寸长</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="大箱尺寸长" name="bigboxlength" value="${product.bigboxlength}">
                    </div>

                    <div class="col-md-2 title">大箱尺寸宽</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="大箱尺寸长" name="bigboxwidth" value="${product.bigboxwidth}">
                    </div>

                    <div class="col-md-2 title">大箱尺寸高</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="大箱尺寸长" name="bigboxheight" value="${product.bigboxheight}">
                    </div>

                    <div class="col-md-2 title">备注</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="备注" name="remark" value="${product.remark}">
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