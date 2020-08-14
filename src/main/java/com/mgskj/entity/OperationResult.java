package com.mgskj.entity;

public interface OperationResult {
	int /// <summary>
	/// 未知结果
	/// </summary>
	Unknow = -1,

			/// <summary>
			/// 失败
			/// </summary>
			Failure = 0,

			/// <summary>
			/// 成功
			/// </summary>
			Success = 1,

			/// <summary>
			/// 部分成功，用于批量操作等
			/// </summary>
			PartialSuccess = 2,

			/// <summary>
			/// 预案使用，其他用户正在执行
			/// </summary>
			Busy = 3,

			/// <summary>
			/// 预案被终止
			/// </summary>
			Abort = 4;
}
