package com.mgskj.service;

import java.util.List;
import java.util.Map;

import com.mgskj.model.HTOrganizationInfo;
import com.mgskj.model.TRegionInfo;

/**
 * 机维站
 *
 * @author shenchanghui
 */
public interface IRegionService {
    List<TRegionInfo> selectMachineStation(String regionId);

    List<TRegionInfo> selectPublicRegion(String regionId);

    TRegionInfo selectRegionInfoById(String regionId);

    // 通过线号查找区域
    List<TRegionInfo> selectRegionByRouteCode(Map<String, Object> map);

    /**
     * 根据id获取机维站列表
     */
    List<HTOrganizationInfo> getStationListById(String orgid);

    /**
     * 根据id获取机维站详情
     */
    HTOrganizationInfo getStationById(String orgid);
}
