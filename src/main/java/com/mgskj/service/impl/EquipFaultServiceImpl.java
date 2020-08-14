package com.mgskj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mgskj.dao.TEquipFaultDataMapper;
import com.mgskj.model.TEquipFaultData;
import com.mgskj.service.IEquipFaultService;

/**
 * 设备故障
 *
 * @author shenchanghui
 */
@Service("equipFaultService")
public class EquipFaultServiceImpl implements IEquipFaultService {
    @Resource
    private TEquipFaultDataMapper equipFaultDataMapper;

    @Override
    public List<TEquipFaultData> selectEquipFault(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return equipFaultDataMapper.selectEquipFault(map);
    }

    @Override
    public List<TEquipFaultData> selectModule(Map<String, Object> map) {
        return equipFaultDataMapper.selectModule(map);
    }

}
