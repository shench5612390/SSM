package com.mgskj.utils;

import com.mgskj.entity.ModuleDefine;
import com.mgskj.status.*;

public class EquipStatusUtil {
    public static String getEquipStatus2StringByModule(int sourceModule, int equipStatus) {
        switch (sourceModule) {
            case ModuleDefine.FanControlSystem:
                return FanStatus2String(equipStatus);
            case ModuleDefine.EmergencyVDSystem:
                return EmergencyVDStatus2String(equipStatus);
            case ModuleDefine.SignalsControlSystem:
                break;
            case ModuleDefine.LEDControlSystem:
                break;
            case ModuleDefine.CMSSystem:
                return CMSStstus2String(equipStatus);
            case ModuleDefine.LightControlSystem:
                return LightStatus2String(equipStatus);
            case ModuleDefine.EmergencyTelephoneSystem:
                return EmergencyTelephoneStatus2String(equipStatus);
            case ModuleDefine.PLCControlSystem:
                return PLCStatus2String(equipStatus);
            case ModuleDefine.GeneratorControlSystem:
                return GeneratorControlStatus2String(equipStatus);
            case ModuleDefine.SchemedControlSystem:
                break;
            case ModuleDefine.UPSSystem:
                return UPSStatus2String(equipStatus);
            case ModuleDefine.FireAlarmSystem:
                return FireAlarmStatus2String(equipStatus);
            case ModuleDefine.LightScheduleSystem:
                return LightScheduleStatus2String(equipStatus);
            case ModuleDefine.ShutterControlSystem:
                return ShutterStatus2String(equipStatus);
            case ModuleDefine.VideoEventDetectorSystem:
                break;
            case ModuleDefine.DataProviderSystem:
                break;
            case ModuleDefine.FireCisternControlSystem:
                return FireCisternStatus2String(equipStatus);
            case ModuleDefine.HighVoltageControlSystem:
                return HighVoltageStatus2String(equipStatus);
            case ModuleDefine.ReportingService:
                break;
            case ModuleDefine.SecurityServiceSystem:
                break;
            case ModuleDefine.TunnelPowerControlSystem:
                break;
            case ModuleDefine.VDControlSystem:
                return VDEquipStatus2String(equipStatus);
            case ModuleDefine.AmmeterControlSystem:
                return AmmeterStatus2String(equipStatus);
            case ModuleDefine.ClientDisplaySystem:
                break;
            case ModuleDefine.COVIControlSystem:
                return COVIStatus2String(equipStatus);
            case ModuleDefine.DistCabinetInnerEquipControlSystem:
                return DistCabinetInnerEquipStatus2String(equipStatus);
            case ModuleDefine.SpeedLimitSignSystem:
                break;
            case ModuleDefine.TemperatureControllerSystem:
                return TemperatureControllerStatus2String(equipStatus);
            case ModuleDefine.TunnelTrafficControlSystem:
                break;
            case ModuleDefine.VideoControlSystem:
                break;
            case ModuleDefine.BrightnessSystem:
                return BrightnessStatus2String(equipStatus);
            case ModuleDefine.InvasionDetectionSystem:
                break;
            case ModuleDefine.LSControlSystem:
                return LSStatus2String(equipStatus);
            case ModuleDefine.TSControlSystem:
                return TSStatus2String(equipStatus);
            case ModuleDefine.WeatherStationSystem:
                return WeatherStationStatus2String(equipStatus);
            case ModuleDefine.WindVelocitySystem:
                return WindVelocityStatus2String(equipStatus);
            default:
                break;
        }
        return "未知";
    }

    public static String FanStatus2String(int equipStatus) {
        switch (equipStatus) {
            case FanStatus.Backward:
                return "反转";
            case FanStatus.Fault:
                return "故障";
            case FanStatus.Forward:
                return "正转";
            case FanStatus.Off:
                return "停止";
            case FanStatus.OPCDisconnected:
                return "OPC通讯中断";
            case FanStatus.OutOfRange:
                return "数据不在规定范围内";
            case FanStatus.PLCDisconnected:
                return "PLC通讯中断";
            case FanStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String EmergencyVDStatus2String(int equipStatus) {
        switch (equipStatus) {
            case EmergencyVDStatus.AllVDCoilFault:
                return "全部线圈故障";
            case EmergencyVDStatus.BehindVDCoilFault:
                return "后线圈故障";
            case EmergencyVDStatus.Disconnect:
                return "通讯中断";
            case EmergencyVDStatus.DoorOpened:
                return "箱门打开";
            case EmergencyVDStatus.Fault:
                return "故障";
            case EmergencyVDStatus.FrontVDCoilFault:
                return "前线圈故障";
            case EmergencyVDStatus.LightOn:
                return "路灯打开";
            case EmergencyVDStatus.LSBackward:
                return "车道指示灯逆行";
            case EmergencyVDStatus.LSForward:
                return "车道指示灯正行";
            case EmergencyVDStatus.LSOff:
                return "车道指示灯关闭";
            case EmergencyVDStatus.LSStop:
                return "车道指示灯禁行";
            case EmergencyVDStatus.LSTurn:
                return "车道指示灯转向";
            case EmergencyVDStatus.Normal:
                return "正常";
            case EmergencyVDStatus.OutOfRange:
                return "数据不在规定范围内";
            case EmergencyVDStatus.ServiceDisconnected:
                return "服务通讯中断";
            case EmergencyVDStatus.TSGreen:
                return "交通指示灯绿灯";
            case EmergencyVDStatus.TSOff:
                return "交通指示灯关闭";
            case EmergencyVDStatus.TSRed:
                return "交通指示灯红灯";
            case EmergencyVDStatus.TSTurn:
                return "交通指示灯转向";
            case EmergencyVDStatus.TSYellow:
                return "交通指示灯黄灯";
            case EmergencyVDStatus.Unknown:
                return "未知";
            case EmergencyVDStatus.VehicleExist:
                return "车辆存在";
            default:
                return "未知";
        }
    }

    public static String LightStatus2String(int equipStatus) {
        switch (equipStatus) {
            case LightStatus.Fault:
                return "故障";
            case LightStatus.Off:
                return "关闭";
            case LightStatus.On:
                return "开启";
            case LightStatus.OPCDisconnected:
                return "OPC通讯中断";
            case LightStatus.OutOfRange:
                return "数据不在规定范围内";
            case LightStatus.PLCDisconnected:
                return "PLC通讯中断";
            case LightStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String EmergencyTelephoneStatus2String(int equipStatus) {
        switch (equipStatus) {
            case EmergencyTelephoneStatus.DoorOpened:
                return "箱门打开";
            case EmergencyTelephoneStatus.Fault:
                return "发生故障";
            case EmergencyTelephoneStatus.Inexsitence:
                return "设备不存在";
            case EmergencyTelephoneStatus.Normal:
                return "正常";
            case EmergencyTelephoneStatus.OutOfRange:
                return "数据不在规定范围内";
            case EmergencyTelephoneStatus.Ringing:
                return "正在振铃";
            case EmergencyTelephoneStatus.ServiceDisconnected:
                return "服务通讯中断";
            case EmergencyTelephoneStatus.Talking:
                return "正在通话";
            default:
                return "未知";
        }
    }

    public static String UPSStatus2String(int equipStatus) {
        switch (equipStatus) {
            case UPSStatus.BatterySupply:
                return "电池供电";
            case UPSStatus.Bypass:
                return "旁路";
            case UPSStatus.DataNonCollectableStatus:
                return "无法采集数据的状态集合";
            case UPSStatus.Disconnect:
                return "通信中断";
            case UPSStatus.DriverError:
                return "驱动运行错误";
            case UPSStatus.Fault:
                return "故障";
            case UPSStatus.LowBattery:
                return "电池剩余容量低";
            case UPSStatus.LowBatteryProtect:
                return "电池余量过低保护";
            case UPSStatus.Normal:
                return "正常";
            case UPSStatus.OutOfRange:
                return "数据不在规定范围内";
            case UPSStatus.Overload:
                return "负载超限";
            case UPSStatus.OverloadProtect:
                return "过载保护";
            case UPSStatus.PLCDisconnected:
                return "PLC通讯中断";
            case UPSStatus.PowerAbnormalProtect:
                return "市电异常保护";
            case UPSStatus.PowerDown:
                return "市电中断";
            case UPSStatus.ServiceDisconnected:
                return "服务通讯中断";
            case UPSStatus.Stop:
                return "停止";
            case UPSStatus.VoltInAbnormal:
                return "输入电压超限";
            case UPSStatus.VoltOutAbnormal:
                return "输出电压超限";
            default:
                return "未知";
        }
    }

    public static String FireAlarmStatus2String(int equipStatus) {
        switch (equipStatus) {
            case FireAlarmStatus.CriticalFault:
                return "严重故障";
            case FireAlarmStatus.Disconnect:
                return "通讯中断";
            case FireAlarmStatus.FireAlarm:
                return "火灾报警";
            case FireAlarmStatus.GeneralFault:
                return "普通故障";
            case FireAlarmStatus.Normal:
                return "正常";
            case FireAlarmStatus.OutOfRange:
                return "数据不在规定范围内";
            case FireAlarmStatus.PowerFailure:
                return "断电故障";
            case FireAlarmStatus.ServiceDisconnected:
                return "服务通讯中断";
            case FireAlarmStatus.Shortcircuit:
                return "短路故障";
            default:
                return "未知";
        }
    }

    public static String VDEquipStatus2String(int equipStatus) {
        switch (equipStatus) {
            case VDEquipStatus.CommunicationFaulted:
                return "通信中断";
            case VDEquipStatus.EquipFaulted:
                return "设备故障";
            case VDEquipStatus.Normal:
                return "正常";
            case VDEquipStatus.OutOfRange:
                return "数据不在规定范围内";
            case VDEquipStatus.ServiceDisconnected:
                return "服务通讯中断";
            case VDEquipStatus.WCFDisconnected:
                return "WCF服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String DistCabinetInnerEquipStatus2String(int equipStatus) {
        switch (equipStatus) {
            case DistCabinetInnerEquipStatus.AutoSwitcherAuto:
                return "手自动远程手动";
            case DistCabinetInnerEquipStatus.AutoSwitcherLocalControl:
                return "手自动本地控制";
            case DistCabinetInnerEquipStatus.AutoSwitcherTiming:
                return "手自动时序控制器控制";
            case DistCabinetInnerEquipStatus.FanBypassOff:
                return "旁路运行未开启";
            case DistCabinetInnerEquipStatus.FanBypassOn:
                return "旁路运行";
            case DistCabinetInnerEquipStatus.FanMotorCapacitorOff:
                return "电容未投入";
            case DistCabinetInnerEquipStatus.FanMotorCapacitorOn:
                return "电容投入";
            case DistCabinetInnerEquipStatus.FanSoftStarterFault:
                return "风机软启动器故障";
            case DistCabinetInnerEquipStatus.FanSoftStarterNormal:
                return "风机软启动器正常";
            case DistCabinetInnerEquipStatus.MainPowerBreakerOff:
                return "总断路器分闸";
            case DistCabinetInnerEquipStatus.MainPowerBreakerOn:
                return "总断路器合闸";
            case DistCabinetInnerEquipStatus.MainPowerSupplyOff:
                return "主电源供电分闸";
            case DistCabinetInnerEquipStatus.MainPowerSupplyOn:
                return "主电源供电合闸";
            case DistCabinetInnerEquipStatus.Off:
                return "接触器断开";
            case DistCabinetInnerEquipStatus.On:
                return "接触器接通";
            case DistCabinetInnerEquipStatus.OPCDisconnected:
                return "OPC通讯中断";
            case DistCabinetInnerEquipStatus.OutOfRange:
                return "数据不在规定范围内";
            case DistCabinetInnerEquipStatus.PLCDisconnected:
                return "PLC通讯中断";
            case DistCabinetInnerEquipStatus.ServiceDisconnected:
                return "服务通讯中断";
            case DistCabinetInnerEquipStatus.StandbyPowerSupplyOff:
                return "备电源供电分闸";
            case DistCabinetInnerEquipStatus.StandbyPowerSupplyOn:
                return "备电源供电合闸";
            case DistCabinetInnerEquipStatus.SurgeProtectionNormal:
                return "浪涌保护正常";
            case DistCabinetInnerEquipStatus.SurgeProtectionOverVoltage:
                return "浪涌保护击穿";
            default:
                return "未知";
        }
    }

    public static String LSStatus2String(int equipStatus) {
        switch (equipStatus) {
            case LSStatus.Backward:
                return "逆行";
            case LSStatus.Fault:
                return "故障";
            case LSStatus.Forward:
                return "正行";
            case LSStatus.Off:
                return "关闭";
            case LSStatus.OPCDisconnected:
                return "OPC通讯中断";
            case LSStatus.OutOfRange:
                return "数据不在规定范围内";
            case LSStatus.PLCDisconnected:
                return "PLC通讯中断";
            case LSStatus.ServiceDisconnected:
                return "服务通讯中断";
            case LSStatus.Stop:
                return "禁行";
            case LSStatus.Turn:
                return "转向（禁行+横箭头）";
            default:
                return "未知";
        }
    }

    public static String WeatherStationStatus2String(int equipStatus) {
        switch (equipStatus) {
            case WeatherStationStatus.Disconnected:
                return "通讯中断";
            case WeatherStationStatus.Fault:
                return "故障";
            case WeatherStationStatus.Normal:
                return "正常";
            case WeatherStationStatus.OutOfRange:
                return "数据不在规定范围内";
            case WeatherStationStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String AmmeterStatus2String(int equipStatus) {
        switch (equipStatus) {
            case AmmeterStatus.Disconnect:
                return "通信中断";
            case AmmeterStatus.Fault:
                return "故障";
            case AmmeterStatus.Normal:
                return "正常";
            case AmmeterStatus.OPCDisconnected:
                return "OPC通讯中断";
            case AmmeterStatus.OutOfRange:
                return "数据不在规定范围内";
            case AmmeterStatus.PLCDisconnected:
                return "PLC通讯中断";
            case AmmeterStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String ShutterStatus2String(int equipStatus) {
        switch (equipStatus) {
            case ShutterStatus.Close:
                return "全闭";
            case ShutterStatus.Fault:
                return "故障";
            case ShutterStatus.Middle:
                return "半开";
            case ShutterStatus.OPCDisconnected:
                return "OPC通讯中断";
            case ShutterStatus.Open:
                return "全开";
            case ShutterStatus.OutOfRange:
                return "数据不在规定范围内";
            case ShutterStatus.PLCDisconnected:
                return "PLC通讯中断";
            case ShutterStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String LightScheduleStatus2String(int equipStatus) {
        switch (equipStatus) {
            case LightScheduleStatus.Fault:
                return "故障";
            case LightScheduleStatus.Normal:
                return "正常";
            case LightScheduleStatus.OPCDisconnected:
                return "OPC通讯中断";
            case LightScheduleStatus.OutOfRange:
                return "数据不在规定范围内";
            case LightScheduleStatus.PLCDisconnected:
                return "PLC通讯中断";
            case LightScheduleStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String CMSStstus2String(int equipStatus) {
        switch (equipStatus) {
            case CMSStstus.DisConnect:
                return "通讯中断";
            case CMSStstus.EquipFault:
                return "设备故障";
            case CMSStstus.Normal:
                return "正常";
            case CMSStstus.ServiceDisConnect:
                return "服务通信中断";
            case CMSStstus.Unspecified:
                return "数据不在规定范围内";
            default:
                return "未知";
        }
    }

    public static String COVIStatus2String(int equipStatus) {
        switch (equipStatus) {
            case COVIStatus.COAbnormal:
                return "CO值异常";
            case COVIStatus.COFault:
                return "CO故障";
            case COVIStatus.Disconnect:
                return "通信中断";
            case COVIStatus.Normal:
                return "正常";
            case COVIStatus.OPCDisconnected:
                return "OPC通讯中断";
            case COVIStatus.OutOfRange:
                return "数据不在规定范围内";
            case COVIStatus.PLCDisconnected:
                return "PLC通讯中断";
            case COVIStatus.ServiceDisconnected:
                return "服务通讯中断";
            case COVIStatus.VIAbnormal:
                return "VI值异常";
            case COVIStatus.VIFault:
                return "VI故障";
            default:
                return "未知";
        }
    }

    public static String FireCisternStatus2String(int equipStatus) {
        switch (equipStatus) {
            case FireCisternStatus.Disconnect:
                return "通信中断";
            case FireCisternStatus.Fault:
                return "故障";
            case FireCisternStatus.HighWaterLevel:
                return "水池高水位";
            case FireCisternStatus.LowWaterLevel:
                return "水池低水位";
            case FireCisternStatus.MiddleWaterLevel:
                return "水池中水位";
            case FireCisternStatus.Normal:
                return "正常";
            case FireCisternStatus.OPCDisconnected:
                return "OPC通讯中断";
            case FireCisternStatus.OutOfRange:
                return "数据不在规定范围内";
            case FireCisternStatus.PLCDisconnected:
                return "PLC通讯中断";
            case FireCisternStatus.PumpAuto:
                return "水泵自动控制";
            case FireCisternStatus.PumpLocalControl:
                return "水泵本地控制";
            case FireCisternStatus.PumpOff:
                return "水泵停止";
            case FireCisternStatus.PumpOn:
                return "水泵启动";
            case FireCisternStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String GeneratorControlStatus2String(int equipStatus) {
        switch (equipStatus) {
            case GeneratorControlStatus.Disconnected:
                return "断开连接";
            case GeneratorControlStatus.Fault:
                return "故障";
            case GeneratorControlStatus.OPCDisconnected:
                return "OPC通讯中断";
            case GeneratorControlStatus.OutOfRange:
                return "数据不在规定范围内";
            case GeneratorControlStatus.PLCDisconnected:
                return "PLC通讯中断";
            case GeneratorControlStatus.ServiceDisconnected:
                return "服务通讯中断";
            case GeneratorControlStatus.Start:
                return "启动";
            case GeneratorControlStatus.Starting:
                return "启动中";
            case GeneratorControlStatus.Stop:
                return "停止";
            case GeneratorControlStatus.Stopping:
                return "停止中";
            default:
                return "未知";
        }
    }

    public static String HighVoltageStatus2String(int equipStatus) {
        switch (equipStatus) {
            case HighVoltageStatus.OPCDisconnected:
                return "OPC通讯中断";
            case HighVoltageStatus.OutOfRange:
                return "数据不在规定范围内";
            case HighVoltageStatus.PLCDisconnected:
                return "PLC通讯中断";
            case HighVoltageStatus.ServiceDisconnected:
                return "服务通讯中断";
            case HighVoltageStatus.SwitchOff:
                return "分闸";
            case HighVoltageStatus.SwitchOn:
                return "合闸";
            default:
                return "未知";
        }
    }

    public static String PLCStatus2String(int equipStatus) {
        switch (equipStatus) {
            case PLCStatus.Fault:
                return "故障";
            case PLCStatus.Normal:
                return "正常";
            case PLCStatus.OPCDisconnected:
                return "OPC通讯中断";
            case PLCStatus.OutOfRange:
                return "数据不在规定范围内";
            case PLCStatus.PLCDisconnected:
                return "PLC通讯中断";
            case PLCStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String TemperatureControllerStatus2String(int equipStatus) {
        switch (equipStatus) {
            case TemperatureControllerStatus.Disconnect:
                return "通信中断";
            case TemperatureControllerStatus.Fault:
                return "故障";
            case TemperatureControllerStatus.HighTemperature:
                return "相温控器超上限";
            case TemperatureControllerStatus.LowTemperature:
                return "相温控器超下限";
            case TemperatureControllerStatus.Normal:
                return "正常";
            case TemperatureControllerStatus.OPCDisconnected:
                return "OPC通讯中断";
            case TemperatureControllerStatus.OutOfRange:
                return "数据不在规定范围内";
            case TemperatureControllerStatus.PhaseTemperatureControllerOpen:
                return "开路";
            case TemperatureControllerStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }

    public static String TSStatus2String(int equipStatus) {
        switch (equipStatus) {
            case TSStatus.Fault:
                return "故障";
            case TSStatus.Green:
                return "绿灯";
            case TSStatus.Off:
                return "关闭";
            case TSStatus.On:
                return "开启";
            case TSStatus.OPCDisconnected:
                return "OPC通讯中断";
            case TSStatus.OutOfRange:
                return "数据不在规定范围内";
            case TSStatus.PLCDisconnected:
                return "PLC通讯中断";
            case TSStatus.Red:
                return "红灯";
            case TSStatus.ServiceDisconnected:
                return "服务通讯中断";
            case TSStatus.Turn:
                return "转向（红灯+横箭头）";
            case TSStatus.Yellow:
                return "黄灯";
            default:
                return "未知";
        }
    }

    public static String WindVelocityStatus2String(int equipStatus) {
        switch (equipStatus) {
            case WindVelocityStatus.Direction_Fault:
                return "风向故障";
            case WindVelocityStatus.Normal:
                return "正常";
            case WindVelocityStatus.OPCDisconnected:
                return "OPC通讯中断";
            case WindVelocityStatus.OutOfRange:
                return "数据不在规定范围内";
            case WindVelocityStatus.PLCDisconnected:
                return "PLC通讯中断";
            case WindVelocityStatus.ServiceDisconnected:
                return "服务通讯中断";
            case WindVelocityStatus.Speed_Fault:
                return "风速故障";
            default:
                return "未知";
        }
    }

    public static String BrightnessStatus2String(int equipStatus) {
        switch (equipStatus) {
            case BrightnessStatus.Fault:
                return "故障";
            case BrightnessStatus.Normal:
                return "正常";
            case BrightnessStatus.OPCDisconnected:
                return "OPC通讯中断";
            case BrightnessStatus.OutOfRange:
                return "数据不在规定范围内";
            case BrightnessStatus.PLCDisconnected:
                return "PLC通讯中断";
            case BrightnessStatus.ServiceDisconnected:
                return "服务通讯中断";
            default:
                return "未知";
        }
    }
}
