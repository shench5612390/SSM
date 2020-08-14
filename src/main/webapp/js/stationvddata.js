// 日报表
function getVDDataHour() {
    $
        .ajax({
            url: "vddata/hour/list",
            type: "post",
            data: {
                "regionCode": selectMachineStation == null ? null
                    : selectMachineStation.regioncode,
                "date": selectDate == null ? null
                    : (selectDate.year + '-'
                        + getTwoChar(selectDate.month) + '-' + getTwoChar(selectDate.date)),
                "PrefixLength": selectMachineStation == null ? null
                    : selectMachineStation.prefixlength + ""
            },
            success: function (json) {
                dismissLoading();
                // console.log(json);
                if (json.code == 0) {
                    alert("获取失败！！");
                } else if (json.code == 1) {
                    // console.log("获取成功！！");
                    if (json.data != null) {
                        var value = json.data;
                        var datas = [];
                        var data;
                        var forward;
                        for (var i = 0; i < value.length; i++) {
                            forward = value[i].forward;
                            for (var j = 0; j < datas.length; j++) {
                                if (value[i].equipname == datas[j].equipname) {
                                    datas[j]['' + value[i].gathertime] = forward;
                                    break;
                                } else if (j == datas.length - 1) {
                                    data = {};
                                    data["equipname"] = value[i].equipname;
                                    data['' + value[i].gathertime] = forward;
                                    datas.push(data);
                                    break;
                                }
                            }
                            if (datas.length == 0) {
                                data = {};
                                data["equipname"] = value[i].equipname;
                                data['' + value[i].gathertime] = forward;
                                datas.push(data);
                            }
                        }
                        var temp;
                        var tag;
                        for (var k = 0; k < datas.length; k++) {
                            temp = 0;
                            for (var l = 0; l < 24; l++) {
                                if (l < 10) {
                                    tag = '0' + l;
                                } else {
                                    tag = '' + l;
                                }
                                if (!isNaN(datas[k][tag])) {
                                    temp += datas[k][tag];
                                }
                            }
                            datas[k]["total"] = temp;
                        }
                        // console.log("datas", datas);
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
                                                        field: 'equipname',
                                                        title: '车辆检测断面位置',
                                                        minWidth: 130,
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        rowspan: 2
                                                    },
                                                    {
                                                        title: '每小时流量（单位：辆），负数表示异常数据',
                                                        align: 'center',
                                                        colspan: 24
                                                    },
                                                    {
                                                        field: 'total',
                                                        title: '车流量总量',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        minWidth: 100,
                                                        rowspan: 2
                                                    }],
                                                [
                                                    {
                                                        field: '00',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '0'
                                                        // width
                                                        // : 20
                                                    },

                                                    {
                                                        field: '01',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '1'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '02',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '2'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '03',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '3'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '04',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '4'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '05',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '5'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '06',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '6'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '07',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '7'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '08',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '8'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '09',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '9'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '10',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '10'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '11',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '11'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '12',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '12'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '13',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '13'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '14',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '14'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '15',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '15'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '16',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '16'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '17',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '17'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '18',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '18'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '19',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '19'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '20',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '20'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '21',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '21'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '22',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '22'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '23',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '23'
                                                        // width
                                                        // : 20
                                                    }]],
                                            data: datas,
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
                                                        '车辆检测器车流量参数日报表');
                                                $(
                                                    "#tvdata_date")
                                                    .html(
                                                        '统计时间：'
                                                        + (selectDate == null ? ''
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

// 月报表
function getVDDataDay() {
    $
        .ajax({
            url: "vddata/day/list",
            type: "post",
            data: {
                "regionCode": selectMachineStation == null ? null
                    : selectMachineStation.regioncode,
                "date": selectDate == null ? null
                    : (selectDate.year + '-'
                        + getTwoChar(selectDate.month) + '-' + getTwoChar(selectDate.date)),
                "PrefixLength": selectMachineStation == null ? null
                    : selectMachineStation.prefixlength + ""
            },
            success: function (json) {
                dismissLoading();
                // console.log(json);
                if (json.code == 0) {
                    alert("获取失败！！");
                } else if (json.code == 1) {
                    // console.log("获取成功！！");
                    if (json.data != null) {
                        var value = json.data;
                        var datas = [];
                        var data;
                        for (var i = 0; i < value.length; i++) {
                            for (var j = 0; j < datas.length; j++) {
                                if (value[i].equipname == datas[j].equipname) {
                                    datas[j][value[i].gatherdate.substr(8,
                                        2)] = value[i].forward;
                                    break;
                                } else if (j == datas.length - 1) {
                                    data = {};
                                    data["equipname"] = value[i].equipname;
                                    data[value[i].gatherdate.substr(8, 2)] = value[i].forward;
                                    datas.push(data);
                                    break;
                                }
                            }
                            if (datas.length == 0) {
                                data = {};
                                data["equipname"] = value[i].equipname;
                                data[value[i].gatherdate.substr(8, 2)] = value[i].forward;
                                datas.push(data);
                            }
                        }
                        var temp;
                        var tag;
                        for (var k = 0; k < datas.length; k++) {
                            temp = 0;
                            for (var l = 1; l <= 31; l++) {
                                if (l < 10) {
                                    tag = '0' + l;
                                } else {
                                    tag = '' + l;
                                }
                                if (!isNaN(datas[k][tag])) {
                                    temp += datas[k][tag];
                                }
                            }
                            datas[k]["total"] = temp;
                        }
                        // console.log("datas", datas);
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
                                                        field: 'equipname',
                                                        title: '车辆检测断面位置',
                                                        minWidth: 130,
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        rowspan: 2
                                                    },
                                                    {
                                                        title: '每日流量（单位：辆），负数表示异常数据',
                                                        align: 'center',
                                                        colspan: 31
                                                    },
                                                    {
                                                        field: 'total',
                                                        title: '车流量总量',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        minWidth: 100,
                                                        rowspan: 2
                                                    }],
                                                [

                                                    {
                                                        field: '01',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '1'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '02',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '2'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '03',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '3'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '04',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '4'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '05',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '5'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '06',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '6'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '07',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '7'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '08',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '8'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '09',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '9'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '10',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '10'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '11',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '11'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '12',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '12'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '13',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '13'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '14',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '14'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '15',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '15'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '16',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '16'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '17',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '17'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '18',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '18'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '19',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '19'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '20',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '20'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '21',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '21'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '22',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '22'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '23',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '23'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '24',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '24'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '25',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '25'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '26',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '26'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '27',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '27'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '28',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '28'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '29',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '29'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '30',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '30'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '31',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '31'
                                                        // width
                                                        // : 20
                                                    }]],
                                            data: datas,
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
                                                        '车辆检测器车流量参数月报表');
                                                $(
                                                    "#tvdata_date")
                                                    .html(
                                                        '统计时间：'
                                                        + (selectDate == null ? ''
                                                        : (selectDate.year
                                                            + '年'
                                                            + selectDate.month + '月')));
                                                $("#printer").html('制表人:' + fromUserName);
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

// 年报表
function getVDDataMonth() {
    $
        .ajax({
            url: "vddata/month/list",
            type: "post",
            data: {
                "regionCode": selectMachineStation == null ? null
                    : selectMachineStation.regioncode,
                "date": selectDate == null ? null
                    : (selectDate.year + '-'
                        + getTwoChar(selectDate.month) + '-' + getTwoChar(selectDate.date)),
                "PrefixLength": selectMachineStation == null ? null
                    : selectMachineStation.prefixlength + ""
            },
            success: function (json) {
                dismissLoading();
                console.log(json);
                if (json.code == 0) {
                    alert("获取失败！！");
                } else if (json.code == 1) {
                    // console.log("获取成功！！");
                    if (json.data != null) {
                        var value = json.data;
                        var datas = [];
                        var data;
                        for (var i = 0; i < value.length; i++) {
                            for (var j = 0; j < datas.length; j++) {
                                if (value[i].equipname == datas[j].equipname) {
                                    if (!isNaN(datas[j][value[i].gatherdate
                                        .substr(5, 2)])) {
                                        datas[j][value[i].gatherdate
                                            .substr(5, 2)] += value[i].forward;
                                    } else {
                                        datas[j][value[i].gatherdate
                                            .substr(5, 2)] = value[i].forward;
                                    }
                                    break;
                                } else if (j == datas.length - 1) {
                                    data = {};
                                    data["equipname"] = value[i].equipname;
                                    data[value[i].gatherdate.substr(5, 2)] = value[i].forward;
                                    datas.push(data);
                                    break;
                                }
                            }
                            if (datas.length == 0) {
                                data = {};
                                data["equipname"] = value[i].equipname;
                                data[value[i].gatherdate.substr(5, 2)] = value[i].forward;
                                datas.push(data);
                            }
                        }
                        var temp;
                        var tag;
                        for (var k = 0; k < datas.length; k++) {
                            temp = 0;
                            for (var l = 1; l <= 12; l++) {
                                if (l < 10) {
                                    tag = '0' + l;
                                } else {
                                    tag = '' + l;
                                }
                                if (!isNaN(datas[k][tag])) {
                                    temp += datas[k][tag];
                                }
                            }
                            datas[k]["total"] = temp;
                        }
                        // console.log("datas", datas);
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
                                                        field: 'equipname',
                                                        title: '车辆检测断面位置',
                                                        minWidth: 130,
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        rowspan: 2
                                                    },
                                                    {
                                                        title: '每月流量（单位：辆），负数表示异常数据',
                                                        align: 'center',
                                                        colspan: 12
                                                    },
                                                    {
                                                        field: 'total',
                                                        title: '车流量总量',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        minWidth: 100,
                                                        rowspan: 2
                                                    }],
                                                [

                                                    {
                                                        field: '01',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '1'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '02',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '2'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '03',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '3'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '04',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '4'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '05',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '5'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '06',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '6'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '07',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '7'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '08',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '8'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '09',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '9'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '10',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '10'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '11',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '11'
                                                        // width
                                                        // : 20
                                                    },
                                                    {
                                                        field: '12',
                                                        align: 'center',
                                                        style: 'background-color:#d5e0ff;font-size:12;',
                                                        title: '12'
                                                        // width
                                                        // : 20
                                                    }]],
                                            data: datas,
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
                                                        '车辆检测器车流量参数年报表');
                                                $(
                                                    "#tvdata_date")
                                                    .html(
                                                        '统计时间：'
                                                        + (selectDate == null ? ''
                                                        : (selectDate.year + '年')));
                                                $("#printer").html('制表人:' + fromUserName);
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
            // "region_type" : regionType,
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
                            + machineStationArray[i].regionname
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
var tableType = "3";
// 日期显示类型
var dateType = 'date';
// 机维站数据
var machineStationArray = null;
// 选择的日期
var selectDate = null;
// 选中的机维站
var selectMachineStation = null;

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
            if (tableType == "3") {
                // 车流量日报表
                url = "vddata/hour/export?regionCode="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.regioncode)
                    + "&date="
                    + (selectDate == null ? '' : (selectDate.year
                        + '-'
                        + getTwoChar(selectDate.month)
                        + '-'
                        + getTwoChar(selectDate.date)))
                    + "&PrefixLength="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.prefixlength)
                    + "&printer="
                    + (fromUserName == null ? '' : fromUserName);
                console.log("url=" + url);
                location.href = url;
            } else if (tableType == "4") {
                // 车流量月报表
                url = "vddata/day/export?regionCode="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.regioncode)
                    + "&date="
                    + (selectDate == null ? '' : (selectDate.year
                        + '-'
                        + getTwoChar(selectDate.month)
                        + '-'
                        + getTwoChar(selectDate.date)))
                    + "&PrefixLength="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.prefixlength)
                    + "&printer="
                    + (fromUserName == null ? '' : fromUserName);
                location.href = url;
            } else if (tableType == "5") {
                // 车流量年报表
                url = "vddata/month/export?regionCode="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.regioncode)
                    + "&date="
                    + (selectDate == null ? '' : (selectDate.year
                        + '-'
                        + getTwoChar(selectDate.month)
                        + '-'
                        + getTwoChar(selectDate.date)))
                    + "&PrefixLength="
                    + (selectMachineStation == null ? ""
                        : selectMachineStation.prefixlength)
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
            showLoading();
            if (tableType == "3") {
                getVDDataHour();
            } else if (tableType == "4") {
                getVDDataDay();
            } else if (tableType == "5") {
                getVDDataMonth();
            } else {
                dismissLoading();
                alert("暂不支持")
            }
            return false;
        });
        form.on('select(show_table_type)', function (data) {
            // console.log(data);
            initValues();
            tableType = data.value;
            if (tableType == "3") {
                dateType = 'date';
            } else if (tableType == "4") {
                dateType = 'month';
            } else if (tableType == "5") {
                dateType = 'year';
            }
            selectDateType(dateType);
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
    });
}

window.console = window.console || (function () {
    var c = {};
    c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function () {
    };
    return c;
})();