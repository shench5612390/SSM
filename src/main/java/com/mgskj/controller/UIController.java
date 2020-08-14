package com.mgskj.controller;

import com.mgskj.service.IEquipFaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class UIController {
    private static Logger log = LoggerFactory.getLogger(UIController.class);

    @Resource
    private IEquipFaultService equipFaultService;

    /**
     * 跳转到报表首页
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    public String jumpToHome(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map)
            throws IOException {
        String tableType = request.getParameter("table_type");
        String regionId = request.getParameter("region_id");
        String userName = request.getParameter("user_name");
        userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
        System.out.println("userName=" + userName);
        map.put("tabletype", tableType);
        map.put("regionid", regionId);
        map.put("username", userName);
        if ("0".equals(tableType)) {
            // 设备故障报表
            return "equipfault";
        } else if ("1".equals(tableType)) {
            // 机维站车检器报表
            return "stationvddata";
        } else if ("2".equals(tableType)) {
            // 信息中心车检器报表
            return "centervddata";
        } else if ("3".equals(tableType)) {
            // 操作日志报表
            return "operation";
        } else if ("4".equals(tableType)) {
            // 报警联动设置操作报表
            return "alarmlink";
        }
        return "equipfault";
    }

}
