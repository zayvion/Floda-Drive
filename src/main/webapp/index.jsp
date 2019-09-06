<%--
  User: zayvion
  Date: 2019-08-25
  Time: 20:32
  Description：主页
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
    <title>FlodaDrive-一种生活态度</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="./layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./layuiadmin/style/admin.css" media="all">
    <link rel="shortcut icon" href="./views/imgs/logo16.png" />
    <link rel="bookmark"href="./views/imgs/logo16.png" />
    <style>
        .layui-nav-tree .layui-nav-bar {
            background-color: #1E9FFF;
        }
        .layui-progress-text{
            color: #ffffff;
        }
    </style>
    <base href="<%=basePath%>">
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect  style="margin-right: 50px;">
                    <a href="javascript:;">
                        <cite>
                           <c:choose>
                               <c:when test="${onlineuser.userNickname!= null}">
                                   ${onlineuser.userNickname}
                               </c:when>
                               <c:otherwise>
                                   ${onlineuser.userName}
                               </c:otherwise>
                           </c:choose>
                        </cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="/user/info">基本资料</a></dd>
                        <dd><a lay-href="views/set/user/password.jsp">修改密码</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a href="user/logout">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side  layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="views/home/console.jsp">
                    <img src="./views/imgs/yun-2.png" alt="" style="height: 30px;margin: 0 5px 10px 0"><span style="font-size: 1.5em">FlodaDrive</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-list"></i>
                            <cite>全部文件</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">
                                <a lay-href="./views/home/console.jsp">
                                    文件夹
                                </a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="/userfile/getAllPic">
                                    图片
                                </a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="./views/home/file.jsp">
                                    文档
                                </a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="./views/home/video.jsp">
                                    视频
                                </a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="./views/home/music.jsp">
                                    音乐
                                </a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="./views/home/other.jsp">
                                    其他
                                </a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="get" class="layui-nav-item">
                        <a href="javascript:;" lay-href="./views/home/share.jsp" lay-tips="我的分享">
                            <i class="layui-icon layui-icon-share"></i>
                            <cite>我的分享</cite>
                        </a>
                    </li>
                    <li data-name="get" class="layui-nav-item">
                        <a href="javascript:;" lay-href="./views/home/trash.jsp" lay-tips="回收站">
                            <i class="layui-icon layui-icon-delete"></i>
                            <cite>回收站</cite>
                        </a>
                    </li>
                </ul>

<%--               <div style="width: 220px;position: relative;top: 200px;border-radius: 20px; background-color: #ffffff;">--%>
<%--                   <div class="layui-progress-bar layui-bg-blue" lay-percent="30%" style="width: ${sizePresent}%;height: 8px;position: absolute;"><--%>
<%--                   </div>--%>
<%--                   <span class="layui-progress-text" style="color: #F6F6F6">${sizePresent}%</span>--%>
<%--                   --%>
<%--               </div>--%>
                <div class="layui-progress" lay-showpercent="true" style="width: 180px;margin:100px 0 0 15px;height: 8px;">
                    <div class="layui-progress-bar" lay-percent="${sizePresent}%" style="height: 8px;background-color: #1E9FFF"></div>
                    <span style="display:inline-block;font-size: 12px;margin: 15px 0 0 5px">网盘容量：${userTotalSize}M/${TotalSize}M</span>
                </div>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="./views/home/console.jsp" lay-attr="./views/home/console.jsp" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="./views/home/console.jsp" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="./layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: './layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>


</body>
</html>
