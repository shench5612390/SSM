package com.mgskj.service.impl;

import com.mgskj.dao.HTOrganizationInfoMapper;
import com.mgskj.dao.TRegionInfoMapper;
import com.mgskj.model.HTOrganizationInfo;
import com.mgskj.model.TRegionInfo;
import com.mgskj.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 机维站
 *
 * @author shenchanghui
 */
@Service("tRegionService")
public class TRegionServiceImpl implements IRegionService {
    @Resource
    private TRegionInfoMapper tRegionInfoMapper;

    @Autowired
    private HTOrganizationInfoMapper htOrganizationInfoMapper;

    @Override
    public List<TRegionInfo> selectMachineStation(String regionId) {
        // TODO Auto-generated method stub
        return tRegionInfoMapper.selectMachineStation(regionId);
    }

    @Override
    public List<TRegionInfo> selectPublicRegion(String regionId) {
        return tRegionInfoMapper.selectPublicRegion(regionId);
    }

    @Override
    public TRegionInfo selectRegionInfoById(String regionId) {
        // TODO Auto-generated method stub
        return tRegionInfoMapper.selectByPrimaryKey(regionId);
    }

    @Override
    public List<TRegionInfo> selectRegionByRouteCode(Map<String, Object> map) {
        return tRegionInfoMapper.selectRegionByRouteCode(map);
    }

    /**
     * 根据id获取机维站列表
     */
    @Override
    public List<HTOrganizationInfo> getStationListById(String orgid) {
        return htOrganizationInfoMapper.getStationListById(orgid);
    }

    /**
     * 根据id获取机维站详情
     */
    @Override
    public HTOrganizationInfo getStationById(String orgid) {
        return htOrganizationInfoMapper.selectByPrimaryKey(orgid);
    }

}
