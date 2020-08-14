package com.mgskj.status;

public interface TSStatus {
    int Off = 0,//关闭
            Red = 1,//红灯
            Yellow = 2,//黄灯
            Green = 3,//绿灯
            Turn = 4,//转向（红灯+横箭头）
            Fault = 5,//故障
            On = 6,

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
