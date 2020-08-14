package com.mgskj.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mgskj.bean.BaseResult;
import com.mgskj.bean.TVDDataCenterResult;
import com.mgskj.bean.TVDDataStationHourResult;
import com.mgskj.manager.RegionManager;
import com.mgskj.model.TRegionInfo;
import com.mgskj.model.TVDDataDayResult;
import com.mgskj.model.TVDDataHourResult;
import com.mgskj.model.TVDEquip;
import com.mgskj.service.IRegionService;
import com.mgskj.service.ITVDDataFilterService;
import com.mgskj.service.ITVDDataService;
import com.mgskj.utils.BigDecimalUtil;
import com.mgskj.utils.DateUtil;
import com.mgskj.utils.ExcelUtil;
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
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 车检器报表
 *
 * @author shenchanghui
 */
@Controller
@RequestMapping("/vddata")
public class TVDDataController {
    private static Logger log = LoggerFactory.getLogger(TVDDataController.class);

    @Resource
    private ITVDDataService tvdDataService;

    @Resource
    private IRegionService tRegionService;

    private DecimalFormat mDecimalFormat = new DecimalFormat("#.00");

    /**
     * 日报表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/hour/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TVDDataStationHourResult>> selectVDDataHourList(HttpServletRequest request,
                                                                    HttpServletResponse response) throws IOException {
        BaseResult<List<TVDDataStationHourResult>> result = new BaseResult();
        try {
            String dateString = request.getParameter("date");
            System.out.println("dateString=" + dateString);
            System.out.println("dateString == '':" + "".equals(dateString));
            String regionCode = request.getParameter("regionCode");
            System.out.println("regionCode=" + regionCode);
            System.out.println("request == '':" + "".equals(regionCode));
            String prefixLength = request.getParameter("PrefixLength");
            System.out.println("prefixLength=" + prefixLength);
            System.out.println("prefixLength == '':" + "".equals(prefixLength));
            List<TVDDataStationHourResult> list = tvdDataService.selectHourList(regionCode, dateString, prefixLength);
            result.setCode(1);
            result.setMsg("获取成功");
            result.setCount(list.size());
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }
        return result;
    }

    /**
     * 月报表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/day/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TVDDataDayResult>> selectVDDataDayList(HttpServletRequest request,
                                                           HttpServletResponse response) throws IOException {
        BaseResult<List<TVDDataDayResult>> result = new BaseResult();
        try {
            String dateString = request.getParameter("date");
            System.out.println("dateString=" + dateString);
            String regionCode = request.getParameter("regionCode");
            System.out.println("regionCode=" + regionCode);
            String prefixLength = request.getParameter("PrefixLength");
            System.out.println("prefixLength=" + prefixLength);
            List<TVDDataDayResult> list = tvdDataService.selectDayList(regionCode, dateString, prefixLength);
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

    /**
     * 年报表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/month/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TVDDataDayResult>> selectVDDataYearList(HttpServletRequest request,
                                                            HttpServletResponse response) throws IOException {
        BaseResult<List<TVDDataDayResult>> result = new BaseResult();
        try {
            String dateString = request.getParameter("date");
            System.out.println("dateString=" + dateString);
            String regionCode = request.getParameter("regionCode");
            System.out.println("regionCode=" + regionCode);
            String prefixLength = request.getParameter("PrefixLength");
            System.out.println("prefixLength=" + prefixLength);
            List<TVDDataDayResult> list = tvdDataService.selectMonthList(regionCode, dateString, prefixLength);
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

    /**
     * 信息中心报表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/center/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    BaseResult<List<TVDDataCenterResult>> selectVDDataCenterList(HttpServletRequest request,
                                                                 HttpServletResponse response) throws IOException {
        BaseResult<List<TVDDataCenterResult>> result = new BaseResult();
        try {
            String dateString = request.getParameter("date");
            System.out.println("dateString=" + dateString);
//            String regionCode = request.getParameter("regionCode");
//            System.out.println("regionCode=" + regionCode);
//            String prefixLength = request.getParameter("PrefixLength");
//            System.out.println("prefixLength=" + prefixLength);
            String routeCode = request.getParameter("route_code");
            System.out.println("routeCode=" + routeCode);
            String equipId = request.getParameter("equip_id");
            System.out.println("equipId=" + equipId);
            String regionId = request.getParameter("region_id");
            Map<String, Object> map = new HashMap<>();
            List<TRegionInfo> regionList = new ArrayList<>();
            TRegionInfo tRegionInfo = RegionManager.getInstance().getRegionInfoById(tRegionService, regionId);
            regionList.addAll(RegionManager.getInstance().selectPublicRegionList(tRegionService, regionId));
            regionList.add(tRegionInfo);
            List<TVDDataHourResult> list = new ArrayList<>();
            for (TRegionInfo regionInfo : regionList) {
                System.out.println("regionInfo=" + regionInfo);
                map.clear();
                map.put("regionCode", regionInfo == null ? null : regionInfo.getRegioncode());
                map.put("prefixLength", regionInfo == null ? null : regionInfo.getPrefixlength());
                map.put("date", dateString);
                map.put("routeCode", routeCode);
                map.put("equipId", equipId);
                list.addAll(tvdDataService.selectCenterList(map));
            }

            System.out.println("list.size()=" + list.size());
            result.setCode(1);
            result.setMsg("获取成功");
            result.setData(formatCenterData(list));
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("获取失败");
        }
        return result;
    }

    // 处理信息中心车检器数据
    private List<TVDDataCenterResult> formatCenterData(List<TVDDataHourResult> list) {
        List<TVDDataCenterResult> resultList = new ArrayList<>();
        TVDDataCenterResult tVDDataCenterResult;
        TVDDataHourResult tVDDataHourResult;
        // 设备id
        String equipId;
        // 控制id
        String controllerid;
        // 小车车流量
        int smallForward;
        // 大车车流量
        int bigForward;
        // 小车平均车速
        double smallAvgSpd;
        // 大车平均车速
        double bigAvgSpd;
        // 全部平均车速
        double allAvgSpd;
        // 小车占有率
        double smallOccupancy;
        // 大车占有率
        double bigOccupancy;
        // 全部占有率
        double allOccupancy;
        // 设备名称
        String equipName;
        // 设备类型
        int equipType;
        // 车道类型
        int channel;

        Date time;
        for (int i = 0; i < list.size(); i++) {
            tVDDataHourResult = list.get(i);
            equipId = tVDDataHourResult.getEquipid();
            controllerid = tVDDataHourResult.getControllerid();
            smallForward = tVDDataHourResult.getForward1();
            bigForward = tVDDataHourResult.getForward2() + tVDDataHourResult.getForward3()
                    + tVDDataHourResult.getForward4() + tVDDataHourResult.getForward5();
            smallAvgSpd = tVDDataHourResult.getAvgspd1();
            bigAvgSpd = bigForward == 0 ? 0
                    : (tVDDataHourResult.getForward2() * tVDDataHourResult.getAvgspd2()
                    + tVDDataHourResult.getForward3() * tVDDataHourResult.getAvgspd3()
                    + tVDDataHourResult.getForward4() * tVDDataHourResult.getAvgspd4()
                    + tVDDataHourResult.getForward5() * tVDDataHourResult.getAvgspd5()) / bigForward;
            allAvgSpd = smallForward + bigForward == 0 ? 0
                    : (bigForward * bigAvgSpd + smallForward * smallAvgSpd) / (smallForward + bigForward);
            smallOccupancy = tVDDataHourResult.getOccupancy1();
            bigOccupancy = tVDDataHourResult.getOccupancy2() + tVDDataHourResult.getOccupancy3()
                    + tVDDataHourResult.getOccupancy4() + tVDDataHourResult.getOccupancy5();
            allOccupancy = smallOccupancy + bigOccupancy;
            equipName = tVDDataHourResult.getControllername();
            equipType = tVDDataHourResult.getEquiptype();
            channel = tVDDataHourResult.getChannel();
            time = tVDDataHourResult.getGathertime();
            if (equipType == 1) {
                // 控制器
            } else if (equipType == 2) {
                // 线圈
                equipId = controllerid;
            }
            for (int j = 0; j < resultList.size(); j++) {
                if (equipName.equals(resultList.get(j).getEquipName())
                        && DateUtil.isSameDate(time, resultList.get(j).getGathertime())) {
                    formatCenterDataSetValue(resultList.get(j), controllerid, equipId, smallForward, bigForward,
                            smallAvgSpd, bigAvgSpd, allAvgSpd, smallOccupancy, bigOccupancy, allOccupancy, equipName,
                            equipType, channel, time);
                    break;
                } else if (j == resultList.size() - 1) {
                    tVDDataCenterResult = null;
                    tVDDataCenterResult = formatCenterDataSetValue(tVDDataCenterResult, controllerid, equipId,
                            smallForward, bigForward, smallAvgSpd, bigAvgSpd, allAvgSpd, smallOccupancy, bigOccupancy,
                            allOccupancy, equipName, equipType, channel, time);
                    resultList.add(tVDDataCenterResult);
                    break;
                }

            }
            if (resultList.size() == 0) {
                tVDDataCenterResult = null;
                tVDDataCenterResult = formatCenterDataSetValue(tVDDataCenterResult, controllerid, equipId, smallForward,
                        bigForward, smallAvgSpd, bigAvgSpd, allAvgSpd, smallOccupancy, bigOccupancy, allOccupancy,
                        equipName, equipType, channel, time);
                resultList.add(tVDDataCenterResult);
            }
        }
        return resultList;
    }

    /**
     * 设置信息中心返回数据
     *
     * @param tVDDataCenterResult
     * @param equipId
     * @param smallForward
     * @param bigForward
     * @param smallAvgSpd
     * @param bigAvgSpd
     * @param allAvgSpd
     * @param smallOccupancy
     * @param bigOccupancy
     * @param allOccupancy
     * @param equipName
     * @param equipType
     * @param channel
     * @return
     */
    private TVDDataCenterResult formatCenterDataSetValue(@NotNull TVDDataCenterResult tVDDataCenterResult,
                                                         String controllerid, String equipId, int smallForward, int bigForward, double smallAvgSpd, double bigAvgSpd,
                                                         double allAvgSpd, double smallOccupancy, double bigOccupancy, double allOccupancy, String equipName,
                                                         int equipType, int channel, Date time) {
        if (tVDDataCenterResult == null) {
            tVDDataCenterResult = new TVDDataCenterResult();
        }
        tVDDataCenterResult.setGathertime(time);
        // if (equipType == 1) {
        // // 控制器
        // tVDDataCenterResult.setEquipId(equipId);
        // } else if (equipType == 2) {
        // // 线圈
        // tVDDataCenterResult.setEquipId(controllerid);
        // }
        tVDDataCenterResult.setEquipName(equipName);
        // System.out.println("equipName=" + equipName);
        int oldASmallForward = tVDDataCenterResult.getaSmallForward();
        int oldBSmallForward = tVDDataCenterResult.getbSmallForward();
        int oldABigForward = tVDDataCenterResult.getaBigForward();
        int oldBBigForward = tVDDataCenterResult.getbBigForward();
        double oldASmallAvgSpd = tVDDataCenterResult.getaSmallAvgSpd();
        double oldBSmallAvgSpd = tVDDataCenterResult.getbSmallAvgSpd();
        double oldABigAvgSpd = tVDDataCenterResult.getaBigAvgSpd();
        double oldBBigAvgSpd = tVDDataCenterResult.getbBigAvgSpd();
        double oldASmallOccupancy = tVDDataCenterResult.getAsmallOccupancy();
        double oldBSmallOccupancy = tVDDataCenterResult.getBsmallOccupancy();
        double oldABigOccupancy = tVDDataCenterResult.getaBigOccupancy();
        double oldBBigOccupancy = tVDDataCenterResult.getbBigOccupancy();

        if (channel > 0) {
            if (channel % 2 == 0) {
                // B道
                // 小车车流量
                tVDDataCenterResult.setbSmallForward(smallForward + oldBSmallForward);
                // 大车车流量
                tVDDataCenterResult.setbBigForward(bigForward + oldBBigForward);
                // 全部车流量
                tVDDataCenterResult.setbAllForward(tVDDataCenterResult.getbSmallForward() + tVDDataCenterResult.getbBigForward());
                // 小车平均车速
                tVDDataCenterResult.setbSmallAvgSpd((smallForward + oldBSmallForward == 0) ? 0 : (BigDecimalUtil.add(BigDecimalUtil.multiply(smallAvgSpd, smallForward), BigDecimalUtil.multiply(oldBSmallAvgSpd, oldBSmallForward))) / (smallForward + oldBSmallForward));
                tVDDataCenterResult.setbSmallAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getbSmallAvgSpd())));
                // 大车平均车速
                tVDDataCenterResult.setbBigAvgSpd((bigForward + oldBBigForward == 0) ? 0 : (bigAvgSpd * bigForward + oldBBigAvgSpd * oldBBigForward) / (bigForward + oldBBigForward));
                tVDDataCenterResult.setbBigAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getbBigAvgSpd())));
                // 全部平均车速
                tVDDataCenterResult.setbAllAvgSpd((tVDDataCenterResult.getbSmallForward() + tVDDataCenterResult.getbBigForward() == 0) ? 0
                        : (tVDDataCenterResult.getbBigForward() * tVDDataCenterResult.getbBigAvgSpd() + tVDDataCenterResult.getbSmallForward() * tVDDataCenterResult.getbSmallAvgSpd()) / (tVDDataCenterResult.getbSmallForward() + tVDDataCenterResult.getbBigForward()));
                tVDDataCenterResult.setbAllAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getbAllAvgSpd())));
                // 小车占有率
                tVDDataCenterResult.setBsmallOccupancy(oldBSmallOccupancy == 0 ? smallOccupancy : (smallOccupancy + oldBSmallOccupancy) / 2);
                tVDDataCenterResult.setBsmallOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getBsmallOccupancy())));
                // 大车占有率
                tVDDataCenterResult.setbBigOccupancy(oldBBigOccupancy == 0 ? bigOccupancy : (bigOccupancy + oldBBigOccupancy) / 2);
                tVDDataCenterResult.setbBigOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getbBigOccupancy())));
                // 全部占有率
                tVDDataCenterResult.setbAllOccupancy(tVDDataCenterResult.getBsmallOccupancy() + tVDDataCenterResult.getbBigOccupancy());
                tVDDataCenterResult.setbAllOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getbAllOccupancy())));
            } else {
                // A道
                // 小车车流量
                tVDDataCenterResult.setaSmallForward(smallForward + oldASmallForward);
                // 大车车流量
                tVDDataCenterResult.setaBigForward(bigForward + oldABigForward);
                // 全部车流量
                tVDDataCenterResult.setaAllForward(tVDDataCenterResult.getaSmallForward() + tVDDataCenterResult.getaBigForward());

                // 小车平均车速
                tVDDataCenterResult.setaSmallAvgSpd((smallForward + oldASmallForward == 0) ? 0 : (BigDecimalUtil.divide(BigDecimalUtil.add(BigDecimalUtil.multiply(smallAvgSpd, smallForward), BigDecimalUtil.multiply(oldASmallAvgSpd, oldASmallForward)), (smallForward + oldASmallForward), 3)));
                tVDDataCenterResult.setaSmallAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getaSmallAvgSpd())));
                // 大车平均车速
                tVDDataCenterResult.setaBigAvgSpd((bigForward + oldABigForward == 0) ? 0 : (bigAvgSpd * bigForward + oldABigAvgSpd * oldABigForward) / (bigForward + oldABigForward));
                tVDDataCenterResult.setaBigAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getaBigAvgSpd())));
                // 全部平均车速
                tVDDataCenterResult.setaAllAvgSpd((tVDDataCenterResult.getaSmallForward() + tVDDataCenterResult.getaBigForward() == 0) ? 0
                        : (tVDDataCenterResult.getaBigForward() * tVDDataCenterResult.getaBigAvgSpd() + tVDDataCenterResult.getaSmallForward() * tVDDataCenterResult.getaSmallAvgSpd()) / (tVDDataCenterResult.getaSmallForward() + tVDDataCenterResult.getaBigForward()));
                tVDDataCenterResult.setaAllAvgSpd(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getaAllAvgSpd())));
                // 小车占有率
                tVDDataCenterResult.setAsmallOccupancy(oldASmallOccupancy == 0 ? smallOccupancy : (smallOccupancy + oldASmallOccupancy) / 2);
                tVDDataCenterResult.setAsmallOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getAsmallOccupancy())));
                // 大车占有率
                tVDDataCenterResult.setaBigOccupancy(oldABigOccupancy == 0 ? bigOccupancy : (bigOccupancy + oldABigOccupancy) / 2);
                tVDDataCenterResult.setaBigOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getaBigOccupancy())));
                // 全部占有率
                tVDDataCenterResult.setaAllOccupancy(tVDDataCenterResult.getAsmallOccupancy() + tVDDataCenterResult.getaBigOccupancy());
                tVDDataCenterResult.setaAllOccupancy(Double.parseDouble(mDecimalFormat.format(tVDDataCenterResult.getaAllOccupancy())));
            }
        }
        return tVDDataCenterResult;
    }

    /**
     * 导出日报表
     *
     * @return
     */
    @RequestMapping(value = "/hour/export")
    public void exportHourList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取数据
        String dateString = request.getParameter("date");
        System.out.println("dateString=" + dateString);
        String regionCode = request.getParameter("regionCode");
        System.out.println("regionCode=" + regionCode);
        String prefixLength = request.getParameter("PrefixLength");
        System.out.println("prefixLength=" + prefixLength);
        List<TVDDataStationHourResult> list = this.tvdDataService.selectHourList(regionCode, dateString, prefixLength);

        String printer = request.getParameter("printer");

        // excel标题
        String[][] title = {{"车辆检测器车流量参数日报表"}, {dateString}, {"制表人：" + printer},
                {"车辆检测器断面位置", "每小时流量（单位：辆，负数表示异常数据）", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                        "", "", "", "", "", "", "", "车流量总数"},
                {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                        "18", "19", "20", "21", "22", "23", ""}};

        // excel文件名
        String fileName = "车辆检测器车流量参数日报表" + ".xls";

        // sheet名
        String sheetName = "车辆检测器车流量参数日报表";

        String[][] content = new String[list.size()][title.length];
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        TVDDataStationHourResult tVDDataHourResult;
        int forward;
        String equipName;
        Date time;
        for (int i = 0; i < list.size(); i++) {
            tVDDataHourResult = list.get(i);
            forward = tVDDataHourResult.getForward();
            equipName = tVDDataHourResult.getEquipname();
            time = tVDDataHourResult.getGathertime();
            for (int j = 0; j < jsonArray.size(); j++) {
                if (equipName.equals(jsonArray.getJSONObject(j).getString("equipName"))) {
                    jsonArray.getJSONObject(j).put(String.valueOf(time.getHours()), forward);
                    break;
                } else if (j == jsonArray.size() - 1) {
                    jsonObject = new JSONObject();
                    jsonObject.put("equipName", equipName);
                    jsonObject.put(String.valueOf(time.getHours()), forward);
                    jsonArray.add(jsonObject);
                }

            }
            if (jsonArray.size() == 0) {
                jsonObject = new JSONObject();
                jsonObject.put("equipName", equipName);
                jsonObject.put(String.valueOf(time.getHours()), forward);
                jsonArray.add(jsonObject);
            }
        }
        String[][] array = new String[jsonArray.size()][];
        int total;
        for (int k = 0; k < jsonArray.size(); k++) {
            array[k] = new String[26];
            array[k][0] = jsonArray.getJSONObject(k).getString("equipName");
            total = 0;
            for (int l = 0; l < 24; l++) {
                total += jsonArray.getJSONObject(k).getIntValue(String.valueOf(l));
                array[k][l + 1] = String.valueOf(jsonArray.getJSONObject(k).getInteger(String.valueOf(l)));
            }
            array[k][25] = String.valueOf(total);
        }
        CellRangeAddress[] regions = new CellRangeAddress[6];
        regions[0] = new CellRangeAddress(3, 4, 0, 0);
        regions[1] = new CellRangeAddress(3, 3, 1, 24);
        regions[2] = new CellRangeAddress(3, 4, 25, 25);
        regions[3] = new CellRangeAddress(0, 0, 0, 25);
        regions[4] = new CellRangeAddress(1, 1, 0, 25);
        regions[5] = new CellRangeAddress(2, 2, 0, 25);
        // 创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, array, regions, null);

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
    }

    /**
     * 导出月报表
     *
     * @return
     */
    @RequestMapping(value = "/day/export")
    public void exportDayList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取数据
        String dateString = request.getParameter("date");
        System.out.println("dateString=" + dateString);
        String regionCode = request.getParameter("regionCode");
        System.out.println("regionCode=" + regionCode);
        String prefixLength = request.getParameter("PrefixLength");
        System.out.println("prefixLength=" + prefixLength);
        List<TVDDataDayResult> list = this.tvdDataService.selectDayList(regionCode, dateString, prefixLength);

        String printer = request.getParameter("printer");

        // excel标题
        String[][] title = {{"车辆检测器车流量参数月报表"}, {dateString.substring(0, 7)}, {"制表人：" + printer},
                {"车辆检测器断面位置", "每日流量（单位：辆，负数表示异常数据）", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "车流量总数"},
                {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
                        "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", ""}};

        // excel文件名
        String fileName = "车辆检测器车流量参数月报表" + ".xls";

        // sheet名
        String sheetName = "车辆检测器车流量参数月报表";

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        TVDDataDayResult tVDDataDayResult;
        String equipName;
        Date time;
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < list.size(); i++) {
            tVDDataDayResult = list.get(i);
            equipName = tVDDataDayResult.getEquipname();
            time = tVDDataDayResult.getGatherdate();
            calendar.setTime(time);
            for (int j = 0; j < jsonArray.size(); j++) {
                if (equipName.equals(jsonArray.getJSONObject(j).getString("equipName"))) {
                    jsonArray.getJSONObject(j).put(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),
                            tVDDataDayResult.getForward());
                    break;
                } else if (j == jsonArray.size() - 1) {
                    jsonObject = new JSONObject();
                    jsonObject.put("equipName", equipName);
                    jsonObject.put(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), tVDDataDayResult.getForward());
                    jsonArray.add(jsonObject);
                }

            }
            if (jsonArray.size() == 0) {
                jsonObject = new JSONObject();
                jsonObject.put("equipName", equipName);
                jsonObject.put(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), tVDDataDayResult.getForward());
                jsonArray.add(jsonObject);
            }
        }
        String[][] array = new String[jsonArray.size()][];
        int total;
        for (int k = 0; k < jsonArray.size(); k++) {
            array[k] = new String[33];
            array[k][0] = jsonArray.getJSONObject(k).getString("equipName");
//            System.out.print(jsonArray.getJSONObject(k).getString("equipName") + " ");
            total = 0;
            for (int l = 0; l < 31; l++) {
                total += jsonArray.getJSONObject(k).getIntValue(String.valueOf(l + 1));
                array[k][l + 1] = String.valueOf(jsonArray.getJSONObject(k).getInteger(String.valueOf(l + 1)));
//                System.out.print(
//                        l + ":" + String.valueOf(jsonArray.getJSONObject(k).getInteger(String.valueOf(l + 1))) + " ");
            }
            array[k][32] = String.valueOf(total);
//            System.out.print(String.valueOf(total) + " ");
//            System.out.println();
        }

        CellRangeAddress[] regions = new CellRangeAddress[6];
        regions[0] = new CellRangeAddress(3, 4, 0, 0);
        regions[1] = new CellRangeAddress(3, 3, 1, 31);
        regions[2] = new CellRangeAddress(3, 4, 32, 32);
        regions[3] = new CellRangeAddress(0, 0, 0, 32);
        regions[4] = new CellRangeAddress(1, 1, 0, 32);
        regions[5] = new CellRangeAddress(2, 2, 0, 32);
        // 创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, array, regions, null);

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
    }

    /**
     * 导出年报表
     *
     * @return
     */
    @RequestMapping(value = "/month/export")
    public void exportMonthList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取数据
        String dateString = request.getParameter("date");
        System.out.println("dateString=" + dateString);
        String regionCode = request.getParameter("regionCode");
        System.out.println("regionCode=" + regionCode);
        String prefixLength = request.getParameter("PrefixLength");
        System.out.println("prefixLength=" + prefixLength);
        List<TVDDataDayResult> list = this.tvdDataService.selectMonthList(regionCode, dateString, prefixLength);

        String printer = request.getParameter("printer");

        // excel标题
        String[][] title = {{"车辆检测器车流量参数年报表"}, {dateString.substring(0, 4)}, {"制表人：" + printer},
                {"车辆检测器断面位置", "每月流量（单位：辆，负数表示异常数据）", "", "", "", "", "", "", "", "", "", "", "", "车流量总数"},
                {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", ""}};

        // excel文件名
        String fileName = "车辆检测器车流量参数年报表" + ".xls";

        // sheet名
        String sheetName = "车辆检测器车流量参数年报表";

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        TVDDataDayResult tVDDataDayResult;
        String equipName;
        Date time;
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < list.size(); i++) {
            tVDDataDayResult = list.get(i);
            equipName = tVDDataDayResult.getEquipname();
            time = tVDDataDayResult.getGatherdate();
            calendar.setTime(time);
            if ("官田隧道右洞入口VD1A道主车道".equals(equipName)) {
                System.out.println("官田隧道右洞入口VD1A道主车道===forward=" + tVDDataDayResult.getForward());
            }
            for (int j = 0; j < jsonArray.size(); j++) {
                if (equipName.equals(jsonArray.getJSONObject(j).getString("equipName"))) {
                    if (jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH))) != null) {
                        if ("官田隧道右洞入口VD1A道主车道".equals(equipName)) {
                            System.out.println("4===官田隧道右洞入口VD1A道主车道===jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH))))=" +
                                    (jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH)))));
                            System.out.println("4===官田隧道右洞入口VD1A道主车道===tVDDataDayResult.getForward()=" +
                                    (tVDDataDayResult.getForward()));
                            System.out.println("4===官田隧道右洞入口VD1A道主车道===jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH)))\n" +
                                    "                                            + tVDDataDayResult.getForward()=" +
                                    (jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH)))
                                            + tVDDataDayResult.getForward()));
                        }
                        jsonArray.getJSONObject(j).replace(String.valueOf(calendar.get(Calendar.MONTH)),
                                jsonArray.getJSONObject(j).getInteger(String.valueOf(calendar.get(Calendar.MONTH)))
                                        + tVDDataDayResult.getForward());
                    } else {
                        jsonArray.getJSONObject(j).put(String.valueOf(calendar.get(Calendar.MONTH)),
                                tVDDataDayResult.getForward());
                        if ("官田隧道右洞入口VD1A道主车道".equals(equipName)) {
                            System.out.println("3===官田隧道右洞入口VD1A道主车道===forward=" + tVDDataDayResult.getForward());
                        }
                    }
                    break;
                } else if (j == jsonArray.size() - 1) {
                    jsonObject = new JSONObject();
                    jsonObject.put("equipName", equipName);
                    jsonObject.put(String.valueOf(calendar.get(Calendar.MONTH)), tVDDataDayResult.getForward());
                    jsonArray.add(jsonObject);
                    if ("官田隧道右洞入口VD1A道主车道".equals(equipName)) {
                        System.out.println("2===官田隧道右洞入口VD1A道主车道===forward=" + tVDDataDayResult.getForward());
                    }
                    break;
                }

            }
            if (jsonArray.size() == 0) {
                jsonObject = new JSONObject();
                jsonObject.put("equipName", equipName);
                jsonObject.put(String.valueOf(calendar.get(Calendar.MONTH)), tVDDataDayResult.getForward());
                jsonArray.add(jsonObject);
                if ("官田隧道右洞入口VD1A道主车道".equals(equipName)) {
                    System.out.println("1===官田隧道右洞入口VD1A道主车道===forward=" + tVDDataDayResult.getForward());
                }
            }
        }
        String[][] array = new String[jsonArray.size()][];
        int total;
        for (int k = 0; k < jsonArray.size(); k++) {
            array[k] = new String[14];
            array[k][0] = jsonArray.getJSONObject(k).getString("equipName");
//            System.out.print(jsonArray.getJSONObject(k).getString("equipName") + " ");
            total = 0;
            for (int l = 0; l < 12; l++) {
                total += jsonArray.getJSONObject(k).getIntValue(String.valueOf(l));
                array[k][l + 1] = String.valueOf(jsonArray.getJSONObject(k).getInteger(String.valueOf(l)));
//                System.out.print(
//                        l + ":" + String.valueOf(jsonArray.getJSONObject(k).getInteger(String.valueOf(l))) + " ");
            }
            array[k][13] = String.valueOf(total);
//            System.out.print(String.valueOf(total) + " ");
//            System.out.println();
        }

        CellRangeAddress[] regions = new CellRangeAddress[6];
        regions[0] = new CellRangeAddress(3, 4, 0, 0);
        regions[1] = new CellRangeAddress(3, 3, 1, 12);
        regions[2] = new CellRangeAddress(3, 4, 13, 13);
        regions[3] = new CellRangeAddress(0, 0, 0, 13);
        regions[4] = new CellRangeAddress(1, 1, 0, 13);
        regions[5] = new CellRangeAddress(2, 2, 0, 13);
        // 创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, array, regions, null);

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
    }

    /**
     * 导出信息中心报表
     *
     * @return
     */
    @RequestMapping(value = "/center/export")
    public void exportCenterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取数据
        String dateString = request.getParameter("date");
        System.out.println("dateString=" + dateString);
//        String regionCode = request.getParameter("regionCode");
//        System.out.println("regionCode=" + regionCode);
//        String prefixLength = request.getParameter("PrefixLength");
//        System.out.println("prefixLength=" + prefixLength);
        String routeCode = request.getParameter("route_code");
        System.out.println("routeCode=" + routeCode);
        String equipId = request.getParameter("equip_id");
        System.out.println("equipId=" + equipId);
        String regionId = request.getParameter("region_id");
        Map<String, Object> map = new HashMap<>();
        List<TRegionInfo> regionList = new ArrayList<>();
        TRegionInfo tRegionInfo = RegionManager.getInstance().getRegionInfoById(tRegionService, regionId);
        regionList.addAll(RegionManager.getInstance().selectPublicRegionList(tRegionService, regionId));
        regionList.add(tRegionInfo);
        List<TVDDataHourResult> list = new ArrayList<>();
        for (TRegionInfo regionInfo : regionList) {
            System.out.println("regionInfo=" + regionInfo);
            map.clear();
            map.put("regionCode", regionInfo == null ? null : regionInfo.getRegioncode());
            map.put("prefixLength", regionInfo == null ? null : regionInfo.getPrefixlength());
            map.put("date", dateString);
            map.put("routeCode", routeCode);
            map.put("equipId", equipId);
            list.addAll(tvdDataService.selectCenterList(map));
        }

        String printer = request.getParameter("printer");

        // excel标题
        String[][] title = {{"车检器数据报表"}, {dateString}, {"制表人：" + printer},
                {"车检器名称", "采集时间（每小时记录）", "A向车流量（单位：辆）", "", "", "B向车流量（单位：辆）", "", "", "A向平均车速（单位：KM/H）", "", "",
                        "B向平均车速（单位：KM/H）", "", "", "A向占有率（单位：%）", "", "", "B向占有率（单位：%）", "", ""},
                {"", "", "全部", "小车", "大车", "全部", "小车", "大车", "全部", "小车", "大车", "全部", "小车", "大车", "全部", "小车", "大车",
                        "全部", "小车", "大车"}};

        // excel文件名
        String fileName = "车检器数据报表" + ".xls";

        // sheet名
        String sheetName = "车检器数据报表";

        List<TVDDataCenterResult> list2 = formatCenterData(list);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String[][] array = new String[list2.size()][];
        for (int k = 0; k < list2.size(); k++) {
            array[k] = new String[20];
            array[k][0] = list2.get(k).getEquipName();
            array[k][1] = sdf.format(list2.get(k).getGathertime());
            array[k][2] = String.valueOf(list2.get(k).getaAllForward());
            array[k][3] = String.valueOf(list2.get(k).getaSmallForward());
            array[k][4] = String.valueOf(list2.get(k).getaBigForward());
            array[k][5] = String.valueOf(list2.get(k).getbAllForward());
            array[k][6] = String.valueOf(list2.get(k).getbSmallForward());
            array[k][7] = String.valueOf(list2.get(k).getbBigForward());
            array[k][8] = String.valueOf(list2.get(k).getaAllAvgSpd());
            array[k][9] = String.valueOf(list2.get(k).getaSmallAvgSpd());
            array[k][10] = String.valueOf(list2.get(k).getaBigAvgSpd());
            array[k][11] = String.valueOf(list2.get(k).getbAllAvgSpd());
            array[k][12] = String.valueOf(list2.get(k).getbSmallAvgSpd());
            array[k][13] = String.valueOf(list2.get(k).getbBigAvgSpd());
            array[k][14] = String.valueOf(list2.get(k).getaAllOccupancy());
            array[k][15] = String.valueOf(list2.get(k).getAsmallOccupancy());
            array[k][16] = String.valueOf(list2.get(k).getaBigOccupancy());
            array[k][17] = String.valueOf(list2.get(k).getbAllOccupancy());
            array[k][18] = String.valueOf(list2.get(k).getBsmallOccupancy());
            array[k][19] = String.valueOf(list2.get(k).getbBigOccupancy());
        }
        CellRangeAddress[] regions = new CellRangeAddress[11];
        regions[0] = new CellRangeAddress(3, 4, 0, 0);
        regions[1] = new CellRangeAddress(3, 4, 1, 1);
        regions[2] = new CellRangeAddress(3, 3, 2, 4);
        regions[3] = new CellRangeAddress(0, 0, 0, 19);
        regions[4] = new CellRangeAddress(1, 1, 0, 19);
        regions[5] = new CellRangeAddress(3, 3, 5, 7);
        regions[6] = new CellRangeAddress(3, 3, 8, 10);
        regions[7] = new CellRangeAddress(3, 3, 11, 13);
        regions[8] = new CellRangeAddress(3, 3, 14, 16);
        regions[9] = new CellRangeAddress(3, 3, 17, 19);
        regions[10] = new CellRangeAddress(2, 2, 0, 19);
        // 创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getComplexWorkbook(sheetName, title, array, regions, null);

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
    }

}
