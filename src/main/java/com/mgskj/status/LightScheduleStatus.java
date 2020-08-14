package com.mgskj.status;

public interface LightScheduleStatus {
    int  /// 正常
            /// </summary>
            Normal = 0,

    /// <summary>
    /// 故障
    /// </summary>
    Fault = 1,

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
