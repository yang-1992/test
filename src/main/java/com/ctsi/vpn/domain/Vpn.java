package com.ctsi.vpn.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @author ctsi-biyi-generator
*/
public class Vpn implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vpn_id
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Long vpnId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String netCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.crm_net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String crmNetCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vpn_type
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Short vpnType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vsi
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String vsi;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vrf
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String vrf;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String rd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_name
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_name_ab
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusNameAb;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_address
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_contact
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_tel
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.cus_fax_email
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String cusFaxEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vpn_route_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Long vpnRouteNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.net_topo
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Short netTopo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.busi_create_area
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Long busiCreateArea;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vpn_type_detail
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Integer vpnTypeDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.rt_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String rtIpv6;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.optional_rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String optionalRd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.create_time
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private ZonedDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String rdIpv6;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.vpn_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Short vpnIpv6;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.accept_carrier
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private Long acceptCarrier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.optional_rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String optionalRdIpv6;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.update_timestamp
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private ZonedDateTime updateTimestamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vpn.topology_level
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    private String topologyLevel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vpn_id
     *
     * @return the value of vpn.vpn_id
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Long getVpnId() {
        return vpnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vpn_id
     *
     * @param vpnId the value for vpn.vpn_id
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVpnId(Long vpnId) {
        this.vpnId = vpnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.net_code
     *
     * @return the value of vpn.net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getNetCode() {
        return netCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.net_code
     *
     * @param netCode the value for vpn.net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setNetCode(String netCode) {
        this.netCode = netCode == null ? null : netCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.crm_net_code
     *
     * @return the value of vpn.crm_net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCrmNetCode() {
        return crmNetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.crm_net_code
     *
     * @param crmNetCode the value for vpn.crm_net_code
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCrmNetCode(String crmNetCode) {
        this.crmNetCode = crmNetCode == null ? null : crmNetCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vpn_type
     *
     * @return the value of vpn.vpn_type
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Short getVpnType() {
        return vpnType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vpn_type
     *
     * @param vpnType the value for vpn.vpn_type
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVpnType(Short vpnType) {
        this.vpnType = vpnType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vsi
     *
     * @return the value of vpn.vsi
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getVsi() {
        return vsi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vsi
     *
     * @param vsi the value for vpn.vsi
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVsi(String vsi) {
        this.vsi = vsi == null ? null : vsi.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vrf
     *
     * @return the value of vpn.vrf
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getVrf() {
        return vrf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vrf
     *
     * @param vrf the value for vpn.vrf
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVrf(String vrf) {
        this.vrf = vrf == null ? null : vrf.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.rd
     *
     * @return the value of vpn.rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getRd() {
        return rd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.rd
     *
     * @param rd the value for vpn.rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setRd(String rd) {
        this.rd = rd == null ? null : rd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_num
     *
     * @return the value of vpn.cus_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusNum() {
        return cusNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_num
     *
     * @param cusNum the value for vpn.cus_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusNum(String cusNum) {
        this.cusNum = cusNum == null ? null : cusNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_name
     *
     * @return the value of vpn.cus_name
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_name
     *
     * @param cusName the value for vpn.cus_name
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_name_ab
     *
     * @return the value of vpn.cus_name_ab
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusNameAb() {
        return cusNameAb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_name_ab
     *
     * @param cusNameAb the value for vpn.cus_name_ab
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusNameAb(String cusNameAb) {
        this.cusNameAb = cusNameAb == null ? null : cusNameAb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_address
     *
     * @return the value of vpn.cus_address
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusAddress() {
        return cusAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_address
     *
     * @param cusAddress the value for vpn.cus_address
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress == null ? null : cusAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_contact
     *
     * @return the value of vpn.cus_contact
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusContact() {
        return cusContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_contact
     *
     * @param cusContact the value for vpn.cus_contact
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusContact(String cusContact) {
        this.cusContact = cusContact == null ? null : cusContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_tel
     *
     * @return the value of vpn.cus_tel
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusTel() {
        return cusTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_tel
     *
     * @param cusTel the value for vpn.cus_tel
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusTel(String cusTel) {
        this.cusTel = cusTel == null ? null : cusTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.cus_fax_email
     *
     * @return the value of vpn.cus_fax_email
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getCusFaxEmail() {
        return cusFaxEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.cus_fax_email
     *
     * @param cusFaxEmail the value for vpn.cus_fax_email
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCusFaxEmail(String cusFaxEmail) {
        this.cusFaxEmail = cusFaxEmail == null ? null : cusFaxEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vpn_route_num
     *
     * @return the value of vpn.vpn_route_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Long getVpnRouteNum() {
        return vpnRouteNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vpn_route_num
     *
     * @param vpnRouteNum the value for vpn.vpn_route_num
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVpnRouteNum(Long vpnRouteNum) {
        this.vpnRouteNum = vpnRouteNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.net_topo
     *
     * @return the value of vpn.net_topo
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Short getNetTopo() {
        return netTopo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.net_topo
     *
     * @param netTopo the value for vpn.net_topo
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setNetTopo(Short netTopo) {
        this.netTopo = netTopo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.busi_create_area
     *
     * @return the value of vpn.busi_create_area
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Long getBusiCreateArea() {
        return busiCreateArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.busi_create_area
     *
     * @param busiCreateArea the value for vpn.busi_create_area
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setBusiCreateArea(Long busiCreateArea) {
        this.busiCreateArea = busiCreateArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vpn_type_detail
     *
     * @return the value of vpn.vpn_type_detail
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Integer getVpnTypeDetail() {
        return vpnTypeDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vpn_type_detail
     *
     * @param vpnTypeDetail the value for vpn.vpn_type_detail
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVpnTypeDetail(Integer vpnTypeDetail) {
        this.vpnTypeDetail = vpnTypeDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.rt_ipv6
     *
     * @return the value of vpn.rt_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getRtIpv6() {
        return rtIpv6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.rt_ipv6
     *
     * @param rtIpv6 the value for vpn.rt_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setRtIpv6(String rtIpv6) {
        this.rtIpv6 = rtIpv6 == null ? null : rtIpv6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.optional_rd
     *
     * @return the value of vpn.optional_rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getOptionalRd() {
        return optionalRd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.optional_rd
     *
     * @param optionalRd the value for vpn.optional_rd
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setOptionalRd(String optionalRd) {
        this.optionalRd = optionalRd == null ? null : optionalRd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.create_time
     *
     * @return the value of vpn.create_time
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.create_time
     *
     * @param createTime the value for vpn.create_time
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.rd_ipv6
     *
     * @return the value of vpn.rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getRdIpv6() {
        return rdIpv6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.rd_ipv6
     *
     * @param rdIpv6 the value for vpn.rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setRdIpv6(String rdIpv6) {
        this.rdIpv6 = rdIpv6 == null ? null : rdIpv6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.vpn_ipv6
     *
     * @return the value of vpn.vpn_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Short getVpnIpv6() {
        return vpnIpv6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.vpn_ipv6
     *
     * @param vpnIpv6 the value for vpn.vpn_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setVpnIpv6(Short vpnIpv6) {
        this.vpnIpv6 = vpnIpv6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.accept_carrier
     *
     * @return the value of vpn.accept_carrier
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public Long getAcceptCarrier() {
        return acceptCarrier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.accept_carrier
     *
     * @param acceptCarrier the value for vpn.accept_carrier
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setAcceptCarrier(Long acceptCarrier) {
        this.acceptCarrier = acceptCarrier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.optional_rd_ipv6
     *
     * @return the value of vpn.optional_rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getOptionalRdIpv6() {
        return optionalRdIpv6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.optional_rd_ipv6
     *
     * @param optionalRdIpv6 the value for vpn.optional_rd_ipv6
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setOptionalRdIpv6(String optionalRdIpv6) {
        this.optionalRdIpv6 = optionalRdIpv6 == null ? null : optionalRdIpv6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.update_timestamp
     *
     * @return the value of vpn.update_timestamp
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public ZonedDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.update_timestamp
     *
     * @param updateTimestamp the value for vpn.update_timestamp
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setUpdateTimestamp(ZonedDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vpn.topology_level
     *
     * @return the value of vpn.topology_level
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public String getTopologyLevel() {
        return topologyLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vpn.topology_level
     *
     * @param topologyLevel the value for vpn.topology_level
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    public void setTopologyLevel(String topologyLevel) {
        this.topologyLevel = topologyLevel == null ? null : topologyLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vpn
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
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
        Vpn other = (Vpn) that;
        return (this.getVpnId() == null ? other.getVpnId() == null : this.getVpnId().equals(other.getVpnId()))
            && (this.getNetCode() == null ? other.getNetCode() == null : this.getNetCode().equals(other.getNetCode()))
            && (this.getCrmNetCode() == null ? other.getCrmNetCode() == null : this.getCrmNetCode().equals(other.getCrmNetCode()))
            && (this.getVpnType() == null ? other.getVpnType() == null : this.getVpnType().equals(other.getVpnType()))
            && (this.getVsi() == null ? other.getVsi() == null : this.getVsi().equals(other.getVsi()))
            && (this.getVrf() == null ? other.getVrf() == null : this.getVrf().equals(other.getVrf()))
            && (this.getRd() == null ? other.getRd() == null : this.getRd().equals(other.getRd()))
            && (this.getCusNum() == null ? other.getCusNum() == null : this.getCusNum().equals(other.getCusNum()))
            && (this.getCusName() == null ? other.getCusName() == null : this.getCusName().equals(other.getCusName()))
            && (this.getCusNameAb() == null ? other.getCusNameAb() == null : this.getCusNameAb().equals(other.getCusNameAb()))
            && (this.getCusAddress() == null ? other.getCusAddress() == null : this.getCusAddress().equals(other.getCusAddress()))
            && (this.getCusContact() == null ? other.getCusContact() == null : this.getCusContact().equals(other.getCusContact()))
            && (this.getCusTel() == null ? other.getCusTel() == null : this.getCusTel().equals(other.getCusTel()))
            && (this.getCusFaxEmail() == null ? other.getCusFaxEmail() == null : this.getCusFaxEmail().equals(other.getCusFaxEmail()))
            && (this.getVpnRouteNum() == null ? other.getVpnRouteNum() == null : this.getVpnRouteNum().equals(other.getVpnRouteNum()))
            && (this.getNetTopo() == null ? other.getNetTopo() == null : this.getNetTopo().equals(other.getNetTopo()))
            && (this.getBusiCreateArea() == null ? other.getBusiCreateArea() == null : this.getBusiCreateArea().equals(other.getBusiCreateArea()))
            && (this.getVpnTypeDetail() == null ? other.getVpnTypeDetail() == null : this.getVpnTypeDetail().equals(other.getVpnTypeDetail()))
            && (this.getRtIpv6() == null ? other.getRtIpv6() == null : this.getRtIpv6().equals(other.getRtIpv6()))
            && (this.getOptionalRd() == null ? other.getOptionalRd() == null : this.getOptionalRd().equals(other.getOptionalRd()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRdIpv6() == null ? other.getRdIpv6() == null : this.getRdIpv6().equals(other.getRdIpv6()))
            && (this.getVpnIpv6() == null ? other.getVpnIpv6() == null : this.getVpnIpv6().equals(other.getVpnIpv6()))
            && (this.getAcceptCarrier() == null ? other.getAcceptCarrier() == null : this.getAcceptCarrier().equals(other.getAcceptCarrier()))
            && (this.getOptionalRdIpv6() == null ? other.getOptionalRdIpv6() == null : this.getOptionalRdIpv6().equals(other.getOptionalRdIpv6()))
            && (this.getUpdateTimestamp() == null ? other.getUpdateTimestamp() == null : this.getUpdateTimestamp().equals(other.getUpdateTimestamp()))
            && (this.getTopologyLevel() == null ? other.getTopologyLevel() == null : this.getTopologyLevel().equals(other.getTopologyLevel()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vpn
     *
     * @mbg.generated Tue Nov 17 18:33:03 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVpnId() == null) ? 0 : getVpnId().hashCode());
        result = prime * result + ((getNetCode() == null) ? 0 : getNetCode().hashCode());
        result = prime * result + ((getCrmNetCode() == null) ? 0 : getCrmNetCode().hashCode());
        result = prime * result + ((getVpnType() == null) ? 0 : getVpnType().hashCode());
        result = prime * result + ((getVsi() == null) ? 0 : getVsi().hashCode());
        result = prime * result + ((getVrf() == null) ? 0 : getVrf().hashCode());
        result = prime * result + ((getRd() == null) ? 0 : getRd().hashCode());
        result = prime * result + ((getCusNum() == null) ? 0 : getCusNum().hashCode());
        result = prime * result + ((getCusName() == null) ? 0 : getCusName().hashCode());
        result = prime * result + ((getCusNameAb() == null) ? 0 : getCusNameAb().hashCode());
        result = prime * result + ((getCusAddress() == null) ? 0 : getCusAddress().hashCode());
        result = prime * result + ((getCusContact() == null) ? 0 : getCusContact().hashCode());
        result = prime * result + ((getCusTel() == null) ? 0 : getCusTel().hashCode());
        result = prime * result + ((getCusFaxEmail() == null) ? 0 : getCusFaxEmail().hashCode());
        result = prime * result + ((getVpnRouteNum() == null) ? 0 : getVpnRouteNum().hashCode());
        result = prime * result + ((getNetTopo() == null) ? 0 : getNetTopo().hashCode());
        result = prime * result + ((getBusiCreateArea() == null) ? 0 : getBusiCreateArea().hashCode());
        result = prime * result + ((getVpnTypeDetail() == null) ? 0 : getVpnTypeDetail().hashCode());
        result = prime * result + ((getRtIpv6() == null) ? 0 : getRtIpv6().hashCode());
        result = prime * result + ((getOptionalRd() == null) ? 0 : getOptionalRd().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRdIpv6() == null) ? 0 : getRdIpv6().hashCode());
        result = prime * result + ((getVpnIpv6() == null) ? 0 : getVpnIpv6().hashCode());
        result = prime * result + ((getAcceptCarrier() == null) ? 0 : getAcceptCarrier().hashCode());
        result = prime * result + ((getOptionalRdIpv6() == null) ? 0 : getOptionalRdIpv6().hashCode());
        result = prime * result + ((getUpdateTimestamp() == null) ? 0 : getUpdateTimestamp().hashCode());
        result = prime * result + ((getTopologyLevel() == null) ? 0 : getTopologyLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Vpn{" +
                "vpnId=" + vpnId +
                ", netCode='" + netCode + '\'' +
                ", crmNetCode='" + crmNetCode + '\'' +
                ", vpnType=" + vpnType +
                ", vsi='" + vsi + '\'' +
                ", vrf='" + vrf + '\'' +
                ", rd='" + rd + '\'' +
                ", cusNum='" + cusNum + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusNameAb='" + cusNameAb + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", cusTel='" + cusTel + '\'' +
                ", cusFaxEmail='" + cusFaxEmail + '\'' +
                ", vpnRouteNum=" + vpnRouteNum +
                ", netTopo=" + netTopo +
                ", busiCreateArea=" + busiCreateArea +
                ", vpnTypeDetail=" + vpnTypeDetail +
                ", rtIpv6='" + rtIpv6 + '\'' +
                ", optionalRd='" + optionalRd + '\'' +
                ", createTime=" + createTime +
                ", rdIpv6='" + rdIpv6 + '\'' +
                ", vpnIpv6=" + vpnIpv6 +
                ", acceptCarrier=" + acceptCarrier +
                ", optionalRdIpv6='" + optionalRdIpv6 + '\'' +
                ", updateTimestamp=" + updateTimestamp +
                ", topologyLevel='" + topologyLevel + '\'' +
                '}';
    }
}