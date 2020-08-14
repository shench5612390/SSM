package com.mgskj.status;

public interface LSStatus {
    int Forward = 1,//正行
            Backward = 2,//逆行
            Stop = 3,//禁行
            Turn = 4,//转向（禁行+横箭头）
            Off = 0,//关闭
            Fault = 5,//故障

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
