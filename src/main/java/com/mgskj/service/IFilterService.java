package com.mgskj.service;

import java.util.List;
import java.util.Map;

import com.mgskj.bean.ETEquipResult;
import com.mgskj.bean.UserName;
import com.mgskj.model.TCMSEquip;
import com.mgskj.model.TETEquip;
import com.mgskj.model.TEVDEquip;
import com.mgskj.model.TFAEquip;
import com.mgskj.model.TRegionInfo;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
public interface IFilterService {
    // 情报板线号
    List<TCMSEquip> selectBoardEquip(Map<String,Object> map);


    // 情报板设备名称
    List<TCMSEquip> selectBoardEquipNameList(String routeCode, String boardType);

    // 情报板用户名称
    List<UserName> selectBoardUserNameList(Map<String, Object> map);

    // 紧急电话操作 线号
    List<ETEquipResult> selectETEquip(Map<String, Object> map);

    // 紧急电话操作 区域
    List<TRegionInfo> selectETRegion(String routeCode);

    // 紧急电话操作 设备名称
    List<TETEquip> selectETEquipName(String routeCode, String regionId);

    // 避险车道报警处理日志报表线号
    List<ETEquipResult> selectEVDEquip(Map<String, Object> map);

    // 避险车道报警处理日志报表 区域
    List<TRegionInfo> selectEVDRegion();

    // 避险车道报警处理日志报表 区域
    List<TEVDEquip> selectEVDEquipName(String routeCode, String regionId);

    // 火灾报警处理日志报表 设备
    List<ETEquipResult> selectFAEquip(Map<String, Object> map);

    // 火灾报警处理日志报表 区域
    List<TRegionInfo> selectFARegion();

    // 火灾报警处理日志报表 设备名称
    List<TFAEquip> selectFAEquipName(String routeCode, String regionId);

    // 根据id获取用户信息
    com.mgskj.model.UserName selectUserNameById(String id);
}
