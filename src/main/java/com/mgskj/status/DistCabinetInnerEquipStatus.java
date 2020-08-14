package com.mgskj.status;

public interface DistCabinetInnerEquipStatus {
    int Off = 0,//接触器断开
            On = 1,//接触器接通
            MainPowerBreakerOff = 2,//总断路器分闸
            MainPowerBreakerOn = 3,//总断路器合闸
            MainPowerSupplyOff = 4,//主电源供电分闸
            MainPowerSupplyOn = 5,//主电源供电合闸
            StandbyPowerSupplyOff = 6,//备电源供电分闸
            StandbyPowerSupplyOn = 7,//备电源供电合闸
            AutoSwitcherLocalControl = 8,//手自动本地控制
            AutoSwitcherAuto = 9,//手自动远程手动
            AutoSwitcherTiming = 10,//手自动时序控制器控制
            SurgeProtectionNormal = 11,//浪涌保护正常
            SurgeProtectionOverVoltage = 12,//浪涌保护击穿
            FanSoftStarterNormal = 13,//风机软启动器正常
            FanSoftStarterFault = 14,//风机软启动器故障
            FanBypassOff = 15,//旁路运行未开启
            FanBypassOn = 16,//旁路运行
            FanMotorCapacitorOff = 17,//电容未投入
            FanMotorCapacitorOn = 18,//电容投入

    /// <summary>
    /// PLC通讯中断
    /// </summary>
    PLCDisconnected = 0x08000000,

    /// <summary>
    /// OPC通讯中断
    /// </summary>
    OPCDisconnected = 0x10000000,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
