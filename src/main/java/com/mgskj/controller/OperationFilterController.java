package com.mgskj.controller;

import com.mgskj.bean.BaseResult;
import com.mgskj.bean.ETEquipResult;
import com.mgskj.bean.UserName;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.*;
import com.mgskj.service.IFilterService;
import com.mgskj.service.IRegionService;
import com.mgskj.utils.EquipTypeUtil;
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
public class OperationFilterController {
    private static Logger log = LoggerFactory.getLogger(OperationFilterController.class);

    @Resource
    private IFilterService filterService;

    @Resource
    private IRegionService regionService;


    // 情报板操作日志 线号
    @RequestMapping(value = "/board/equip", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TCMSEquip>> getBoardEquip(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        BaseResult<List<TCMSEquip>> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            TRegionInfo regionInfo = RegionManager.getInstance().getRegionInfoById(regionService, regionId);
            List<TRegionInfo> regionList = new ArrayList<>();
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(regionService, regionId));
            regionList.add(regionInfo);
            System.out.println("regionList.size()=" + regionList.size());
            Map<String, Object> map = new HashMap<>();
            List<TCMSEquip> list = new ArrayList<>();
            for (TRegionInfo info : regionList) {
                map.clear();
                map.put("regionCode", info.getRegioncode());
                map.put("prefixLength", info.getPrefixlength());
                map.put("regionId", regionId);
                list.addAll(filterService.selectBoardEquip(map));
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

    // 情报板操作日志 设备名称
    @RequestMapping(value = "/board/area", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TRegionInfo>> getBoardArea(HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {
        BaseResult<List<TRegionInfo>> result = new BaseResult<>();
        try {
            String routeCode = request.getParameter("route_code");
            String fromRegionId = request.getParameter("from_region_id");
            TRegionInfo regionInfo = RegionManager.getInstance().getRegionInfoById(regionService, fromRegionId);
            String regionCode = null;
            String prefixLength = null;
            if (regionInfo != null) {
                regionCode = regionInfo.getRegioncode();
                prefixLength = regionInfo.getPrefixlength() == null ? null : regionInfo.getPrefixlength().toString();
            }
            Map<String, Object> map = new HashMap<>();
            map.put("routeCode", routeCode);
            map.put("regionType1", 5);
            map.put("regionType2", 6);
            map.put("regionCode", regionCode);
            map.put("prefixLength", prefixLength);
            List<TRegionInfo> list = regionService.selectRegionByRouteCode(map);
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

    // 情报板操作日志 设备名称
    @RequestMapping(value = "/board/equipname", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TCMSEquip>> getBoardEquipName(HttpServletRequest request,
                                                  HttpServletResponse response) throws IOException {
        BaseResult<List<TCMSEquip>> result = new BaseResult();
        try {
            String routeCode = request.getParameter("route_code");
            String boardType = request.getParameter("board_type");
            if (routeCode == null) {
                result.setCode(0);
                result.setMsg("未正确传线号");
                return result;
            }
            List<TCMSEquip> list = filterService.selectBoardEquipNameList(routeCode, boardType);
            // 去重
            List<TCMSEquip> list2 = new ArrayList<>();
            boolean isRepeat = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEquipname() == null || list.get(i).getEquipname() == "") {
                    isRepeat = true;
                } else {
                    isRepeat = false;
                }
                for (int j = 0; j < list2.size(); j++) {
                    if (isRepeat || list.get(i).getEquipname().equals(list2.get(j).getEquipname())) {
                        isRepeat = true;
                        break;
                    }
                }
                if (!isRepeat) {
                    list2.add(list.get(i));
                }
            }
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(list2);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

    // 情报板操作日志 用户名称
    @RequestMapping(value = "/board/username", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<UserName>> getBoardUserName(HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {
        BaseResult<List<UserName>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(regionService, fromRegionId);
            }
            if (regionList == null) {
                regionList = new ArrayList<>();
            }
            String[] array = new String[regionList.size()];
            for (int i = 0; i < regionList.size(); i++) {
                array[i] = regionList.get(i).getId();
            }
            Map<String, Object> map = new HashMap<>();
            map.put("stations", array);
            List<UserName> list = filterService.selectBoardUserNameList(map);
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

    // 紧急电话报警处理日志报表 线号
    @RequestMapping(value = "/et/equip", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<ETEquipResult>> getETRouteCode(HttpServletRequest request,
                                                   HttpServletResponse response) throws IOException {
        BaseResult<List<ETEquipResult>> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            TRegionInfo regionInfo = RegionManager.getInstance().getRegionInfoById(regionService, regionId);
            List<TRegionInfo> regionList = new ArrayList<>();
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(regionService, regionId));
            regionList.add(regionInfo);
            System.out.println("regionList.size()=" + regionList.size());
            Map<String, Object> map = new HashMap<>();
            List<ETEquipResult> list = new ArrayList<>();
            for (TRegionInfo info : regionList) {
                map.clear();
                map.put("regionCode", info.getRegioncode());
                map.put("prefixLength", info.getPrefixlength());
                list.addAll(filterService.selectETEquip(map));
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


    // 紧急电话操作 设备名称
    @RequestMapping(value = "/et/equipname", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TETEquip>> getETEquipName(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        BaseResult<List<TETEquip>> result = new BaseResult();
        try {
            String routeCode = request.getParameter("route_code");
            System.out.println("routeCode=" + routeCode);
            String regionId = request.getParameter("region_id");
            System.out.println("regionId=" + regionId);
            if (routeCode == null) {
                result.setCode(0);
                result.setMsg("未正确传线号");
                return result;
            }
            List<TETEquip> list = filterService.selectETEquipName(routeCode, regionId);
            // 去重
            List<TETEquip> list2 = new ArrayList<>();
            boolean isRepeat = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEquipname() == null || list.get(i).getEquipname() == "") {
                    isRepeat = true;
                } else {
                    isRepeat = false;
                }
                for (int j = 0; j < list2.size(); j++) {
                    if (isRepeat || list.get(i).getEquipname().equals(list2.get(j).getEquipname())) {
                        isRepeat = true;
                        break;
                    }
                }
                if (!isRepeat) {
                    list2.add(list.get(i));
                }
            }
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(list2);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

    // 避险车道报警处理日志报表 线号
    @RequestMapping(value = "/evd/equip", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<ETEquipResult>> getEVDEquip(HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {
        BaseResult<List<ETEquipResult>> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            TRegionInfo regionInfo = RegionManager.getInstance().getRegionInfoById(regionService, regionId);
            List<TRegionInfo> regionList = new ArrayList<>();
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(regionService, regionId));
            regionList.add(regionInfo);
            System.out.println("regionList.size()=" + regionList.size());
            Map<String, Object> map = new HashMap<>();
            List<ETEquipResult> list = new ArrayList<>();
            for (TRegionInfo info : regionList) {
                map.clear();
                map.put("regionCode", info.getRegioncode());
                map.put("prefixLength", info.getPrefixlength());
                list.addAll(filterService.selectEVDEquip(map));
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


    // 避险车道报警处理日志报表 设备名称
    @RequestMapping(value = "/evd/equipname", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TEVDEquip>> getEVDEquipName(HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {
        BaseResult<List<TEVDEquip>> result = new BaseResult();
        try {
            String routeCode = request.getParameter("route_code");
            String regionId = request.getParameter("region_id");
            if (routeCode == null) {
                result.setCode(0);
                result.setMsg("未正确传线号");
                return result;
            }
            List<TEVDEquip> list = filterService.selectEVDEquipName(routeCode, regionId);
            // 去重
            List<TEVDEquip> list2 = new ArrayList<>();
            boolean isRepeat = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEquipname() == null || list.get(i).getEquipname() == "") {
                    isRepeat = true;
                } else {
                    isRepeat = false;
                }
                for (int j = 0; j < list2.size(); j++) {
                    if (isRepeat || list.get(i).getEquipname().equals(list2.get(j).getEquipname())) {
                        isRepeat = true;
                        break;
                    }
                }
                if (!isRepeat) {
                    list2.add(list.get(i));
                }
            }
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(list2);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

    // 火灾报警处理日志报表 线号
    @RequestMapping(value = "/fa/equip", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<ETEquipResult>> getFARouteCode(HttpServletRequest request,
                                                   HttpServletResponse response) throws IOException {
        BaseResult<List<ETEquipResult>> result = new BaseResult();
        try {
            String regionId = request.getParameter("region_id");
            TRegionInfo regionInfo = RegionManager.getInstance().getRegionInfoById(regionService, regionId);
            List<TRegionInfo> regionList = new ArrayList<>();
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(regionService, regionId));
            regionList.add(regionInfo);
            System.out.println("regionList.size()=" + regionList.size());
            Map<String, Object> map = new HashMap<>();
            List<ETEquipResult> list = new ArrayList<>();
            for (TRegionInfo info : regionList) {
                map.clear();
                map.put("regionCode", info.getRegioncode());
                map.put("prefixLength", info.getPrefixlength());
                list.addAll(filterService.selectFAEquip(map));
            }
//            for (int i = 0; i < list.size(); i++) {
//                list.get(i).setEquiptypedesc(EquipTypeUtil.FireAlarmEquipType2String(list.get(i).getEquiptype()));
//            }
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


    // 火灾报警处理日志报表 设备名称
    @RequestMapping(value = "/fa/equipname", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TFAEquip>> getFAEquipName(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        BaseResult<List<TFAEquip>> result = new BaseResult();
        try {
            String routeCode = request.getParameter("route_code");
            String regionId = request.getParameter("region_id");
            if (routeCode == null) {
                result.setCode(0);
                result.setMsg("未正确传线号");
                return result;
            }
            List<TFAEquip> list = filterService.selectFAEquipName(routeCode, regionId);
            // 去重
            List<TFAEquip> list2 = new ArrayList<>();
            boolean isRepeat = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEquipname() == null || list.get(i).getEquipname() == "") {
                    isRepeat = true;
                } else {
                    isRepeat = false;
                }
                for (int j = 0; j < list2.size(); j++) {
                    if (isRepeat || list.get(i).getEquipname().equals(list2.get(j).getEquipname())) {
                        isRepeat = true;
                        break;
                    }
                }
                if (!isRepeat) {
                    list2.add(list.get(i));
                }
            }
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(list2);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }

        return result;
    }

}
