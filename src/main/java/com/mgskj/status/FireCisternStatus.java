package com.mgskj.status;

public interface FireCisternStatus {
    int Normal = 0,//正常
            Disconnect = 1,//通信中断
            Fault = 2,//故障
            HighWaterLevel = 4,//水池高水位
            MiddleWaterLevel = 8,//水池中水位
            LowWaterLevel = 16,//水池低水位
            PumpOn = 32,//水泵启动
            PumpOff = 64,//水泵停止
            PumpAuto = 128,//水泵自动控制
            PumpLocalControl = 256,//水泵本地控制

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
