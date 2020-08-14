package com.mgskj.controller;

import com.mgskj.bean.BaseResult;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.TEquipFaultData;
import com.mgskj.model.TRegionInfo;
import com.mgskj.service.IEquipFaultService;
import com.mgskj.service.IRegionService;
import com.mgskj.utils.EquipStatusUtil;
import com.mgskj.utils.EquipTypeUtil;
import com.mgskj.utils.ExcelUtil;
import com.mgskj.utils.ModuleUtil;
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

@Controller
@RequestMapping("/equipfault")
public class EquipFaultController {
    private static Logger log = LoggerFactory.getLogger(EquipFaultController.class);
    private SimpleDateFormat sdf;
    private SimpleDateFormat sdf2;

    @Resource
    private IEquipFaultService equipFaultService;

    @Resource
    private IRegionService regionService;

    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TEquipFaultData>> selectUserList(HttpServletRequest request,
                                                     HttpServletResponse response) throws IOException {
        BaseResult<List<TEquipFaultData>> result = new BaseResult();
        try {
            String fromRegionId = request.getParameter("from_region_id");
            String regionId = request.getParameter("regionId");
            System.out.println("regionId=" + regionId);
            String date = request.getParameter("date");
            System.out.println("date=" + date);
            String module = request.getParameter("module");
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
            map.put("regionId", regionId);
            map.put("module", module);
            map.put("date", date);
            List<TEquipFaultData> list = this.equipFaultService.selectEquipFault(map);
            for (TEquipFaultData tEquipFaultData : list) {
                tEquipFaultData.setEquiptypedesc(EquipTypeUtil.getEquiptype2StringByModule(tEquipFaultData.getModule(), tEquipFaultData.getEquiptype()));
                tEquipFaultData.setFaultstatusdesc(EquipStatusUtil.getEquipStatus2StringByModule(tEquipFaultData.getModule(), tEquipFaultData.getFaultstatus()));
            }
            result.setMsg("获取成功");
            result.setCode(1);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }
        return result;
    }

    @RequestMapping(value = "/modulelist", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TEquipFaultData>> selectModuleList(HttpServletRequest request,
                                                       HttpServletResponse response) throws IOException {
        BaseResult<List<TEquipFaultData>> result = new BaseResult();
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
            List<TEquipFaultData> list = this.equipFaultService.selectModule(map);
            for (TEquipFaultData tEquipFaultData : list) {
                tEquipFaultData.setModuledesc(ModuleUtil.getModule2StringByModule(tEquipFaultData.getModule()));
            }
            result.setMsg("获取成功");
            result.setCode(1);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }
        return result;
    }

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // 获取数据
            String fromRegionId = request.getParameter("from_region_id");
            String regionId = request.getParameter("regionId");
            System.out.println("regionId=" + regionId);
            String date = request.getParameter("date");
            System.out.println("date=" + date);
            String module = request.getParameter("module");
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
            map.put("regionId", regionId);
            map.put("module", module);
            map.put("date", date);
            List<TEquipFaultData> list = this.equipFaultService.selectEquipFault(map);
            for (TEquipFaultData tEquipFaultData : list) {
                tEquipFaultData.setEquiptypedesc(EquipTypeUtil.getEquiptype2StringByModule(tEquipFaultData.getModule(), tEquipFaultData.getEquiptype()));
                tEquipFaultData.setFaultstatusdesc(EquipStatusUtil.getEquipStatus2StringByModule(tEquipFaultData.getModule(), tEquipFaultData.getFaultstatus()));
            }
            String printer = request.getParameter("printer");

            // excel标题
            String[][] title = {{"设备故障报表"}, {"制表人：" + printer}, {"日期", "时间", "设备类型", "机维站", "隧道", "设备名称", "路线", "桩号", "IP", "故障状态 "}};

            // excel文件名
            String fileName = "设备故障报表" + ".xls";

            // sheet名
            String sheetName = "设备故障报表";

            String[][] content = new String[list.size()][title[title.length - 1].length];
            TEquipFaultData equipFaultData;
            if (sdf == null) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            if (sdf2 == null) {
                sdf2 = new SimpleDateFormat("HH:mm:ss");
            }
            for (int i = 0; i < list.size(); i++) {
                equipFaultData = list.get(i);
                content[i][0] = sdf.format(equipFaultData.getCreatedate());
                content[i][1] = sdf2.format(equipFaultData.getCreatetime());
                content[i][2] = equipFaultData.getEquiptypedesc();
                content[i][3] = equipFaultData.getLocalcenterregionname();
                content[i][4] = equipFaultData.getTunnelregionname();
                content[i][5] = equipFaultData.getEquipname();
                content[i][6] = equipFaultData.getRoutecode();
                content[i][7] = equipFaultData.getMile();
                content[i][8] = equipFaultData.getIp();
                content[i][9] = equipFaultData.getFaultstatusdesc();
            }
            CellRangeAddress[] regions = new CellRangeAddress[2];
            regions[0] = new CellRangeAddress(0, 0, 0, 9);
            regions[1] = new CellRangeAddress(1, 1, 0, 9);
            // 创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, content, regions, null);

            // 响应到客户端
            response2Client(response, fileName, wb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void response2Client(HttpServletResponse response, String fileName, HSSFWorkbook wb) {
        try {
            ExcelUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
