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
            系统管理
            <small>用户管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/system/user/list.do">用户列表</a></li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">用户信息</div>
            <form id="editForm" action="/system/user/edit.do" method="post">
                <input type="hidden" id="id" name="id" value="${user.id}">
                <input type="hidden" id="deptName" name="deptName" value="${user.deptName}">
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">用户名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="用户名称" id="name" name="userName" value="${user.userName}">
                    </div>

                    <div class="col-md-2 title">所在部门</div>
                    <div class="col-md-4 data">
                        <select class="form-control" onchange="document.getElementById('deptName').value=this.options[this.selectedIndex].text" name="deptId">
                            <option value="">请选择</option>
                            <c:forEach items="${deptList}" var="item">
                                <option ${user.deptId == item.id ?'selected':''} value="${item.id}">${item.deptName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="邮箱" id="emailld" name="email" value="${user.email}">
                    </div>

                    <div class="col-md-2 title">密码</div>
                    <div class="col-md-4 data">
                        <input type="password" class="form-control" placeholder="密码" name="password" value="${user.password}">
                    </div>

                    <div class="col-md-2 title">薪水</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="薪水" name="salary" value="${user.salary}">
                    </div>

                    <div class="col-md-2 title">状态</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" ${user.state==0?'checked':''} name="state" value="0">停用</label></div>
                            <div class="radio"><label><input type="radio" ${user.state==1?'checked':''} name="state" value="1">启用</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">入职时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="入职时间"  name="joinDate" class="form-control pull-right"
                                   value="${user.joinDate}" id="datepicker">
                        </div>
                    </div>

                    <div class="col-md-2 title">等级</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline" >
                            <select class="form-control" onchange="document.getElementById('degree').value=this.options[this.selectedIndex].text" name="degree">
                                <option ${user.degree == 1 ?'selected':''} value="1">系统管理员</option>
                                <option ${user.degree == 2 ?'selected':''} value="2">管理所有下属部门和人员</option>
                                <option ${user.degree == 3 ?'selected':''} value="3">管理本部门</option>
                                <option ${user.degree == 4 ?'selected':''} value="4">普通员工</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-2 title">性别</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" ${user.gender==0?'checked':''} name="gender" value="0">男</label></div>
                            <div class="radio"><label><input type="radio" ${user.gender==1?'checked':''} name="gender" value="1">女</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">岗位</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="岗位" name="station" value="${user.station}">
                    </div>
                    <div class="col-md-2 title">电话</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="电话" id="phone" name="telephone" value="${user.telephone}">
                    </div>

                    <div class="col-md-2 title">出生年月</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="出生年月" class="form-control pull-right" name="birthday"
                                   value="${user.birthday}" id="datepicker1">
                        </div>
                    </div>
                    <div class="col-md-2 title">排序号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="排序号" name="orderNo" value="${user.orderNo}">
                    </div>
                    <div class="col-md-2 title">说明</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="说明" name="remark" value="${user.remark}">
                    </div>
                </div>
            </form>
        </div>
        <!--订单信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="button" onclick="sun()" class="btn bg-maroon">保存</button>
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
    $('#datepicker').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
    $('#datepicker1').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>
<script>
    //校验姓名
    function username(str) {
        //获取输入的员工姓名的值
        let name = $("#name").val();
        //定义校验输入员工姓名的正则表达式-单词字符8-20
        let reg_name =/^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{2,10}$/;
        //判断输入的员工姓名是否符合规则
        let flag = reg_name.test(name);
        if (flag){//符合规则
            // alert("姓名符合规则")
            $("#name").css("border\",\"1px solid green");
        }else{
            //不符合规则
            //alert("姓名不符合规则")
            $("#name").css("border","1px solid red");
        }
        $("name").blur(username)
        return flag;
    }


    //验证邮箱字段
    function emailCheck(str) {
        let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        let email = $("#emailld").val();
        let flag = reg.test(email);
        if (flag){
            //符合规则
            // alert("邮箱符合规则")
            $("#emailId").css("border","1px solid green");
        }else {
            //不符合规则
            $("#emailld").css("border","1px solid red")
        }
        $("#emailId").blur(emailCheck);
        return flag;
    }


    //验证手机号
    function telephone(str) {
        let reg = /^\d{11}$/;
        let User_tel = $("#phone").val();
        let flag = reg.test(User_tel);
        if(flag){  //符合规则
            // alert("邮箱符合规则!");
            $("#phone").css("border","1px solid green");
        } else { //不符合规则
            $("#phone").css("border","1px solid red");
        }
        $("#phone").blur(telephone);
        return flag;
        }
//提交表单时检验所有表单中填写的信息
        function sun() {
            let fl = username();
            let el = emailCheck();
            let te = telephone();

            //如果都通过
            if (fl==false){
                alert("输入用户名有误,用户名由英文字母和数字组成的2-10位字符");
                return false
            } else if (el==false){
                alert("邮箱输入有误,必须符合邮箱规则!")
                return false
            } else if (te = false){
                alert("输入电话有误,必须是11位数")
                return false
            }
            $('#editForm').submit()
    }

</script>
</html>