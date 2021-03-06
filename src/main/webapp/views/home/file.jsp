<%--
  User: zwf97
  Date: 2019/8/29
  Time: 8:44
  Description：文档
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
    <title>文档</title>
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
                    <div class="layui-btn-group layui-hide" style="float: right">
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="addShare()">
                            <i class="fa fa-share"></i>分享
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="trash()">
                            <i class="fa fa-trash"></i>删除
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="renameFolder()">
                            <i class="fa fa-pencil"></i>重命名
                        </button>
                    </div>
                </div>
                <div class="layui-card-body" style="margin-top: -5px">
                    <p style="font-size: 12px;">全部文档</p>
                    <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-checkbox"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../layuiadmin/layui/layui.js?t=1"></script>
<script src="../../layuiadmin/layui/jquery.min.js"></script>
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
            , url: 'userfile/getFileType?type=4'//获取数据的地方
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , id:'test-table-checkbox'
            , cols: [[{type: 'checkbox'}
                , {
                    field: 'fileName',
                    width: 600,
                    title: '文件名',
                    sort: true,
                    templet: function (d) {
                        var icon = "<a lay-href='userfile/previewFile?fileId="+d.userSysfileId+"&type="+d.fileType+"'><i class='fa fa-file-text' style='font-size:18px;color:rgb(77,151,255);margin:8px 5px 0 0'></i>"+d.fileName+"</a>";
                        return icon;
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

    //分享
    function addShare(folder_father) {
        var checkStatus = table.checkStatus('test-table-checkbox');
        if(checkStatus.data.length === 1){
            var title = checkStatus.data[0].fileName;

        }else{
            var title = checkStatus.data[0].fileName+"等";
        }
        layer.prompt({
                type: 1,
                title: ['<i class="fa fa-share"></i>分享文件:'+title,'color:#0098ea'],
                offset: '100px',
                value:checkStatus.data[0].fileName
            },
            function (text, index) {
                //index为当前层索引
                //text为输入参数
                checkStatus.data[0].fileName = text;
                var shareObjs = [];
                for (var i = 0; i < checkStatus.data.length; i ++){
                    var shareObj = {comment:"",fileId:"",title:"",type:""};
                    shareObj.comment = text;
                    shareObj.title = title;
                    shareObj.fileId = checkStatus.data[i].id;
                    shareObj.type = checkStatus.data[i].fileType;
                    shareObjs.push(shareObj);
                }
                console.log(shareObjs);
                //修改后触发ajax方法，异步请求后台修改数据库
                $.post('/share/add',{'shareObjs':JSON.stringify(shareObjs)},function (data,status) {
                    console.log(data);
                    if (data.status === 200){
                        layer.msg(data.data,{
                            icon:1,
                            offset: '200px'
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

    //删除文档
    function trash() {
        var dataa = table.checkStatus('test-table-checkbox').data;
        console.log(dataa);
        layer.confirm('',{
            offset: '200px',
            content: '确认要把所选文件放入回收站吗？\n' +
                '删除的文件可通过回收站还原',
            btnAlign: 'c',
            title:'确认删除',
            icon:2
        },function(index){
            $.post("folder/delete",{deleteList:JSON.stringify(dataa)},function (data,status) {
                if (data.status === 200){
                    layer.msg(data.msg,{
                        icon:1,
                        offset: '200px'
                    });
                    //需改数据后表格局部刷新
                    tableIns.reload({
                        where: { //设定异步数据接口的额外参数，任意设
                            fileType: 4
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