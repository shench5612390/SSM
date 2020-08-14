package com.mgskj.status;

public interface UPSStatus {
    /// <summary>
    /// 正常
    /// </summary>
    int Normal = 0,

    /// <summary>
    /// 停止
    /// </summary>
    Stop = 1,

    /// <summary>
    /// 通信中断
    /// </summary>
    Disconnect = 2,

    /// <summary>
    /// 故障
    /// </summary>
    Fault = 4,

    /// <summary>
    /// 市电中断
    /// </summary>
    PowerDown = 8,

    /// <summary>
    /// 电池供电
    /// </summary>
    BatterySupply = 16,

    /// <summary>
    /// 旁路
    /// </summary>
    Bypass = 32,

    /// <summary>
    /// 过载保护
    /// </summary>
    OverloadProtect = 64,

    /// <summary>
    /// 市电异常保护
    /// </summary>
    PowerAbnormalProtect = 128,

    /// <summary>
    /// 电池余量过低保护
    /// </summary>
    LowBatteryProtect = 256,

//            #region 预警状态

    /// <summary>
    /// 输入电压超限
    /// </summary>
    VoltInAbnormal = 512,

    /// <summary>
    /// 输出电压超限
    /// </summary>
    VoltOutAbnormal = 1024,

    /// <summary>
    /// 负载超限
    /// </summary>
    Overload = 2048,

    /// <summary>
    /// 电池剩余容量低
    /// </summary>
    LowBattery = 4096,

//            #endregion 预警状态

    /// <summary>
    /// PLC通讯中断
    /// </summary>
    PLCDisconnected = 0x08000000,

    /// <summary>
    /// 驱动运行错误
    /// </summary>
    DriverError = 0x10000000,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000,

    /// <summary>
    /// 无法采集数据的状态集合
    /// </summary>
    DataNonCollectableStatus = PLCDisconnected | Disconnect | DriverError | OutOfRange;
}
