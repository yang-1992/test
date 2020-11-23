package com.ctsi.space.domain;

import java.io.Serializable;

/**
 * @author ctsi-biyi-generator
*/
public class BasCustomer implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Long cusId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_num
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_name
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_name_ab
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusNameAb;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Long cusType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Byte cusLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_addr
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_person
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusPerson;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_tel
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_email
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_note
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusNote;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_is_lease
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Byte cusIsLease;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_circuit_postfix
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusCircuitPostfix;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_admin_district
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Long cusAdminDistrict;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_postfix_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Integer cusPostfixType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.is_valid
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Byte isValid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_belong
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Byte cusBelong;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_service_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Integer cusServiceLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_attribute1
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusAttribute1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_attribute2
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusAttribute2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_attribute3
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusAttribute3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_attribute4
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusAttribute4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.parent_cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private Long parentCusId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.cus_path
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String cusPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bas_customer.inner_order
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    private String innerOrder;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_id
     *
     * @return the value of bas_customer.cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Long getCusId() {
        return cusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_id
     *
     * @param cusId the value for bas_customer.cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_num
     *
     * @return the value of bas_customer.cus_num
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusNum() {
        return cusNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_num
     *
     * @param cusNum the value for bas_customer.cus_num
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusNum(String cusNum) {
        this.cusNum = cusNum == null ? null : cusNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_name
     *
     * @return the value of bas_customer.cus_name
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_name
     *
     * @param cusName the value for bas_customer.cus_name
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_name_ab
     *
     * @return the value of bas_customer.cus_name_ab
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusNameAb() {
        return cusNameAb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_name_ab
     *
     * @param cusNameAb the value for bas_customer.cus_name_ab
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusNameAb(String cusNameAb) {
        this.cusNameAb = cusNameAb == null ? null : cusNameAb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_type
     *
     * @return the value of bas_customer.cus_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Long getCusType() {
        return cusType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_type
     *
     * @param cusType the value for bas_customer.cus_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusType(Long cusType) {
        this.cusType = cusType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_level
     *
     * @return the value of bas_customer.cus_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Byte getCusLevel() {
        return cusLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_level
     *
     * @param cusLevel the value for bas_customer.cus_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusLevel(Byte cusLevel) {
        this.cusLevel = cusLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_addr
     *
     * @return the value of bas_customer.cus_addr
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusAddr() {
        return cusAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_addr
     *
     * @param cusAddr the value for bas_customer.cus_addr
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr == null ? null : cusAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_person
     *
     * @return the value of bas_customer.cus_person
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusPerson() {
        return cusPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_person
     *
     * @param cusPerson the value for bas_customer.cus_person
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusPerson(String cusPerson) {
        this.cusPerson = cusPerson == null ? null : cusPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_tel
     *
     * @return the value of bas_customer.cus_tel
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusTel() {
        return cusTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_tel
     *
     * @param cusTel the value for bas_customer.cus_tel
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusTel(String cusTel) {
        this.cusTel = cusTel == null ? null : cusTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_email
     *
     * @return the value of bas_customer.cus_email
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusEmail() {
        return cusEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_email
     *
     * @param cusEmail the value for bas_customer.cus_email
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail == null ? null : cusEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_note
     *
     * @return the value of bas_customer.cus_note
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusNote() {
        return cusNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_note
     *
     * @param cusNote the value for bas_customer.cus_note
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusNote(String cusNote) {
        this.cusNote = cusNote == null ? null : cusNote.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_is_lease
     *
     * @return the value of bas_customer.cus_is_lease
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Byte getCusIsLease() {
        return cusIsLease;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_is_lease
     *
     * @param cusIsLease the value for bas_customer.cus_is_lease
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusIsLease(Byte cusIsLease) {
        this.cusIsLease = cusIsLease;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_circuit_postfix
     *
     * @return the value of bas_customer.cus_circuit_postfix
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusCircuitPostfix() {
        return cusCircuitPostfix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_circuit_postfix
     *
     * @param cusCircuitPostfix the value for bas_customer.cus_circuit_postfix
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusCircuitPostfix(String cusCircuitPostfix) {
        this.cusCircuitPostfix = cusCircuitPostfix == null ? null : cusCircuitPostfix.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_admin_district
     *
     * @return the value of bas_customer.cus_admin_district
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Long getCusAdminDistrict() {
        return cusAdminDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_admin_district
     *
     * @param cusAdminDistrict the value for bas_customer.cus_admin_district
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAdminDistrict(Long cusAdminDistrict) {
        this.cusAdminDistrict = cusAdminDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_postfix_type
     *
     * @return the value of bas_customer.cus_postfix_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Integer getCusPostfixType() {
        return cusPostfixType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_postfix_type
     *
     * @param cusPostfixType the value for bas_customer.cus_postfix_type
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusPostfixType(Integer cusPostfixType) {
        this.cusPostfixType = cusPostfixType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.is_valid
     *
     * @return the value of bas_customer.is_valid
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Byte getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.is_valid
     *
     * @param isValid the value for bas_customer.is_valid
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_belong
     *
     * @return the value of bas_customer.cus_belong
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Byte getCusBelong() {
        return cusBelong;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_belong
     *
     * @param cusBelong the value for bas_customer.cus_belong
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusBelong(Byte cusBelong) {
        this.cusBelong = cusBelong;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_service_level
     *
     * @return the value of bas_customer.cus_service_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Integer getCusServiceLevel() {
        return cusServiceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_service_level
     *
     * @param cusServiceLevel the value for bas_customer.cus_service_level
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusServiceLevel(Integer cusServiceLevel) {
        this.cusServiceLevel = cusServiceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_attribute1
     *
     * @return the value of bas_customer.cus_attribute1
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusAttribute1() {
        return cusAttribute1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_attribute1
     *
     * @param cusAttribute1 the value for bas_customer.cus_attribute1
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAttribute1(String cusAttribute1) {
        this.cusAttribute1 = cusAttribute1 == null ? null : cusAttribute1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_attribute2
     *
     * @return the value of bas_customer.cus_attribute2
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusAttribute2() {
        return cusAttribute2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_attribute2
     *
     * @param cusAttribute2 the value for bas_customer.cus_attribute2
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAttribute2(String cusAttribute2) {
        this.cusAttribute2 = cusAttribute2 == null ? null : cusAttribute2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_attribute3
     *
     * @return the value of bas_customer.cus_attribute3
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusAttribute3() {
        return cusAttribute3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_attribute3
     *
     * @param cusAttribute3 the value for bas_customer.cus_attribute3
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAttribute3(String cusAttribute3) {
        this.cusAttribute3 = cusAttribute3 == null ? null : cusAttribute3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_attribute4
     *
     * @return the value of bas_customer.cus_attribute4
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusAttribute4() {
        return cusAttribute4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_attribute4
     *
     * @param cusAttribute4 the value for bas_customer.cus_attribute4
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusAttribute4(String cusAttribute4) {
        this.cusAttribute4 = cusAttribute4 == null ? null : cusAttribute4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.parent_cus_id
     *
     * @return the value of bas_customer.parent_cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public Long getParentCusId() {
        return parentCusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.parent_cus_id
     *
     * @param parentCusId the value for bas_customer.parent_cus_id
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setParentCusId(Long parentCusId) {
        this.parentCusId = parentCusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.cus_path
     *
     * @return the value of bas_customer.cus_path
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getCusPath() {
        return cusPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.cus_path
     *
     * @param cusPath the value for bas_customer.cus_path
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setCusPath(String cusPath) {
        this.cusPath = cusPath == null ? null : cusPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bas_customer.inner_order
     *
     * @return the value of bas_customer.inner_order
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String getInnerOrder() {
        return innerOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bas_customer.inner_order
     *
     * @param innerOrder the value for bas_customer.inner_order
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public void setInnerOrder(String innerOrder) {
        this.innerOrder = innerOrder == null ? null : innerOrder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
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
        BasCustomer other = (BasCustomer) that;
        return (this.getCusId() == null ? other.getCusId() == null : this.getCusId().equals(other.getCusId()))
            && (this.getCusNum() == null ? other.getCusNum() == null : this.getCusNum().equals(other.getCusNum()))
            && (this.getCusName() == null ? other.getCusName() == null : this.getCusName().equals(other.getCusName()))
            && (this.getCusNameAb() == null ? other.getCusNameAb() == null : this.getCusNameAb().equals(other.getCusNameAb()))
            && (this.getCusType() == null ? other.getCusType() == null : this.getCusType().equals(other.getCusType()))
            && (this.getCusLevel() == null ? other.getCusLevel() == null : this.getCusLevel().equals(other.getCusLevel()))
            && (this.getCusAddr() == null ? other.getCusAddr() == null : this.getCusAddr().equals(other.getCusAddr()))
            && (this.getCusPerson() == null ? other.getCusPerson() == null : this.getCusPerson().equals(other.getCusPerson()))
            && (this.getCusTel() == null ? other.getCusTel() == null : this.getCusTel().equals(other.getCusTel()))
            && (this.getCusEmail() == null ? other.getCusEmail() == null : this.getCusEmail().equals(other.getCusEmail()))
            && (this.getCusNote() == null ? other.getCusNote() == null : this.getCusNote().equals(other.getCusNote()))
            && (this.getCusIsLease() == null ? other.getCusIsLease() == null : this.getCusIsLease().equals(other.getCusIsLease()))
            && (this.getCusCircuitPostfix() == null ? other.getCusCircuitPostfix() == null : this.getCusCircuitPostfix().equals(other.getCusCircuitPostfix()))
            && (this.getCusAdminDistrict() == null ? other.getCusAdminDistrict() == null : this.getCusAdminDistrict().equals(other.getCusAdminDistrict()))
            && (this.getCusPostfixType() == null ? other.getCusPostfixType() == null : this.getCusPostfixType().equals(other.getCusPostfixType()))
            && (this.getIsValid() == null ? other.getIsValid() == null : this.getIsValid().equals(other.getIsValid()))
            && (this.getCusBelong() == null ? other.getCusBelong() == null : this.getCusBelong().equals(other.getCusBelong()))
            && (this.getCusServiceLevel() == null ? other.getCusServiceLevel() == null : this.getCusServiceLevel().equals(other.getCusServiceLevel()))
            && (this.getCusAttribute1() == null ? other.getCusAttribute1() == null : this.getCusAttribute1().equals(other.getCusAttribute1()))
            && (this.getCusAttribute2() == null ? other.getCusAttribute2() == null : this.getCusAttribute2().equals(other.getCusAttribute2()))
            && (this.getCusAttribute3() == null ? other.getCusAttribute3() == null : this.getCusAttribute3().equals(other.getCusAttribute3()))
            && (this.getCusAttribute4() == null ? other.getCusAttribute4() == null : this.getCusAttribute4().equals(other.getCusAttribute4()))
            && (this.getParentCusId() == null ? other.getParentCusId() == null : this.getParentCusId().equals(other.getParentCusId()))
            && (this.getCusPath() == null ? other.getCusPath() == null : this.getCusPath().equals(other.getCusPath()))
            && (this.getInnerOrder() == null ? other.getInnerOrder() == null : this.getInnerOrder().equals(other.getInnerOrder()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCusId() == null) ? 0 : getCusId().hashCode());
        result = prime * result + ((getCusNum() == null) ? 0 : getCusNum().hashCode());
        result = prime * result + ((getCusName() == null) ? 0 : getCusName().hashCode());
        result = prime * result + ((getCusNameAb() == null) ? 0 : getCusNameAb().hashCode());
        result = prime * result + ((getCusType() == null) ? 0 : getCusType().hashCode());
        result = prime * result + ((getCusLevel() == null) ? 0 : getCusLevel().hashCode());
        result = prime * result + ((getCusAddr() == null) ? 0 : getCusAddr().hashCode());
        result = prime * result + ((getCusPerson() == null) ? 0 : getCusPerson().hashCode());
        result = prime * result + ((getCusTel() == null) ? 0 : getCusTel().hashCode());
        result = prime * result + ((getCusEmail() == null) ? 0 : getCusEmail().hashCode());
        result = prime * result + ((getCusNote() == null) ? 0 : getCusNote().hashCode());
        result = prime * result + ((getCusIsLease() == null) ? 0 : getCusIsLease().hashCode());
        result = prime * result + ((getCusCircuitPostfix() == null) ? 0 : getCusCircuitPostfix().hashCode());
        result = prime * result + ((getCusAdminDistrict() == null) ? 0 : getCusAdminDistrict().hashCode());
        result = prime * result + ((getCusPostfixType() == null) ? 0 : getCusPostfixType().hashCode());
        result = prime * result + ((getIsValid() == null) ? 0 : getIsValid().hashCode());
        result = prime * result + ((getCusBelong() == null) ? 0 : getCusBelong().hashCode());
        result = prime * result + ((getCusServiceLevel() == null) ? 0 : getCusServiceLevel().hashCode());
        result = prime * result + ((getCusAttribute1() == null) ? 0 : getCusAttribute1().hashCode());
        result = prime * result + ((getCusAttribute2() == null) ? 0 : getCusAttribute2().hashCode());
        result = prime * result + ((getCusAttribute3() == null) ? 0 : getCusAttribute3().hashCode());
        result = prime * result + ((getCusAttribute4() == null) ? 0 : getCusAttribute4().hashCode());
        result = prime * result + ((getParentCusId() == null) ? 0 : getParentCusId().hashCode());
        result = prime * result + ((getCusPath() == null) ? 0 : getCusPath().hashCode());
        result = prime * result + ((getInnerOrder() == null) ? 0 : getInnerOrder().hashCode());
        return result;
    }
}