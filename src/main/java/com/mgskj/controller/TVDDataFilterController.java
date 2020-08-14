package com.mgskj.controller;

import com.mgskj.bean.BaseResult;
import com.mgskj.entity.Operation;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.TRegionInfo;
import com.mgskj.model.TVDEquip;
import com.mgskj.service.IRegionService;
import com.mgskj.service.ITVDDataFilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
@Controller
@RequestMapping("/filter")
public class TVDDataFilterController {
    private static Logger log = LoggerFactory.getLogger(TVDDataFilterController.class);

    @Resource
    private ITVDDataFilterService tvdFilterService;

    @Resource
    private IRegionService tRegionService;

    // 车检器设备数据
    @RequestMapping(value = "/tvd/equip", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TVDEquip>> getBoardRouteCode(HttpServletRequest request,
                                                 HttpServletResponse response) throws IOException {
        BaseResult<List<TVDEquip>> result = new BaseResult();
        try {
            // 根据id获取区域信息
            String regionId = request.getParameter("region_id");
//            String regionCode = request.getParameter("region_code");
//            String prefixLength = request.getParameter("prefix_length");
//            log.debug("regionCode=" + regionCode);
//            log.debug("prefixLength=" + prefixLength);
            Map<String, Object> map = new HashMap<>();
            List<TVDEquip> list = new ArrayList<>();
            List<TRegionInfo> regionList = new ArrayList<>();
            TRegionInfo tRegionInfo = RegionManager.getInstance().getRegionInfoById(tRegionService, regionId);
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(tRegionService, regionId));
            regionList.add(tRegionInfo);
            for (TRegionInfo regionInfo : regionList) {
                System.out.println("regionInfo=" + regionInfo);
                map.clear();
                map.put("regionCode", regionInfo.getRegioncode());
                map.put("prefixLength", regionInfo.getPrefixlength());
                list.addAll(tvdFilterService.getTVDRouteCode(map));
            }
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

}
