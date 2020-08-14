package com.mgskj.utils;

import com.mgskj.entity.ModuleDefine;
import com.mgskj.equiptype.*;

public class ModuleUtil {
    public static String getModule2StringByModule(int sourceModule) {
        switch (sourceModule) {
            case ModuleDefine.FanControlSystem:
                return "风机控制系统";
            case ModuleDefine.EmergencyVDSystem:
                return "避险车道";
            case ModuleDefine.SignalsControlSystem:
                return "交通信号标志";
            case ModuleDefine.LEDControlSystem:
                return "LED控制系统";
            case ModuleDefine.CMSSystem:
                return "情报板系统";
            case ModuleDefine.LightControlSystem:
                return "灯控制系统";
            case ModuleDefine.EmergencyTelephoneSystem:
                return "紧急电话";
            case ModuleDefine.PLCControlSystem:
                return "PLC";
            case ModuleDefine.GeneratorControlSystem:
                return "柴发";
            case ModuleDefine.SchemedControlSystem:
                return "联动预案服务";
            case ModuleDefine.UPSSystem:
                return "UPS";
            case ModuleDefine.FireAlarmSystem:
                return "火灾报警";
            case ModuleDefine.LightScheduleSystem:
                return "照明时序系统";
            case ModuleDefine.ShutterControlSystem:
                return "卷帘门";
            case ModuleDefine.VideoEventDetectorSystem:
                return "视频事件检测";
            case ModuleDefine.DataProviderSystem:
                return "数据提供系统";
            case ModuleDefine.FireCisternControlSystem:
                return "消防水池";
            case ModuleDefine.HighVoltageControlSystem:
                return "高压控制系统";
            case ModuleDefine.ReportingService:
                return "报表服务";
            case ModuleDefine.SecurityServiceSystem:
                return "用户安全服务系统";
            case ModuleDefine.TunnelPowerControlSystem:
                return "隧道电力控制系统";
            case ModuleDefine.VDControlSystem:
                return "车检控制系统";
            case ModuleDefine.AmmeterControlSystem:
                return "电表";
            case ModuleDefine.ClientDisplaySystem:
                return "客户端界面显示模块";
            case ModuleDefine.COVIControlSystem:
                return "COVI";
            case ModuleDefine.DistCabinetInnerEquipControlSystem:
                return "柜内设备";
            case ModuleDefine.SpeedLimitSignSystem:
                return "限速标志系统";
            case ModuleDefine.TemperatureControllerSystem:
                return "温控仪";
            case ModuleDefine.TunnelTrafficControlSystem:
                return "隧道交通监控系统";
            case ModuleDefine.VideoControlSystem:
                return "视频管理系统";
            case ModuleDefine.BrightnessSystem:
                return "光强设备";
            case ModuleDefine.InvasionDetectionSystem:
                return "入侵检测";
            case ModuleDefine.LSControlSystem:
                return "LS交通信号标志";
            case ModuleDefine.ThermoHygroMeterSystem:
                return "环境温湿度传感器";
            case ModuleDefine.TSControlSystem:
                return "TS交通信号标志";
            case ModuleDefine.WeatherStationSystem:
                return "气象站设备";
            default:
                break;
        }
        return "未知";
    }

}
