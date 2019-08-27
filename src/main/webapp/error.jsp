<%--
  User: zwf97
  Date: 2019/8/27
  Time: 15:09
  Description：全局错误页面
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
</head>
<body>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML><HEAD><TITLE>404错误页面</TITLE><!--STATUS OK-->
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <meta name="author" content="sucaihuo">
    <meta name="copyright" content="Copyright">
    <link href="./layuiadmin/style/error.css" type=text/css rel=stylesheet>
    <STYLE type=text/css>.mod-notfound {
        BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 585px; TEXT-ALIGN: center; border-radius: 10px
    }
        .myFile{
            font-size: 20px;
            color: #1471ff;
        }
        .myFile:hover{
            color: #cc0000;
            text-decoration: underline;
        }

    </STYLE>

    <META content="MSHTML 6.00.6000.17117" name=GENERATOR></HEAD>
<BODY><SECTION class=mod-page-body>
    <DIV class="mod-page-main wordwrap clearfix">
        <DIV class=x-page-container>
            <DIV class="mod-notfound grid-98"><IMG class=img-notfound height=320
                                                   src="./views/imgs/notfound.png" width=520>
                <P style="FONT-SIZE: 24px; LINE-HEIGHT: 70px; color: #c55454">
                    <c:if test="${msg != null}">${msg}</c:if>
                </P>
                <P style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">您可以回到
                    <A href="views/home/console.jsp" class="myFile">我的文件</A>
                </P>
            </DIV></DIV></DIV></SECTION><FOOTER
        class="mod-footer mod-cs-footer">
    <DIV class="clearfix hidden-box"></DIV>
    </FOOTER>
</body>
</html>