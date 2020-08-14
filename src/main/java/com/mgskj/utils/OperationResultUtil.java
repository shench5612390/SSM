package com.mgskj.utils;

import com.mgskj.entity.OperationResult;

public class OperationResultUtil {
    public static String result2String(int result) {
        switch (result) {
            case OperationResult.Unknow:
                return "未知结果";
            case OperationResult.Failure:
                return "失败";
            case OperationResult.Success:
                return "成功";
            case OperationResult.PartialSuccess:
                return "部分成功";
            case OperationResult.Busy:
                return "预案使用，其他用户正在执行";
            case OperationResult.Abort:
                return "预案被终止";
            default:
                return null;
        }
    }
}
