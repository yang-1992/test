package com.ctsi.block.repository;

import com.ctsi.block.domain.BlockedSystem;
import com.ctsi.block.domain.BlockedSystemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
@Repository
public interface BlockedSystemRepository extends com.ctsi.ssdc.repository.BaseRepository<BlockedSystem, Object, BlockedSystemExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @SelectProvider(type=BlockedSystemSqlProvider.class, method="countByExample")
    long countByExample(BlockedSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @DeleteProvider(type=BlockedSystemSqlProvider.class, method="deleteByExample")
    int deleteByExample(BlockedSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @Insert({
        "insert into trans_con_db.blocked_system (affact_id, blocked_id, ",
        "data_resource, system_type, ",
        "system_id, system_name, ",
        "system_mark, system_level, ",
        "system_alias)",
        "values (#{affactId,jdbcType=DECIMAL}, #{blockedId,jdbcType=DECIMAL}, ",
        "#{dataResource,jdbcType=DECIMAL}, #{systemType,jdbcType=DECIMAL}, ",
        "#{systemId,jdbcType=DECIMAL}, #{systemName,jdbcType=VARCHAR}, ",
        "#{systemMark,jdbcType=VARCHAR}, #{systemLevel,jdbcType=DECIMAL}, ",
        "#{systemAlias,jdbcType=VARCHAR})"
    })
    int insert(BlockedSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @InsertProvider(type=BlockedSystemSqlProvider.class, method="insertSelective")
    int insertSelective(BlockedSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @SelectProvider(type=BlockedSystemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="affact_id", property="affactId", jdbcType=JdbcType.DECIMAL),
        @Result(column="blocked_id", property="blockedId", jdbcType=JdbcType.DECIMAL),
        @Result(column="data_resource", property="dataResource", jdbcType=JdbcType.DECIMAL),
        @Result(column="system_type", property="systemType", jdbcType=JdbcType.DECIMAL),
        @Result(column="system_id", property="systemId", jdbcType=JdbcType.DECIMAL),
        @Result(column="system_name", property="systemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="system_mark", property="systemMark", jdbcType=JdbcType.VARCHAR),
        @Result(column="system_level", property="systemLevel", jdbcType=JdbcType.DECIMAL),
        @Result(column="system_alias", property="systemAlias", jdbcType=JdbcType.VARCHAR)
    })
    List<BlockedSystem> selectByExample(BlockedSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @UpdateProvider(type=BlockedSystemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BlockedSystem record, @Param("example") BlockedSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blocked_system
     *
     * @mbg.generated Wed Oct 28 17:18:56 CST 2020
     */
    @UpdateProvider(type=BlockedSystemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BlockedSystem record, @Param("example") BlockedSystemExample example);

    @Select({
            "<script>",
                "select blocked_id,system_name from ",
                "trans_con_db.blocked_system where data_resource = 0 and blocked_id in ",
                " <foreach item='item' index='index' collection='list' open='(' separator=',' close=')'> #{item}</foreach>",
            "</script>",
    })
            @Results({
            @Result(column="blocked_id", property="blockedId", jdbcType=JdbcType.DECIMAL),
            @Result(column="system_name", property="systemName", jdbcType=JdbcType.VARCHAR),
    })
    List<BlockedSystem> selectSystemByBlockedId(List<Long> blockedList);

    @Delete({
        "delete from trans_con_db.blocked_system where blocked_id = #{blockedId} and data_resource = #{resource}"
    })
    int deleteByBlocked(@Param("blockedId") Long blockedId,@Param("resource") int resource);
}