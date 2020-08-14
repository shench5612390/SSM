package com.mgskj.status;

public interface EmergencyVDStatus {
    int Normal = 1,//正常
            VehicleExist = 2,//车辆存在
            Fault = 4,//故障
            Disconnect = 8,//通讯中断
            LightOn = 16,//路灯打开
            DoorOpened = 32,//箱门打开
            Unknown = 64,

    /// <summary>
    /// 前线圈故障
    /// </summary>
    FrontVDCoilFault = 128,

    /// <summary>
    /// 后线圈故障
    /// </summary>
    BehindVDCoilFault = 256,

    /// <summary>
    /// 全部线圈故障
    /// </summary>
    AllVDCoilFault = 512,

    /// <summary>
    /// 车道指示灯正行
    /// </summary>
    LSForward = 1024,

    /// <summary>
    /// 车道指示灯逆行
    /// </summary>
    LSBackward = 2048,

    /// <summary>
    /// 车道指示灯禁行
    /// </summary>
    LSStop = 4096,

    /// <summary>
    /// 车道指示灯转向
    /// </summary>
    LSTurn = 8192,

    /// <summary>
    /// 车道指示灯关闭
    /// </summary>
    LSOff = 16384,

    /// <summary>
    /// 交通指示灯红灯
    /// </summary>
    TSRed = 32768,

    /// <summary>
    /// 交通指示灯绿灯
    /// </summary>
    TSGreen = 65536,

    /// <summary>
    /// 交通指示灯黄灯
    /// </summary>
    TSYellow = 131072,

    /// <summary>
    /// 交通指示灯转向
    /// </summary>
    TSTurn = 262144,

    /// <summary>
    /// 交通指示灯关闭
    /// </summary>
    TSOff = 524288,

    /// <summary>
    /// 数据不在规定范围内
    /// </summary>
    OutOfRange = 0x20000000,

    /// <summary>
    /// 服务通讯中断
    /// </summary>
    ServiceDisconnected = 0x40000000;
}
