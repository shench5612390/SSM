package com.mgskj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mgskj.model.TCMSEquip;

public interface TCMSEquipMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int insert(TCMSEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int insertSelective(TCMSEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    TCMSEquip selectByPrimaryKey(String id);

    /**
     * 设备名称
     *
     * @return
     */
    List<TCMSEquip> selectEquipNameList(@Param("routeCode") String routeCode, @Param("boardType") String boardType);

    /**
     * 情报板设备
     *
     * @return
     */
    List<TCMSEquip> selectCMSEquip(@Param("map") Map<String, Object> map);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TCMSEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TCMSEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TCMSEquip record);

}