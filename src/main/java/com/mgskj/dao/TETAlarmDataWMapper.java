package com.mgskj.dao;

import com.mgskj.model.TETAlarmDataW;

public interface TETAlarmDataWMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    int insert(TETAlarmDataW record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    int insertSelective(TETAlarmDataW record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    TETAlarmDataW selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TETAlarmDataW record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ET_AlarmDataW
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TETAlarmDataW record);
}