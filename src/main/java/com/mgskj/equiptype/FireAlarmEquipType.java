package com.mgskj.equiptype;

public interface FireAlarmEquipType {
	int /// <summary>
	/// 网络接连
	/// </summary>
	FireAlarmConnection = -1,
			/// <summary>
			/// 火灾报警主机
			/// </summary>
			FireAlarmStation = 1, // 在振东广电的设备中，约定ProducerCode1为光纤主机，2为手动报警主机
			/// <summary>
			/// 火灾报警探测器
			/// </summary>
			FireAlarmDetector = 2,
			/// <summary>
			/// 手动报警按钮
			/// </summary>
			FireAlarmButton = 3,
			/// <summary>
			/// 其它
			/// </summary>
			Other = 4;// include EGA communicator
}
