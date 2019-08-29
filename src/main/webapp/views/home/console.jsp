<%--
  User: dc
  Date: 2019/8/26
  Time: 9:27
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
    <title>文件夹</title>
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

        .folderList{
            font-size: 12px;
            margin: 5px 0;
            color: #1E9FFF;
        }
    </style>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="uploadFile(0)">
                        <i class="fa fa-upload"></i>上传文件
                    </button>
                    <button class="layui-btn layui-btn-sm layui-btn-primary" onclick="addFolder(0)">
                        <i class="fa fa-folder-o"></i>新建文件夹
                    </button>
                    <div class="layui-btn-group layui-hide">
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                            <i class="fa fa-share"></i>分享
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="downLoad()">
                            <i class="fa fa-download"></i>下载
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="trash(0)">
                            <i class="fa fa-trash"></i>删除
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="renameFolder(0)">
                            <i class="fa fa-pencil"></i>重命名
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                            移动到
                        </button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
                            复制到
                        </button>
                    </div>
                </div>
                <div class="layui-card-body">
                    <a href="javascript:void(0)" class="folderList" onclick="interFolder(0)">全部文件</a>
                    <a href="javascript:void(0)" class="folderList" style="visibility: hidden;"> | 返回上一级</a>
                    <%--<a href="/sysfile/download2" class="folderList" >下载</a>--%>
                    <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-checkbox"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../layuiadmin/layui/layui.js?t=1"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="../../layuiadmin/lib/spotlight/js/spotlight.bundle.js"></script>
<script>
    var table,layer,tableIns,folderId=0,gallery = [],count = 0;

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
            , url: 'folder/folders'//获取数据的地方
            , where:{folder_father:folderId}//传递参数的地方
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , id:'test-table-checkbox'
            , cols: [[{type: 'checkbox'}
                , {
                    field: 'fileName',
                    width: 600,
                    title: '文件名',
                    sort: true,
                    templet: function (d) {
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
                                console.log(d);
                                icon = "<i class='fa fa-file-text' style='font-size:18px;color:rgb(77,151,255);margin:8px 5px 0 0'></i>";
                                prefix = "<a lay-href='userfile/previewFile?fileId="+d.userSysfileId+"&type="+d.fileType+"'>";
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
                    $('.layui-btn-group button').eq(3).addClass('layui-btn-disabled').attr("disabled", 'disabled');
                } else {
                    $('.layui-btn-group button').eq(3).removeClass('layui-btn-disabled').removeAttr('disabled');
                }
            } else {
                $('.layui-btn-group').addClass('layui-hide');
            }
        });
    });

    //上传
    function uploadFile(folder_father){
        folderId = folder_father;
        layer.open({
            title: ['<i class="fa fa-upload"></i>上传文件','color:#0098ea']
            ,content: '<form action="/sysfile/upload" method="post" enctype="multipart/form-data" id="test">\n' +
                '    <input type="file" required name="files"><br><br>\n' +
                '    <input type="hidden" required value="'+folder_father+'" name="folder_id"><br><br>\n' +
                '    <input type="reset" class="layui-btn layui-btn-sm layui-btn-normal" value="重置" style="float: right;margin-left: 10px">' +
                '    <input type="submit" class="layui-btn layui-btn-sm layui-btn-normal" value="上传" style="float: right">\n' +
                '</form>'
            ,btn:''
        });
    }

    //在指定目录下创建文件夹
    function addFolder(folder_father) {
        layer.prompt({
                type: 1,
                title: ['<i class="fa fa-folder-o"></i>新建文件夹', 'color:#0098ea'],
                offset: '100px',
                btn: ['创建', '取消']
            },
            function (text, index) {
                $.post('folder/create',{folderName:text,folder_father:folder_father},function (data,status) {
                    if (data.status === 200){
                        layer.msg(data.msg,{
                            icon:1,
                            offset: '200px'
                        });
                        //需改数据后表格局部刷新
                        tableIns.reload({
                            where: { //设定异步数据接口的额外参数，任意设
                                folder_father:folder_father
                            }
                        });
                    }else {
                        layer.msg(data.msg,{
                            icon:2,
                            offset: '200px'
                        });
                    }
                });
                layer.close(index);//index为当前层索引
            });
    }

    //重命名
    function renameFolder(folder_father) {
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
                checkStatus.data[0].fileName = text;
                //修改后触发ajax方法，异步请求后台修改数据库
                $.post('/folder/rename',{'folder':JSON.stringify(checkStatus.data[0])},function (data,status) {
                    if (data.status === 200){
                        layer.msg(data.msg,{
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

    //下一级文件夹
    var parentIds = [];//记录所有父文件夹的id
    function interFolder(folder_father,parentId) {
        parentIds.push(parentId);
        tableIns.reload({
            where: {
                //设定异步数据接口的额外参数，任意设
                folder_father: folder_father
            }
        });
        //清空图片集合以及下标
        gallery = [];
        count = 0;
        //显示返回上一级文件夹
        $('.folderList').eq(1).css('visibility','visible');
        $('.folderList').eq(1).attr('onclick','preFolder()');
        $('.layui-card-header button').eq(1).attr('onclick','addFolder('+folder_father+')');
        $('.layui-card-header button').eq(0).attr('onclick','uploadFile('+folder_father+')');
        $('.layui-btn-group button').eq(2).attr('onclick','renameFolder('+folder_father+')');
    }

    //把上一级id添加到返回上一级的方法中
    function preFolder() {
        tableIns.reload({
            where: {
                //设定异步数据接口的额外参数，任意设
                folder_father:parentIds[parentIds.length-1]
            }
        });
        //清空图片集合以及下标
        gallery = [];
        count = 0;
        $('.layui-card-header button').eq(1).attr('onclick','addFolder('+parentIds[parentIds.length-1]+')');
        if (parentIds.length > 1){
            parentIds.pop();
        }
    }

    //图片预览
    function showGallery(index) {
        Spotlight.show(gallery, {
            index: index,
            theme: "dark"
        });
    }

    //文件夹、文件删除
    function trash(folder_father) {
        var checkStatus = table.checkStatus('test-table-checkbox');
        console.log(gallery);
    }

    //文件下载以及批量下载
    function downLoad() {
        var checkStatus = table.checkStatus('test-table-checkbox');
        console.log(checkStatus.data);
        $.post("sysfile/download2",{userFileId:JSON.stringify(checkStatus.data)},function (data,status) {
            console.log("1111");
        })
    }

</script>
</body>
</html>