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

// 用户名称
function setUserNameList() {
    $.ajax({
        url: "filter/board/username",
        type: "post",
        data: {"from_region_id": fromRegionId},
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

// 刷新选择器
function refreshSelecter() {
    layui.use('form', function () {
        var form = layui.form;
        form.render('select');
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

// 报警联动设置操作报表
function getAlarmLinkOperation() {
    $.ajax({
        url: "operation/alarmlink/list",
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
                                field: 'operationdesc',
                                align: 'center',
                                style: style,
                                title: '操作动作'
                            }, {
                                field: 'resultdesc',
                                align: 'center',
                                style: style,
                                title: '操作结果'
                            }]],
                            data: json.data,
                            page: true,
                            done: function (res, curr, count) {
                                $('th').css({
                                    'background-color': '#7d95df',
                                    'font-size': 12
                                });
                                $("#tvdata_title").html('报警联动设置操作报表');
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

function initValues() {
    initTable();
    dateType = 'date';
    startDate = null;
    userName = null;
    userNameList = null;
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
var tableType = "0";
// 日期显示类型
var dateType = 'date';
// 开始的日期
var startDate = null;
// 用户名称
var userName = null;

// 用户名称列表
var userNameList = null;

var style = 'background-color:#d5e0ff;font-size:12;';


// console.log("fromTableType", fromTableType);
// console.log("formRegionId", formRegionId);
// console.log("fromUserName", fromUserName);

$().ready(function () {
    initForm();
});

// 初始化表单
function initForm() {
    layui.use('form', function () {
        if (userNameList == null) {
            setUserNameList();
        }
        selectDateType(dateType, true);

        var form = layui.form;

        // 重置
        form.on('submit(reset)', function (data) {
            initValues();
        });
        // 监听导出
        form.on('submit(export)', function (data) {
            if (startDate == null) {
                alert("请选择日期！");
                return false;
            }
            var url;
            if (tableType == "0") {
                // 报警联动设置操作报表
                url = "operation/alarmlink/export?user_name=" + (userName == null ? '' : userName)
                    + "&begin_date=" + (startDate == null ? '' : (startDate.year + '-'
                            + getTwoChar(startDate.month) + '-'
                            + getTwoChar(startDate.date))
                    ) + "&end_date="
                    + (endDate == null ? '' : (endDate.year + '-' + endDate.month
                        + '-' + endDate.date))
                    + "&printer=" + (fromUserName == null ? '' : fromUserName);
                location.href = url;
            } else {
                alert('请正确选择!');
            }
            return false;
        });
        // 监听提交
        form.on('submit(commit)', function (data) {
            if (startDate == null) {
                alert("请选择日期！");
                return false;
            }
            if (tableType == "0") {
                showLoading();
                getAlarmLinkOperation();
            } else {
                alert("暂不支持");
            }
            return false;
        });
        form.on('select(user_name)', function (data) {
            // console.log(data);
            if (data.value != "-2") {
                if (tableType == "0") {
                    userName = data.value;
                }

            } else {
                userName = null;
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
