package com.mgskj.service.impl;

import com.mgskj.bean.*;
import com.mgskj.dao.TOperationLogWMapper;
import com.mgskj.service.IOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 过滤条件
 *
 * @author shenchanghui
 */
@Service("operationService")
public class OperationServiceImpl implements IOperationService {
    @Resource
    private TOperationLogWMapper TOperationLogWMapper;

    @Override
    public List<BoardOperationResult> getBoardOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getBoardOperationList(map);
    }

    @Override
    public List<ETOperationResult> getETOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getETOperationList(map);
    }

    @Override
    public List<EVDOperationResult> getEVDOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getEVDOperationList(map);
    }

    @Override
    public List<FAOperationResult> getFAOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getFAOperationList(map);
    }

    @Override
    public List<TOperationLogWResult> getLoginOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getLoginOperationList(map);
    }

    @Override
    public List<TOperationLogWResult> getTunnelOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getTunnelOperationList(map);
    }

    @Override
    public List<TOperationLogWResult> getAlarmLinkOperationList(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return TOperationLogWMapper.getAlarmLinkOperationList(map);
    }

}
