package com.mgskj.controller;

import com.mgskj.bean.*;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.TRegionInfo;
import com.mgskj.service.IFilterService;
import com.mgskj.service.IOperationService;
import com.mgskj.service.IRegionService;
import com.mgskj.utils.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
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
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @author shenchanghui
 */
@Controller
@RequestMapping("/operation")
public class OperationController {
    private static Logger log = LoggerFactory.getLogger(OperationController.class);

    @Resource
    private IOperationService operationService;

    @Resource
    private IRegionService tRegionService;

    @Resource
    private IFilterService filterService;

    // 情报板操作日志
    @RequestMapping(value = "/board/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<BoardOperationResult>> getBoardList(HttpServletRequest request,
                                                        HttpServletResponse response) throws IOException {
        BaseResult<List<BoardOperationResult>> result = new BaseResult<>();
        try {
            String regionId = request.getParameter("region_id");
            String routeCode = request.getParameter("route_code");
            String bussinessCategory = request.getParameter("bussiness_category");
            log.debug("bussinessCategory=" + bussinessCategory);
            String equipName = request.getParameter("equip_name");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            log.debug("regionId=" + regionId);
            List<TRegionInfo> regionList = null;
            if (regionId != null && regionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, regionId);
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
            map.put("routeCode", routeCode);
            map.put("bussinessCategory", bussinessCategory);
            map.put("equipName", equipName);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<BoardOperationResult> list = operationService.getBoardOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setFontcolordesc(CMSColorUtil.color2String(list.get(i).getFontcolor()));
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

    // 情报板操作日志
    @RequestMapping(value = "/board/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportBoardList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String regionId = request.getParameter("region_id");
            String routeCode = request.getParameter("route_code");
            routeCode = new String(routeCode.getBytes("ISO8859-1"), "UTF-8");
            String bussinessCategory = request.getParameter("bussiness_category");
            bussinessCategory = new String(bussinessCategory.getBytes("ISO8859-1"), "UTF-8");
            log.debug("bussinessCategory=" + bussinessCategory);
            String equipName = request.getParameter("equip_name");
            equipName = new String(equipName.getBytes("ISO8859-1"), "UTF-8");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            log.debug("regionId=" + regionId);
            List<TRegionInfo> regionList = null;
            if (regionId != null && regionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, regionId);
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
            map.put("routeCode", routeCode);
            map.put("bussinessCategory", bussinessCategory);
            map.put("equipName", equipName);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<BoardOperationResult> list = operationService.getBoardOperationList(map);
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setFontcolordesc(CMSColorUtil.color2String(list.get(i).getFontcolor()));
            }
            // excel标题
            String[][] title = {{"情报板操作日志报表"}, {"制表人：" + printer},
                    {"设备名称", "线号", "桩号", "所属区域", "所属类别", "信息内容", "字体类型", "尺寸", "字色", "发送用户 ", "操作结果", "操作时间"}};

            // excel文件名
            String fileName = "情报板操作日志报表" + ".xls";

            // sheet名
            String sheetName = "情报板操作日志报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            BoardOperationResult boardOperationResult;
            for (int i = 0; i < list.size(); i++) {
                boardOperationResult = list.get(i);
                content[i][0] = boardOperationResult.getEquipname();
                content[i][1] = boardOperationResult.getRoutecode();
                content[i][2] = boardOperationResult.getMile();
                content[i][3] = boardOperationResult.getRegionname();
                content[i][4] = boardOperationResult.getBusinesscategory();
                content[i][5] = boardOperationResult.getDescription();
                content[i][6] = boardOperationResult.getFontname();
                content[i][7] = boardOperationResult.getFontsize();
                content[i][8] = boardOperationResult.getFontcolordesc();
                content[i][9] = boardOperationResult.getUsername();
                content[i][10] = boardOperationResult.getResultdesc();
                content[i][11] = boardOperationResult.getOperatetime();
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 11);
            regions[1] = new CellRangeAddress(1, 1, 0, 11);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 紧急电话报警处理日志报表
    @RequestMapping(value = "/et/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<ETOperationResult>> getETList(HttpServletRequest request,
                                                  HttpServletResponse response) throws IOException {
        BaseResult<List<ETOperationResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            String regionID = request.getParameter("region_id");
            String equipName = request.getParameter("equip_name");
            String state = request.getParameter("state");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipName", equipName);
            map.put("state", state);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<ETOperationResult> list = operationService.getETOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setEquiptypedesc(EquipTypeUtil.EmergencyTelephoneEquipType2String(list.get(i).getEquiptype()));
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
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

    // 导出紧急电话报警处理日志报表
    @RequestMapping(value = "/et/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportETList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            routeCode = new String(routeCode.getBytes("ISO8859-1"), "UTF-8");
            String regionID = request.getParameter("region_id");
            String equipName = request.getParameter("equip_name");
            equipName = new String(equipName.getBytes("ISO8859-1"), "UTF-8");
            String state = request.getParameter("state");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipName", equipName);
            map.put("state", state);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<ETOperationResult> list = operationService.getETOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setEquiptypedesc(EquipTypeUtil.EmergencyTelephoneEquipType2String(list.get(i).getEquiptype()));
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
            }

            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"紧急电话报警处理日志报表"}, {"制表人：" + printer},
                    {"设备类型", "设备名称", "线号", "桩号", "所属区域", "状态", "操作员", "操作动作", "重复报警次数", "操作时间"}};

            // excel文件名
            String fileName = "紧急电话报警处理日志报表" + ".xls";

            // sheet名
            String sheetName = "紧急电话报警处理日志报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            ETOperationResult eTOperationResult;
            for (int i = 0; i < list.size(); i++) {
                eTOperationResult = list.get(i);
                content[i][0] = eTOperationResult.getEquiptypedesc();
                content[i][1] = eTOperationResult.getEquipname();
                content[i][2] = eTOperationResult.getRoutecode();
                content[i][3] = eTOperationResult.getMile();
                content[i][4] = eTOperationResult.getRegionname();
                content[i][5] = eTOperationResult.getUsername();
                content[i][6] = eTOperationResult.getOperationdesc();
                content[i][7] = eTOperationResult.getDealingstatus();
                content[i][8] = String.valueOf(eTOperationResult.getDuplicatecount());
                content[i][9] = eTOperationResult.getOperatetime();
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 9);
            regions[1] = new CellRangeAddress(1, 1, 0, 9);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 避险车道报警处理日志报表
    @RequestMapping(value = "/evd/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<EVDOperationResult>> getEVDList(HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        BaseResult<List<EVDOperationResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            String regionID = request.getParameter("region_id");
            String equipType = request.getParameter("equip_type");
            String equipName = request.getParameter("equip_name");
            String status = request.getParameter("status");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipType", equipType);
            map.put("equipName", equipName);
            map.put("status", status);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<EVDOperationResult> list = operationService.getEVDOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setEquiptypedesc(EquipTypeUtil.EmergencyVDEquipType2String(list.get(i).getEquiptype()));
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

    // 导出避险车道报警处理日志报表
    @RequestMapping(value = "/evd/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportEVDList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            routeCode = new String(routeCode.getBytes("ISO8859-1"), "UTF-8");
            String regionID = request.getParameter("region_id");
            String equipType = request.getParameter("equip_type");
            String equipName = request.getParameter("equip_name");
            equipName = new String(equipName.getBytes("ISO8859-1"), "UTF-8");
            String status = request.getParameter("status");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipType", equipType);
            map.put("equipName", equipName);
            map.put("status", status);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<EVDOperationResult> list = operationService.getEVDOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setEquiptypedesc(EquipTypeUtil.EmergencyVDEquipType2String(list.get(i).getEquiptype()));
            }
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"避险车道报警处理日志报表"}, {"制表人：" + printer},
                    {"设备类型", "设备名称", "线号", "桩号", "所属区域", "操作员", "操作动作", "重复报警次数", "状态", "操作结果", "操作日期", "操作时间"}};

            // excel文件名
            String fileName = "避险车道报警处理日志报表" + ".xls";

            // sheet名
            String sheetName = "避险车道报警处理日志报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            EVDOperationResult eVDOperationResult;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                eVDOperationResult = list.get(i);
                content[i][0] = eVDOperationResult.getEquiptypedesc();
                content[i][1] = eVDOperationResult.getEquipname();
                content[i][2] = eVDOperationResult.getRoutecode();
                content[i][3] = eVDOperationResult.getMile();
                content[i][4] = eVDOperationResult.getRegionname();
                content[i][5] = eVDOperationResult.getUsername();
                content[i][6] = eVDOperationResult.getOperationdesc();
                content[i][7] = String.valueOf(eVDOperationResult.getDuplicatecount());
                content[i][8] = String.valueOf(eVDOperationResult.getDealingstatus());
                content[i][9] = eVDOperationResult.getResultdesc();
                content[i][10] = sdf.format(eVDOperationResult.getCreatedate());
                content[i][11] = sdf2.format(eVDOperationResult.getCreatetime());
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 11);
            regions[1] = new CellRangeAddress(1, 1, 0, 11);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 火灾报警处理日志报表
    @RequestMapping(value = "/fa/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<FAOperationResult>> getFAList(HttpServletRequest request,
                                                  HttpServletResponse response) throws IOException {
        BaseResult<List<FAOperationResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            String regionID = request.getParameter("region_id");
            String equipType = request.getParameter("equip_type");
            String equipName = request.getParameter("equip_name");
            String status = request.getParameter("status");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            String fireBeginDate = request.getParameter("fire_begin_date");
            String fireEndDate = request.getParameter("fire_end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipType", equipType);
            map.put("equipName", equipName);
            map.put("status", status);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            map.put("fireBeginDate", fireBeginDate);
            map.put("fireEndDate", fireEndDate);
            List<FAOperationResult> list = operationService.getFAOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setEquiptypedesc(EquipTypeUtil.FireAlarmEquipType2String(list.get(i).getEquiptype()));
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

    // 导出火灾报警处理日志报表
    @RequestMapping(value = "/fa/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportFAList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String routeCode = request.getParameter("route_code");
            routeCode = new String(routeCode.getBytes("ISO8859-1"), "UTF-8");
            String regionID = request.getParameter("region_id");
            String equipType = request.getParameter("equip_type");
            String equipName = request.getParameter("equip_name");
            equipName = new String(equipName.getBytes("ISO8859-1"), "UTF-8");
            String status = request.getParameter("status");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            String fireBeginDate = request.getParameter("fire_begin_date");
            String fireEndDate = request.getParameter("fire_end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("routeCode", routeCode);
            map.put("regionID", regionID);
            map.put("equipType", equipType);
            map.put("equipName", equipName);
            map.put("status", status);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            map.put("fireBeginDate", fireBeginDate);
            map.put("fireEndDate", fireEndDate);
            List<FAOperationResult> list = operationService.getFAOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
                list.get(i).setEquiptypedesc(EquipTypeUtil.FireAlarmEquipType2String(list.get(i).getEquiptype()));
            }
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"火灾报警处理日志报表"}, {"制表人：" + printer},
                    {"设备类型", "设备名称", "线号", "桩号", "所属区域", "操作员", "操作动作", "重复报警次数", "状态", "操作结果", "操作日期", "操作时间", "报警时间"}};

            // excel文件名
            String fileName = "火灾报警处理日志报表" + ".xls";

            // sheet名
            String sheetName = "火灾报警处理日志报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            FAOperationResult faOperationResult;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                faOperationResult = list.get(i);
                content[i][0] = faOperationResult.getEquiptypedesc();
                content[i][1] = faOperationResult.getEquipname();
                content[i][2] = faOperationResult.getRoutecode();
                content[i][3] = faOperationResult.getMile();
                content[i][4] = faOperationResult.getRegionname();
                content[i][5] = faOperationResult.getUsername();
                content[i][6] = faOperationResult.getOperationdesc();
                content[i][7] = String.valueOf(faOperationResult.getDuplicatecount());
                content[i][8] = String.valueOf(faOperationResult.getDealingstatus());
                content[i][9] = faOperationResult.getResultdesc();
                content[i][10] = faOperationResult.getCreatedate() == null ? null : sdf.format(faOperationResult.getCreatedate());
                content[i][11] = faOperationResult.getCreatetime() == null ? null : sdf2.format(faOperationResult.getCreatetime());
                content[i][12] = faOperationResult.getFiredate() == null ? null : sdf.format(faOperationResult.getFiredate());
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 12);
            regions[1] = new CellRangeAddress(1, 1, 0, 12);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 登录信息数据报表
    @RequestMapping(value = "/login/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TOperationLogWResult>> getLoginList(HttpServletRequest request,
                                                        HttpServletResponse response) throws IOException {
        BaseResult<List<TOperationLogWResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
//            List<TRegionInfo> regionList = null;
//            if (fromRegionId != null && fromRegionId != "") {
//                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
//            }
//            if (regionList == null) {
//                regionList = new ArrayList<>();
//            }
//            String[] array = new String[regionList.size()];
//            for (int i = 0; i < regionList.size(); i++) {
//                array[i] = regionList.get(i).getId();
//            }
            Map<String, Object> map = new HashMap<>();
//            map.put("stations", array);
            map.put("fromRegionId", fromRegionId);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getLoginOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
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

    // 导出登录信息数据报表
    @RequestMapping(value = "/login/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportLoginList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
//            List<TRegionInfo> regionList = null;
//            if (fromRegionId != null && fromRegionId != "") {
//                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
//            }
//            if (regionList == null) {
//                regionList = new ArrayList<>();
//            }
//            String[] array = new String[regionList.size()];
//            for (int i = 0; i < regionList.size(); i++) {
//                array[i] = regionList.get(i).getId();
//            }
            Map<String, Object> map = new HashMap<>();
//            map.put("stations", array);
            map.put("fromRegionId", fromRegionId);
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getLoginOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
            }
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"登录信息数据报表"}, {"制表人：" + printer}, {"账号", "IP地址", "状态", "操作日期", "操作时间"}};

            // excel文件名
            String fileName = "登录信息数据报表" + ".xls";

            // sheet名
            String sheetName = "登录信息数据报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            TOperationLogWResult tOperationLogW;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                tOperationLogW = list.get(i);
                content[i][0] = tOperationLogW.getUsername();
                content[i][1] = tOperationLogW.getTarget();
                content[i][2] = String.valueOf(tOperationLogW.getOperationdesc());
                content[i][3] = sdf.format(tOperationLogW.getCreatedate());
                content[i][4] = sdf2.format(tOperationLogW.getCreatetime());
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 4);
            regions[1] = new CellRangeAddress(1, 1, 0, 4);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 隧道控制操作日志报表
    @RequestMapping(value = "/tunnel/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TOperationLogWResult>> getTunnelList(HttpServletRequest request,
                                                         HttpServletResponse response) throws IOException {
        BaseResult<List<TOperationLogWResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getTunnelOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
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

    // 导出隧道控制操作日志报表
    @RequestMapping(value = "/tunnel/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportTunnelList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getTunnelOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
            }
            // List<TOperationLogW> list = new ArrayList<>();
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"隧道控制操作日志报表"}, {"制表人：" + printer},
                    {"操作用户", "操作动作", "操作目标", "操作结果", "操作日期", "操作时间"}};

            // excel文件名
            String fileName = "隧道控制操作日志报表" + ".xls";

            // sheet名
            String sheetName = "隧道控制操作日志报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            TOperationLogWResult tOperationLogW;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                tOperationLogW = list.get(i);
                content[i][0] = tOperationLogW.getUsername();
                content[i][1] = String.valueOf(tOperationLogW.getOperationdesc());
                content[i][2] = tOperationLogW.getTarget();
                content[i][3] = String.valueOf(tOperationLogW.getResultdesc());
                content[i][4] = sdf.format(tOperationLogW.getCreatedate());
                content[i][5] = sdf2.format(tOperationLogW.getCreatetime());
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 5);
            regions[1] = new CellRangeAddress(1, 1, 0, 5);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 报警联动设置操作报表
    @RequestMapping(value = "/alarmlink/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TOperationLogWResult>> getAlarmLinkList(HttpServletRequest request,
                                                            HttpServletResponse response) throws IOException {
        BaseResult<List<TOperationLogWResult>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getAlarmLinkOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
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

    // 导出报警联动设置操作报表
    @RequestMapping(value = "/alarmlink/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void exportAlarmLinkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String userName = request.getParameter("user_name");
            userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
            String beginDate = request.getParameter("begin_date");
            String endDate = request.getParameter("end_date");
            List<TRegionInfo> regionList = null;
            if (fromRegionId != null && fromRegionId != "") {
                regionList = RegionManager.getInstance().getStationList(tRegionService, fromRegionId);
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
            map.put("userName", userName);
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            List<TOperationLogWResult> list = operationService.getAlarmLinkOperationList(map);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOperationdesc(OperationUtil.operation2String(list.get(i).getOperation()));
                list.get(i).setResultdesc(OperationResultUtil.result2String(list.get(i).getResult()));
            }
            // List<TOperationLogW> list = new ArrayList<>();
            String printer = request.getParameter("printer");
            printer = new String(printer.getBytes("ISO8859-1"), "UTF-8");
//            printer = UserManager.getInstance().getUserNameById(filterService, printer);
            // excel标题
            String[][] title = {{"报警联动设置操作报表"}, {"制表人：" + printer}, {"账号", "操作日期", "操作时间", "操作动作", "操作结果"}};

            // excel文件名
            String fileName = "报警联动设置操作报表" + ".xls";

            // sheet名
            String sheetName = "报警联动设置操作报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            TOperationLogWResult tOperationLogW;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                tOperationLogW = list.get(i);
                content[i][0] = tOperationLogW.getUsername();
                content[i][1] = sdf.format(tOperationLogW.getCreatedate());
                content[i][2] = sdf2.format(tOperationLogW.getCreatetime());
                content[i][3] = tOperationLogW.getOperationdesc();
                content[i][4] = tOperationLogW.getResultdesc();
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 4);
            regions[1] = new CellRangeAddress(1, 1, 0, 4);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            try {
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
