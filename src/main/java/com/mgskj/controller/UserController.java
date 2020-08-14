package com.mgskj.controller;

import com.mgskj.bean.BaseResult;
import com.mgskj.manager.RegionManager;
import com.mgskj.manager.UserManager;
import com.mgskj.model.TRegionInfo;
import com.mgskj.model.UserName;
import com.mgskj.service.IFilterService;
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
import java.util.List;

/**
 * 用户
 *
 * @author shenchanghui
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IFilterService filterService;

    /**
     * 区域数据
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
//    @RequestMapping(value = "/getusernamebyid", method = {RequestMethod.POST, RequestMethod.GET})
//    public @ResponseBody
//    BaseResult<String> getUserNameById(HttpServletRequest request,
//                                       HttpServletResponse response) throws IOException {
//        BaseResult<String> result = new BaseResult();
//        try {
//            String userId = request.getParameter("user_id");
//            String userName = UserManager.getInstance().getUserNameById(filterService, userId);
//            result.setCode(1);
//            result.setMsg("获取成功");
//            result.setData(userName);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setCode(0);
//            result.setMsg("获取失败");
//        }
//
//        return result;
//    }

}
