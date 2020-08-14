package com.mgskj.service;

import com.mgskj.model.TVDEquip;

import java.util.List;
import java.util.Map;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
public interface ITVDDataFilterService {
    // 车检器线号
    List<TVDEquip> getTVDRouteCode(Map<String,Object> map);
}
