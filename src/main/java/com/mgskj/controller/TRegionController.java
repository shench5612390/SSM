package com.mgskj.controller;

import com.mgskj.bean.BaseResult;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.HTOrganizationInfo;
import com.mgskj.model.TRegionInfo;
import com.mgskj.service.IRegionService;
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
import java.util.List;

/**
 * 机维站
 *
 * @author shenchanghui
 */
@Controller
@RequestMapping("/region")
public class TRegionController {
    private static Logger log = LoggerFactory.getLogger(TRegionController.class);

    @Resource
    private IRegionService tRegionService;

    /**
     * 区域数据
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/info", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<TRegionInfo> getRegionInfoById(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        BaseResult<TRegionInfo> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            TRegionInfo tRegionInfo = tRegionService.selectRegionInfoById(regionId);
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(tRegionInfo);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

    /**
     * 机维站数据
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/stationlist", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResult<List<HTOrganizationInfo>> selectStationList(HttpServletRequest request,
                                                                  HttpServletResponse response) throws IOException {
        BaseResult<List<HTOrganizationInfo>> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            if (regionId != null && regionId != ""){
                List<HTOrganizationInfo> list = tRegionService.getStationListById(regionId);
                result.setCode(1);
                result.setMsg("获取成功");
                result.setData(list);
            }else{
                result.setCode(0);
                result.setMsg("未正确传递regionId");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

}
