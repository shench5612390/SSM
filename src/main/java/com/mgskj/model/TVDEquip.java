package com.mgskj.model;

import java.io.Serializable;
import java.util.Date;

public class TVDEquip implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ControllerId
     *
     * @mbggenerated
     */
    private String controllerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.RegionId
     *
     * @mbggenerated
     */
    private String regionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.EquipName
     *
     * @mbggenerated
     */
    private String equipname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.EquipType
     *
     * @mbggenerated
     */
    private Integer equiptype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    private Integer physicalequiptype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.RouteCode
     *
     * @mbggenerated
     */
    private String routecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Mile
     *
     * @mbggenerated
     */
    private String mile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ProducerCode
     *
     * @mbggenerated
     */
    private String producercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ProtocolId
     *
     * @mbggenerated
     */
    private Integer protocolid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Channel
     *
     * @mbggenerated
     */
    private Integer channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ObMileage
     *
     * @mbggenerated
     */
    private Double obmileage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ObBeginMile
     *
     * @mbggenerated
     */
    private String obbeginmile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ObEndMile
     *
     * @mbggenerated
     */
    private String obendmile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ObBeginDesc
     *
     * @mbggenerated
     */
    private String obbegindesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ObEndDesc
     *
     * @mbggenerated
     */
    private String obenddesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.TechLevel
     *
     * @mbggenerated
     */
    private Integer techlevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Port
     *
     * @mbggenerated
     */
    private Integer port;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    private Integer serialportnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.BaudRate
     *
     * @mbggenerated
     */
    private Integer baudrate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.Parity
     *
     * @mbggenerated
     */
    private Integer parity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.DataBits
     *
     * @mbggenerated
     */
    private Integer databits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.StopBits
     *
     * @mbggenerated
     */
    private Integer stopbits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.IsDeleted
     *
     * @mbggenerated
     */
    private Boolean isdeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.InUse
     *
     * @mbggenerated
     */
    private Boolean inuse;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.CreateDate
     *
     * @mbggenerated
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_VD_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    private byte[] concurrencytoken;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Id
     *
     * @return the value of T_VD_Equip.Id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Id
     *
     * @param id the value for T_VD_Equip.Id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ControllerId
     *
     * @return the value of T_VD_Equip.ControllerId
     *
     * @mbggenerated
     */
    public String getControllerid() {
        return controllerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ControllerId
     *
     * @param controllerid the value for T_VD_Equip.ControllerId
     *
     * @mbggenerated
     */
    public void setControllerid(String controllerid) {
        this.controllerid = controllerid == null ? null : controllerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.RegionId
     *
     * @return the value of T_VD_Equip.RegionId
     *
     * @mbggenerated
     */
    public String getRegionid() {
        return regionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.RegionId
     *
     * @param regionid the value for T_VD_Equip.RegionId
     *
     * @mbggenerated
     */
    public void setRegionid(String regionid) {
        this.regionid = regionid == null ? null : regionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.EquipName
     *
     * @return the value of T_VD_Equip.EquipName
     *
     * @mbggenerated
     */
    public String getEquipname() {
        return equipname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.EquipName
     *
     * @param equipname the value for T_VD_Equip.EquipName
     *
     * @mbggenerated
     */
    public void setEquipname(String equipname) {
        this.equipname = equipname == null ? null : equipname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.EquipType
     *
     * @return the value of T_VD_Equip.EquipType
     *
     * @mbggenerated
     */
    public Integer getEquiptype() {
        return equiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.EquipType
     *
     * @param equiptype the value for T_VD_Equip.EquipType
     *
     * @mbggenerated
     */
    public void setEquiptype(Integer equiptype) {
        this.equiptype = equiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.PhysicalEquipType
     *
     * @return the value of T_VD_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    public Integer getPhysicalequiptype() {
        return physicalequiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.PhysicalEquipType
     *
     * @param physicalequiptype the value for T_VD_Equip.PhysicalEquipType
     *
     * @mbggenerated
     */
    public void setPhysicalequiptype(Integer physicalequiptype) {
        this.physicalequiptype = physicalequiptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.RouteCode
     *
     * @return the value of T_VD_Equip.RouteCode
     *
     * @mbggenerated
     */
    public String getRoutecode() {
        return routecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.RouteCode
     *
     * @param routecode the value for T_VD_Equip.RouteCode
     *
     * @mbggenerated
     */
    public void setRoutecode(String routecode) {
        this.routecode = routecode == null ? null : routecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Mile
     *
     * @return the value of T_VD_Equip.Mile
     *
     * @mbggenerated
     */
    public String getMile() {
        return mile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Mile
     *
     * @param mile the value for T_VD_Equip.Mile
     *
     * @mbggenerated
     */
    public void setMile(String mile) {
        this.mile = mile == null ? null : mile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ProducerCode
     *
     * @return the value of T_VD_Equip.ProducerCode
     *
     * @mbggenerated
     */
    public String getProducercode() {
        return producercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ProducerCode
     *
     * @param producercode the value for T_VD_Equip.ProducerCode
     *
     * @mbggenerated
     */
    public void setProducercode(String producercode) {
        this.producercode = producercode == null ? null : producercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ProtocolId
     *
     * @return the value of T_VD_Equip.ProtocolId
     *
     * @mbggenerated
     */
    public Integer getProtocolid() {
        return protocolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ProtocolId
     *
     * @param protocolid the value for T_VD_Equip.ProtocolId
     *
     * @mbggenerated
     */
    public void setProtocolid(Integer protocolid) {
        this.protocolid = protocolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Channel
     *
     * @return the value of T_VD_Equip.Channel
     *
     * @mbggenerated
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Channel
     *
     * @param channel the value for T_VD_Equip.Channel
     *
     * @mbggenerated
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ObMileage
     *
     * @return the value of T_VD_Equip.ObMileage
     *
     * @mbggenerated
     */
    public Double getObmileage() {
        return obmileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ObMileage
     *
     * @param obmileage the value for T_VD_Equip.ObMileage
     *
     * @mbggenerated
     */
    public void setObmileage(Double obmileage) {
        this.obmileage = obmileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ObBeginMile
     *
     * @return the value of T_VD_Equip.ObBeginMile
     *
     * @mbggenerated
     */
    public String getObbeginmile() {
        return obbeginmile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ObBeginMile
     *
     * @param obbeginmile the value for T_VD_Equip.ObBeginMile
     *
     * @mbggenerated
     */
    public void setObbeginmile(String obbeginmile) {
        this.obbeginmile = obbeginmile == null ? null : obbeginmile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ObEndMile
     *
     * @return the value of T_VD_Equip.ObEndMile
     *
     * @mbggenerated
     */
    public String getObendmile() {
        return obendmile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ObEndMile
     *
     * @param obendmile the value for T_VD_Equip.ObEndMile
     *
     * @mbggenerated
     */
    public void setObendmile(String obendmile) {
        this.obendmile = obendmile == null ? null : obendmile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ObBeginDesc
     *
     * @return the value of T_VD_Equip.ObBeginDesc
     *
     * @mbggenerated
     */
    public String getObbegindesc() {
        return obbegindesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ObBeginDesc
     *
     * @param obbegindesc the value for T_VD_Equip.ObBeginDesc
     *
     * @mbggenerated
     */
    public void setObbegindesc(String obbegindesc) {
        this.obbegindesc = obbegindesc == null ? null : obbegindesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ObEndDesc
     *
     * @return the value of T_VD_Equip.ObEndDesc
     *
     * @mbggenerated
     */
    public String getObenddesc() {
        return obenddesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ObEndDesc
     *
     * @param obenddesc the value for T_VD_Equip.ObEndDesc
     *
     * @mbggenerated
     */
    public void setObenddesc(String obenddesc) {
        this.obenddesc = obenddesc == null ? null : obenddesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.TechLevel
     *
     * @return the value of T_VD_Equip.TechLevel
     *
     * @mbggenerated
     */
    public Integer getTechlevel() {
        return techlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.TechLevel
     *
     * @param techlevel the value for T_VD_Equip.TechLevel
     *
     * @mbggenerated
     */
    public void setTechlevel(Integer techlevel) {
        this.techlevel = techlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Ip
     *
     * @return the value of T_VD_Equip.Ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Ip
     *
     * @param ip the value for T_VD_Equip.Ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Port
     *
     * @return the value of T_VD_Equip.Port
     *
     * @mbggenerated
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Port
     *
     * @param port the value for T_VD_Equip.Port
     *
     * @mbggenerated
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.SerialPortNumber
     *
     * @return the value of T_VD_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    public Integer getSerialportnumber() {
        return serialportnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.SerialPortNumber
     *
     * @param serialportnumber the value for T_VD_Equip.SerialPortNumber
     *
     * @mbggenerated
     */
    public void setSerialportnumber(Integer serialportnumber) {
        this.serialportnumber = serialportnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.BaudRate
     *
     * @return the value of T_VD_Equip.BaudRate
     *
     * @mbggenerated
     */
    public Integer getBaudrate() {
        return baudrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.BaudRate
     *
     * @param baudrate the value for T_VD_Equip.BaudRate
     *
     * @mbggenerated
     */
    public void setBaudrate(Integer baudrate) {
        this.baudrate = baudrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.Parity
     *
     * @return the value of T_VD_Equip.Parity
     *
     * @mbggenerated
     */
    public Integer getParity() {
        return parity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.Parity
     *
     * @param parity the value for T_VD_Equip.Parity
     *
     * @mbggenerated
     */
    public void setParity(Integer parity) {
        this.parity = parity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.DataBits
     *
     * @return the value of T_VD_Equip.DataBits
     *
     * @mbggenerated
     */
    public Integer getDatabits() {
        return databits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.DataBits
     *
     * @param databits the value for T_VD_Equip.DataBits
     *
     * @mbggenerated
     */
    public void setDatabits(Integer databits) {
        this.databits = databits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.StopBits
     *
     * @return the value of T_VD_Equip.StopBits
     *
     * @mbggenerated
     */
    public Integer getStopbits() {
        return stopbits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.StopBits
     *
     * @param stopbits the value for T_VD_Equip.StopBits
     *
     * @mbggenerated
     */
    public void setStopbits(Integer stopbits) {
        this.stopbits = stopbits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.IsDeleted
     *
     * @return the value of T_VD_Equip.IsDeleted
     *
     * @mbggenerated
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.IsDeleted
     *
     * @param isdeleted the value for T_VD_Equip.IsDeleted
     *
     * @mbggenerated
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.InUse
     *
     * @return the value of T_VD_Equip.InUse
     *
     * @mbggenerated
     */
    public Boolean getInuse() {
        return inuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.InUse
     *
     * @param inuse the value for T_VD_Equip.InUse
     *
     * @mbggenerated
     */
    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.CreateDate
     *
     * @return the value of T_VD_Equip.CreateDate
     *
     * @mbggenerated
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.CreateDate
     *
     * @param createdate the value for T_VD_Equip.CreateDate
     *
     * @mbggenerated
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.CreateTime
     *
     * @return the value of T_VD_Equip.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.CreateTime
     *
     * @param createtime the value for T_VD_Equip.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_VD_Equip.ConcurrencyToken
     *
     * @return the value of T_VD_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    public byte[] getConcurrencytoken() {
        return concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_VD_Equip.ConcurrencyToken
     *
     * @param concurrencytoken the value for T_VD_Equip.ConcurrencyToken
     *
     * @mbggenerated
     */
    public void setConcurrencytoken(byte[] concurrencytoken) {
        this.concurrencytoken = concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_VD_Equip
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
        TVDEquip other = (TVDEquip) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getControllerid() == null ? other.getControllerid() == null : this.getControllerid().equals(other.getControllerid()))
            && (this.getRegionid() == null ? other.getRegionid() == null : this.getRegionid().equals(other.getRegionid()))
            && (this.getEquipname() == null ? other.getEquipname() == null : this.getEquipname().equals(other.getEquipname()))
            && (this.getEquiptype() == null ? other.getEquiptype() == null : this.getEquiptype().equals(other.getEquiptype()))
            && (this.getPhysicalequiptype() == null ? other.getPhysicalequiptype() == null : this.getPhysicalequiptype().equals(other.getPhysicalequiptype()))
            && (this.getRoutecode() == null ? other.getRoutecode() == null : this.getRoutecode().equals(other.getRoutecode()))
            && (this.getMile() == null ? other.getMile() == null : this.getMile().equals(other.getMile()))
            && (this.getProducercode() == null ? other.getProducercode() == null : this.getProducercode().equals(other.getProducercode()))
            && (this.getProtocolid() == null ? other.getProtocolid() == null : this.getProtocolid().equals(other.getProtocolid()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getObmileage() == null ? other.getObmileage() == null : this.getObmileage().equals(other.getObmileage()))
            && (this.getObbeginmile() == null ? other.getObbeginmile() == null : this.getObbeginmile().equals(other.getObbeginmile()))
            && (this.getObendmile() == null ? other.getObendmile() == null : this.getObendmile().equals(other.getObendmile()))
            && (this.getObbegindesc() == null ? other.getObbegindesc() == null : this.getObbegindesc().equals(other.getObbegindesc()))
            && (this.getObenddesc() == null ? other.getObenddesc() == null : this.getObenddesc().equals(other.getObenddesc()))
            && (this.getTechlevel() == null ? other.getTechlevel() == null : this.getTechlevel().equals(other.getTechlevel()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getSerialportnumber() == null ? other.getSerialportnumber() == null : this.getSerialportnumber().equals(other.getSerialportnumber()))
            && (this.getBaudrate() == null ? other.getBaudrate() == null : this.getBaudrate().equals(other.getBaudrate()))
            && (this.getParity() == null ? other.getParity() == null : this.getParity().equals(other.getParity()))
            && (this.getDatabits() == null ? other.getDatabits() == null : this.getDatabits().equals(other.getDatabits()))
            && (this.getStopbits() == null ? other.getStopbits() == null : this.getStopbits().equals(other.getStopbits()))
            && (this.getIsdeleted() == null ? other.getIsdeleted() == null : this.getIsdeleted().equals(other.getIsdeleted()))
            && (this.getInuse() == null ? other.getInuse() == null : this.getInuse().equals(other.getInuse()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getConcurrencytoken() == null ? other.getConcurrencytoken() == null : this.getConcurrencytoken().equals(other.getConcurrencytoken()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_VD_Equip
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getControllerid() == null) ? 0 : getControllerid().hashCode());
        result = prime * result + ((getRegionid() == null) ? 0 : getRegionid().hashCode());
        result = prime * result + ((getEquipname() == null) ? 0 : getEquipname().hashCode());
        result = prime * result + ((getEquiptype() == null) ? 0 : getEquiptype().hashCode());
        result = prime * result + ((getPhysicalequiptype() == null) ? 0 : getPhysicalequiptype().hashCode());
        result = prime * result + ((getRoutecode() == null) ? 0 : getRoutecode().hashCode());
        result = prime * result + ((getMile() == null) ? 0 : getMile().hashCode());
        result = prime * result + ((getProducercode() == null) ? 0 : getProducercode().hashCode());
        result = prime * result + ((getProtocolid() == null) ? 0 : getProtocolid().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getObmileage() == null) ? 0 : getObmileage().hashCode());
        result = prime * result + ((getObbeginmile() == null) ? 0 : getObbeginmile().hashCode());
        result = prime * result + ((getObendmile() == null) ? 0 : getObendmile().hashCode());
        result = prime * result + ((getObbegindesc() == null) ? 0 : getObbegindesc().hashCode());
        result = prime * result + ((getObenddesc() == null) ? 0 : getObenddesc().hashCode());
        result = prime * result + ((getTechlevel() == null) ? 0 : getTechlevel().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getSerialportnumber() == null) ? 0 : getSerialportnumber().hashCode());
        result = prime * result + ((getBaudrate() == null) ? 0 : getBaudrate().hashCode());
        result = prime * result + ((getParity() == null) ? 0 : getParity().hashCode());
        result = prime * result + ((getDatabits() == null) ? 0 : getDatabits().hashCode());
        result = prime * result + ((getStopbits() == null) ? 0 : getStopbits().hashCode());
        result = prime * result + ((getIsdeleted() == null) ? 0 : getIsdeleted().hashCode());
        result = prime * result + ((getInuse() == null) ? 0 : getInuse().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getConcurrencytoken() == null) ? 0 : getConcurrencytoken().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_VD_Equip
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
        sb.append(", controllerid=").append(controllerid);
        sb.append(", regionid=").append(regionid);
        sb.append(", equipname=").append(equipname);
        sb.append(", equiptype=").append(equiptype);
        sb.append(", physicalequiptype=").append(physicalequiptype);
        sb.append(", routecode=").append(routecode);
        sb.append(", mile=").append(mile);
        sb.append(", producercode=").append(producercode);
        sb.append(", protocolid=").append(protocolid);
        sb.append(", channel=").append(channel);
        sb.append(", obmileage=").append(obmileage);
        sb.append(", obbeginmile=").append(obbeginmile);
        sb.append(", obendmile=").append(obendmile);
        sb.append(", obbegindesc=").append(obbegindesc);
        sb.append(", obenddesc=").append(obenddesc);
        sb.append(", techlevel=").append(techlevel);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", serialportnumber=").append(serialportnumber);
        sb.append(", baudrate=").append(baudrate);
        sb.append(", parity=").append(parity);
        sb.append(", databits=").append(databits);
        sb.append(", stopbits=").append(stopbits);
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