<%--
  User: zwf97
  Date: 2019/8/26
  Time: 14:00
  Description：忘记密码
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
    <meta charset="utf-8">
    <title>忘记密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="../layuiadmin/style/login.css" media="all">
    <base href="<%=basePath%>">
</head>
<body>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <img src="../views/imgs/logo200.png">
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-reply-fill" for="LAY-user-login-cellemail"></label>
                <input type="text" name="cellemail" id="LAY-user-login-cellemail" lay-verify="email" placeholder="请输入注册时的邮箱"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                        <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="验证码"
                               class="layui-input">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <a type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="btn_code"
                               href="javascript:void(0)">获取验证码</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="新密码"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
                <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="LAY-user-forget-submit" style="width: 100%">重置密码</button>
            </div>
        </div>
    </div>

</div>

<script src="../layuiadmin/layui/layui.js"></script>
<script src="../../layuiadmin/layui/jquery.min.js"></script>
<script>
    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user'], function () {
        var $ = layui.$
            , setter = layui.setter
            , admin = layui.admin
            , form = layui.form
            , router = layui.router();

        form.render();


        //找回密码下一步
        form.on('submit(LAY-user-forget-submit)', function (obj) {

            var field = obj.field;
            //确认密码
            if (field.password !== field.repass) {
                return layer.msg('两次密码输入不一致');
            }
            //请求接口
            admin.req({
                url: layui.setter.base + 'json/user/forget.js' //实际使用请改成服务端真实接口
                , data: field
                , done: function (res) {
                    location.hash = '/type=resetpass';
                    location.reload();
                }
            });

            return false;
        });

    });
    $("#btn_code").click(function () {
        let count = 60;
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