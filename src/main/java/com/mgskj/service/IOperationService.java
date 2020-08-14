package com.mgskj.service;

import java.util.List;
import java.util.Map;

import com.mgskj.bean.*;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
public interface IOperationService {
    // 情报板操作日志
    List<BoardOperationResult> getBoardOperationList(Map<String, Object> map);

    // 紧急电话报警处理日志报表
    List<ETOperationResult> getETOperationList(Map<String, Object> map);

    // 避险车道报警处理日志报表
    List<EVDOperationResult> getEVDOperationList(Map<String, Object> map);

    // 火灾报警处理日志报表
    List<FAOperationResult> getFAOperationList(Map<String, Object> map);

    // 登录信息数据报表
    List<TOperationLogWResult> getLoginOperationList(Map<String, Object> map);

    // 隧道控制操作日志报表
    List<TOperationLogWResult> getTunnelOperationList(Map<String, Object> map);

    // 报警联动设置操作报表
    List<TOperationLogWResult> getAlarmLinkOperationList(Map<String, Object> map);
}
