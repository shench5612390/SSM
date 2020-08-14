package com.mgskj.status;

public interface EmergencyTelephoneStatus {
    /// <summary>
    /// 正常
    /// </summary>
    int Normal = 0,

    /// <summary>
    /// 发生故障
    /// </summary>
    Fault = 1,

    /// <summary>
    /// 正在振铃
    /// </summary>
    Ringing = 2,

    /// <summary>
    /// 正在通话
    /// </summary>
    Talking = 3,

    /// <summary>
    /// 箱门打开
    /// </summary>
    DoorOpened = 4,

    /// <summary>
    /// 设备不存在
    /// </summary>
    Inexsitence = 32,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
