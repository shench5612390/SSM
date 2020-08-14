// 设备故障表
function getEqualFault() {
    $.ajax({
        url: "equipfault/list",
        type: "post",
        data: {
            "from_region_id": fromRegionId,
            "regionId": selectMachineStation == null ? ''
                : selectMachineStation.orgid,
            "module": module,
            "date": selectDate == null ? null : (selectDate.year + '-'
                + getTwoChar(selectDate.month) + '-' + getTwoChar(selectDate.date))
        },
        success: function (json) {
            dismissLoading();
            console.log(json);
            if (json.code == 0) {
                alert("获取失败！！");
            } else if (json.code == 1) {
                // console.log("获取成功！！");
                if (json.data != null) {
                    layui.use('table', function () {
                        var table = layui.table;

                        table.render({
                            elem: '#table',
                            cellMinWidth: 80 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            ,
                            cols: [[{
                                field: 'createdate',
                                align: 'center',
                                style: style,
                                title: '日期'
                            }, {
                                field: 'createtime',
                                align: 'center',
                                style: style,
                                title: '时间'
                            }, {
                                field: 'equiptypedesc',
                                align: 'center',
                                style: style,
                                title: '设备类型'
                            }, {
                                field: 'localcenterregionname',
                                align: 'center',
                                style: style,
                                title: '机维站'
                            }, {
                                field: 'tunnelregionname',
                                align: 'center',
                                style: style,
                                title: '隧道'
                            }, {
                                field: 'equipname',
                                align: 'center',
                                style: style,
                                title: '设备名称'
                            }, {
                                field: 'routecode',
                                align: 'center',
                                style: style,
                                title: '路线'
                            }, {
                                field: 'mile',
                                align: 'center',
                                style: style,
                                title: '桩号'
                            }, {
                                field: 'ip',
                                align: 'center',
                                style: style,
                                title: 'IP'
                            }, {
                                field: 'faultstatusdesc',
                                align: 'center',
                                style: style,
                                title: '故障状态'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('设备故障报表');
                                $("#tvdata_date").html('制表人:' + fromUserName);
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

function getTwoChar(a) {
    var temp = '';
    if (a < 10) {
        temp += '0';
    }
    temp += a;
    return temp;
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
                // console.log(value); // 得到日期生成的值，如：2017-08-18
                // console.log(date); // 得到日期时间对象：{year: 2017, month: 8, date: 18,
                // hours: 0, minutes: 0, seconds: 0}
                // console.log(endDate); // 得结束的日期时间对象，开启范围选择（range:
                // true）才会返回。对象成员同上。
                selectDate = date;
            }
        });
    });
}

function setMachineStation(regionType) {
    $.ajax({
        url: "region/stationlist",
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
                    machineStationArray = json.data;
                    $("#machine_station").empty();
                    $("#machine_station").append(
                        '<option value="-2">不限</option>');
                    for (var i = 0; i < machineStationArray.length; i++) {
                        $("#machine_station").append(
                            "<option value='" + i + "'>"
                            + machineStationArray[i].organizationname
                            + "</option>");
                    }
                    layui.use('form', function () {
                        var form = layui.form;
                        form.render('select');
                    });
                }
            }
        },
        error: function (e) {
            // console.log(e);
        }
    });
}

function setModule() {
    $.ajax({
        url: "equipfault/modulelist",
        type: "post",
        data: {
            "from_region_id": fromRegionId
        },
        success: function (json) {
            console.log(json);
            if (json.code == 0) {
                // console.log("机维站获取失败！！");
            } else if (json.code == 1) {
                if (json.data != null) {
                    $("#equip_type").empty();
                    $("#equip_type").append(
                        '<option value="-2">不限</option>');
                    for (var i = 0; i < json.data.length; i++) {
                        $("#equip_type").append(
                            "<option value='" + json.data[i].module + "'>"
                            + json.data[i].moduledesc
                            + "</option>");
                    }
                    layui.use('form', function () {
                        var form = layui.form;
                        form.render('select');
                    });
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
    machineStationArray = null;
    selectDate = null;
    selectMachineStation = null;
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
}

function showLoading() {
    initTable();
    $("#tvdata_title").empty();
    $("#tvdata_date").empty();
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
// 机维站数据
var machineStationArray = null;
// 选择的日期
var selectDate = null;
// 选中的机维站
var selectMachineStation = null;

var style = 'background-color:#d5e0ff;font-size:12;';
var module = null;

// console.log("fromTableType", fromTableType);
// console.log("fromRegionId", fromRegionId);
// console.log("fromUserName", fromUserName);

$().ready(function () {
    initForm();
});

// 初始化表单
function initForm() {
    layui.use('form', function () {
        selectDateType(dateType);
        setMachineStation(2);
        setModule();

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
            if (tableType == "1") {
                // 设备故障表
                url = "equipfault/export?regionId="
                    + (selectMachineStation == null ? ''
                        : selectMachineStation.id)
                    + "&module=" + (module == null ? '' : module)
                    + "&date=" + (selectDate == null ? '' : (selectDate.year + '-'
                        + getTwoChar(selectDate.month) + '-' + getTwoChar(selectDate.date)))
                    + "&printer="
                    + (fromUserName == null ? '' : fromUserName);
                console.log("url=" + url);
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
            if (tableType == "1") {
                showLoading();
                getEqualFault();
            }
            return false;
        });
        form.on('select(machine_station)', function (data) {
            // console.log(data);
            if (data.value != "-2") {
                if (machineStationArray != null
                    && machineStationArray.length > data.value) {
                    selectMachineStation = machineStationArray[data.value];
                    // console.log("选中的机维站", selectMachineStation);
                }
            } else {
                selectMachineStation = null;
            }
        });
        form.on('select(equip_type)', function (data) {
            // console.log(data);
            if (data.value != "-2") {
                module = data.value;
            } else {
                module = null;
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
