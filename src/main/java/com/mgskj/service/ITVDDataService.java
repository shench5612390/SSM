package com.mgskj.service;

import com.mgskj.bean.TVDDataStationHourResult;
import com.mgskj.model.TVDDataDayResult;
import com.mgskj.model.TVDDataHourResult;

import java.util.List;
import java.util.Map;

/**
 * 车检器
 *
 * @author shenchanghui
 */
public interface ITVDDataService {
    // 获取日报表数据
    List<TVDDataStationHourResult> selectHourList(String regionCode, String date, String prefixLength);

    // 获取月报表数据
    List<TVDDataDayResult> selectDayList(String regionCode, String date, String prefixLength);

    // 获取年报表数据
    List<TVDDataDayResult> selectMonthList(String regionCode, String date, String prefixLength);

    // 获取信息中心报表数据
    List<TVDDataHourResult> selectCenterList(Map<String, Object> map);

}
