<%--
  User: dc
  Date: 2019/8/26
  Time: 15:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>设置我的密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改密码</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email" id="LAY-user-login-cellemail" lay-verify="email" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                                <label class="layui-form-label">验证码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="mailCode" id="LAY-user-login-vercode" lay-verify="required" class="layui-input">
                                </div>
                                <div  class="layui-input-inline">
                                    <div style="margin-left: 10px;">
                                        <a type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="btn_code" href="javascript:void(0)">获取验证码</a>
                                    </div>
                                </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" lay-verify="pass" lay-verType="tips" autocomplete="off" id="LAY_password" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="repassword" lay-verify="repass" lay-verType="tips" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="setmypass">确认修改</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script src="../../../layuiadmin/layui/jquery.min.js"></script>
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set']);
    $("#btn_code").click(function () {
        var email = $("#LAY-user-login-cellemail").val();
        console.log(email);
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        console.log(!reg.test(email));
        if(email == '' || !reg.test(email)){
            alert("邮箱格式错误");
            return;
        }
        $.post('/user/sendRegCode?mailBox='+email, function () {
            console.log('验证码发送成功');
        });
        var count = 60;
        const countDown = setInterval(() => {
            if (count === 0) {
            $('#btn_code').text('重新发送').removeAttr('disabled');
            $('#btn_code').css({
                background: '#EEEEEE',
                color: '#666666',
                cursor: 'pointer'
            });
            clearInterval(countDown);
        } else {
            $('#btn_code').attr('disabled', true);
            $('#btn_code').css({
                background: '#F6F6F6',
                color: '#C5C5C5',
                cursor: 'default'
            });
            $('#btn_code').text(count + '秒可重新获取');
            count--;

        }
    }, 1000);

    })
</script>
</body>
</html>