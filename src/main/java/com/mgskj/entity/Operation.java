package com.mgskj.entity;

public interface Operation {
	int None = 0,

			/// <summary>
			/// 确认
			/// </summary>
			FireAlarmConfirm = ModuleDefine.FireAlarmSystem + 1,

			/// <summary>
			/// 复位
			/// </summary>
			FireAlarmReset = ModuleDefine.FireAlarmSystem + 2,

			/// <summary>
			/// 处理完毕
			/// </summary>
			FireAlarmFinishDealing = ModuleDefine.FireAlarmSystem + 3,

			/// <summary>
			/// 消警
			/// </summary>
			FireAlarmEliminate = ModuleDefine.FireAlarmSystem + 4,

			/// <summary>
			/// 紧急电话确认报警
			/// </summary>
			EmergencyTelephoneConfirm = ModuleDefine.EmergencyTelephoneSystem + 1,
			/// <summary>
			/// 紧急电话复位
			/// </summary>
			EmergencyTelephoneReset = ModuleDefine.EmergencyTelephoneSystem + 2,
			/// <summary>
			/// 停止所有广播
			/// </summary>
			EmergencyTelephoneStopAllBroadcast = ModuleDefine.EmergencyTelephoneSystem + 3,
			/// <summary>
			/// 紧急电话处理完毕
			/// </summary>
			EmergencyTelephoneFinishDealing = ModuleDefine.EmergencyTelephoneSystem + 4,
			/// <summary>
			/// 紧急电话消警
			/// </summary>
			EmergencyTelephoneEliminate = ModuleDefine.EmergencyTelephoneSystem + 5,
			/// <summary>
			/// 开始广播
			/// </summary>
			EmergencyTelephoneStartBroadcast = ModuleDefine.EmergencyTelephoneSystem + 6,
			/// <summary>
			/// 停止广播
			/// </summary>
			EmergencyTelephoneStopBroadcast = ModuleDefine.EmergencyTelephoneSystem + 7,

			/// <summary>
			/// 避险车道确认报警
			/// </summary>
			EmergencyVDConfirm = ModuleDefine.EmergencyVDSystem + 1,
			/// <summary>
			/// 避险车道复位
			/// </summary>
			EmergencyVDReset = ModuleDefine.EmergencyVDSystem + 2,
			/// <summary>
			/// 避险车道处理完成
			/// </summary>
			EmergencyVDFinishDealing = ModuleDefine.EmergencyVDSystem + 3,
			/// <summary>
			/// 避险车道消警
			/// </summary>
			EmergencyVDEliminate = ModuleDefine.EmergencyVDSystem + 4,
			/// <summary>
			/// 避险车道开灯
			/// </summary>
			EmergencyVDLightOn = ModuleDefine.EmergencyVDSystem + 5,
			/// <summary>
			/// 避险车道关灯
			/// </summary>
			EmergencyVDLightOff = ModuleDefine.EmergencyVDSystem + 6,
			/// <summary>
			/// 避险车道设置时序
			/// </summary>
			EmergencyVDSetLightSchedule = ModuleDefine.EmergencyVDSystem + 7,
			/// <summary>
			/// 避险车道LS正行
			/// </summary>
			EmergencyVDLSForward = ModuleDefine.EmergencyVDSystem + 8,
			/// <summary>
			/// 避险车道LS逆行
			/// </summary>
			EmergencyVDLSBackward = ModuleDefine.EmergencyVDSystem + 9,
			/// <summary>
			/// 避险车道LS禁行
			/// </summary>
			EmergencyVDLSStop = ModuleDefine.EmergencyVDSystem + 10,
			/// <summary>
			/// 避险车道LS转向
			/// </summary>
			EmergencyVDLSTurn = ModuleDefine.EmergencyVDSystem + 11,
			/// <summary>
			/// 避险车道LS关闭
			/// </summary>
			EmergencyVDLSOff = ModuleDefine.EmergencyVDSystem + 12,
			/// <summary>
			/// 避险车道LS撤离
			/// </summary>
			EmergencyVDLSEvacuate = ModuleDefine.EmergencyVDSystem + 13,
			/// <summary>
			/// 避险车道TS红灯
			/// </summary>
			EmergencyVDTSRed = ModuleDefine.EmergencyVDSystem + 14,
			/// <summary>
			/// 避险车道TS黄灯
			/// </summary>
			EmergencyVDTSYellow = ModuleDefine.EmergencyVDSystem + 15,
			/// <summary>
			/// 避险车道TS绿灯
			/// </summary>
			EmergencyVDTSGreen = ModuleDefine.EmergencyVDSystem + 16,
			/// <summary>
			/// 避险车道TS转向
			/// </summary>
			EmergencyVDTSTurn = ModuleDefine.EmergencyVDSystem + 17,
			/// <summary>
			/// 避险车道TS关闭
			/// </summary>
			EmergencyVDTSOff = ModuleDefine.EmergencyVDSystem + 18,

			// InvasionDetectionConfirm = ModuleDefine.InvasionDetectionSystem +
			// 1,
			// InvasionDetectionReset = ModuleDefine.InvasionDetectionSystem +
			// 2,

			/// <summary>
			/// //查询故障
			/// </summary>
			BoardQueryFailure = ModuleDefine.CMSSystem + 1,
			/// <summary>
			/// 上载火灾联动
			/// </summary>
			BoardUploadFile = ModuleDefine.CMSSystem + 2,
			/// <summary>
			/// 下载火灾联动
			/// </summary>
			BoardDownloadFile = ModuleDefine.CMSSystem + 3,
			/// <summary>
			/// 显示文件
			/// </summary>
			BoardDisplayFile = ModuleDefine.CMSSystem + 4,
			/// <summary>
			/// 显示内容
			/// </summary>
			BoardDisplayContent = ModuleDefine.CMSSystem + 5,
			/// <summary>
			/// 设置亮度调节方式及亮度值
			/// </summary>
			BoardSetModAndVal = ModuleDefine.CMSSystem + 6,
			/// <summary>
			/// 获取亮度调节方式及亮度值
			/// </summary>
			BoardQueModAndVal = ModuleDefine.CMSSystem + 7,
			/// <summary>
			/// 设置超速联动开关
			/// </summary>
			BoardSetSwitch = ModuleDefine.CMSSystem + 8,
			/// <summary>
			/// 开灯
			/// </summary>
			TunnelLightOn = ModuleDefine.LightControlSystem + 1,

			/// <summary>
			/// 关灯
			/// </summary>
			TunnelLightOff = ModuleDefine.LightControlSystem + 2,

			/// <summary>
			/// 灯时序复位
			/// </summary>
			TunnelRestoreTimeControl = ModuleDefine.LightControlSystem + 3,

			/// <summary>
			/// 获取LED调光灯亮度
			/// </summary>
			TunnelLightGetBrightness = ModuleDefine.LightControlSystem + 4,

			/// <summary>
			/// 设置LED调光灯亮度
			/// </summary>
			TunnelLightSetBrightness = ModuleDefine.LightControlSystem + 5,

			/// <summary>
			/// 隧道设置时序控制
			/// </summary>
			TunnelSetLightScheduleAuto = ModuleDefine.LightControlSystem + 6,

			/// <summary>
			/// 隧道设置光强自动控制
			/// </summary>
			TunnelSetLightOpticalIntensityAuto = ModuleDefine.LightControlSystem + 7,

			/// <summary>
			/// 风机正转
			/// </summary>
			TunnelFanForward = ModuleDefine.FanControlSystem + 1,

			/// <summary>
			/// 风机反转
			/// </summary>
			TunnelFanReverse = ModuleDefine.FanControlSystem + 2,

			/// <summary>
			/// 风机关机
			/// </summary>
			TunnelFanOff = ModuleDefine.FanControlSystem + 3,

			/// <summary>
			/// 轴流风机控制停止
			/// </summary>
			TunnelAxisFanStop = ModuleDefine.FanControlSystem + 4,

			/// <summary>
			/// 设置频率
			/// </summary>
			TunnelAxisFanSetVFDFrequency = ModuleDefine.FanControlSystem + 5,
			/// <summary>
			/// 设置转速百分比
			/// </summary>
			TunnelAxisFanSetRotationSpeedPercent = ModuleDefine.FanControlSystem + 6,
			/// <summary>
			/// 设置转速
			/// </summary>
			TunnelAxisFanSetRotationSpeed = ModuleDefine.FanControlSystem + 7,
			/// <summary>
			/// 设置风速
			/// </summary>
			TunnelAxisFanSetWindVelocity = ModuleDefine.FanControlSystem + 8,
			/// <summary>
			/// 设置风量
			/// </summary>
			TunnelAxisFanSetAirQuantity = ModuleDefine.FanControlSystem + 9,
			/// <summary>
			/// 设置风压
			/// </summary>
			TunnelAxisFanSetWindPressure = ModuleDefine.FanControlSystem + 10,
			/// <summary>
			/// 重启变频器
			/// </summary>
			TunnelAxisFanResetVFD = ModuleDefine.FanControlSystem + 11,
			/// <summary>
			/// 打开风机风阀
			/// </summary>
			TunnelAxisFanOpenFanValve = ModuleDefine.FanControlSystem + 12,
			/// <summary>
			/// 关闭风机风阀
			/// </summary>
			TunnelAxisFanCloseFanValve = ModuleDefine.FanControlSystem + 13,
			/// <summary>
			/// 停止风机风阀
			/// </summary>
			TunnelAxisFanStopFanValve = ModuleDefine.FanControlSystem + 14,
			/// <summary>
			/// 打开风道风阀
			/// </summary>
			TunnelAxisFanOpenDuctValve = ModuleDefine.FanControlSystem + 15,
			/// <summary>
			/// 关闭风道风阀
			/// </summary>
			TunnelAxisFanCloseDuctValve = ModuleDefine.FanControlSystem + 16,
			/// <summary>
			/// 停止风道风阀
			/// </summary>
			TunnelAxisFanStopDuctValve = ModuleDefine.FanControlSystem + 17,
			/// <summary>
			/// 手工确认风阀状态
			/// </summary>
			TunnelAxisFanManualCheckAirValve = ModuleDefine.FanControlSystem + 18,
			/// <summary>
			/// 设置风阀开启时间
			/// </summary>
			TunnelAxisFanSetAirValveOpenTime = ModuleDefine.FanControlSystem + 19,
			/// <summary>
			/// 启动自动保护
			/// </summary>
			TunnelAxisFanEnableAutoProtection = ModuleDefine.FanControlSystem + 20,
			/// <summary>
			/// 停止自动保护
			/// </summary>
			TunnelAxisFanDisableAutoProtection = ModuleDefine.FanControlSystem + 21,
			/// <summary>
			/// 打开卷帘门
			/// </summary>
			TunnelAxisFanOpenShutter = ModuleDefine.FanControlSystem + 22,
			/// <summary>
			/// 关闭卷帘门
			/// </summary>
			TunnelAxisFanCloseShutter = ModuleDefine.FanControlSystem + 23,
			/// <summary>
			/// 打开风机
			/// </summary>
			TunnelAxisFanSimpleOn = ModuleDefine.FanControlSystem + 24,
			/// <summary>
			/// 关闭风机
			/// </summary>
			TunnelAxisFanSimpleOff = ModuleDefine.FanControlSystem + 25,

			/// <summary>
			/// 获取轴流风机设置
			/// </summary>
			TunnelAxisFanSelectSetting = ModuleDefine.FanControlSystem + 26,

			/// <summary>
			/// 更新轴流风机设置
			/// </summary>
			TunnelAxisFanUpdateSetting = ModuleDefine.FanControlSystem + 27,

			/// <summary>
			/// 风机房控制
			/// </summary>
			AxisFanHouseControl = ModuleDefine.FanControlSystem + 28,

			/// <summary>
			/// TS红灯
			/// </summary>
			TunnelTSRed = ModuleDefine.SignalsControlSystem + 1,

			/// <summary>
			/// TS黄灯
			/// </summary>
			TunnelTSYellow = ModuleDefine.SignalsControlSystem + 2,

			/// <summary>
			/// TS绿灯
			/// </summary>
			TunnelTSGreen = ModuleDefine.SignalsControlSystem + 3,

			/// <summary>
			/// TS转向
			/// </summary>
			TunnelTSTurn = ModuleDefine.SignalsControlSystem + 4,

			/// <summary>
			/// TS关闭
			/// </summary>
			TunnelTSOff = ModuleDefine.SignalsControlSystem + 5,

			/// <summary>
			/// TS开启
			/// </summary>
			TunnelTSOn = ModuleDefine.SignalsControlSystem + 6,

			/// <summary>
			/// LS正行
			/// </summary>
			TunnelLSForward = ModuleDefine.SignalsControlSystem + 11,

			/// <summary>
			/// LS禁行
			/// </summary>
			TunnelLSStop = ModuleDefine.SignalsControlSystem + 12,

			/// <summary>
			/// LS转向
			/// </summary>
			TunnelLSTurn = ModuleDefine.SignalsControlSystem + 13,

			/// <summary>
			/// LS逆行
			/// </summary>
			TunnelLSReverse = ModuleDefine.SignalsControlSystem + 14,

			/// <summary>
			/// LS关闭
			/// </summary>
			TunnelLSOff = ModuleDefine.SignalsControlSystem + 15,

			/// <summary>
			/// 开启柴发
			/// </summary>
			TunnelGeneratorStart = ModuleDefine.GeneratorControlSystem + 1,

			/// <summary>
			/// 关闭柴发
			/// </summary>
			TunnelGeneratorStop = ModuleDefine.GeneratorControlSystem + 2,

			/// <summary>
			/// 柴发自动控制
			/// </summary>
			TunnelGeneratorAutoControl = ModuleDefine.GeneratorControlSystem + 3,

			/// <summary>
			/// 柴发手动控制
			/// </summary>
			TunnelGeneratorManualControl = ModuleDefine.GeneratorControlSystem + 4,

			/// <summary>
			/// 打开卷帘门
			/// </summary>
			TunnelShutterOpen = ModuleDefine.ShutterControlSystem + 1,

			/// <summary>
			/// 关闭卷帘门
			/// </summary>
			TunnelShutterClose = ModuleDefine.ShutterControlSystem + 2,

			// TunnelShutterHalf = ModuleDefine.ShutterControlSystem + 3,
			/// <summary>
			/// 停止卷帘门
			/// </summary>
			TunnelShutterStop = ModuleDefine.ShutterControlSystem + 4,

			// TunnelTransverseGallerySignOn = ModuleDefine.SignalsControlSystem
			// + 51,
			// TunnelTransverseGallerySignOff =
			// ModuleDefine.SignalsControlSystem + 52,

			/// <summary>
			/// 隧道批控
			/// </summary>
			TunnelBatchControl = ModuleDefine.TunnelPowerControlSystem + 1,

			/// <summary>
			/// PLC设备校时
			/// </summary>
			TunnelPLCTimeSync = ModuleDefine.PLCControlSystem + 1,

			/// <summary>
			/// PLC时序自动复位设置
			/// </summary>
			TunnelPLCSetAutoClear = ModuleDefine.PLCControlSystem + 2,

			/// <summary>
			/// PLC设置应急事故处理模式
			/// </summary>
			TunnelPLCSetEmergencyMode = ModuleDefine.PLCControlSystem + 3,

			/// <summary>
			/// PLC取消事故处理模式
			/// </summary>
			TunnelPLCClearEmergencyMode = ModuleDefine.PLCControlSystem + 4,

			/// <summary>
			/// PLC光强LED设置
			/// </summary>
			TunnelPLCBrightnessSetting = ModuleDefine.PLCControlSystem + 5,

			/// <summary>
			/// 风机时序下发
			/// </summary>
			TunnelFanScheduleSend = ModuleDefine.FanControlSystem + 120,

			// 限速标志系列，暂未启用
			// SpeedLimitSignOn = ModuleDefine.SpeedLimitSignSystem + 1,
			// SpeedLimitSignOff = ModuleDefine.SpeedLimitSignSystem + 2,
			// SpeedLimitSignLightAuto = ModuleDefine.SpeedLimitSignSystem + 3,
			// SpeedLimitSignLightManual = ModuleDefine.SpeedLimitSignSystem +
			// 4,
			// SpeedLimitSignSpeedUpLoad = ModuleDefine.SpeedLimitSignSystem +
			// 5,
			// SpeedLimitSignLightUpLoad = ModuleDefine.SpeedLimitSignSystem +
			// 6,
			// SpeedLimitSignBatchControl = ModuleDefine.SpeedLimitSignSystem +
			// 7,

			/// <summary>
			/// 打开水泵
			/// </summary>
			FireCisternPumpOn = ModuleDefine.FireCisternControlSystem + 1,

			/// <summary>
			/// 关闭水泵
			/// </summary>
			FireCisternPumpOff = ModuleDefine.FireCisternControlSystem + 2,

			/// <summary>
			/// 打开高压
			/// </summary>
			HighVoltageOn = ModuleDefine.HighVoltageControlSystem + 1,

			/// <summary>
			/// 关闭高压
			/// </summary>
			HighVoltageOff = ModuleDefine.HighVoltageControlSystem + 2,

			/// <summary>
			/// 预案下发
			/// </summary>
			ExecScheme = ModuleDefine.SchemedControlSystem + 1,

			/// <summary>
			/// 添加预案
			/// </summary>
			AddScheme = ModuleDefine.SchemedControlSystem + 2,

			/// <summary>
			/// 删除预案
			/// </summary>
			RemoveScheme = ModuleDefine.SchemedControlSystem + 3,

			/// <summary>
			/// 更新预案
			/// </summary>
			UpdateScheme = ModuleDefine.SchemedControlSystem + 4,

			/// <summary>
			/// 撤销预案
			/// </summary>
			AbortScheme = ModuleDefine.SchemedControlSystem + 5,

			/// <summary>
			/// 设置车检器联动参数
			/// </summary>
			VDSetSpeedSend = ModuleDefine.VDControlSystem + 1,

			/// <summary>
			/// 设置车检器联动门限
			/// </summary>
			VDSetSpeedThresholds = ModuleDefine.VDControlSystem + 2,

			/// <summary>
			/// UPS报警确认
			/// </summary>
			UPSConfirm = ModuleDefine.UPSSystem + 1,

			/// <summary>
			/// UPS报警处理完毕
			/// </summary>
			UPSFinishDealing = ModuleDefine.UPSSystem + 3,

			/// <summary>
			/// UPS报警消警
			/// </summary>
			UPSEliminate = ModuleDefine.UPSSystem + 4,

			/// <summary>
			/// UPS预警参数设置
			/// </summary>
			UPSAlarmParameterSet = ModuleDefine.UPSSystem + 10,

			/// <summary>
			/// 报表导出
			/// </summary>
			ReportExport = ModuleDefine.ReportingService + 1,

			/// <summary>
			/// 报表打印
			/// </summary>
			ReportPrint = ModuleDefine.ReportingService + 2,

			/// <summary>
			/// 时序添加
			/// </summary>
			LightScheduleAdd = ModuleDefine.LightScheduleSystem + 1,

			/// <summary>
			/// 时序修改
			/// </summary>
			LightScheduleModify = ModuleDefine.LightScheduleSystem + 2,

			/// <summary>
			/// 时序删除
			/// </summary>
			LightScheduleDelete = ModuleDefine.LightScheduleSystem + 3,

			/// <summary>
			/// 时序发送
			/// </summary>
			LightScheduleSend = ModuleDefine.LightScheduleSystem + 4,

			/// <summary>
			/// 切换视频
			/// </summary>
			SwitchVideo = ModuleDefine.VideoControlSystem + 1,

			/// <summary>
			/// 视频事件确认
			/// </summary>
			VideoEventConfirm = ModuleDefine.VideoEventDetectorSystem + 1,

			/// <summary>
			/// 视频事件复位
			/// </summary>
			VideoEventReset = ModuleDefine.VideoEventDetectorSystem + 2,

			/// <summary>
			/// 视频事件处理完毕
			/// </summary>
			VideoEventFinishDealing = ModuleDefine.VideoEventDetectorSystem + 3,

			/// <summary>
			/// 视频事件消警
			/// </summary>
			VideoEventEliminate = ModuleDefine.VideoEventDetectorSystem + 4,

			// #region LED相关

			/// <summary>
			/// 添加LED屏幕
			/// </summary>
			AddLEDScreen = ModuleDefine.LEDControlSystem + 1,

			/// <summary>
			/// 移除LED屏幕
			/// </summary>
			RemoveLEDScreen = ModuleDefine.LEDControlSystem + 2,

			/// <summary>
			/// 添加屏幕页面
			/// </summary>
			AddScreenPage = ModuleDefine.LEDControlSystem + 3,

			/// <summary>
			/// 移除屏幕页面
			/// </summary>
			RemoveScreenPage = ModuleDefine.LEDControlSystem + 4,

			/// <summary>
			/// 添加页面Gadget
			/// </summary>
			AddPageGadget = ModuleDefine.LEDControlSystem + 5,

			/// <summary>
			/// 移除页面Gadget
			/// </summary>
			RemovePageGadget = ModuleDefine.LEDControlSystem + 6,

			/// <summary>
			/// 发送至物理LED屏幕显示
			/// </summary>
			SendToLEDScreen = ModuleDefine.LEDControlSystem + 7,

			/// <summary>
			/// 更新LED屏幕参数
			/// </summary>
			UpdateLEDScreenParam = ModuleDefine.LEDControlSystem + 8,

			/// <summary>
			/// 更新LED页面Gadget参数
			/// </summary>
			UpdatePageGadgetParam = ModuleDefine.LEDControlSystem + 9,

			// #endregion LED相关

			// #region 电力监控相关操作

			/// <summary>
			/// 中压柜(断路器、负荷开关柜)打开
			/// </summary>
			DistributionCabinetMediumVoltageOn = ModuleDefine.DistributionCabinetMediumVoltageSystem + 1,

			/// <summary>
			/// 中压柜(断路器、负荷开关柜)关闭
			/// </summary>
			DistributionCabinetMediumVoltageOff = ModuleDefine.DistributionCabinetMediumVoltageSystem + 2,

			/// <summary>
			/// 低压柜打开
			/// </summary>
			DistributionCabinetLowVoltageSystemOn = ModuleDefine.DistributionCabinetLowVoltageSystem + 1,

			/// <summary>
			/// 低压柜关闭
			/// </summary>
			DistributionCabinetLowVoltageSystemOff = ModuleDefine.DistributionCabinetLowVoltageSystem + 2,

			// #endregion 电力监控相关操作

			// #region 客户端相关操作

			DelayAlarmHintAtClient = ModuleDefine.ClientDisplaySystem + 1,

			// #endregion 客户端相关操作

			/// <summary>
			/// 用户登录
			/// </summary>
			UserLogOn = ModuleDefine.SecurityServiceSystem + 1,

			/// <summary>
			/// 用户登出
			/// </summary>
			UserLogOff = ModuleDefine.SecurityServiceSystem + 2,

			/// <summary>
			/// 修改用户报警设置
			/// </summary>
			UpdateUserAlarmSetting = ModuleDefine.DataProviderSystem + 1,
			/// <summary>
			/// 修改区域报警设置
			/// </summary>
			UpdateRegionAlarmSetting = ModuleDefine.DataProviderSystem + 2;
}
