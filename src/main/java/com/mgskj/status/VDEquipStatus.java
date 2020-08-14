package com.mgskj.status;

public interface VDEquipStatus {
    int /// <summary>
            /// 正常
            /// </summary>
            Normal = 0,

    /// <summary>
    /// 设备故障
    /// </summary>
    EquipFaulted = 1,

    /// <summary>
    /// 通信中断
    /// </summary>
    CommunicationFaulted = 2,

    /// <summary>
    /// WCF服务通讯中断
    /// </summary>
    WCFDisconnected = 0x10000000,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
