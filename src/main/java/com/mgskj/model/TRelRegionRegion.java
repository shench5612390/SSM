package com.mgskj.model;

import java.io.Serializable;
import java.util.Date;

public class TRelRegionRegion implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.Id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.SourceRegionId
     *
     * @mbggenerated
     */
    private String sourceregionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.TargetRegionId
     *
     * @mbggenerated
     */
    private String targetregionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.RelationType
     *
     * @mbggenerated
     */
    private Integer relationtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.CreateDate
     *
     * @mbggenerated
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_Rel_Region_Region.ConcurrencyToken
     *
     * @mbggenerated
     */
    private byte[] concurrencytoken;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_Rel_Region_Region
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.Id
     *
     * @return the value of T_Rel_Region_Region.Id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.Id
     *
     * @param id the value for T_Rel_Region_Region.Id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.SourceRegionId
     *
     * @return the value of T_Rel_Region_Region.SourceRegionId
     *
     * @mbggenerated
     */
    public String getSourceregionid() {
        return sourceregionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.SourceRegionId
     *
     * @param sourceregionid the value for T_Rel_Region_Region.SourceRegionId
     *
     * @mbggenerated
     */
    public void setSourceregionid(String sourceregionid) {
        this.sourceregionid = sourceregionid == null ? null : sourceregionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.TargetRegionId
     *
     * @return the value of T_Rel_Region_Region.TargetRegionId
     *
     * @mbggenerated
     */
    public String getTargetregionid() {
        return targetregionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.TargetRegionId
     *
     * @param targetregionid the value for T_Rel_Region_Region.TargetRegionId
     *
     * @mbggenerated
     */
    public void setTargetregionid(String targetregionid) {
        this.targetregionid = targetregionid == null ? null : targetregionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.RelationType
     *
     * @return the value of T_Rel_Region_Region.RelationType
     *
     * @mbggenerated
     */
    public Integer getRelationtype() {
        return relationtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.RelationType
     *
     * @param relationtype the value for T_Rel_Region_Region.RelationType
     *
     * @mbggenerated
     */
    public void setRelationtype(Integer relationtype) {
        this.relationtype = relationtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.CreateDate
     *
     * @return the value of T_Rel_Region_Region.CreateDate
     *
     * @mbggenerated
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.CreateDate
     *
     * @param createdate the value for T_Rel_Region_Region.CreateDate
     *
     * @mbggenerated
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.CreateTime
     *
     * @return the value of T_Rel_Region_Region.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.CreateTime
     *
     * @param createtime the value for T_Rel_Region_Region.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_Rel_Region_Region.ConcurrencyToken
     *
     * @return the value of T_Rel_Region_Region.ConcurrencyToken
     *
     * @mbggenerated
     */
    public byte[] getConcurrencytoken() {
        return concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_Rel_Region_Region.ConcurrencyToken
     *
     * @param concurrencytoken the value for T_Rel_Region_Region.ConcurrencyToken
     *
     * @mbggenerated
     */
    public void setConcurrencytoken(byte[] concurrencytoken) {
        this.concurrencytoken = concurrencytoken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_Rel_Region_Region
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
        TRelRegionRegion other = (TRelRegionRegion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceregionid() == null ? other.getSourceregionid() == null : this.getSourceregionid().equals(other.getSourceregionid()))
            && (this.getTargetregionid() == null ? other.getTargetregionid() == null : this.getTargetregionid().equals(other.getTargetregionid()))
            && (this.getRelationtype() == null ? other.getRelationtype() == null : this.getRelationtype().equals(other.getRelationtype()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getConcurrencytoken() == null ? other.getConcurrencytoken() == null : this.getConcurrencytoken().equals(other.getConcurrencytoken()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_Rel_Region_Region
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceregionid() == null) ? 0 : getSourceregionid().hashCode());
        result = prime * result + ((getTargetregionid() == null) ? 0 : getTargetregionid().hashCode());
        result = prime * result + ((getRelationtype() == null) ? 0 : getRelationtype().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getConcurrencytoken() == null) ? 0 : getConcurrencytoken().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_Rel_Region_Region
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
        sb.append(", sourceregionid=").append(sourceregionid);
        sb.append(", targetregionid=").append(targetregionid);
        sb.append(", relationtype=").append(relationtype);
        sb.append(", createdate=").append(createdate);
        sb.append(", createtime=").append(createtime);
        sb.append(", concurrencytoken=").append(concurrencytoken);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}