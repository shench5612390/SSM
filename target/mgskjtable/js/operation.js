function getTwoChar(a) {
    var temp = '';
    if (a < 10) {
        temp += '0';
    }
    temp += a;
    return temp;
}

// 日期
function selectDateType(dateType, isRange) {
    $('#date_range').remove();
    $("#date_range_parent")
        .html(
            '<input type="text" class="layui-input" id="date_range"placeholder="">');
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        // 日期
        laydate.render({
            elem: '#date_range',
            range: isRange,
            type: dateType,
            done: function (value, date, enddate) {
                // console.log(value); // 得到日期生成的值，如：2017-08-18
                // console.log(date); // 得到日期时间对象：{year: 2017, month: 8, date: 18,
                // hours: 0, minutes: 0, seconds: 0}
                // console.log(enddate); // 得结束的日期时间对象，开启范围选择（range:
                // true）才会返回。对象成员同上。
                startDate = date;
                endDate = enddate;
            }
        });
    });
}

// 火灾报警日期
function selectFireDateType(dateType, isRange) {
    $('#fire_date_range').remove();
    $("#fire_date_range_parent")
        .html(
            '<input type="text" class="layui-input" id="fire_date_range"placeholder="">');
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        // 日期
        laydate.render({
            elem: '#fire_date_range',
            range: isRange,
            type: dateType,
            done: function (value, date, enddate) {
                // console.log(value); // 得到日期生成的值，如：2017-08-18
                // console.log(date); // 得到日期时间对象：{year: 2017, month: 8, date: 18,
                // hours: 0, minutes: 0, seconds: 0}
                // console.log(enddate); // 得结束的日期时间对象，开启范围选择（range:
                // true）才会返回。对象成员同上。
                fireStartDate = date;
                fireEndDate = enddate;
            }
        });
    });
}

// 获取设备信息
function getEquipInfo() {
    var url = null;
    if (tableType == "0") {
        url = "filter/board/equip";
    } else if (tableType == "2") {
        url = "filter/et/equip";
    } else if (tableType == "3") {
        url = "filter/evd/equip";
    } else if (tableType == "4") {
        url = "filter/fa/equip";
    }
    $.ajax({
        url: url,
        type: "post",
        data: {
            "region_id": fromRegionId,
            "region_code": regionCode,
            "prefix_length": prefixLength
        },
        success: function (json) {
            console.log(json);
            if (json.code == 0) {
                // console.log("线号获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    if (tableType == "0") {
                        setRouteCodeList(json.data);
                        setBoardType(json.data);
                    } else if (tableType == "2") {
                        setRouteCodeList(json.data);
                    } else if (tableType == "3") {
                        setRouteCodeList(json.data);
                        setEquipType(json.data);
                    } else if (tableType == "4") {
                        setRouteCodeList(json.data);
                        setEquipType(json.data);
                    }
                }
            }
        },
        error: function (e) {
            // console.log(e);
        }
    });
}

// 线号
function setRouteCodeList(equipInfo) {
    // 去重
    var array = [];
    var isRepeat = false;
    for (var i = 0; i < equipInfo.length; i++) {
        if (equipInfo[i] == null || equipInfo[i].routecode == null || equipInfo[i].routecode == "") {
            isRepeat = true;
        } else {
            isRepeat = false;
            for (var j = 0; j < array.length; j++) {
                if (isRepeat || equipInfo[i].routecode == array[j].routecode) {
                    isRepeat = true;
                    break;
                }
            }
        }
        if (!isRepeat) {
            array.push(equipInfo[i]);
        }
    }
    $("#route_code").empty();
    $("#route_code").append('<option value="-2">不限</option>');
    for (var i = 0; i < array.length; i++) {
        $("#route_code").append(
            "<option value='" + array[i].routecode + "'>"
            + array[i].routecode + "</option>");
    }
    refreshSelecter()
}

// 情报板类别
function setBoardType(equipInfo) {
    // 去重
    var array = [];
    var isRepeat = false;
    for (var i = 0; i < equipInfo.length; i++) {
        if (equipInfo[i].businesscategory == null
            || equipInfo[i].businesscategory == "") {
            isRepeat = true;
        } else {
            isRepeat = false;
            for (var j = 0; j < array.length; j++) {
                if (isRepeat
                    || equipInfo[i].businesscategory == array[j].businesscategory) {
                    isRepeat = true;
                    break;
                }
            }
        }
        if (!isRepeat) {
            array.push(equipInfo[i]);
        }
    }
    $("#board_type").empty();
    $("#board_type").append('<option value="-2">不限</option>');
    for (var i = 0; i < array.length; i++) {
        $("#board_type").append(
            "<option value='" + array[i].businesscategory + "'>"
            + array[i].businesscategory + "</option>");
    }
    refreshSelecter();
}

// 设备名称
function setEquipNameList(routeCode, boardType) {
    var url;
    var data;
    if (tableType == "0") {
        url = "filter/board/equipname";
        data = {
            "route_code": routeCode,
            "board_type": boardType
        };
    } else if (tableType == "2") {
        url = "filter/et/equipname";
        data = {
            "route_code": routeCode,
            "region_id": regionId
        }
    } else if (tableType == "3") {
        url = "filter/evd/equipname";
        data = {
            "route_code": routeCode,
            "region_id": regionId
        }
    } else if (tableType == "4") {
        url = "filter/fa/equipname";
        data = {
            "route_code": routeCode,
            "region_id": regionId
        }
    }
    $.ajax({
        url: url,
        type: "post",
        data: data,
        success: function (json) {
            // console.log(json);
            if (json.code == 0) {
                // console.log("设备名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    $("#equip_name").empty();
                    $("#equip_name").append('<option value="-2">不限</option>');
                    for (var i = 0; i < json.data.length; i++) {
                        $("#equip_name").append(
                            "<option value='" + json.data[i].equipname
                            + "'>" + json.data[i].equipname
                            + "</option>");
                    }
                    refreshSelecter()
                }
            }
        },
        error: function (e) {
            // console.log(e);
        }
    });
}

// 用户名称
function setUserNameList() {
    if (userNameList != null) {
        return;
    }
    $.ajax({
        url: "filter/board/username",
        type: "post",
        data: {
            "from_region_id": fromRegionId
        },
        success: function (json) {
            // console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    userNameList = json.data;
                    $("#user_name").empty();
                    $("#user_name").append('<option value="-2">不限</option>');
                    for (var i = 0; i < json.data.length; i++) {
                        $("#user_name").append(
                            "<option value='" + json.data[i].username
                            + "'>" + json.data[i].username
                            + "</option>");
                    }
                    refreshSelecter()
                }
            }
        },
        error: function (e) {
            // console.log(e);
        }
    });
}

// 情报板操作日志
function getBoardOperation() {
    $.ajax({
        url: "operation/board/list",
        type: "post",
        data: {
            "region_id": fromRegionId,
            "route_code": routeCode,
            "bussiness_category": boardType,
            "equip_name": equipName,
            "user_name": userName,
            "begin_date": startDate == null ? null : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? null : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date)
        },
        success: function (json) {
            dismissLoading();
            // console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 30 // 全局定义常规单元格的最小宽度，layui
                            // 2.2.1 新增
                            ,
                            cols: [[{
                                title: '序号',
                                align: 'center',
                                style: style,
                                // templet: '#indexTpl'
                                type: 'numbers'
                            }, {
                                field: 'equipname',
                                align: 'center',
                                style: style,
                                title: '设备名称'
                            }, {
                                field: 'routecode',
                                align: 'center',
                                style: style,
                                title: '线号'
                            }, {
                                field: 'mile',
                                align: 'center',
                                style: style,
                                title: '桩号'
                            }, {
                                field: 'regionname',
                                align: 'center',
                                style: style,
                                title: '所属区域'
                            }, {
                                field: 'businesscategory',
                                align: 'center',
                                style: style,
                                title: '所属类别'
                            }, {
                                field: 'description',
                                align: 'center',
                                style: style,
                                title: '信息内容'
                            }, {
                                field: 'fontname',
                                align: 'center',
                                style: style,
                                title: '字体类型'
                            }, {
                                field: 'fontsize',
                                align: 'center',
                                style: style,
                                title: '尺寸'
                            }, {
                                field: 'fontcolordesc',
                                align: 'center',
                                style: style,
                                title: '字色'
                            }, {
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '发送用户'
                            }, {
                                field: 'resultdesc',
                                align: 'center',
                                style: style,
                                title: '操作结果'
                            }, {
                                field: 'operatetime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('情报板操作日志报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").html('发布总条数:' + json.data.length);
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 刷新选择器
function refreshSelecter() {
    layui.use('form', function () {
        var form = layui.form;
        form.render('select');
    });
}

// 所属区域
function setArea(routeCode) {
    $.ajax({
        url: "filter/board/area",
        type: "post",
        data: {
            "route_code": routeCode
        },
        success: function (json) {
            console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    $("#board_type").empty();
                    $("#board_type").append('<option value="-2">不限</option>');
                    for (var i = 0; i < json.data.length; i++) {
                        $("#board_type").append(
                            "<option value='" + json.data[i].id + "'>"
                            + json.data[i].regionname + "</option>");
                    }
                    refreshSelecter()
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 设备类型
function setEquipType(equipInfo) {
    // 去重
    var array = [];
    var isRepeat = false;
    for (var i = 0; i < equipInfo.length; i++) {
        if (equipInfo[i] == null || equipInfo[i].equiptype == null || equipInfo[i].equiptype == "") {
            isRepeat = true;
        } else {
            isRepeat = false;
            for (var j = 0; j < array.length; j++) {
                if (isRepeat || equipInfo[i].equiptype == array[j].equiptype) {
                    isRepeat = true;
                    break;
                }
            }
        }
        if (!isRepeat) {
            array.push(equipInfo[i]);
        }
    }
    $("#equip_type").empty();
    $("#equip_type").append('<option value="-2">不限</option>');
    for (var i = 0; i < array.length; i++) {
        $("#equip_type").append(
            "<option value='" + array[i].equiptype + "'>"
            + array[i].equiptypedesc + "</option>");
    }
    refreshSelecter();
}

// 紧急电话报警处理日志报表
function getETOperation() {
    // console.log(routeCode);
    // console.log(regionId);
    // console.log(equipName);
    // console.log(state);
    // console.log(startDate);
    $.ajax({
        url: "operation/et/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "route_code": routeCode,
            "region_id": regionId,
            "equip_name": equipName,
            "state": state,
            "begin_date": startDate == null ? '' : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? '' : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date)
        },
        success: function (json) {
            dismissLoading();
            console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'equiptypedesc',
                                align: 'center',
                                style: style,
                                title: '设备类型'
                            }, {
                                field: 'equipname',
                                align: 'center',
                                style: style,
                                title: '设备名称'
                            }, {
                                field: 'routecode',
                                align: 'center',
                                style: style,
                                title: '线号'
                            }, {
                                field: 'mile',
                                align: 'center',
                                style: style,
                                title: '桩号'
                            }, {
                                field: 'regionname',
                                align: 'center',
                                style: style,
                                title: '所属区域'
                            }, {
                                field: 'dealingstatus',
                                align: 'center',
                                style: style,
                                title: '状态'
                            }, {
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '操作员'
                            }, {
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '操作动作'
                            }, {
                                field: 'duplicatecount',
                                align: 'center',
                                style: style,
                                title: '重复报警次数'
                            }, {
                                field: 'operatetime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('紧急电话报警处理日志报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").empty();
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 避险车道报警处理日志报表
function getEVDOperation() {
    $.ajax({
        url: "operation/evd/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "route_code": routeCode,
            "region_id": regionId,
            "equip_type": equipType,
            "equip_name": equipName,
            "status": state,
            "user_name": userName,
            "begin_date": startDate == null ? '' : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? '' : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date)
        },
        success: function (json) {
            dismissLoading();
            // console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'equiptypedesc',
                                align: 'center',
                                style: style,
                                title: '设备类型'
                            }, {
                                field: 'equipname',
                                align: 'center',
                                style: style,
                                title: '设备名称'
                            }, {
                                field: 'routecode',
                                align: 'center',
                                style: style,
                                title: '线号'
                            }, {
                                field: 'mile',
                                align: 'center',
                                style: style,
                                title: '桩号'
                            }, {
                                field: 'regionname',
                                align: 'center',
                                style: style,
                                title: '所属区域'
                            }, {
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '操作员'
                            }, {
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '操作动作'
                            }, {
                                field: 'duplicatecount',
                                align: 'center',
                                style: style,
                                title: '重复报警次数'
                            }, {
                                field: 'dealingstatus',
                                align: 'center',
                                style: style,
                                title: '状态'
                            }, {
                                field: 'resultdesc',
                                align: 'center',
                                style: style,
                                title: '操作结果'
                            }, {
                                field: 'createdate',
                                align: 'center',
                                style: style,
                                title: '操作日期'
                            }, {
                                field: 'createtime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('避险车道报警处理日志报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").empty();
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 火灾报警处理日志报表
function getFAOperation() {
    $.ajax({
        url: "operation/fa/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "route_code": routeCode,
            "region_id": regionId,
            "equip_type": equipType,
            "equip_name": equipName,
            "status": state,
            "user_name": userName,
            "begin_date": startDate == null ? '' : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? '' : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date),
            "fire_begin_date": fireStartDate == null ? '' : fireStartDate.year + '-'
                + getTwoChar(fireStartDate.month) + '-' + getTwoChar(fireStartDate.date),
            "fire_end_date": fireEndDate == null ? '' : fireEndDate.year + '-'
                + getTwoChar(fireEndDate.month) + '-' + getTwoChar(fireEndDate.date)
        },
        success: function (json) {
            dismissLoading();
            console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'equiptypedesc',
                                align: 'center',
                                style: style,
                                title: '设备类型'
                            }, {
                                field: 'equipname',
                                align: 'center',
                                style: style,
                                title: '设备名称'
                            }, {
                                field: 'routecode',
                                align: 'center',
                                style: style,
                                title: '线号'
                            }, {
                                field: 'mile',
                                align: 'center',
                                style: style,
                                title: '桩号'
                            }, {
                                field: 'regionname',
                                align: 'center',
                                style: style,
                                title: '所属区域'
                            }, {
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '操作员'
                            }, {
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '操作动作'
                            }, {
                                field: 'duplicatecount',
                                align: 'center',
                                style: style,
                                title: '重复报警次数'
                            }, {
                                field: 'dealingstatus',
                                align: 'center',
                                style: style,
                                title: '状态'
                            }, {
                                field: 'resultdesc',
                                align: 'center',
                                style: style,
                                title: '操作结果'
                            }, {
                                field: 'createdate',
                                align: 'center',
                                style: style,
                                title: '操作日期'
                            }, {
                                field: 'createtime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }, {
                                field: 'firedate',
                                align: 'center',
                                style: style,
                                title: '报警时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('火灾报警处理日志报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").empty();
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 登录信息数据报表
function getLoginOperation() {
    $.ajax({
        url: "operation/login/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "user_name": userName,
            "begin_date": startDate == null ? '' : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? '' : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date)
        },
        success: function (json) {
            dismissLoading();
            // console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '账号'
                            }, {
                                field: 'target',
                                align: 'center',
                                style: style,
                                title: 'IP地址'
                            }, {
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '状态'
                            }, {
                                field: 'createdate',
                                align: 'center',
                                style: style,
                                title: '操作日期'
                            }, {
                                field: 'createtime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('登录信息数据报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").empty();
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading();
            // console.log(e);
        }
    });
}

// 隧道控制
function getTunnelOperation() {
    $.ajax({
        url: "operation/tunnel/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "user_name": userName,
            "begin_date": startDate == null ? '' : startDate.year + '-'
                + getTwoChar(startDate.month) + '-' + getTwoChar(startDate.date),
            "end_date": endDate == null ? '' : endDate.year + '-'
                + getTwoChar(endDate.month) + '-' + getTwoChar(endDate.date)
        },
        success: function (json) {
            dismissLoading();
            // console.log(json);
            if (json.code == 0) {
                // console.log("用户名称获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'username',
                                align: 'center',
                                style: style,
                                title: '操作用户'
                            }, {
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '操作动作'
                            }, {
                                field: 'target',
                                align: 'center',
                                style: style,
                                title: '操作目标'
                            }, {
                                field: 'resultdesc',
                                align: 'center',
                                style: style,
                                title: '操作结果'
                            }, {
                                field: 'createdate',
                                align: 'center',
                                style: style,
                                title: '操作日期'
                            }, {
                                field: 'createtime',
                                align: 'center',
                                style: style,
                                title: '操作时间'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('隧道控制操作日志报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
                                $("#count").empty();
                            }
                        });
                    });
                }
            }
        },
        error: function (e) {
            dismissLoading()
            // console.log(e);
        }
    });
}

// 根据regionId获取区域信息
function getRegionInfo() {
    $.ajax({
        url: "region/info",
        type: "post",
        data: {
            "region_id": fromRegionId
        },
        success: function (json) {
            console.log(json);
            if (json.code == 0) {
                // console.log("机维站获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    regionCode = json.data.regioncode;
                    prefixLength = json.data.prefixlength;
                }
            }
        },
        error: function (e) {
            // console.log(e);
        }
    });
}

function initValues() {
    initTable();
    dateType = 'date';
    startDate = null;
    endDate = null;
    routeCode = null;
    boardType = null;
    equipName = null;
    userName = null;
    regionId = null;
    state = null;
    equipType = null;
    userNameList = null;
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
    $("#count").empty();
    $("#route_code").empty();
    $("#route_code").append('<option value="-2">不限</option>');
    $("#board_type").empty();
    $("#board_type").append('<option value="-2">不限</option>');
    $("#equip_name").empty();
    $("#equip_name").append('<option value="-2">不限</option>');
    $("#user_name").empty();
    $("#user_name").append('<option value="-2">不限</option>');
    $("#status").empty();
    $("#status").append('<option value="-2">不限</option>');
}

function showLoading() {
    initTable();
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
    $("#count").empty();
    $("#loading").show();
}

function dismissLoading() {
    $("#loading").hide();
}

function initTable() {
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#table',
            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,
            cols: [],
            data: null,
        });
    });
}


// 报表类型
var tableType = "1";
// 日期显示类型
var dateType = 'date';
// 开始的日期
var startDate = null;
// 结束的日期
var endDate = null;
// 线号
var routeCode = null;
// 情报板类别
var boardType = null;
// 设备名称
var equipName = null;
// 用户名称
var userName = null;
// regionid
var regionId = null;
// et 状态
var state = null;

var equipType = null;

var regionCode = null;
var prefixLength = null;

//用户名列表
var userNameList = null;

// 火灾报警开始的日期
var fireStartDate = null;
// 火灾报警结束的日期
var fireEndDate = null;

var style = 'background-color:#d5e0ff;font-size:12;';

// console.log("fromTableType", fromTableType);
// console.log("fromRegionId", fromRegionId);
// console.log("fromUserName", fromUserName);

$().ready(function () {
    initForm();
});

// 初始化表单
function initForm() {
    layui
        .use(
            'form',
            function () {
                selectDateType(dateType, true);
                selectFireDateType(dateType, true)
                getRegionInfo();

                var form = layui.form;

                // 重置
                form.on('submit(reset)', function (data) {
                    initValues();
                });
                // 监听导出
                form.on('submit(export)', function (data) {
                    var url;
                    if (tableType == "0") {
                        // 情报板操作日志报表
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        url = "operation/board/export?region_id="
                            + (fromRegionId == null ? '' : fromRegionId)
                            + "&route_code="
                            + (routeCode == null ? '' : routeCode) + "&bussiness_category="
                            + (boardType == null ? '' : boardType) + "&equip_name="
                            + (equipName == null ? '' : equipName) + "&user_name="
                            + (userName == null ? '' : userName)
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&printer="
                            + (fromUserName == null ? '' : fromUserName);
                        location.href = url;
                    } else if (tableType == "1") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        url = "operation/tunnel/export?from_region_id=" + (fromRegionId == null ? '' : fromRegionId) + "&user_name="
                            + (userName == null ? '' : userName)
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&printer="
                            + (fromUserName == null ? '' : fromUserName);
                        location.href = url;
                    } else if (tableType == "2") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        url = "operation/et/export?route_code="
                            + (routeCode == null ? '' : routeCode) + "&region_id=" + (regionId == null ? '' : regionId)
                            + "&equip_name=" + (equipName == null ? '' : equipName)
                            + "&state=" + (state == null ? '' : state)
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&printer="
                            + (fromUserName == null ? '' : fromUserName)
                            + "&from_region_id=" + (fromRegionId == null ? '' : fromRegionId);
                        location.href = url;
                    } else if (tableType == "3") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        url = "operation/evd/export?route_code="
                            + (routeCode == null ? '' : routeCode) + "&region_id=" + (regionId == null ? '' : regionId)
                            + "&equip_type=" + (equipType == null ? '' : equipType)
                            + "&equip_name=" + (equipName == null ? '' : equipName)
                            + "&status=" + (state == null ? '' : state) + "&user_name="
                            + (userName == null ? '' : userName)
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&printer="
                            + (fromUserName == null ? '' : fromUserName)
                            + "&from_region_id=" + (fromRegionId == null ? '' : fromRegionId);
                        location.href = url;
                    } else if (tableType == "4") {
                        url = "operation/fa/export?route_code="
                            + (routeCode == null ? '' : routeCode) + "&region_id=" + (regionId == null ? '' : regionId)
                            + "&equip_type=" + (equipType == null ? '' : equipType)
                            + "&equip_name=" + (equipName == null ? '' : equipName)
                            + "&status=" + (state == null ? '' : state) + "&user_name="
                            + (userName == null ? '' : userName)
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&fire_begin_date=" + (fireStartDate == null ? '' : (fireStartDate.year + '-'
                                    + getTwoChar(fireStartDate.month) + '-'
                                    + getTwoChar(fireStartDate.date))
                            ) + "&fire_end_date="
                            + (fireEndDate == null ? '' : (fireEndDate.year + '-' + getTwoChar(fireEndDate.month)
                                + '-' + getTwoChar(fireEndDate.date)))
                            + "&printer=" + (fromUserName == null ? '' : fromUserName)
                            + "&from_region_id=" + (fromRegionId == null ? '' : fromRegionId);
                        location.href = url;
                    } else if (tableType == "5") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        url = "operation/login/export?user_name="
                            + (userName == null ? '' : userName)
                            + "&from_region_id=" + fromRegionId
                            + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                                    + getTwoChar(startDate.month) + '-'
                                    + getTwoChar(startDate.date))
                            )
                            + "&end_date="
                            + (endDate == null ? '' : (endDate.year + '-' + getTwoChar(endDate.month)
                                + '-' + getTwoChar(endDate.date)))
                            + "&printer="
                            + (fromUserName == null ? '' : fromUserName)
                            + "&from_region_id=" + (fromRegionId == null ? '' : fromRegionId);
                        location.href = url;
                    } else {
                        alert('请正确选择!');
                    }
                    // console.log("url", url);
                    return false;
                });
                // 监听提交
                form.on('submit(commit)', function (data) {
                    if (tableType == "0") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        showLoading();
                        getBoardOperation();
                    } else if (tableType == "1") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        showLoading();
                        getTunnelOperation();
                    } else if (tableType == "2") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        showLoading();
                        getETOperation();
                    } else if (tableType == "3") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        showLoading();
                        getEVDOperation();
                    } else if (tableType == "4") {
                        showLoading();
                        getFAOperation();
                    } else if (tableType == "5") {
                        if (startDate == null) {
                            alert("请选择日期！");
                            return false;
                        }
                        showLoading();
                        getLoginOperation();
                    } else {
                        alert("暂不支持");
                        dismissLoading();
                    }
                    return false;
                });
                form
                    .on(
                        'select(show_table_type)',
                        function (data) {
                            // console.log(data);
                            tableType = data.value;
                            initValues();
                            if (tableType == "0") {
                                // 情报板
                                $("#div_route_code").show();
                                $("#label_board_type").html(
                                    "情报板类别");
                                $("#div_board_type").show();
                                $("#div_equip_name").show();
                                $("#div_user_name").show();
                                $("#div_equip_type").hide();
                                $("#div_status").hide();
                                $("#div_fire_date").hide();
                                getEquipInfo();
                                setUserNameList();
                                selectDateType(dateType, true);
                            } else if (tableType == "1") {
                                // 隧道控制操作日志报表
                                $("#div_board_type").hide();
                                $("#div_route_code").hide();
                                $("#div_equip_name").hide();
                                $("#div_user_name").show();
                                $("#div_equip_type").hide();
                                $("#div_status").hide();
                                $("#div_fire_date").hide();
                                // console
                                //     .log($(
                                //         "#div_board_type")
                                //         .is(":hidden"));
                                setUserNameList();
                                selectDateType(dateType, true);
                            } else if (tableType == "2") {
                                // 紧急电话
                                $("#div_route_code").show();
                                $("#label_board_type").html(
                                    "所属区域");
                                $("#div_board_type").show();
                                $("#div_equip_name").show();
                                $("#div_user_name").hide();
                                $("#div_equip_type").hide();
                                $("#status").empty();
                                $("#status")
                                    .append(
                                        '<option value="-2">不限</option><option value="0">未处理</option><option value="1">正在处理</option><option value="2">已处理</option>');
                                $("#div_status").show();
                                $("#div_fire_date").hide();
                                getEquipInfo();
                                selectDateType(dateType, true);
                            } else if (tableType == "3") {
                                // 避险车道报警处理日志报表
                                $("#div_route_code").show();
                                // $("#label_board_type").html(
                                //     "所属区域");
                                $("#div_board_type").hide();
                                $("#div_equip_name").show();
                                $("#div_user_name").show();
                                $("#div_equip_type").hide();
                                $("#div_status").show();
                                $("#status").empty();
                                $("#status")
                                    .append(
                                        '<option value="-2">不限</option><option value="0">未处理</option><option value="1">正在处理</option><option value="2">已处理</option>');
                                $("#div_fire_date").hide();
                                getEquipInfo();
                                setUserNameList();
                                selectDateType(dateType, true);
                            } else if (tableType == "4") {
                                // 火灾报警处理日志报表
                                $("#div_route_code").show();
                                $("#label_board_type").html(
                                    "所属区域");
                                $("#div_board_type").show();
                                $("#div_equip_name").show();
                                $("#div_user_name").show();
                                $("#div_equip_type").hide();
                                $("#status").empty();
                                $("#status")
                                    .append(
                                        '<option value="-2">不限</option><option value="0">未处理</option><option value="1">正在处理</option><option value="2">已处理</option>');
                                $("#div_status").show();
                                $("#div_fire_date").show();
                                getEquipInfo();
                                setUserNameList();
                                selectDateType(dateType, true);
                            } else if (tableType == "5") {
                                // 登录信息数据报表
                                $("#div_board_type").hide();
                                $("#div_route_code").hide();
                                $("#div_equip_name").hide();
                                $("#div_user_name").show();
                                $("#div_equip_type").hide();
                                $("#div_status").hide();
                                $("#div_fire_date").hide();
                                // console
                                //     .log($(
                                //         "#div_board_type")
                                //         .is(":hidden"));
                                setUserNameList();
                                selectDateType(dateType, true);
                            }

                            refreshSelecter()
                        });
                form.on('select(route_code)', function (data) {
                    // console.log(data);
                    $("#equip_name").empty();
                    $("#equip_name").append('<option value="-2">不限</option>');
                    if (tableType != "0") {
                        $("#board_type").empty();
                        $("#board_type").append('<option value="-2">不限</option>');
                    }
                    refreshSelecter();
                    if (data.value != "-2") {
                        routeCode = data.value;
                        if (tableType == "2") {
                            setArea(routeCode);
                        } else if (tableType == "3") {
                            // setArea(routeCode);
                            setEquipNameList(routeCode, regionId);
                        } else if (tableType == "4") {
                            setArea(routeCode);
                        }
                    } else {
                        routeCode = null;
                    }
                });
                form.on('select(board_type)', function (data) {
                    // console.log(data);
                    $("#equip_name").empty();
                    $("#equip_name").append('<option value="-2">不限</option>');
                    if (data.value != "-2") {
                        if (tableType == "0") {
                            boardType = data.value;
                            setEquipNameList(routeCode, boardType);
                        } else if (tableType == "2") {
                            regionId = data.value;
                            setEquipNameList(routeCode, regionId);
                        } else if (tableType == "3") {
                            // regionId = data.value;
                            // setEquipNameList(routeCode, regionId);
                        } else if (tableType == "4") {
                            regionId = data.value;
                            setEquipNameList(routeCode, regionId);
                        }

                    } else {
                        boardType = null;
                        regionId = null;
                    }
                    refreshSelecter();
                });
                form.on('select(equip_name)', function (data) {
                    // console.log(data);
                    if (data.value != "-2") {
                        equipName = data.value;
                    } else {
                        equipName = null;
                    }
                });
                form.on('select(equip_type)', function (data) {
                    // console.log(data);
                    if (data.value != "-2") {
                        equipType = data.value;
                    } else {
                        equipType = null;
                    }
                });
                form.on('select(user_name)', function (data) {
                    // console.log(data);
                    if (data.value != "-2") {
                        userName = data.value;

                    } else {
                        userName = null;
                    }
                });
                form.on('select(status)', function (data) {
                    // console.log(data);
                    if (data.value != "-2") {
                        state = data.value;
                    } else {
                        state = null;
                    }
                });
            });
}

window.console = window.console || (function () {
    var c = {};
    c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function () {
    };
    return c;
})();