package com.mgskj.utils;

import com.mgskj.entity.ModuleDefine;
import com.mgskj.equiptype.*;

public class EquipTypeUtil {
    public static String getEquiptype2StringByModule(int sourceModule, int equipType) {
        switch (sourceModule) {
            case ModuleDefine.FanControlSystem:
                return FanEquipType2String(equipType);
            case ModuleDefine.EmergencyVDSystem:
                return EmergencyVDEquipType2String(equipType);
            case ModuleDefine.SignalsControlSystem:
                return "交通信号标志";
            case ModuleDefine.LEDControlSystem:
                return "LED控制系统";
            case ModuleDefine.CMSSystem:
                return "情报板系统";
            case ModuleDefine.LightControlSystem:
                return LightEquipType2String(equipType);
            case ModuleDefine.EmergencyTelephoneSystem:
                return EmergencyTelephoneEquipType2String(equipType);
            case ModuleDefine.PLCControlSystem:
                return "PLC";
            case ModuleDefine.GeneratorControlSystem:
                return "柴发";
            case ModuleDefine.SchemedControlSystem:
                return "联动预案服务";
            case ModuleDefine.UPSSystem:
                return UPSEquipType2String(equipType);
            case ModuleDefine.FireAlarmSystem:
                return FireAlarmEquipType2String(equipType);
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
                return VDEquipType2String(equipType);
            case ModuleDefine.AmmeterControlSystem:
                return AmmeterEquipType2String(equipType);
            case ModuleDefine.ClientDisplaySystem:
                return "客户端界面显示模块";
            case ModuleDefine.COVIControlSystem:
                return "COVI检测系统";
            case ModuleDefine.DistCabinetInnerEquipControlSystem:
                return DistCabinetInnerEquipType2String(equipType);
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
                return LSEquipType2String(equipType);
            case ModuleDefine.TSControlSystem:
                return "TS交通信号标志";
            case ModuleDefine.WeatherStationSystem:
                return WeatherStationEquipType2String(equipType);
            case ModuleDefine.WindVelocitySystem:
                return "风速风向";
            default:
                break;
        }
        return "未知";
    }

    public static String FireAlarmEquipType2String(int type) {
        switch (type) {
            case FireAlarmEquipType.FireAlarmConnection:
                return "网络连接";
            case FireAlarmEquipType.FireAlarmStation:
                return "火灾报警主机";
            case FireAlarmEquipType.FireAlarmDetector:
                return "火灾报警探测器";
            case FireAlarmEquipType.FireAlarmButton:
                return "手动报警按钮";
            case FireAlarmEquipType.Other:
                return "其它";

            default:
                return "网络连接";
        }
    }

    public static String EmergencyTelephoneEquipType2String(int type) {
        switch (type) {
            case EmergencyTelephoneEquipType.BroadcastGroup:
                return "广播组";
            case EmergencyTelephoneEquipType.Broadcast:
                return "广播";
            case EmergencyTelephoneEquipType.EmergencyCall:
                return "紧急电话";
            case EmergencyTelephoneEquipType.EmergencyCallStation:
                return "紧急电话工作站";
            case EmergencyTelephoneEquipType.BroadcastStation:
                return "广播工作站";

            default:
                return "未知";
        }
    }

    public static String EVDEquiptype2String(int type) {
        switch (type) {
            case EmergencyVDEquipType.Controller:
                return "控制器";
            case EmergencyVDEquipType.VDCoil:
                return "VD线圈";
            case EmergencyVDEquipType.Lamp:
                return "路灯";
            case EmergencyVDEquipType.LS1:
                return "车道指示灯1";
            case EmergencyVDEquipType.LS2:
                return "车道指示灯2";
            case EmergencyVDEquipType.TS1:
                return "交通信号灯1";
            case EmergencyVDEquipType.TS2:
                return "交通信号灯2";
            case EmergencyVDEquipType.Lamp2:
                return "路灯2";
            case EmergencyVDEquipType.Lamp3:
                return "路灯3";
            case EmergencyVDEquipType.CMSSwitch:
                return "情报板开关";

            default:
                return "未知";
        }
    }

    public static String TunnelEquiptype2String(int type) {
        switch (type) {
            case ModuleDefine.TunnelPowerControlSystem:
                return "隧道电力控制系统";
            case ModuleDefine.LightControlSystem:
                return "灯控制系统";
            case ModuleDefine.FanControlSystem:
                return "风机控制系统";
            case ModuleDefine.AmmeterControlSystem:
                return "电表";
            case ModuleDefine.UPSSystem:
                return "UPS";
            case ModuleDefine.PLCControlSystem:
                return "PLC";
            case ModuleDefine.DistCabinetInnerEquipControlSystem:
                return "柜内设备";
            case ModuleDefine.TemperatureControllerSystem:
                return "温控仪";
            case ModuleDefine.GeneratorControlSystem:
                return "柴发";
            case ModuleDefine.TunnelTrafficControlSystem:
                return "隧道交通监控系统";
            case ModuleDefine.SignalsControlSystem:
                return "交通信号标志";
            case ModuleDefine.COVIControlSystem:
                return "COVI检测系统";
            case ModuleDefine.ShutterControlSystem:
                return "卷帘门";
            case ModuleDefine.SpeedLimitSignSystem:
                return "限速标志系统";
            default:
                return "未知";
        }
    }

    public static String FanEquipType2String(int equipType) {
        switch (equipType) {
            case FanEquipType.AxisFan:
                return "轴流风机";
            case FanEquipType.JetFan:
                return "射流风机";
            case FanEquipType.SimpleAxisFan:
                return "简化轴流风机";
            default:
                return "未知";
        }
    }

    public static String EmergencyVDEquipType2String(int equipType) {
        switch (equipType) {
            case EmergencyVDEquipType.CMSSwitch:
                return "情报板开关";
            case EmergencyVDEquipType.Controller:
                return "情报板开关控制器";
            case EmergencyVDEquipType.Lamp:
                return "路灯";
            case EmergencyVDEquipType.Lamp2:
                return "路灯2";
            case EmergencyVDEquipType.Lamp3:
                return "路灯3";
            case EmergencyVDEquipType.LS1:
                return "车道指示灯1";
            case EmergencyVDEquipType.LS2:
                return "车道指示灯2";
            case EmergencyVDEquipType.TS1:
                return "交通信号灯1";
            case EmergencyVDEquipType.TS2:
                return "交通信号灯2";
            case EmergencyVDEquipType.VDCoil:
                return "VD线圈";

            default:
                return "未知";
        }
    }

    public static String LightEquipType2String(int equipType) {
        switch (equipType) {
            case LightEquipType.CableLamp:
                return "拉锁灯";
            case LightEquipType.ClearanceLamp:
                return "轮廓灯";
            case LightEquipType.EmergencyLamp:
                return "应急灯";
            case LightEquipType.FogLamp:
                return "雾灯";
            case LightEquipType.FullTimeLamp1:
                return "全日灯1";
            case LightEquipType.FullTimeLamp2:
                return "全日灯2";
            case LightEquipType.FullTimeLamp3:
                return "全日灯3";
            case LightEquipType.FullTimeLamp4:
                return "全日灯4";
            case LightEquipType.FullTimeLampA1:
                return "全日灯A1";
            case LightEquipType.FullTimeLampA2:
                return "全日灯A2";
            case LightEquipType.FullTimeLampB1:
                return "全日灯B1";
            case LightEquipType.FullTimeLampB2:
                return "全日灯B2";
            case LightEquipType.GalleryLamp:
                return "横洞路灯";
            case LightEquipType.IntensifyLamp1:
                return "加强灯1";
            case LightEquipType.IntensifyLamp2:
                return "加强灯2";
            case LightEquipType.IntensifyLamp3:
                return "加强灯3";
            case LightEquipType.IntensifyLamp4:
                return "加强灯4";
            case LightEquipType.IntensifyLamp11:
                return "加强灯1-1";
            case LightEquipType.IntensifyLamp12:
                return "加强灯1-2";
            case LightEquipType.IntensifyLamp21:
                return "加强灯2-1";
            case LightEquipType.IntensifyLampC:
                return "加强灯C";
            case LightEquipType.IntensifyLampD:
                return "加强灯D";
            case LightEquipType.IntensifyLampE:
                return "加强灯E";
            case LightEquipType.IntensifyLampF:
                return "加强灯F";
            case LightEquipType.IntensifyLampG:
                return "加强灯G";
            case LightEquipType.IntensifyLampH:
                return "加强灯H";
            case LightEquipType.StreetLamp:
                return "路灯";
            case LightEquipType.TowerLamp:
                return "灯塔照明";
            default:
                return "未知";
        }
    }

    public static String UPSEquipType2String(int type) {
        switch (type) {
            case UPSEquipType.ManageStation:
                return "管理工作站";
            case UPSEquipType.SinglePhase:
                return "单相UPS";
            case UPSEquipType.TriplePhase:
                return "三相UPS";
            default:
                return "未知";
        }
    }

    public static String VDEquipType2String(int type) {
        switch (type) {
            case VDEquipType.Coil:
                return "线圈";
            case VDEquipType.Controller:
                return "控制器";
            case VDEquipType.Server:
                return "分中心服务器";
            default:
                return "未知";
        }
    }

    public static String DistCabinetInnerEquipType2String(int type) {
        switch (type) {
            case DistCabinetInnerEquipType.AutoSwitcher:
                return "手自动开关";
            case DistCabinetInnerEquipType.FanBypass:
                return "风机旁路运行";
            case DistCabinetInnerEquipType.FanContactor:
                return "风机接触器";
            case DistCabinetInnerEquipType.FanMotorCapacitor:
                return "风机电容投入";
            case DistCabinetInnerEquipType.FanSoftStarter:
                return "风机软启动器";
            case DistCabinetInnerEquipType.Label:
                return "文字标签";
            case DistCabinetInnerEquipType.LightContactor:
                return "灯接触器";
            case DistCabinetInnerEquipType.MainPowerBreaker:
                return "总断路器";
            case DistCabinetInnerEquipType.MainPowerSupply:
                return "主电供电";
            case DistCabinetInnerEquipType.StandbyPowerSupply:
                return "备电供电";
            case DistCabinetInnerEquipType.SurgeProtection:
                return "浪涌保护";
            default:
                return "未知";
        }
    }

    public static String LSEquipType2String(int type) {
        switch (type) {
            case LSEquipType.LSNoTurn:
                return "车道指示标志,不带横洞指示标志";
            case LSEquipType.LSSingle:
                return "单片LS";
            case LSEquipType.LSWithTurn:
                return "车道指示标志，带横洞指示标志";
            default:
                return "未知";
        }
    }

    public static String WeatherStationEquipType2String(int type) {
        switch (type) {
            case WeatherStationEquipType.AtmosphericPressure:
                return "气压";
            case WeatherStationEquipType.Humidity:
                return "湿度";
            case WeatherStationEquipType.Rainfall:
                return "雨量";
            case WeatherStationEquipType.RoadTemperature:
                return "路温";
            case WeatherStationEquipType.SurfaceCondition:
                return "路面状况";
            case WeatherStationEquipType.Temperature:
                return "气温";
            case WeatherStationEquipType.Visibility:
                return "能见度";
            case WeatherStationEquipType.WindDirection:
                return "风向";
            case WeatherStationEquipType.WindVelocity:
                return "风速";
            default:
                return "未知";
        }
    }

    public static String AmmeterEquipType2String(int type) {
        switch (type) {
            case AmmeterEquipType.SinglePhase:
                return "单相电表";
            case AmmeterEquipType.ThreePhase:
                return "三相电表";
            default:
                return "未知";
        }
    }
}
