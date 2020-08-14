package com.mgskj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mgskj.model.TVDEquip;

public interface TVDEquipMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int insert(TVDEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int insertSelective(TVDEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    TVDEquip selectByPrimaryKey(String id);

    List<TVDEquip> selectRouteCode(@Param("map") Map<String, Object> map);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TVDEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TVDEquip record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TVDEquip record);
}