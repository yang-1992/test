package com.ctsi.security.repository;

import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.BasUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
public interface BasUserRepository extends com.ctsi.ssdc.repository.BaseRepository<BasUser, Long, BasUserExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @SelectProvider(type=BasUserSqlProvider.class, method="countByExample")
    long countByExample(BasUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @DeleteProvider(type=BasUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(BasUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @Delete({
        "delete from bas_user",
        "where user_id = #{userId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @Insert({
        "insert into bas_user (user_id, user_name, ",
        "user_mode, user_type_id, ",
        "user_login_name, user_password, ",
        "user_valid, user_work_num, ",
        "user_tel, user_email, ",
        "user_fax, note, center_nms, ",
        "org_id, oa_user_id, ",
        "person_id, status, ",
        "update_time)",
        "values (#{userId,jdbcType=DECIMAL}, #{userName,jdbcType=VARCHAR}, ",
        "#{userMode,jdbcType=TINYINT}, #{userTypeId,jdbcType=DECIMAL}, ",
        "#{userLoginName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ",
        "#{userValid,jdbcType=TINYINT}, #{userWorkNum,jdbcType=VARCHAR}, ",
        "#{userTel,jdbcType=VARCHAR}, #{userEmail,jdbcType=VARCHAR}, ",
        "#{userFax,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, #{centerNms,jdbcType=DECIMAL}, ",
        "#{orgId,jdbcType=DECIMAL}, #{oaUserId,jdbcType=VARCHAR}, ",
        "#{personId,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BasUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @InsertProvider(type=BasUserSqlProvider.class, method="insertSelective")
    int insertSelective(BasUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @SelectProvider(type=BasUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mode", property="userMode", jdbcType=JdbcType.TINYINT),
        @Result(column="user_type_id", property="userTypeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_valid", property="userValid", jdbcType=JdbcType.TINYINT),
        @Result(column="user_work_num", property="userWorkNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_tel", property="userTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_fax", property="userFax", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="center_nms", property="centerNms", jdbcType=JdbcType.DECIMAL),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.DECIMAL),
        @Result(column="oa_user_id", property="oaUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_id", property="personId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BasUser> selectByExample(BasUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @Select({
        "select",
        "user_id, user_name, user_mode, user_type_id, user_login_name, user_password, ",
        "user_valid, user_work_num, user_tel, user_email, user_fax, note, center_nms, ",
        "org_id, oa_user_id, person_id, status, update_time",
        "from bas_user",
        "where user_id = #{userId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mode", property="userMode", jdbcType=JdbcType.TINYINT),
        @Result(column="user_type_id", property="userTypeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_valid", property="userValid", jdbcType=JdbcType.TINYINT),
        @Result(column="user_work_num", property="userWorkNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_tel", property="userTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_fax", property="userFax", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="center_nms", property="centerNms", jdbcType=JdbcType.DECIMAL),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.DECIMAL),
        @Result(column="oa_user_id", property="oaUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_id", property="personId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BasUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @UpdateProvider(type=BasUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasUser record, @Param("example") BasUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @UpdateProvider(type=BasUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BasUser record, @Param("example") BasUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @UpdateProvider(type=BasUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BasUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_user
     *
     * @mbg.generated Fri Sep 18 10:12:01 CST 2020
     */
    @Update({
        "update bas_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_mode = #{userMode,jdbcType=TINYINT},",
          "user_type_id = #{userTypeId,jdbcType=DECIMAL},",
          "user_login_name = #{userLoginName,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "user_valid = #{userValid,jdbcType=TINYINT},",
          "user_work_num = #{userWorkNum,jdbcType=VARCHAR},",
          "user_tel = #{userTel,jdbcType=VARCHAR},",
          "user_email = #{userEmail,jdbcType=VARCHAR},",
          "user_fax = #{userFax,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "center_nms = #{centerNms,jdbcType=DECIMAL},",
          "org_id = #{orgId,jdbcType=DECIMAL},",
          "oa_user_id = #{oaUserId,jdbcType=VARCHAR},",
          "person_id = #{personId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(BasUser record);

    @SelectProvider(type = com.ctsi.security.repository.BasUserSqlProvider.class, method = "selectUserIdsByOrgIds")
    List<Long> selectUserIdsByOrgIds(@Param("orgIds") List<Long> orgIds);
}