<%--
  User: dc
  Date: 2019/8/26
  Time: 15:52
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
    <title>设置我的资料</title>
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
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">我的角色</label>
                            <div class="layui-input-inline">

                                    <c:choose>
                                        <c:when test='${onlineuser.userLevel=="2"}'>
                                            <input type="text" name="username" value="高级用户" readonly class="layui-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" name="username" value="普通用户" readonly class="layui-input">
                                        </c:otherwise>
                                    </c:choose>

                            </div>
                            <c:choose>
                                <c:when test='${onlineuser.userLevel=="2"}'>
                                    <div class="layui-form-mid layui-word-aux">您已经是高级用户，解锁全部功能！</div>
                                </c:when>
                                <c:otherwise>
                                    <div class="layui-form-mid layui-word-aux">您当前是普通用户，<a href="javascript:void(0)">成为高级用户</a></div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" value="${onlineuser.userName}" readonly class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-inline">
                                <input name="avatar" lay-verify="" id="LAY_avatarSrc" placeholder="图片地址" value="${onlineuser.userImgurl}" class="layui-input">
                            </div>
                            <form action="/user/uploadImg" method="post">
                                <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                    <input type="file" name="img" accept="image/*" />
                                    <input type="submit" value="上传图片" class="layui-btn layui-btn-primary"/>
                                </div>
                            </form>
                            <button class="layui-btn layui-btn-primary" layadmin-event="avartatPreview">查看图片</button >
                        </div>
                        <form action="/user/updateInfo" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userNickname" value="${onlineuser.userNickname}" lay-verify="nickname" autocomplete="off" placeholder="请输入昵称" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <c:choose>
                                    <c:when test='${onlineuser.userSex=="F"}'>
                                        <input type="radio" name="userSex" value="M" title="男">
                                        <input type="radio" name="userSex" value="F" title="女" checked>
                                    </c:when>
                                    <c:when test='${onlineuser.userSex=="M"}'>
                                        <input type="radio" name="userSex" value="M" title="男" checked>
                                        <input type="radio" name="userSex" value="F" title="女">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="userSex" value="M" title="男">
                                        <input type="radio" name="userSex" value="F" title="女">
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userPhone" value="${onlineuser.userPhone}" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userEmail" value="${onlineuser.userEmail}" lay-verify="email" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <input type="submit" class="layui-btn layui-btn-normal"  lay-filter="setmyinfo"value="确认修改"/>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script   src="https://code.jquery.com/jquery-3.4.1.slim.min.js"   integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="   crossorigin="anonymous"></script>
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set']);
</script>
</body>
</html>