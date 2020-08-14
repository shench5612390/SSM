package com.mgskj.status;

public interface HighVoltageStatus {
    int   /// <summary>
            /// 合闸
            /// </summary>
            SwitchOn = 0,

    /// <summary>
    /// 分闸
    /// </summary>
    SwitchOff = 1,

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
