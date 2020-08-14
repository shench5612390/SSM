package com.mgskj.manager;

import com.mgskj.model.TRegionInfo;
import com.mgskj.model.UserName;
import com.mgskj.service.IFilterService;

import java.util.List;

public class UserManager {
    // 机维站列表
    private List<TRegionInfo> mStationList;

    private static class SingletonHolder {
        private static final UserManager INSTANCE = new UserManager();
    }

    private UserManager() {
    }

    public static UserManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 根据id获取用户名
     *
     * @return
     */
    public String getUserNameById(IFilterService filterService, String id) {
        UserName userName = filterService.selectUserNameById(id);
        return userName == null ? null : userName.getRealname();
    }
}
