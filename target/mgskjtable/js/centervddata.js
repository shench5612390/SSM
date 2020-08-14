function getTwoChar(a) {
    var temp = '';
    if (a < 10) {
        temp += '0';
    }
    temp += a;
    return temp;
}

// 信息中心报表
function getVDDataCenter() {
    $
        .ajax({
            url: "vddata/center/list",
            type: "post",
            data: {
                "region_id": fromRegionId,
                "date": selectDate == null ? "" : (selectDate.year + '-'
                    + selectDate.month + '-' + selectDate.date),
                "route_code": selectRouteCode,
                "equip_id": selectEquipId
            },
            success: function (json) {
                dismissLoading();
                //console.log(json);
                if (json.code == 0) {
                    alert("获取失败！！");
                } else if (json.code == 1) {
                    //console.log("获取成功！！");
                    if (json.data != null) {
                        layui
                            .use(
                                'table',
                                function () {
                                    var table = layui.table;

                                    table
                                        .render({
                                            elem: '#table',
                                            cellMinWidth: 10 // 全局定义常规单元格的最小宽度，layui
                                            // 2.2.1新增
                                            ,
                                            cols: [
                                                [
                                                    {
                                                        field: "equipName",
                                                        title: '车检器名称',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        rowspan: 2
                                                    },
                                                    {
                                                        field: "gathertime",
                                                        title: '采集时间(每小时记录)',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        rowspan: 2
                                                    },
                                                    {
                                                        title: 'A向车流量(单位：辆)',
                                                        align: 'center',
                                                        colspan: 3
                                                    },
                                                    {
                                                        title: 'B向车流量(单位：辆)',
                                                        align: 'center',
                                                        colspan: 3
                                                    },
                                                    {
                                                        title: 'A向平均车速(单位：KM/H)',
                                                        align: 'center',
                                                        colspan: 3
                                                    },
                                                    {
                                                        title: 'B向平均车速(单位：KM/H)',
                                                        align: 'center',
                                                        colspan: 3
                                                    },
                                                    {
                                                        title: 'A向占有率(单位：%)',
                                                        align: 'center',
                                                        colspan: 3
                                                    },
                                                    {
                                                        title: 'B向占有率(单位：%)',
                                                        align: 'center',
                                                        colspan: 3
                                                    }],
                                                [
                                                    {
                                                        field: 'aAllForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: 'aSmallForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'aBigForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bAllForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: 'bSmallForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bBigForward',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'aAllAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: 'aSmallAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'aBigAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bAllAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: 'bSmallAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bBigAvgSpd',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'aAllOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: 'asmallOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'aBigOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bAllOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '全部'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bsmallOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '小车'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: 'bBigOccupancy',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '大车'
                                                        // width
                                                        // : 20
                                                    }]],
                                            data: json.data,
                                            page: true,
                                            done: function (
                                                res, curr,
                                                count) {
                                                $('th')
                                                    .css(
                                                        {
                                                            'background-color': '#7d95df',
                                                            'font-size': 12
                                                        });
                                                $(
                                                    "#tvdata_title")
                                                    .html(
                                                        '车检器数据报表');
                                                $(
                                                    "#tvdata_date")
                                                    .html(
                                                        '统计时间：'
                                                        + (selectDate == null ? ""
                                                        : (selectDate.year
                                                            + '年'
                                                            + selectDate.month
                                                            + '月'
                                                            + selectDate.date + '日')));
                                                $("#printer").html('制表人:' + fromUserName);
                                            }
                                        });
                                });
                    }
                }
            },
            error: function (e) {
                dismissLoading();
                //console.log(e);
            }
        });
}

function selectDateType(dateType) {
    $('#date_range').remove();
    $("#date_range_parent")
        .html(
            '<input type="text" class="layui-input" id="date_range"placeholder="">');
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        // 日期
        laydate.render({
            elem: '#date_range',
            // range : true,
            type: dateType,
            done: function (value, date, endDate) {
                //console.log(value); // 得到日期生成的值，如：2017-08-18
                //console.log(date); // 得到日期时间对象：{year: 2017, month: 8, date: 18,
                // hours: 0, minutes: 0, seconds: 0}
                //console.log(endDate); // 得结束的日期时间对象，开启范围选择（range:
                // true）才会返回。对象成员同上。
                selectDate = date;
            }
        });
    });
}

// 设置车检器数据
function getTvdEquip() {
    $
        .ajax({
            url: "filter/tvd/equip",
            type: "post",
            data: {
                "region_id": fromRegionId
            },
            success: function (json) {
                console.log(json);
                if (json.code == 0) {
                    //console.log("机维站获取失败！！");
                } else if (json.code == 1) {
                    if (json.data != null) {
                        equipList = json.data;
                        setRouteCode(equipList);
                    }
                }
            },
            error: function (e) {
                //console.log(e);
            }
        });
}

// 设置线号
function setRouteCode(equipList) {
    $("#route_code").empty();
    $("#route_code").append('<option value="-2">不限</option>');
    // 去重
    var array = [];
    var isRepeat = false;
    for (var i = 0; i < equipList.length; i++) {
        if (equipList[i].routecode == null || equipList[i].routecode == "") {
            isRepeat = true;
        } else {
            isRepeat = false;
            for (var j = 0; j < array.length; j++) {
                if (isRepeat || equipList[i].routecode == array[j]) {
                    isRepeat = true;
                    break;
                }
            }
        }
        if (!isRepeat) {
            array.push(equipList[i].routecode);
        }
    }
    for (var i = 0; i < array.length; i++) {
        $("#route_code").append(
            "<option value='" + array[i] + "'>" + array[i] + "</option>");
    }
    layui.use('form', function () {
        var form = layui.form;
        form.render('select');
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
            //console.log(json);
            if (json.code == 0) {
                //console.log("机维站获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    regionCode = json.data.regioncode;
                    prefixLength = json.data.prefixlength;
                    getTvdEquip()
                }
            }
        },
        error: function (e) {
            //console.log(e);
        }
    });
}

function setController(selectRouteCode) {
    var equipListByRoute = [];
    for (var i = 0; i < equipList.length; i++) {
        if (equipList[i].routecode == selectRouteCode) {
            equipListByRoute.push(equipList[i]);
        }
    }
    // 去重
    var array = [];
    var isRepeat = false;
    for (var i = 0; i < equipListByRoute.length; i++) {
        if (equipListByRoute[i].id == null
            || equipListByRoute[i].id == "") {
            isRepeat = true;
        } else {
            isRepeat = false;
            for (var j = 0; j < array.length; j++) {
                if (isRepeat
                    || equipListByRoute[i].id == array[j].id) {
                    isRepeat = true;
                    break;
                }
            }
        }
        if (!isRepeat) {
            array.push(equipListByRoute[i]);
        }
    }
    $("#vehicle_detector").empty();
    $("#vehicle_detector").append(
        '<option value="-2">不限</option>');
    for (var i = 0; i < array.length; i++) {
        $("#vehicle_detector").append(
            "<option value='" + array[i].id + "'>"
            + array[i].equipname
            + "</option>");
    }
    layui.use('form', function () {
        var form = layui.form;
        form.render('select');
    });
}

function initValues() {
    initTable();
    dateType = 'date';
    selectDate = null;
    regionCode = null;
    prefixLength = null;
    selectEquipId = null;
    selectRouteCode = null;
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
    $("#printer").empty();
}

function showLoading() {
    initTable();
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
    $("#printer").empty();
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
var tableType = "6";
// 日期显示类型
var dateType = 'date';
// 选择的日期
var selectDate = null;
var regionCode = null;
var prefixLength = null;

var selectEquipId = null;
var selectRouteCode = null;
var equipList = null;
//console.log("fromTableType", fromTableType);
//console.log("fromRegionId", fromRegionId);
//console.log("fromUserName", fromUserName);

$().ready(function () {
    initForm();
});

// 初始化表单
function initForm() {
    layui.use('form', function () {
        selectDateType(dateType);
        getRegionInfo();

        var form = layui.form;

        // 重置
        form.on('submit(reset)', function (data) {
            initValues();
        });
        // 监听导出
        form.on('submit(export)', function (data) {
            if (selectDate == null) {
                alert("请选择日期！");
                return false;
            }
            var url;
            if (tableType == "6") {
                // 信息中心报表
                url = "vddata/center/export?region_id=" + (fromRegionId == null ? '' : fromRegionId)
                    + "&date=" + (selectDate == null ? '' : (selectDate.year + '-'
                        + getTwoChar(selectDate.month) + '-'
                        + getTwoChar(selectDate.date)))
                    + "&route_code=" + (selectRouteCode == null ? '' : selectRouteCode)
                    + "&equip_id=" + (selectEquipId == null ? '' : selectEquipId)
                    + "&printer="
                    + (fromUserName == null ? '' : fromUserName);
                location.href = url;
            } else {
                alert('请选择报表!');
            }
            return false;
        });
        // 监听提交
        form.on('submit(commit)', function (data) {
            if (selectDate == null) {
                alert("请选择日期！");
                return false;
            }
            if (tableType == "6") {
                showLoading();
                getVDDataCenter();
            }
            return false;
        });
        form.on('select(vehicle_detector)', function (data) {
            //console.log(data);
            if (data.value != "-2") {
                selectEquipId = data.value;
                //console.log("选中的车检器", selectEquipId);
            } else {
                selectEquipId = null;
            }
        });
        form.on('select(route_code)', function (data) {
            //console.log(data);
            if (data.value != "-2") {
                selectRouteCode = data.value;
                // console.log("选中的线号", selectRouteCode);
                setController(selectRouteCode);
            } else {
                selectRouteCode = null;
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

