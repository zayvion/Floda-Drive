<%--
  User: zayvion
  Date: 2019-08-25
  Time: 20:32
  Description：
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

                <li class="layui-nav-item" lay-unselect>
                    <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
                        <i class="layui-icon layui-icon-notice"></i>

                        <!-- 如果有新消息，则显示小圆点 -->
                        <span class="layui-badge-dot"></span>
                    </a>
                </li>
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
                <li class="layui-nav-item" lay-unselect>
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

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side  layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.jsp">
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
                                <a lay-href="./views/home/photos.jsp">
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
                    <li data-name="component" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="组件" lay-direction="2">
                            <i class="layui-icon layui-icon-component"></i>
                            <cite>组件</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="grid">
                                <a href="javascript:;">栅格</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="list"><a lay-href="component/grid/list.html">等比例列表排列</a></dd>
                                    <dd data-name="mobile"><a lay-href="component/grid/mobile.html">按移动端排列</a></dd>
                                    <dd data-name="mobile-pc"><a lay-href="component/grid/mobile-pc.html">移动桌面端组合</a></dd>
                                    <dd data-name="all"><a lay-href="component/grid/all.html">全端复杂组合</a></dd>
                                    <dd data-name="stack"><a lay-href="component/grid/stack.html">低于桌面堆叠排列</a></dd>
                                    <dd data-name="speed-dial"><a lay-href="component/grid/speed-dial.html">九宫格</a></dd>
                                </dl>
                            </dd>
                            <dd data-name="button">
                                <a lay-href="component/button/index.html">按钮</a>
                            </dd>
                            <dd data-name="form">
                                <a href="javascript:;">表单</a>
                                <dl class="layui-nav-child">
                                    <dd><a lay-href="component/form/element.html">表单元素</a></dd>
                                    <dd><a lay-href="component/form/group.html">表单组合</a></dd>
                                </dl>
                            </dd>
                            <dd data-name="nav">
                                <a lay-href="component/nav/index.html">导航</a>
                            </dd>
                            <dd data-name="tabs">
                                <a lay-href="component/tabs/index.html">选项卡</a>
                            </dd>
                            <dd data-name="progress">
                                <a lay-href="component/progress/index.html">进度条</a>
                            </dd>
                            <dd data-name="panel">
                                <a lay-href="component/panel/index.html">面板</a>
                            </dd>
                            <dd data-name="badge">
                                <a lay-href="component/badge/index.html">徽章</a>
                            </dd>
                            <dd data-name="timeline">
                                <a lay-href="component/timeline/index.html">时间线</a>
                            </dd>
                            <dd data-name="anim">
                                <a lay-href="component/anim/index.html">动画</a>
                            </dd>
                            <dd data-name="auxiliar">
                                <a lay-href="component/auxiliar/index.html">辅助</a>
                            </dd>
                            <dd data-name="layer">
                                <a href="javascript:;">通用弹层<span class="layui-nav-more"></span></a>
                                <dl class="layui-nav-child">
                                    <dd data-name="list">
                                        <a lay-href="component/layer/list.html" lay-text="layer 功能演示">功能演示</a>
                                    </dd>
                                    <dd data-name="special-demo">
                                        <a lay-href="component/layer/special-demo.html" lay-text="layer 特殊示例">特殊示例</a>
                                    </dd>
                                    <dd data-name="theme">
                                        <a lay-href="component/layer/theme.html" lay-text="layer 风格定制">风格定制</a>
                                    </dd>
                                </dl>
                            </dd>
                            <dd data-name="laydate">
                                <a href="javascript:;">日期时间</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="demo1">
                                        <a lay-href="component/laydate/demo1.html" lay-text="layDate 功能演示一">功能演示一</a>
                                    </dd>
                                    <dd data-name="demo2">
                                        <a lay-href="component/laydate/demo2.html" lay-text="layDate 功能演示二">功能演示二</a>
                                    </dd>
                                    <dd data-name="theme">
                                        <a lay-href="component/laydate/theme.html" lay-text="layDate 设定主题">设定主题</a>
                                    </dd>
                                    <dd data-name="special-demo">
                                        <a lay-href="component/laydate/special-demo.html" lay-text="layDate 特殊示例">特殊示例</a>
                                    </dd>
                                </dl>
                            </dd>
                            <dd data-name="table-static">
                                <a lay-href="component/table/static.html">静态表格</a>
                            </dd>
                            <dd data-name="table">
                                <a href="javascript:;">数据表格</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="simple">
                                        <a lay-href="component/table/simple.html" lay-text="">简单数据表格</a>
                                    </dd>
                                    <dd data-name="auto">
                                        <a lay-href="component/table/auto.html" lay-text="">列宽自动分配</a>
                                    </dd>
                                    <dd data-name="data">
                                        <a lay-href="component/table/data.html" lay-text="">赋值已知数据</a>
                                    </dd>
                                    <dd data-name="tostatic">
                                        <a lay-href="component/table/tostatic.html" lay-text="">转化静态表格</a>
                                    </dd>
                                    <dd data-name="page">
                                        <a lay-href="component/table/page.html" lay-text="">开启分页</a>
                                    </dd>
                                    <dd data-name="resetPage">
                                        <a lay-href="component/table/resetPage.html" lay-text="">自定义分页</a>
                                    </dd>
                                    <dd data-name="toolbar">
                                        <a lay-href="component/table/toolbar.html" lay-text="">开启头部工具栏</a>
                                    </dd>
                                    <dd data-name="totalRow">
                                        <a lay-href="component/table/totalRow.html" lay-text="">开启合计行</a>
                                    </dd>
                                    <dd data-name="height">
                                        <a lay-href="component/table/height.html" lay-text="">高度最大适应</a>
                                    </dd>
                                    <dd data-name="checkbox">
                                        <a lay-href="component/table/checkbox.html" lay-text="">开启复选框</a>
                                    </dd>
                                    <dd data-name="radio">
                                        <a lay-href="component/table/radio.html" lay-text="">开启单选框</a>
                                    </dd>
                                    <dd data-name="cellEdit">
                                        <a lay-href="component/table/cellEdit.html" lay-text="">开启单元格编辑</a>
                                    </dd>
                                    <dd data-name="form">
                                        <a lay-href="component/table/form.html" lay-text="">加入表单元素</a>
                                    </dd>
                                    <dd data-name="style">
                                        <a lay-href="component/table/style.html" lay-text="">设置单元格样式</a>
                                    </dd>
                                    <dd data-name="fixed">
                                        <a lay-href="component/table/fixed.html" lay-text="">固定列</a>
                                    </dd>
                                    <dd data-name="operate">
                                        <a lay-href="component/table/operate.html" lay-text="">数据操作</a>
                                    </dd>
                                    <dd data-name="parseData">
                                        <a lay-href="component/table/parseData.html" lay-text="">解析任意数据格式</a>
                                    </dd>
                                    <dd data-name="onrow">
                                        <a lay-href="component/table/onrow.html" lay-text="">监听行事件</a>
                                    </dd>
                                    <dd data-name="reload">
                                        <a lay-href="component/table/reload.html" lay-text="">数据表格的重载</a>
                                    </dd>
                                    <dd data-name="initSort">
                                        <a lay-href="component/table/initSort.html" lay-text="">设置初始排序</a>
                                    </dd>
                                    <dd data-name="cellEvent">
                                        <a lay-href="component/table/cellEvent.html" lay-text="">监听单元格事件</a>
                                    </dd>
                                    <dd data-name="thead">
                                        <a lay-href="component/table/thead.html" lay-text="">复杂表头</a>
                                    </dd>
                                </dl>
                            </dd>
                            <dd data-name="laypage">
                                <a href="javascript:;">分页</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="demo1">
                                        <a lay-href="component/laypage/demo1.html" lay-text="layPage 功能演示一">功能演示一</a>
                                    </dd>
                                    <dd data-name="demo2">
                                        <a lay-href="component/laypage/demo2.html" lay-text="layPage 功能演示二">功能演示二</a>
                                    </dd>
                                </dl>
                            </dd>
                            <dd data-name="upload">
                                <a href="javascript:;">上传</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="demo1">
                                        <a lay-href="component/upload/demo1.html" lay-text="上传功能演示一">功能演示一</a>
                                    </dd>
                                    <dd data-name="demo2">
                                        <a lay-href="component/upload/demo2.html" lay-text="上传功能演示二">功能演示二</a>
                                    </dd>
                                </dl>
                            </dd>
                            <dd data-name="colorpicker">
                                <a lay-href="component/colorpicker/index.html">颜色选择器</a>
                            </dd>
                            <dd data-name="slider">
                                <a lay-href="component/slider/index.html">滑块组件</a>
                            </dd>
                            <dd data-name="rate">
                                <a lay-href="component/rate/index.html">评分</a>
                            </dd>
                            <dd data-name="carousel">
                                <a lay-href="component/carousel/index.html">轮播</a>
                            </dd>
                            <dd data-name="flow">
                                <a lay-href="component/flow/index.html">流加载</a>
                            </dd>
                            <dd data-name="util">
                                <a lay-href="component/util/index.html">工具</a>
                            </dd>
                            <dd data-name="code">
                                <a lay-href="component/code/index.html">代码修饰</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="get" class="layui-nav-item">
                        <a href="javascript:;" lay-href="//www.layui.com/admin/#get" lay-tips="我的分享" lay-direction="2">
                            <i class="layui-icon layui-icon-share"></i>
                            <cite>我的分享</cite>
                        </a>
                    </li>
                    <li data-name="get" class="layui-nav-item">
                        <a href="javascript:;" lay-href="//www.layui.com/admin/#get" lay-tips="回收站" lay-direction="2">
                            <i class="layui-icon layui-icon-delete"></i>
                            <cite>回收站</cite>
                        </a>
                    </li>
                </ul>

               <div style="width: 220px;height: 50px;position: relative;top: 200px;">
                   <div class="layui-progress-bar layui-bg-blue" lay-percent="30%" style="width: ${sizePresent}%;height: 8px;position: absolute;"><span class="layui-progress-text" style="color: #F6F6F6">${sizePresent}%</span></div>
                   <span style="display:inline-block;margin-top:20px;">网盘容量：${userTotalSize}M/${TotalSize}M</span>
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
