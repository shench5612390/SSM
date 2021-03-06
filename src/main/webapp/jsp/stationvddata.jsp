<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入jstl core库 ，使用 循环标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入jstl fmt库，格式化时间标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 开启 EL 表达式支持 -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <!--  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>机维站车检器报表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/table.css">
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="layui/layui.js"></script>
    <script type="text/javascript">
        var fromTableType = "${tabletype}";
        var fromRegionId = "${regionid}";
        var fromUserName = "${username}";
    </script>
    <script src="js/stationvddata.js"></script>
    <title>Title</title>
</head>
<body>
<form class="layui-form" action="" id="tf">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">表格类型</label>
            <div class="layui-input-block">
                <select name="show_table_type" lay-verify="required"
                        lay-filter="show_table_type" lay-search>
                    <option value="">请选择报表类型</option>
                    <option value="3">日报</option>
                    <option value="4">月报</option>
                    <option value="5">年报</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">机维站</label>
            <div class="layui-input-block">
                <select name="equal_type" lay-verify="required"
                        lay-filter="machine_station" id="machine_station" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-inline" id="date_range_parent">
                <input type="text" class="layui-input" id="date_range"
                       lay-verify="required" placeholder="">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="commit">确认</button>
            <button type="reset" class="layui-btn layui-btn-primary" lay-submit lay-filter="reset">重置</button>
            <button class="layui-btn" lay-submit lay-filter="export">导出</button>
        </div>
    </div>
</form>
<div align=center id="loading" style="display:none" width="100%" height="100%">
    <p><span class="red" style="font-size:30px;">拼命加载中...</span></p>
</div>
<div id="tvdata_title"></div>
<div id="tvdata_date"></div>
<div id="printer"></div>
<table class="layui-hide" id="table"></table>
</body>
</html>