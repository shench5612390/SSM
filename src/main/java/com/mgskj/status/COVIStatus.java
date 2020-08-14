package com.mgskj.status;

public interface COVIStatus {
    int Normal = 0,//正常
            Disconnect = 1,//通信中断
            COFault = 2,//CO故障
            VIFault = 4,//VI故障
            COAbnormal = 8,//CO值异常
            VIAbnormal = 16,//VI值异常

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
