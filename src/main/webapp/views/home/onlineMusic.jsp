<%--
  User: zwf97
  Date: 2019/8/28
  Time: 14:09
  Description：在线预览音乐
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
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="../../layuiadmin/layui/css/video-js.min.css" rel="stylesheet" type="text/css">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        div {
            margin: 0 auto;
            margin-top: 50px;
        }
        .text{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="text">
    <sapn><b>文件名：</b>${fileInfo.fileName}</sapn>
    <sapn><b>文件大小：</b>${fileSize}</sapn>
    <sapn><b>修改日期：</b>${fileUploadTime}</sapn>
</div>
<div style="width: 600px;">
    <audio src="${fileInfo.file_url}" controls="controls" style="width: 100%;height: 300px;">
        Your browser does not support the audio element.
    </audio>
</video>
</div>
<script src="../../layuiadmin/layui/video.min.js"></script>
<script>
    videojs.options.flash.swf = "video-js.swf";
    var myPlayer = videojs('example_video_1');
    videojs("example_video_1").ready(function(){
        var myPlayer = this;
        myPlayer.play();
    });
</script>
</body>
</html>