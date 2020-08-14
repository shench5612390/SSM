package com.mgskj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mgskj.dao.TVDEquipMapper;
import com.mgskj.model.TVDEquip;
import com.mgskj.service.ITVDDataFilterService;

/**
 * 过滤条件
 * 
 * @author shenchanghui
 *
 */
@Service("tvdFilterService")
public class TVDDataFilterServiceImpl implements ITVDDataFilterService {
	@Resource
	private TVDEquipMapper tVDEquipMapper;

	@Override
	public List<TVDEquip> getTVDRouteCode(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return tVDEquipMapper.selectRouteCode(map);
	}

}
