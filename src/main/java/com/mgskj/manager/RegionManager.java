package com.mgskj.manager;

import com.mgskj.model.TRegionInfo;
import com.mgskj.service.IRegionService;

import java.util.ArrayList;
import java.util.List;

public class RegionManager {

    private static class SingletonHolder {
        private static final RegionManager INSTANCE = new RegionManager();
    }

    private RegionManager() {
    }

    public static RegionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取某一市中心下面的所有机维站（包含共管机维站）/或者某一机维站
     *
     * @return
     */
    public synchronized List<TRegionInfo> getStationList(IRegionService tRegionService, String regionId) {
        System.out.println("getStationList");
        // 根据id获取区域信息
        TRegionInfo tRegionInfo = getRegionInfoById(tRegionService, regionId);
        // 机维站列表
        List<TRegionInfo> resultList = new ArrayList<>();
        List<TRegionInfo> mStationList;
        if (tRegionInfo != null) {
            if (tRegionInfo.getRegiontype() == 1) {
                // 分公司
                mStationList = tRegionService.selectMachineStation(regionId);
                resultList.addAll(selectPublicRegionList(tRegionService, regionId));
                resultList.addAll(mStationList);
            } else if (tRegionInfo.getRegiontype() == 2) {
                // 机维站
                System.out.println();
                mStationList = selectPublicRegionList(tRegionService, regionId);
                resultList.addAll(mStationList);
                resultList.add(tRegionInfo);
            }
        }
        return resultList;
    }

    /**
     * 获取共管区域
     *
     * @return
     */
    public List<TRegionInfo> selectPublicRegionList(IRegionService tRegionService, String regionId) {
        System.out.println("selectPublicRegionList");
        return tRegionService.selectPublicRegion(regionId);
    }

    /**
     * 根据id获取区域数据
     */
    public TRegionInfo getRegionInfoById(IRegionService tRegionService, String id) {
        return tRegionService.selectRegionInfoById(id);
    }

}
