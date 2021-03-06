package com.mgskj.model;

import java.io.Serializable;
import java.util.Date;

public class HTOrganizationInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.OrgId
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.ParentId
     *
     * @mbggenerated
     */
    private String parentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.OrgType
     *
     * @mbggenerated
     */
    private Integer orgtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.OrganizationName
     *
     * @mbggenerated
     */
    private String organizationname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.GISX
     *
     * @mbggenerated
     */
    private Double gisx;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.GISY
     *
     * @mbggenerated
     */
    private Double gisy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.DeviceID
     *
     * @mbggenerated
     */
    private Integer deviceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.RealDeviceID
     *
     * @mbggenerated
     */
    private Integer realdeviceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.UserID
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.IsUse
     *
     * @mbggenerated
     */
    private Boolean isuse;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_OrganizationInfo.Reserve
     *
     * @mbggenerated
     */
    private String reserve;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_OrganizationInfo
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.OrgId
     *
     * @return the value of T_OrganizationInfo.OrgId
     *
     * @mbggenerated
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.OrgId
     *
     * @param orgid the value for T_OrganizationInfo.OrgId
     *
     * @mbggenerated
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.ParentId
     *
     * @return the value of T_OrganizationInfo.ParentId
     *
     * @mbggenerated
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.ParentId
     *
     * @param parentid the value for T_OrganizationInfo.ParentId
     *
     * @mbggenerated
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.OrgType
     *
     * @return the value of T_OrganizationInfo.OrgType
     *
     * @mbggenerated
     */
    public Integer getOrgtype() {
        return orgtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.OrgType
     *
     * @param orgtype the value for T_OrganizationInfo.OrgType
     *
     * @mbggenerated
     */
    public void setOrgtype(Integer orgtype) {
        this.orgtype = orgtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.OrganizationName
     *
     * @return the value of T_OrganizationInfo.OrganizationName
     *
     * @mbggenerated
     */
    public String getOrganizationname() {
        return organizationname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.OrganizationName
     *
     * @param organizationname the value for T_OrganizationInfo.OrganizationName
     *
     * @mbggenerated
     */
    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.GISX
     *
     * @return the value of T_OrganizationInfo.GISX
     *
     * @mbggenerated
     */
    public Double getGisx() {
        return gisx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.GISX
     *
     * @param gisx the value for T_OrganizationInfo.GISX
     *
     * @mbggenerated
     */
    public void setGisx(Double gisx) {
        this.gisx = gisx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.GISY
     *
     * @return the value of T_OrganizationInfo.GISY
     *
     * @mbggenerated
     */
    public Double getGisy() {
        return gisy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.GISY
     *
     * @param gisy the value for T_OrganizationInfo.GISY
     *
     * @mbggenerated
     */
    public void setGisy(Double gisy) {
        this.gisy = gisy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.DeviceID
     *
     * @return the value of T_OrganizationInfo.DeviceID
     *
     * @mbggenerated
     */
    public Integer getDeviceid() {
        return deviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.DeviceID
     *
     * @param deviceid the value for T_OrganizationInfo.DeviceID
     *
     * @mbggenerated
     */
    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.RealDeviceID
     *
     * @return the value of T_OrganizationInfo.RealDeviceID
     *
     * @mbggenerated
     */
    public Integer getRealdeviceid() {
        return realdeviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.RealDeviceID
     *
     * @param realdeviceid the value for T_OrganizationInfo.RealDeviceID
     *
     * @mbggenerated
     */
    public void setRealdeviceid(Integer realdeviceid) {
        this.realdeviceid = realdeviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.UserID
     *
     * @return the value of T_OrganizationInfo.UserID
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.UserID
     *
     * @param userid the value for T_OrganizationInfo.UserID
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.IsUse
     *
     * @return the value of T_OrganizationInfo.IsUse
     *
     * @mbggenerated
     */
    public Boolean getIsuse() {
        return isuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.IsUse
     *
     * @param isuse the value for T_OrganizationInfo.IsUse
     *
     * @mbggenerated
     */
    public void setIsuse(Boolean isuse) {
        this.isuse = isuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.CreateTime
     *
     * @return the value of T_OrganizationInfo.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.CreateTime
     *
     * @param createtime the value for T_OrganizationInfo.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_OrganizationInfo.Reserve
     *
     * @return the value of T_OrganizationInfo.Reserve
     *
     * @mbggenerated
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_OrganizationInfo.Reserve
     *
     * @param reserve the value for T_OrganizationInfo.Reserve
     *
     * @mbggenerated
     */
    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_OrganizationInfo
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HTOrganizationInfo other = (HTOrganizationInfo) that;
        return (this.getOrgid() == null ? other.getOrgid() == null : this.getOrgid().equals(other.getOrgid()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getOrgtype() == null ? other.getOrgtype() == null : this.getOrgtype().equals(other.getOrgtype()))
            && (this.getOrganizationname() == null ? other.getOrganizationname() == null : this.getOrganizationname().equals(other.getOrganizationname()))
            && (this.getGisx() == null ? other.getGisx() == null : this.getGisx().equals(other.getGisx()))
            && (this.getGisy() == null ? other.getGisy() == null : this.getGisy().equals(other.getGisy()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getRealdeviceid() == null ? other.getRealdeviceid() == null : this.getRealdeviceid().equals(other.getRealdeviceid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getIsuse() == null ? other.getIsuse() == null : this.getIsuse().equals(other.getIsuse()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_OrganizationInfo
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgid() == null) ? 0 : getOrgid().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getOrgtype() == null) ? 0 : getOrgtype().hashCode());
        result = prime * result + ((getOrganizationname() == null) ? 0 : getOrganizationname().hashCode());
        result = prime * result + ((getGisx() == null) ? 0 : getGisx().hashCode());
        result = prime * result + ((getGisy() == null) ? 0 : getGisy().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getRealdeviceid() == null) ? 0 : getRealdeviceid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getIsuse() == null) ? 0 : getIsuse().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_OrganizationInfo
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgid=").append(orgid);
        sb.append(", parentid=").append(parentid);
        sb.append(", orgtype=").append(orgtype);
        sb.append(", organizationname=").append(organizationname);
        sb.append(", gisx=").append(gisx);
        sb.append(", gisy=").append(gisy);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", realdeviceid=").append(realdeviceid);
        sb.append(", userid=").append(userid);
        sb.append(", isuse=").append(isuse);
        sb.append(", createtime=").append(createtime);
        sb.append(", reserve=").append(reserve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}