package com.mgskj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mgskj.model.TEquipFaultData;

public interface TEquipFaultDataMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    int insert(TEquipFaultData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    int insertSelective(TEquipFaultData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    TEquipFaultData selectByPrimaryKey(String id);


    List<TEquipFaultData> selectEquipFault(@Param("map") Map<String, Object> map);

    List<TEquipFaultData> selectModule(@Param("map") Map<String, Object> map);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TEquipFaultData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_EquipFault_Data
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TEquipFaultData record);
}