package com.mgskj.status;

public interface CMSStstus {
    int Normal = 0,//正常
            DisConnect = 1,//通讯中断
            EquipFault = 2,//设备故障
            ServiceDisConnect = -1, //服务通信中断
            Unspecified = 3;//数据不在规定范围内

}
