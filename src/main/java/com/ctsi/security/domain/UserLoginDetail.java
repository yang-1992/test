package com.ctsi.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class UserLoginDetail implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.login_id
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private Long loginId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.login_name
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String loginName;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.user_name
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String userName;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.org_id
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private Long orgId;
	private String orgFullName;
	private Long orgParentId;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.telephone
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String telephone;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.password
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String password;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.is_valid
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private Integer isValid;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.note
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String note;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column org_user.create_time
	 *
	 * @mbg.generated Fri Feb 07 15:41:50 CST 2020
	 */
	private String createTime;
//	private String permissions;

	//用户存在哪些权限
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
//		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
//		if(null != getPermissions() && !getPermissions().equals("")){
//			if(getPermissions().indexOf(",") != -1){
//				for(int i=0;i<getPermissions().split(",").length;i++){
//					list.add(new SimpleGrantedAuthority(getPermissions().split(",")[i]));
//				}
//			}else{
//				list.add(new SimpleGrantedAuthority(getPermissions()));
//			}
//		}
//		return list;
		 return Arrays.asList(new SimpleGrantedAuthority(getLoginId().toString()));
	}

//	public String getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(String permissions) {
//		this.permissions = permissions;
//	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getLoginId() {
		return loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getUserName() {
		return userName;
	}

	public Long getOrgId() {
		return orgId;
	}

	public String getTelephone() {
		return telephone;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public String getNote() {
		return note;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOrgFullName() {
		return orgFullName;
	}

	public Long getOrgParentId() {
		return orgParentId;
	}

	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}

	public void setOrgParentId(Long orgParentId) {
		this.orgParentId = orgParentId;
	}

}