package com.mgskj.service.impl;

import com.mgskj.bean.ETEquipResult;
import com.mgskj.bean.UserName;
import com.mgskj.dao.*;
import com.mgskj.model.*;
import com.mgskj.service.IFilterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
@Service("filterService")
public class FilterServiceImpl implements IFilterService {
    @Resource
    private TCMSEquipMapper tCMSEquipMapper;

    @Resource
    private TETEquipMapper tETEquipMapper;

    @Resource
    private TEVDEquipMapper tEVDEquipMapper;

    @Resource
    private TFAEquipMapper tFAEquipMapper;

    @Resource
    private TOperationLogWMapper TOperationLogWMapper;

    @Resource
    private TUserInfoMapper tUserInfoMapper;

    @Override
    public List<TCMSEquip> selectBoardEquip(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return tCMSEquipMapper.selectCMSEquip(map);
    }

    @Override
    public List<TCMSEquip> selectBoardEquipNameList(String routeCode, String boardType) {
        // TODO Auto-generated method stub
        return tCMSEquipMapper.selectEquipNameList(routeCode, boardType);
    }

    @Override
    public List<UserName> selectBoardUserNameList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.selectUserName(map);
    }

    @Override
    public List<ETEquipResult> selectETEquip(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return tETEquipMapper.selectETEquip(map);
    }

    @Override
    public List<TRegionInfo> selectETRegion(String routeCode) {
        // TODO Auto-generated method stub
        return tETEquipMapper.selectRegionName(routeCode);
    }

    @Override
    public List<TETEquip> selectETEquipName(String routeCode, String regionId) {
        // TODO Auto-generated method stub
        return tETEquipMapper.selectEquipName(routeCode, regionId);
    }

    @Override
    public List<ETEquipResult> selectEVDEquip(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return tEVDEquipMapper.selectEVDEquip(map);
    }

    @Override
    public List<TRegionInfo> selectEVDRegion() {
        // TODO Auto-generated method stub
        return tEVDEquipMapper.selectRegionName();
    }

    @Override
    public List<TEVDEquip> selectEVDEquipName(String routeCode, String regionId) {
        // TODO Auto-generated method stub
        return tEVDEquipMapper.selectEquipName(routeCode, regionId);
    }

    @Override
    public List<ETEquipResult> selectFAEquip(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return tFAEquipMapper.selectFAEquip(map);
    }

    @Override
    public List<TRegionInfo> selectFARegion() {
        // TODO Auto-generated method stub
        return tFAEquipMapper.selectRegionName();
    }

    @Override
    public List<TFAEquip> selectFAEquipName(String routeCode, String regionId) {
        // TODO Auto-generated method stub
        return tFAEquipMapper.selectEquipName(routeCode, regionId);
    }

    @Override
    public com.mgskj.model.UserName selectUserNameById(String id) {
        return tUserInfoMapper.selectByPrimaryKey(id);
    }

}
