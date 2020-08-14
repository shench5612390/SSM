package com.mgskj.service.impl;

import com.mgskj.bean.TVDDataStationHourResult;
import com.mgskj.dao.TVDDataDayMapper;
import com.mgskj.dao.TVDDataHourMapper;
import com.mgskj.model.TVDDataDayResult;
import com.mgskj.model.TVDDataHourResult;
import com.mgskj.service.ITVDDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 车检器
 *
 * @author shenchanghui
 */
@Service("tvdDataService")
public class TVDDataServiceImpl implements ITVDDataService {
    @Resource
    private TVDDataHourMapper tVDDataHourMapper;
    @Resource
    private TVDDataDayMapper tVDDataDayMapper;

    @Override
    public List<TVDDataStationHourResult> selectHourList(String regionCode, String date, String prefixLength) {
        // TODO Auto-generated method stub
        return tVDDataHourMapper.selectHourList(regionCode, date, prefixLength);
    }

    @Override
    public List<TVDDataDayResult> selectDayList(String regionCode, String date, String prefixLength) {
        // TODO Auto-generated method stub
        return tVDDataDayMapper.selectDayList(regionCode, date, prefixLength);
    }

    @Override
    public List<TVDDataDayResult> selectMonthList(String regionCode, String date, String prefixLength) {
        // TODO Auto-generated method stub
        return tVDDataDayMapper.selectMonthList(regionCode, date, prefixLength);
    }

    @Override
    public List<TVDDataHourResult> selectCenterList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return tVDDataHourMapper.selectCenterList(map);
    }

}
