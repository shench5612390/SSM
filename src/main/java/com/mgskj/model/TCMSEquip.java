package com.mgskj.model;

import java.io.Serializable;
import java.util.Date;

public class TCMSEquip implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.RegionId
     *
     * @mbggenerated
     */
    private String regionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.EquipName
     *
     * @mbggenerated
     */
    private String equipname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    private Integer physicalequiptype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.RouteCode
     *
     * @mbggenerated
     */
    private String routecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Mile
     *
     * @mbggenerated
     */
    private String mile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Channel
     *
     * @mbggenerated
     */
    private Integer channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Width
     *
     * @mbggenerated
     */
    private Integer width;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Height
     *
     * @mbggenerated
     */
    private Integer height;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Port
     *
     * @mbggenerated
     */
    private Integer port;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    private Integer serialportnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.BaudRate
     *
     * @mbggenerated
     */
    private Integer baudrate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.Parity
     *
     * @mbggenerated
     */
    private Integer parity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.DataBits
     *
     * @mbggenerated
     */
    private Integer databits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.StopBits
     *
     * @mbggenerated
     */
    private Integer stopbits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.BusinessCategory
     *
     * @mbggenerated
     */
    private String businesscategory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.ProtocolId
     *
     * @mbggenerated
     */
    private Integer protocolid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.IsDeleted
     *
     * @mbggenerated
     */
    private Boolean isdeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.InUse
     *
     * @mbggenerated
     */
    private Boolean inuse;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.CreateDate
     *
     * @mbggenerated
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_CMS_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    private byte[] concurrencytoken;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Id
     *
     * @return the value of T_CMS_Equip.Id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Id
     *
     * @param id the value for T_CMS_Equip.Id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.RegionId
     *
     * @return the value of T_CMS_Equip.RegionId
     *
     * @mbggenerated
     */
    public String getRegionid() {
        return regionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.RegionId
     *
     * @param regionid the value for T_CMS_Equip.RegionId
     *
     * @mbggenerated
     */
    public void setRegionid(String regionid) {
        this.regionid = regionid == null ? null : regionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.EquipName
     *
     * @return the value of T_CMS_Equip.EquipName
     *
     * @mbggenerated
     */
    public String getEquipname() {
        return equipname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.EquipName
     *
     * @param equipname the value for T_CMS_Equip.EquipName
     *
     * @mbggenerated
     */
    public void setEquipname(String equipname) {
        this.equipname = equipname == null ? null : equipname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.PhysicalEquipType
     *
     * @return the value of T_CMS_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    public Integer getPhysicalequiptype() {
        return physicalequiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.PhysicalEquipType
     *
     * @param physicalequiptype the value for T_CMS_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    public void setPhysicalequiptype(Integer physicalequiptype) {
        this.physicalequiptype = physicalequiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.RouteCode
     *
     * @return the value of T_CMS_Equip.RouteCode
     *
     * @mbggenerated
     */
    public String getRoutecode() {
        return routecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.RouteCode
     *
     * @param routecode the value for T_CMS_Equip.RouteCode
     *
     * @mbggenerated
     */
    public void setRoutecode(String routecode) {
        this.routecode = routecode == null ? null : routecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Mile
     *
     * @return the value of T_CMS_Equip.Mile
     *
     * @mbggenerated
     */
    public String getMile() {
        return mile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Mile
     *
     * @param mile the value for T_CMS_Equip.Mile
     *
     * @mbggenerated
     */
    public void setMile(String mile) {
        this.mile = mile == null ? null : mile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Channel
     *
     * @return the value of T_CMS_Equip.Channel
     *
     * @mbggenerated
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Channel
     *
     * @param channel the value for T_CMS_Equip.Channel
     *
     * @mbggenerated
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Width
     *
     * @return the value of T_CMS_Equip.Width
     *
     * @mbggenerated
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Width
     *
     * @param width the value for T_CMS_Equip.Width
     *
     * @mbggenerated
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Height
     *
     * @return the value of T_CMS_Equip.Height
     *
     * @mbggenerated
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Height
     *
     * @param height the value for T_CMS_Equip.Height
     *
     * @mbggenerated
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Ip
     *
     * @return the value of T_CMS_Equip.Ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Ip
     *
     * @param ip the value for T_CMS_Equip.Ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Port
     *
     * @return the value of T_CMS_Equip.Port
     *
     * @mbggenerated
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Port
     *
     * @param port the value for T_CMS_Equip.Port
     *
     * @mbggenerated
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.SerialPortNumber
     *
     * @return the value of T_CMS_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    public Integer getSerialportnumber() {
        return serialportnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.SerialPortNumber
     *
     * @param serialportnumber the value for T_CMS_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    public void setSerialportnumber(Integer serialportnumber) {
        this.serialportnumber = serialportnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.BaudRate
     *
     * @return the value of T_CMS_Equip.BaudRate
     *
     * @mbggenerated
     */
    public Integer getBaudrate() {
        return baudrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.BaudRate
     *
     * @param baudrate the value for T_CMS_Equip.BaudRate
     *
     * @mbggenerated
     */
    public void setBaudrate(Integer baudrate) {
        this.baudrate = baudrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.Parity
     *
     * @return the value of T_CMS_Equip.Parity
     *
     * @mbggenerated
     */
    public Integer getParity() {
        return parity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.Parity
     *
     * @param parity the value for T_CMS_Equip.Parity
     *
     * @mbggenerated
     */
    public void setParity(Integer parity) {
        this.parity = parity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.DataBits
     *
     * @return the value of T_CMS_Equip.DataBits
     *
     * @mbggenerated
     */
    public Integer getDatabits() {
        return databits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.DataBits
     *
     * @param databits the value for T_CMS_Equip.DataBits
     *
     * @mbggenerated
     */
    public void setDatabits(Integer databits) {
        this.databits = databits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.StopBits
     *
     * @return the value of T_CMS_Equip.StopBits
     *
     * @mbggenerated
     */
    public Integer getStopbits() {
        return stopbits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.StopBits
     *
     * @param stopbits the value for T_CMS_Equip.StopBits
     *
     * @mbggenerated
     */
    public void setStopbits(Integer stopbits) {
        this.stopbits = stopbits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.BusinessCategory
     *
     * @return the value of T_CMS_Equip.BusinessCategory
     *
     * @mbggenerated
     */
    public String getBusinesscategory() {
        return businesscategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.BusinessCategory
     *
     * @param businesscategory the value for T_CMS_Equip.BusinessCategory
     *
     * @mbggenerated
     */
    public void setBusinesscategory(String businesscategory) {
        this.businesscategory = businesscategory == null ? null : businesscategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.ProtocolId
     *
     * @return the value of T_CMS_Equip.ProtocolId
     *
     * @mbggenerated
     */
    public Integer getProtocolid() {
        return protocolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.ProtocolId
     *
     * @param protocolid the value for T_CMS_Equip.ProtocolId
     *
     * @mbggenerated
     */
    public void setProtocolid(Integer protocolid) {
        this.protocolid = protocolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.IsDeleted
     *
     * @return the value of T_CMS_Equip.IsDeleted
     *
     * @mbggenerated
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.IsDeleted
     *
     * @param isdeleted the value for T_CMS_Equip.IsDeleted
     *
     * @mbggenerated
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.InUse
     *
     * @return the value of T_CMS_Equip.InUse
     *
     * @mbggenerated
     */
    public Boolean getInuse() {
        return inuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.InUse
     *
     * @param inuse the value for T_CMS_Equip.InUse
     *
     * @mbggenerated
     */
    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.CreateDate
     *
     * @return the value of T_CMS_Equip.CreateDate
     *
     * @mbggenerated
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.CreateDate
     *
     * @param createdate the value for T_CMS_Equip.CreateDate
     *
     * @mbggenerated
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.CreateTime
     *
     * @return the value of T_CMS_Equip.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.CreateTime
     *
     * @param createtime the value for T_CMS_Equip.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_CMS_Equip.ConcurrencyToken
     *
     * @return the value of T_CMS_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    public byte[] getConcurrencytoken() {
        return concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_CMS_Equip.ConcurrencyToken
     *
     * @param concurrencytoken the value for T_CMS_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    public void setConcurrencytoken(byte[] concurrencytoken) {
        this.concurrencytoken = concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CMS_Equip
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
        TCMSEquip other = (TCMSEquip) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRegionid() == null ? other.getRegionid() == null : this.getRegionid().equals(other.getRegionid()))
            && (this.getEquipname() == null ? other.getEquipname() == null : this.getEquipname().equals(other.getEquipname()))
            && (this.getPhysicalequiptype() == null ? other.getPhysicalequiptype() == null : this.getPhysicalequiptype().equals(other.getPhysicalequiptype()))
            && (this.getRoutecode() == null ? other.getRoutecode() == null : this.getRoutecode().equals(other.getRoutecode()))
            && (this.getMile() == null ? other.getMile() == null : this.getMile().equals(other.getMile()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getSerialportnumber() == null ? other.getSerialportnumber() == null : this.getSerialportnumber().equals(other.getSerialportnumber()))
            && (this.getBaudrate() == null ? other.getBaudrate() == null : this.getBaudrate().equals(other.getBaudrate()))
            && (this.getParity() == null ? other.getParity() == null : this.getParity().equals(other.getParity()))
            && (this.getDatabits() == null ? other.getDatabits() == null : this.getDatabits().equals(other.getDatabits()))
            && (this.getStopbits() == null ? other.getStopbits() == null : this.getStopbits().equals(other.getStopbits()))
            && (this.getBusinesscategory() == null ? other.getBusinesscategory() == null : this.getBusinesscategory().equals(other.getBusinesscategory()))
            && (this.getProtocolid() == null ? other.getProtocolid() == null : this.getProtocolid().equals(other.getProtocolid()))
            && (this.getIsdeleted() == null ? other.getIsdeleted() == null : this.getIsdeleted().equals(other.getIsdeleted()))
            && (this.getInuse() == null ? other.getInuse() == null : this.getInuse().equals(other.getInuse()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getConcurrencytoken() == null ? other.getConcurrencytoken() == null : this.getConcurrencytoken().equals(other.getConcurrencytoken()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegionid() == null) ? 0 : getRegionid().hashCode());
        result = prime * result + ((getEquipname() == null) ? 0 : getEquipname().hashCode());
        result = prime * result + ((getPhysicalequiptype() == null) ? 0 : getPhysicalequiptype().hashCode());
        result = prime * result + ((getRoutecode() == null) ? 0 : getRoutecode().hashCode());
        result = prime * result + ((getMile() == null) ? 0 : getMile().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getSerialportnumber() == null) ? 0 : getSerialportnumber().hashCode());
        result = prime * result + ((getBaudrate() == null) ? 0 : getBaudrate().hashCode());
        result = prime * result + ((getParity() == null) ? 0 : getParity().hashCode());
        result = prime * result + ((getDatabits() == null) ? 0 : getDatabits().hashCode());
        result = prime * result + ((getStopbits() == null) ? 0 : getStopbits().hashCode());
        result = prime * result + ((getBusinesscategory() == null) ? 0 : getBusinesscategory().hashCode());
        result = prime * result + ((getProtocolid() == null) ? 0 : getProtocolid().hashCode());
        result = prime * result + ((getIsdeleted() == null) ? 0 : getIsdeleted().hashCode());
        result = prime * result + ((getInuse() == null) ? 0 : getInuse().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getConcurrencytoken() == null) ? 0 : getConcurrencytoken().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CMS_Equip
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", regionid=").append(regionid);
        sb.append(", equipname=").append(equipname);
        sb.append(", physicalequiptype=").append(physicalequiptype);
        sb.append(", routecode=").append(routecode);
        sb.append(", mile=").append(mile);
        sb.append(", channel=").append(channel);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", serialportnumber=").append(serialportnumber);
        sb.append(", baudrate=").append(baudrate);
        sb.append(", parity=").append(parity);
        sb.append(", databits=").append(databits);
        sb.append(", stopbits=").append(stopbits);
        sb.append(", businesscategory=").append(businesscategory);
        sb.append(", protocolid=").append(protocolid);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", inuse=").append(inuse);
        sb.append(", createdate=").append(createdate);
        sb.append(", createtime=").append(createtime);
        sb.append(", concurrencytoken=").append(concurrencytoken);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}