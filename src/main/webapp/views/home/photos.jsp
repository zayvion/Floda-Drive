<%--
  User: dc
  Date: 2019/8/26
  Time: 9:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><base href="<%=basePath%>">
<head>
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

        .spotlight-group div i:nth-of-type(1) {
            left: 10px;
            top: 10px;
        }

        /*visibility:hidden的时候元素任然存在于文档流中，同时visibility:
          hidden对应的数值0，visibility:visible对应的数值1，transition属性可以对0～1之间进行过渡。*/
        .spotlight-group div:hover i {
            visibility: visible;
        }

        .spotlight-group div .imgChecked{
            color:#1E9FFF;
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
                            <li lay-id="22">最近上传</li>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <ul class="layui-timeline">
                                    <li class="layui-timeline-item">
                                        <i class="layui-icon layui-timeline-axis"></i>
                                        <div class="layui-timeline-content layui-text">
                                            <h3 class="layui-timeline-title">12月28日</h3>
                                            <div class="spotlight-group">
                                                <div class="image" style="background-image:url(../imgs/test.jpg)">
                                                    <i class="downLoad fa fa-check-circle" onclick="downLoad(1,this)"></i>
                                                    <i class="fa fa-search-plus" onclick="showGallery(1)"></i>
                                                </div>
                                                <div class="image" style="background-image:url(../imgs/test1.jpg)">
                                                    <i class="downLoad fa fa-check-circle" onclick="downLoad(2,this)"></i>
                                                    <i class="fa fa-search-plus" onclick="showGallery(2)"></i>
                                                </div>
                                                <div class="image" style="background-image:url(../imgs/test2.jpg)">
                                                    <i class=" downLoad fa fa-check-circle" onclick="downLoad(3,this)"></i>
                                                    <i class="fa fa-search-plus" onclick="showGallery(3)"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="layui-timeline-item">
                                        <i class="layui-icon layui-timeline-axis"></i>
                                        <div class="layui-timeline-content layui-text">
                                            <h3 class="layui-timeline-title">12月25日</h3>

                                        </div>
                                    </li>
                                    <li class="layui-timeline-item">
                                        <i class="layui-icon layui-timeline-axis"></i>
                                        <div class="layui-timeline-content layui-text">
                                            <h3 class="layui-timeline-title">12月24日</h3>

                                        </div>
                                    </li>
                                    <li class="layui-timeline-item">
                                        <i class="layui-icon layui-timeline-axis"></i>
                                        <div class="layui-timeline-content layui-text">
                                            <div class="layui-timeline-title">过去</div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="layui-tab-item">

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
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-checkbox'
            , skin: 'row'
            , url: layui.setter.base + 'json/table/user.js'//获取数据的地方
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[{type: 'checkbox'}
                , {field: 'folder', width: 600, title: '文件名', sort: true}
                , {field: 'size', width: 220, title: '大小', sort: true}
                , {field: 'updatetime', title: '修改日期', sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ]]
        });

        table.on('checkbox(test-table-checkbox)', function (obj) {
            var checkStatus = table.checkStatus('test-table-checkbox');
            //console.log("当前选中的个数："+checkStatus.data.length);//输出当前选中的个数
            //console.log("相关数据："+checkStatus.data); //选中行的相关数据
            //console.log("是否全选:"+checkStatus.isAll); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
            if (checkStatus.data.length > 0) {
                $('.layui-btn-group').removeClass('layui-hide');
                // if (checkStatus.data.length > 1){
                //
                // }
            } else {
                $('.layui-btn-group').addClass('layui-hide');
            }
        });
    });

    //图片放大预览
    const gallery = [{
        title: "Image 1",
        description: "This is a description.",
        src: "../imgs/test.jpg"
    }, {
        title: "Image 2",
        description: "This is a description.",
        src: "../imgs/test1.jpg"
    }, {
        title: "Image 3",
        description: "This is a description.",
        src: "../imgs/test2.jpg"
    }];

    function showGallery(index) {
        Spotlight.show(gallery, {
            index: index,
            theme: "dark",
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


    }


</script>
</body>
</html>