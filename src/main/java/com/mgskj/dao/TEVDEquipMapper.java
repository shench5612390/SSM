package com.mgskj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mgskj.bean.ETEquipResult;
import com.mgskj.model.TEVDEquip;
import com.mgskj.model.TRegionInfo;

public interface TEVDEquipMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int insert(TEVDEquip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int insertSelective(TEVDEquip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	TEVDEquip selectByPrimaryKey(String id);

	List<ETEquipResult> selectEVDEquip(@Param("map") Map<String, Object> map);

	List<TRegionInfo> selectRegionName();

	List<TEVDEquip> selectEquipName(@Param("routeCode") String routeCode, @Param("regionId") String regionId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(TEVDEquip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(TEVDEquip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table T_EVD_Equip
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(TEVDEquip record);
}