<%--
  User: zwf97
  Date: 2019/8/30
  Time: 12：34
  Description：分享详情页面
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
    <title>分享详情预览</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
    <link href="../../layuiadmin/style/font-awesome.min.css" rel="stylesheet">

    <style>

        i {
            margin-right: 5px;
        }

        .layui-card-header button:nth-of-type(2) {
            border-color: #c3eaff;
            color: #0098ea;
            margin-right: 10px;
        }

        .layui-card-header .layui-btn-group button {
            border-color: #c3eaff;
            color: #0098ea;
        }

        .layui-card-header .layui-btn-group button:first-child {
            border-color: #c3eaff;
            color: #0098ea;
        }

        .layui-card-header .layui-btn-group button:hover {
            border-color: #c3eaff;
            color: #0098ea;
        }

        .layui-table-cell .layui-form-checkbox[lay-skin=primary] {
            top: 6px;
        }
        .layui-form-checked[lay-skin=primary] i {
            border-color: #0098ea;
            background-color: transparent;
            color: #09AAFF;
            font-weight: bolder;

        }

        .layui-form-checkbox[lay-skin=primary]:hover i {
            border-color: #0098ea;
            color: #09AAFF;
        }
    </style>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" style="height: 200px">
                    <div style="width: 200px;margin: 0 auto">
                        <a href="/index"><img src="/views/imgs/logo200.png"></a>
                    </div>
                    <p style="font-size: 20px;text-align: center;">
                        FloadDrive——懂你的云盘
                    </p>
                    <div></div>

                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" style="margin-top: 160px">
                            <i class="fa fa-exclamation-circle"></i>下载
                        </button>
                    </div>
                </div>
                <div class="layui-card-body" style="padding-top: -5px">
                    <p style="font-size: 12px;">分享详情</p>
                    <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-checkbox"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../layuiadmin/layui/layui.js?t=1"></script>
<script src="../../layuiadmin/layui/jquery.min.js"></script>
<script>
    var  shareId = window.location.href.substr(window.location.href.lastIndexOf("/")+1)
    console.log(shareId)
    var table, layer,tableIns;

    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        table = layui.table,
            layer = layui.layer;

        tableIns = table.render({
            elem: '#test-table-checkbox'
            , skin: 'row'
            , url: 'share/getdata/'+shareId//获取数据的地方
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , id:'test-table-checkbox'
            , cols: [[{type: 'checkbox'}
                , {
                    field: 'fileName',
                    width: 600,
                    title: '文件名',
                    sort: true,
                    templet: function (d) {
                        console.log(d)
                        var icon = "";prefix = "",suffix = "</a>";
                        switch (d.fileType) {
                            case '0':
                                icon = "<i class='fa fa-folder' style='font-size:18px;color:rgb(255,214,89);margin:8px 5px 0 0'></i>";
                                prefix = "<a href='javascript:void(0)' onclick='interFolder("+d.id+","+d.parentId+")'>";
                                break;
                            case '1':
                                gallery.push(d);
                                count ++;
                                prefix = "<a href='javascript:void(0)' onclick='showGallery("+count+")'>";
                                icon = "<i class='fa fa-file-photo-o' style='font-size:18px;color:rgb(255,119,67);margin:8px 5px 0 0'></i>";
                                break;
                            case '2':
                                icon = "<i class='fa fa-file-audio-o' style='font-size:18px;color:rgb(129,131,241);margin:8px 5px 0 0'></i>";
                                break;
                            case '3':
                                icon = "<i class='fa fa-file-video-o' style='font-size:18px;color:rgb(129,131,241);margin:8px 5px 0 0'></i>";
                                break;
                            case '4':
                                icon = "<i class='fa fa-file-text' style='font-size:18px;color:rgb(77,151,255);margin:8px 5px 0 0'></i>";
                                prefix = "<a lay-href='userfile/previewFile?fileId="+d.id+"&type="+d.fileType+"'>";
                                break;
                            case '5':
                                icon = "<i class='fa fa-file' style='font-size:18px;color:rgb(185,201,214);margin:8px 5px 0 0'></i>";
                                break;
                        }
                        return icon+prefix+d.fileName+suffix;
                    }
                }
                , {
                    field: 'fileSize',
                    width: 220,
                    title: '大小',
                    templet: function (d) {
                        if (d.fileSize !== undefined){
                            if (d.fileSize >= 1024){
                                return (d.fileSize/1024).toFixed(1)+"MB";
                            }else {
                                return d.fileSize+"KB";
                            }
                        }else {
                            return '-';
                        }
                    },
                    sort: true
                }
                , {
                    field: 'updatetime',
                    title: '修改日期',
                    templet: "<div>{{layui.util.toDateString(d.updatetime, 'yyyy-MM-dd HH:mm:ss')}}</div>",
                    sort: true
                }
            ]]
        });

        table.on('checkbox(test-table-checkbox)', function (obj) {
            var checkStatus = table.checkStatus('test-table-checkbox');
            //console.log("当前选中的个数："+checkStatus.data.length);//输出当前选中的个数
            //console.log("相关数据："+checkStatus.data); //选中行的相关数据
            //console.log("是否全选:"+checkStatus.isAll); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
            if (checkStatus.data.length > 0) {
                $('.layui-btn-group').removeClass('layui-hide');
                if (checkStatus.data.length > 1) {
                    $('.layui-btn-group button').eq(2).addClass('layui-btn-disabled').attr("disabled", 'disabled');
                } else {
                    $('.layui-btn-group button').eq(2).removeClass('layui-btn-disabled').removeAttr('disabled');
                }
            } else {
                $('.layui-btn-group').addClass('layui-hide');
            }
        });


    });



</script>
</body>
</html>