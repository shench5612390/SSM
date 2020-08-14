package com.mgskj.service;

import java.util.List;
import java.util.Map;

import com.mgskj.model.TEquipFaultData;

/**
 * 设备故障
 *
 * @author shenchanghui
 */
public interface IEquipFaultService {
    List<TEquipFaultData> selectEquipFault(Map<String, Object> map);

    List<TEquipFaultData> selectModule(Map<String, Object> map);
}
