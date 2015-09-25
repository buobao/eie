<%--
  Created by IntelliJ IDEA.
  User: dqf
  Date: 2015/9/25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
    <title>文件上传</title>
  <meta content="no-cache" http-equiv="pragma">
  <meta content="no-cache" http-equiv="cache-control">
  <meta content="0" http-equiv="expires">
  <meta content="keyword1,keyword2,keyword3" http-equiv="keywords">
  <meta content="this os Truman's page" http-equiv="description">
</head>
<body>
<div style="text-align: center;width: 100%;">
  <h1>文件上传</h1>
  <form name="myFile" action="<%=basePath%>com/hello!upload.action" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <td>用户名:</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>
          上传文件:
        </td>
        <td>
          <input type="file" name="upload">
        </td>
      </tr>
      <tr>
        <td><input type="submit" value="上传"></td>
        <td><input type="reset" value="重置"></td>
      </tr>
      <tr>
        <td colspan="2"><s:property value="message"/></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>





































