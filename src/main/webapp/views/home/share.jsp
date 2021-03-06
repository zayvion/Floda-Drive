<%--
  User: zwf97
  Date: 2019/8/29
  Time: 17：45
  Description：我的分享
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
    <title>我的分享</title>
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
                <div class="layui-card-header">
                    <div class="layui-btn-group layui-hide" style="margin-top: 5px">
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="delShare()">
                            <i class="fa fa-exclamation-circle"></i>取消分享
                        </button>
                    </div>
                </div>
                <div class="layui-card-body" style="margin-top: -5px">
                    <p style="font-size: 12px;">我的分享</p>
                    <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-checkbox"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../layuiadmin/layui/layui.js?t=1"></script>
<script src="../../layuiadmin/layui/jquery.min.js"></script>
<script src="../../layuiadmin/layui/clipboard.min.js"></script>
<script>
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
            , url: 'share/list'//获取数据的地方
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , id:'test-table-checkbox'
            , cols: [[{type: 'checkbox'}
                , {
                    field: 'title',
                    width: 250,
                    title: '文件名称',
                    sort: true,
                    templet: function (d) {
                        var icon = "<a lay-href="+d.shareUrl+"><i class='fa fa-share-alt-square' style='font-size:18px;color:rgb(77,151,255);margin:8px 5px 0 0'></i>"+d.title+"</a>";
                        return icon;
                    }
                }
                , {
                    field: 'comment',
                    width: 250,
                    title: '分享名称',
                    templet: function (d) {
                        var icon = d.comment;
                        return icon;
                    },
                    sort: true
                }, {
                    field: 'QRCodeUrl',
                    width: 350,
                    title: '复制下载链接',
                    templet: function (d) {
                        var url = '<input type="text" value="'+d.shareUrl+'" id="copy'+d.LAY_INDEX+'" style="width: 210px; margin-right: 10px;"/><input class="btn" data-clipboard-action="copy" data-clipboard-target="#copy'+d.LAY_INDEX+'" type="button" onclick="copy()" value="点击复制"/><a lay-href="'+d.QRCodeUrl+'"><i class="fa fa-qrcode" style="float: right;padding-top: 5px"></i></a>';
                        return url;
                    },
                    sort: true
                }
                , {
                    field: 'shareDate',
                    title: '分享时间',
                    templet: "<div>{{layui.util.toDateString(d.shareDate, 'yyyy-MM-dd HH:mm:ss')}}</div>",
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

    //重命名文件夹
    function renameFolder() {
        var checkStatus = table.checkStatus('test-table-checkbox');
        layer.prompt({
                type: 1,
                title: ['<i class="fa fa-pencil"></i>重命名', 'color:#0098ea'],
                offset: '100px',
                value:checkStatus.data[0].fileName
            },
            function (text, index) {
                //index为当前层索引
                //text为输入参数
                //在回调函数末尾添加 “return false”可以禁止点击该按钮关闭弹出层
                checkStatus.data[0].fileName = text;
                //修改后触发ajax方法，异步请求后台修改数据库
                console.log(JSON.stringify(checkStatus.data[0]));
                $.post('/folder/rename',{'folder':JSON.stringify(checkStatus.data[0])},function (data,status) {
                    if (data.status === 200){
                        layer.msg(data.msg,{
                            icon:1,
                            offset: '200px'
                        });
                        //需改数据后表格局部刷新
                        tableIns.reload({
                            where: { //设定异步数据接口的额外参数，任意设
                                fileName: 'fileName'
                            }
                        });
                        $('.layui-btn-group').addClass('layui-hide');

                    }else {
                        layer.msg(data.msg,{
                            icon:2,
                            offset: '200px'
                        });
                    }
                });
                layer.close(index);
            });
    }

    //点击复制
    function copy() {
        var clipboard = new ClipboardJS('.btn');
        layer.msg("复制成功！",{icon:1,time:3000})
    }

    //取消分享
    function delShare(folder_father) {
        var jsonData = table.checkStatus('test-table-checkbox').data;
        var shareIds = [];
        for (var i = 0; i < jsonData.length; i++){
            shareIds.push(jsonData[i].shareId);
        }
        console.log(JSON.stringify(shareIds));
        layer.confirm('',{
            offset: '200px',
            content: '确认要取消分享所选文件吗？',
            btnAlign: 'c',
            title:'确认取消',
            icon:2
        },function(index){
            $.post("share/del",{shareIds:JSON.stringify(shareIds)},function (data,status) {
                if (data.status === 200){
                    layer.msg(data.data,{
                        icon:1,
                        offset: '200px'
                    });
                    //需改数据后表格局部刷新
                    tableIns.reload({
                        where: { //设定异步数据接口的额外参数，任意设
                            folder_father: folder_father
                        }
                    });
                    $('.layui-btn-group').addClass('layui-hide');
                }else {
                    layer.msg(data.msg,{
                        icon:2,
                        offset: '200px'
                    });
                }
            });
            layer.close(index);
        });
    }
</script>
</body>
</html>