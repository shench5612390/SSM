package com.mgskj.status;

public interface WeatherStationStatus {
    int Normal = 0,
            Fault = 1,
            Disconnected = 2,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
