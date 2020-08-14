package com.mgskj.entity;

public interface ModuleDefine {
	/// <summary>
	/// 无
	/// </summary>
	int None = 0,

			// 实际设备相关模块 1000~49000
			/// <summary>
			/// 火灾报警
			/// FA
			/// </summary>
			FireAlarmSystem = 100000,

			/// <summary>
			/// 入侵检测
			/// IvDt
			/// </summary>
			InvasionDetectionSystem = 200000,

			/// <summary>
			/// 紧急电话
			/// ET
			/// </summary>
			EmergencyTelephoneSystem = 300000,

			/// <summary>
			/// 避险车道
			/// EVD
			/// </summary>
			EmergencyVDSystem = 400000,

			/// <summary>
			/// 情报板系统
			/// CMS
			/// </summary>
			CMSSystem = 500000,

			/// <summary>
			/// 隧道电力控制系统
			/// </summary>
			TunnelPowerControlSystem = 600000, // TODO 讨论是否需要把隧道控制细分为多个模块

			/// <summary>
			/// 灯控制系统
			/// Light
			/// </summary>
			LightControlSystem = 601000,

			/// <summary>
			/// 风机控制系统
			/// Fan
			/// </summary>
			FanControlSystem = 602000,

			/// <summary>
			/// 电表
			/// Amt
			/// </summary>
			AmmeterControlSystem = 603000,

			/// <summary>
			/// UPS
			/// </summary>
			UPSSystem = 604000,

			/// <summary>
			/// PLC
			/// </summary>
			PLCControlSystem = 605000,

			/// <summary>
			/// 柜内设备
			/// </summary>
			DistCabinetInnerEquipControlSystem = 607000,

			/// <summary>
			/// 温控仪
			/// TempC
			/// </summary>
			TemperatureControllerSystem = 608000,

			/// <summary>
			/// 柴发
			/// </summary>
			GeneratorControlSystem = 609000,

			/// <summary>
			/// 隧道交通监控系统
			/// </summary>
			TunnelTrafficControlSystem = 700000,

			/// <summary>
			/// 交通信号标志
			/// </summary>
			SignalsControlSystem = 701000, LSControlSystem = 701100, TSControlSystem = 701200,

			/// <summary>
			/// COVI检测系统
			/// </summary>
			COVIControlSystem = 702000,

			/// <summary>
			/// 卷帘门
			/// Shutter
			/// </summary>
			ShutterControlSystem = 703000,

			/// <summary>
			/// 限速标志系统
			/// </summary>
			SpeedLimitSignSystem = 704000,

			/// <summary>
			/// 车检控制系统
			/// VD
			/// </summary>
			VDControlSystem = 800000,

			/// <summary>
			/// 视频管理系统
			/// Video
			/// </summary>
			VideoControlSystem = 900000,

			/// <summary>
			/// 高压控制系统
			/// HV
			/// </summary>
			HighVoltageControlSystem = 1000000,

			/// <summary>
			/// 消防水池
			/// FC
			/// </summary>
			FireCisternControlSystem = 1100000,

			/// <summary>
			/// 视频事件检测
			/// VED
			/// </summary>
			VideoEventDetectorSystem = 1200000,

			/// <summary>
			/// 光强设备
			/// </summary>
			BrightnessSystem = 1300000,

			/// <summary>
			/// 气象站设备
			/// </summary>
			WeatherStationSystem = 1400000,

			/// <summary>
			/// 风速风向
			/// </summary>
			WindVelocitySystem = 1500000,

			// region 电力监控

			/// <summary>
			/// 中压柜(断路器、负荷开关柜)
			/// </summary>
			DistributionCabinetMediumVoltageSystem = 1300000,

			/// <summary>
			/// 低压柜
			/// </summary>
			DistributionCabinetLowVoltageSystem = 1400000,

			/// <summary>
			/// 环境温湿度传感器
			/// </summary>
			ThermoHygroMeterSystem = 1500000,

			// endregion 电力监控

			/// <summary>
			/// 用户安全服务系统
			/// Sec
			/// </summary>
			SecurityServiceSystem = 5000000,

			/// <summary>
			/// 联动预案服务
			/// Scm
			/// </summary>
			SchemedControlSystem = 5100000,

			/// <summary>
			/// 报表服务
			/// </summary>
			ReportingService = 5200000,

			/// <summary>
			/// 照明时序系统
			/// </summary>
			LightScheduleSystem = 5300000,

			/// <summary>
			/// LED控制系统
			/// </summary>
			LEDControlSystem = 5400000,

			/// <summary>
			/// 客户端界面显示模块
			/// </summary>
			ClientDisplaySystem = 5500000,
			/// <summary>
			/// 数据提供系统
			/// </summary>
			DataProviderSystem = 5600000;
}
