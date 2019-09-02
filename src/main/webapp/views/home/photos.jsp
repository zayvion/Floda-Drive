<%@ page import="java.util.List" %>
<%@ page import="com.pojo.FolderAndFile" %>
<%@ page import="com.pojo.ShowPictures" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %>
<%--
  User: dc
  Date: 2019/8/26
  Time: 9:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@page isELIgnored="false" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    List<ShowPictures> pics = (List<ShowPictures>)request.getAttribute("pics");
    List<FolderAndFile> ffs = new ArrayList<FolderAndFile>();
    for (ShowPictures showPictures:pics ) {
        for (FolderAndFile ff: showPictures.getFolderAndFiles()) {
            ffs.add(ff);
        }
    }
    String str = new Gson().toJson(ffs);
    int count = 1;
%>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>图片</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
    <link href="../../layuiadmin/style/font-awesome.min.css" rel="stylesheet">
    <script src="../../layuiadmin/lib/spotlight/js/spotlight.bundle.js"></script>
    <style>
        .spotlight-group div {
            width: 150px;
            height: 150px;
            cursor: pointer;
            background-position: center;
            background-size: cover;
            position: relative;
            display: inline-block;
        }
        .spotlight-group div i {
            font-size: 20px;
            color: #ffffff;
            visibility: hidden;
            position: absolute;
            right: 10px;
            bottom: 10px;
        }
        .spotlight-group div .imgChecked {
            color: #1E9FFF;
        }
        .spotlight-group div i:nth-of-type(1) {
            left: 10px;
            top: 10px;
        }
        /*visibility:hidden的时候元素任然存在于文档流中，同时visibility:
          hidden对应的数值0，visibility:visible对应的数值1，transition属性可以对0～1之间进行过渡。*/
        .spotlight-group div:hover i {
            visibility: visible;
        }
        .layui-tab-title .layui-btn-group button {
            border-color: #c3eaff;
            color: #0098ea;
        }
        .layui-tab-title .layui-btn-group button i{
            margin-right: 5px;
        }
        .layui-tab-title .layui-btn-group button:first-child {
            border-color: #c3eaff;
            color: #0098ea;
        }
        .layui-tab-title .layui-btn-group button:hover {
            border-color: #c3eaff;
            color: #0098ea;
        }
        .layui-tab-title .layui-btn-group button:last-child {
            color: #ffffff;
            border: none;
        }
        .layui-tab-brief>.layui-tab-more li.layui-this:after, .layui-tab-brief>.layui-tab-title .layui-this:after {
            border: none;
            border-radius: 0;
            border-bottom: 2px solid #1E9FFF;
        }
        .layui-timeline-axis {
            background-color: #fff;
            color: #777777;
        }
    </style>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-hash">
                        <ul class="layui-tab-title">
                            <li class="layui-this" lay-id="11">时光轴</li>
                            <div class="layui-btn-group layui-hide" style="float: right">
                                <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                                    <i class="fa fa-share"></i>分享
                                </button>
                                <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                                    <i class="fa fa-trash"></i>删除
                                </button>
                                <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                                    <i class="fa fa-download"></i>下载
                                </button>
                                <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="cleanImgCheck()">
                                    <span class="layui-badge layui-bg-gray" style="border-radius:10px;border: 1px solid #1E9FFF;margin:7px 7px 0 0;color: #1E9FFF!important;background-color:#eee!important;">1</span>取消
                                </button>
                            </div>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <ul class="layui-timeline">
                                    <c:forEach var="pic" items="${pics}">
                                        <li class="layui-timeline-item">
                                            <i class="layui-icon layui-timeline-axis"></i>
                                            <div class="layui-timeline-content layui-text">
                                                <h3 class="layui-timeline-title">${pic.date}</h3>
                                                <div class="spotlight-group">
                                                    <c:forEach var="showPic" items="${pic.folderAndFiles}" varStatus="sp">
                                                        <div class="image" style="background-image:url(${showPic.src})">
                                                            <i class="downLoad fa fa-check-circle" onclick="downLoad(1,this)"></i>
                                                            <i class="fa fa-search-plus" onclick="showGallery(<%=count ++ %>)"></i>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="../../layuiadmin/layui/layui.js?t=1"></script>
<script>
    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index'],function () {
        var element = layui.element;
        element.render();

    });

    //图片预览
    var gallery = <%=str%>;
    function showGallery(index) {
        Spotlight.show(gallery, {
            index: index,
            theme: "dark"
        });
    }

    /**
     * 点击选中，传入文件id，添加到下载集合
     * (1)点击选中一张图片后，显示其他图片的选中按钮、预览按钮
     * (2)选中一张图片后，显示下载分享按钮
     */
    //var fileIds = [];
    function downLoad(fileId,elm){
        //(1)点击选中一张图片后，显示其他图片的选中按钮、预览按钮
        $(elm).toggleClass('imgChecked').css('visibility','visible')
            .parent('.image').find('i').css('visibility','visible')
            .parent('.image').siblings().find('i').css('visibility','visible');

        //显示按钮组已经当前选中的个数
        if ($('.imgChecked').size() > 0) {
            $('.layui-btn-group').removeClass('layui-hide');
            $('.layui-badge').text($('.imgChecked').size());
        } else {
            $('.layui-btn-group').addClass('layui-hide');
        }
    }

    //清空所有选中
    function cleanImgCheck(){
        //移除所有选中的样式
        $('.downLoad').removeClass('imgChecked');
        //隐藏按钮组
        $('.layui-btn-group').toggleClass('layui-hide');
    }

    //删除图片

    //下载图片（批量）


</script>
</body>
</html>