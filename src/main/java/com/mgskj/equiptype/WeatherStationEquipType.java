package com.mgskj.equiptype;

public interface WeatherStationEquipType {
    /// <summary>
    /// 路面状况
    /// </summary>
    int SurfaceCondition = 0x1,

    /// <summary>
    /// 能见度
    /// </summary>
    Visibility = 0x2,

    /// <summary>
    /// 气温
    /// </summary>
    Temperature = 0x4,

    /// <summary>
    /// 湿度
    /// </summary>
    Humidity = 0x8,

    /// <summary>
    /// 风速
    /// </summary>
    WindVelocity = 0x10,

    /// <summary>
    /// 风向
    /// </summary>
    WindDirection = 0x20,

    /// <summary>
    /// 雨量
    /// </summary>
    Rainfall = 0x40,

    /// <summary>
    /// 路温
    /// </summary>
    RoadTemperature = 0x80,

    /// <summary>
    /// 气压
    /// </summary>
    AtmosphericPressure = 0x100;
}
