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
    <title>操作日志报表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/table.css">
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="layui/layui.js"></script>
    <script type="text/javascript">
        var fromTableType = "${tabletype}";
        var fromRegionId = "${regionid}";
        var fromUserName = "${username}";
    </script>
    <script type="text/html" id="indexTpl">
        {{d.LAY_TABLE_INDEX+1}}
    </script>
    <script src="js/operation.js"></script>
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
                    <option value="0">情报板操作日志报表</option>
                    <option value="1">隧道控制操作日志报表</option>
                    <option value="2">紧急电话报警处理日志报表</option>
                    <option value="3">避险车道报警处理日志报表</option>
                    <option value="4">火灾报警处理日志报表</option>
                    <option value="5">登录信息数据报表</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_route_code">
            <label class="layui-form-label">线号</label>
            <div class="layui-input-block">
                <select name="route_code" lay-verify="required"
                        lay-filter="route_code" id="route_code" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_board_type">
            <label class="layui-form-label" id="label_board_type">情报板类别</label>
            <div class="layui-input-block">
                <select name="board_type" lay-verify="required"
                        lay-filter="board_type" id="board_type" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_equip_type" style="display: none">
            <label class="layui-form-label" id="label_equip_type">设备类型</label>
            <div class="layui-input-block">
                <select name="equip_type" lay-verify="required"
                        lay-filter="equip_type" id="equip_type" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_equip_name">
            <label class="layui-form-label">设备名称</label>
            <div class="layui-input-block">
                <select name="equip_name" lay-verify="required"
                        lay-filter="equip_name" id="equip_name" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_status" style="display: none">
            <label class="layui-form-label" id="label_status">状态</label>
            <div class="layui-input-block">
                <select name="status" lay-verify="required" lay-filter="status"
                        id="status" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" id="div_user_name">
            <label class="layui-form-label" id="label_user_name">操作用户</label>
            <div class="layui-input-block">
                <select name=user_name lay-verify="required" lay-filter="user_name"
                        id="user_name" lay-search>
                    <option value="-2">不限</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">操作日期</label>
            <div class="layui-input-inline" id="date_range_parent">
                <input type="text" class="layui-input" id="date_range"
                       placeholder="">
            </div>
        </div>
        <div class="layui-inline" id="div_fire_date" style="display: none">
            <label class="layui-form-label">报警日期</label>
            <div class="layui-input-inline" id="fire_date_range_parent">
                <input type="text" class="layui-input" id="fire_date_range"
                       placeholder="">
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
<div id="count"></div>
<table class="layui-hide" id="table"></table>
</body>
</html>