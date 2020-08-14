package com.mgskj.status;

public interface TemperatureControllerStatus {
    //温控仪工作状态类型
    int Normal = 0,//正常
            Disconnect = 1,//通信中断
            Fault = 2,//故障
            PhaseTemperatureControllerOpen = 4,//开路
            HighTemperature = 8,//相温控器超上限
            LowTemperature = 16,//相温控器超下限

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
