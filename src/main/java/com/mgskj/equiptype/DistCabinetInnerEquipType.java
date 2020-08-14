package com.mgskj.equiptype;

public interface DistCabinetInnerEquipType {
    int LightContactor = 1,//灯接触器
            FanContactor = 2,//风机接触器
            AutoSwitcher = 3,//手自动开关
            MainPowerBreaker = 4,//总断路器
            MainPowerSupply = 5,//主电供电
            StandbyPowerSupply = 6,//备电供电
            SurgeProtection = 7,//浪涌保护
            FanSoftStarter = 8,//风机软启动器
            FanBypass = 9,//风机旁路运行
            FanMotorCapacitor = 10,//风机电容投入
            Label = 11;//文字标签
}
