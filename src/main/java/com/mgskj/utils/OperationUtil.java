package com.mgskj.utils;

import com.mgskj.entity.Operation;

public class OperationUtil {
    /**
     * 操作枚举转换
     *
     * @param operation
     * @return
     */
    public static String operation2String(int operation) {
        switch (operation) {
            case Operation.None:
                return "无";
            case Operation.FireAlarmConfirm:
                return "确认";
            case Operation.FireAlarmReset:
                return "复位";
            case Operation.FireAlarmFinishDealing:
                return "处理完毕";
            case Operation.FireAlarmEliminate:
                return "消警";
            case Operation.EmergencyTelephoneConfirm:
                return "紧急电话确认报警";
            case Operation.EmergencyTelephoneReset:
                return "紧急电话复位";
            case Operation.EmergencyTelephoneStopAllBroadcast:
                return "停止所有广播";
            case Operation.EmergencyTelephoneFinishDealing:
                return "紧急电话处理完毕";
            case Operation.EmergencyTelephoneEliminate:
                return "紧急电话消警";
            case Operation.EmergencyTelephoneStartBroadcast:
                return "开始广播";
            case Operation.EmergencyTelephoneStopBroadcast:
                return "停止广播";
            case Operation.EmergencyVDConfirm:
                return "避险车道确认报警";
            case Operation.EmergencyVDReset:
                return "避险车道复位";
            case Operation.EmergencyVDFinishDealing:
                return "避险车道处理完成";
            case Operation.EmergencyVDEliminate:
                return "避险车道消警";
            case Operation.EmergencyVDLightOn:
                return "避险车道开灯";
            case Operation.EmergencyVDLightOff:
                return "避险车道关灯";
            case Operation.EmergencyVDSetLightSchedule:
                return "避险车道设置时序";
            case Operation.EmergencyVDLSForward:
                return "避险车道LS正行";
            case Operation.EmergencyVDLSBackward:
                return "避险车道LS逆行";
            case Operation.EmergencyVDLSStop:
                return "避险车道LS禁行";
            case Operation.EmergencyVDLSTurn:
                return "避险车道LS转向";
            case Operation.EmergencyVDLSOff:
                return "避险车道LS关闭";
            case Operation.EmergencyVDLSEvacuate:
                return "避险车道LS撤离";
            case Operation.EmergencyVDTSRed:
                return "避险车道TS红灯";
            case Operation.EmergencyVDTSYellow:
                return "避险车道TS黄灯";
            case Operation.EmergencyVDTSGreen:
                return "避险车道TS绿灯";
            case Operation.EmergencyVDTSTurn:
                return "避险车道TS转向";
            case Operation.EmergencyVDTSOff:
                return "避险车道TS关闭";
            case Operation.BoardQueryFailure:
                return "查询故障";
            case Operation.BoardUploadFile:
                return "上载火灾联动";
            case Operation.BoardDownloadFile:
                return "下载火灾联动";
            case Operation.BoardDisplayFile:
                return "显示文件";
            case Operation.BoardDisplayContent:
                return "显示内容";
            case Operation.BoardSetModAndVal:
                return "设置亮度调节方式及亮度值";
            case Operation.BoardQueModAndVal:
                return "获取亮度调节方式及亮度值";
            case Operation.BoardSetSwitch:
                return "设置超速联动开关";
            case Operation.TunnelLightOn:
                return "开灯";
            case Operation.TunnelLightOff:
                return "关灯";
            case Operation.TunnelRestoreTimeControl:
                return "灯时序复位";
            case Operation.TunnelLightGetBrightness:
                return "获取LED调光灯亮度";
            case Operation.TunnelLightSetBrightness:
                return "设置LED调光灯亮度";
            case Operation.TunnelSetLightScheduleAuto:
                return "隧道设置时序控制";
            case Operation.TunnelSetLightOpticalIntensityAuto:
                return "隧道设置光强自动控制";
            case Operation.TunnelFanForward:
                return "风机正转";
            case Operation.TunnelFanReverse:
                return "风机反转";
            case Operation.TunnelFanOff:
                return "风机关机";
            case Operation.TunnelAxisFanStop:
                return "轴流风机控制停止";
            case Operation.TunnelAxisFanSetVFDFrequency:
                return "设置频率";
            case Operation.TunnelAxisFanSetRotationSpeedPercent:
                return "设置转速百分比";
            case Operation.TunnelAxisFanSetRotationSpeed:
                return "设置转速";
            case Operation.TunnelAxisFanSetWindVelocity:
                return "设置风速";
            case Operation.TunnelAxisFanSetAirQuantity:
                return "设置风量";
            case Operation.TunnelAxisFanSetWindPressure:
                return "设置风压";
            case Operation.TunnelAxisFanResetVFD:
                return "重启变频器";
            case Operation.TunnelAxisFanOpenFanValve:
                return "打开风机风阀";
            case Operation.TunnelAxisFanCloseFanValve:
                return "关闭风机风阀";
            case Operation.TunnelAxisFanStopFanValve:
                return "停止风机风阀";
            case Operation.TunnelAxisFanOpenDuctValve:
                return "打开风道风阀";
            case Operation.TunnelAxisFanCloseDuctValve:
                return "关闭风道风阀";
            case Operation.TunnelAxisFanStopDuctValve:
                return "停止风道风阀";
            case Operation.TunnelAxisFanManualCheckAirValve:
                return "手工确认风阀状态";
            case Operation.TunnelAxisFanSetAirValveOpenTime:
                return "设置风阀开启时间";
            case Operation.TunnelAxisFanEnableAutoProtection:
                return "启动自动保护";
            case Operation.TunnelAxisFanDisableAutoProtection:
                return "停止自动保护";
            case Operation.TunnelAxisFanOpenShutter:
                return "打开卷帘门";
            case Operation.TunnelAxisFanCloseShutter:
                return "关闭卷帘门";
            case Operation.TunnelAxisFanSimpleOn:
                return "打开风机";
            case Operation.TunnelAxisFanSimpleOff:
                return "关闭风机";
            case Operation.TunnelAxisFanSelectSetting:
                return "获取轴流风机设置";
            case Operation.TunnelAxisFanUpdateSetting:
                return "更新轴流风机设置";
            case Operation.AxisFanHouseControl:
                return "风机房控制";
            case Operation.TunnelTSRed:
                return "TS红灯";
            case Operation.TunnelTSYellow:
                return "TS黄灯";
            case Operation.TunnelTSGreen:
                return "TS绿灯";
            case Operation.TunnelTSTurn:
                return "TS转向";
            case Operation.TunnelTSOff:
                return "TS关闭";
            case Operation.TunnelTSOn:
                return "TS开启";
            case Operation.TunnelLSForward:
                return "LS正行";
            case Operation.TunnelLSStop:
                return "LS禁行";
            case Operation.TunnelLSTurn:
                return "LS转向";
            case Operation.TunnelLSReverse:
                return "LS逆行";
            case Operation.TunnelLSOff:
                return "LS关闭";
            case Operation.TunnelGeneratorStart:
                return "开启柴发";
            case Operation.TunnelGeneratorStop:
                return "关闭柴发";
            case Operation.TunnelGeneratorAutoControl:
                return "柴发自动控制";
            case Operation.TunnelGeneratorManualControl:
                return "柴发手动控制";
            case Operation.TunnelShutterOpen:
                return "打开卷帘门";
            case Operation.TunnelShutterClose:
                return "关闭卷帘门";
            case Operation.TunnelShutterStop:
                return "停止卷帘门";
            case Operation.TunnelBatchControl:
                return "隧道批控";
            case Operation.TunnelPLCTimeSync:
                return "PLC设备校时";
            case Operation.TunnelPLCSetAutoClear:
                return "PLC时序自动复位设置";
            case Operation.TunnelPLCSetEmergencyMode:
                return "PLC设置应急事故处理模式";
            case Operation.TunnelPLCClearEmergencyMode:
                return "PLC取消事故处理模式";
            case Operation.TunnelPLCBrightnessSetting:
                return "PLC光强LED设置";
            case Operation.TunnelFanScheduleSend:
                return "风机时序下发";
            case Operation.FireCisternPumpOn:
                return "打开水泵";
            case Operation.FireCisternPumpOff:
                return "关闭水泵";
            case Operation.HighVoltageOn:
                return "打开高压";
            case Operation.HighVoltageOff:
                return "关闭高压";
            case Operation.ExecScheme:
                return "预案下发";
            case Operation.AddScheme:
                return "添加预案";
            case Operation.RemoveScheme:
                return "删除预案";
            case Operation.UpdateScheme:
                return "更新预案";
            case Operation.AbortScheme:
                return "撤销预案";
            case Operation.VDSetSpeedSend:
                return "设置车检器联动参数";
            case Operation.VDSetSpeedThresholds:
                return "设置车检器联动门限";
            case Operation.UPSConfirm:
                return "UPS报警确认";
            case Operation.UPSFinishDealing:
                return "UPS报警处理完毕";
            case Operation.UPSEliminate:
                return "UPS报警消警";
            case Operation.UPSAlarmParameterSet:
                return "UPS预警参数设置";
            case Operation.ReportExport:
                return "报表导出";
            case Operation.ReportPrint:
                return "报表打印";
            case Operation.LightScheduleAdd:
                return "时序添加";
            case Operation.LightScheduleModify:
                return "时序修改";
            case Operation.LightScheduleDelete:
                return "时序删除";
            case Operation.LightScheduleSend:
                return "时序发送";
            case Operation.SwitchVideo:
                return "切换视频";
            case Operation.VideoEventConfirm:
                return "视频事件确认";
            case Operation.VideoEventReset:
                return "视频事件复位";
            case Operation.VideoEventFinishDealing:
                return "视频事件处理完毕";
            case Operation.VideoEventEliminate:
                return "视频事件消警";
            case Operation.AddLEDScreen:
                return "添加LED屏幕";
            case Operation.RemoveLEDScreen:
                return "移除LED屏幕";
            case Operation.AddScreenPage:
                return "添加屏幕页面";
            case Operation.RemoveScreenPage:
                return "移除屏幕页面";
            case Operation.AddPageGadget:
                return "添加页面Gadget";
            case Operation.RemovePageGadget:
                return "移除页面Gadget";
            case Operation.SendToLEDScreen:
                return "发送至物理LED屏幕显示";
            case Operation.UpdateLEDScreenParam:
                return "更新LED屏幕参数";
            case Operation.UpdatePageGadgetParam:
                return "更新LED页面Gadget参数";
            case Operation.DistributionCabinetMediumVoltageOn:
                return "中压柜(断路器、负荷开关柜)打开";
            case Operation.DistributionCabinetMediumVoltageOff:
                return "中压柜(断路器、负荷开关柜)关闭";
            case Operation.DistributionCabinetLowVoltageSystemOn:
                return "低压柜打开";
            case Operation.DistributionCabinetLowVoltageSystemOff:
                return "低压柜关闭";
            case Operation.DelayAlarmHintAtClient:
                return "客户端相关操作";
            case Operation.UserLogOn:
                return "用户登录";
            case Operation.UserLogOff:
                return "用户登出";
            case Operation.UpdateUserAlarmSetting:
                return "修改用户报警设置";
            case Operation.UpdateRegionAlarmSetting:
                return "修改区域报警设置";

            default:
                return null;
        }
    }

}
