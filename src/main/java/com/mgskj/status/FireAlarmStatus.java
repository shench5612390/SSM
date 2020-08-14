package com.mgskj.status;

public interface FireAlarmStatus {
    int Normal = 0,//正常
            FireAlarm = 1,//火灾报警
            CriticalFault = 2,//严重故障
            GeneralFault = 4,//普通故障
            Disconnect = 8,//通讯中断
            PowerFailure = 16,//断电故障
            Shortcircuit = 32,//短路故障

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
