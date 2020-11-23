package com.ctsi.space.repository;

import com.ctsi.space.domain.BasProtectUserRelationship;
import com.ctsi.space.domain.BasProtectUserRelationshipExample;
import com.ctsi.space.domain.BasProtectUserRelationshipExample.Criteria;
import com.ctsi.space.domain.BasProtectUserRelationshipExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author ctsi-biyi-generator
*/
public class BasProtectUserRelationshipSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String countByExample(BasProtectUserRelationshipExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("bas_protect_user_relationship");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String deleteByExample(BasProtectUserRelationshipExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("bas_protect_user_relationship");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String insertSelective(BasProtectUserRelationship record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bas_protect_user_relationship");
        
        if (record.getRelationshipId() != null) {
            sql.VALUES("relationship_id", "#{relationshipId,jdbcType=DECIMAL}");
        }
        
        if (record.getProtectUserId() != null) {
            sql.VALUES("protect_user_id", "#{protectUserId,jdbcType=DECIMAL}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String selectByExample(BasProtectUserRelationshipExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("relationship_id");
        } else {
            sql.SELECT("relationship_id");
        }
        sql.SELECT("protect_user_id");
        sql.SELECT("user_id");
        sql.FROM("bas_protect_user_relationship");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasProtectUserRelationship record = (BasProtectUserRelationship) parameter.get("record");
        BasProtectUserRelationshipExample example = (BasProtectUserRelationshipExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("bas_protect_user_relationship");
        
        if (record.getRelationshipId() != null) {
            sql.SET("relationship_id = #{record.relationshipId,jdbcType=DECIMAL}");
        }
        
        if (record.getProtectUserId() != null) {
            sql.SET("protect_user_id = #{record.protectUserId,jdbcType=DECIMAL}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("bas_protect_user_relationship");
        
        sql.SET("relationship_id = #{record.relationshipId,jdbcType=DECIMAL}");
        sql.SET("protect_user_id = #{record.protectUserId,jdbcType=DECIMAL}");
        sql.SET("user_id = #{record.userId,jdbcType=DECIMAL}");
        
        BasProtectUserRelationshipExample example = (BasProtectUserRelationshipExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    public String updateByPrimaryKeySelective(BasProtectUserRelationship record) {
        SQL sql = new SQL();
        sql.UPDATE("bas_protect_user_relationship");
        
        if (record.getProtectUserId() != null) {
            sql.SET("protect_user_id = #{protectUserId,jdbcType=DECIMAL}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("relationship_id = #{relationshipId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_protect_user_relationship
     *
     * @mbg.generated Fri Sep 11 16:09:31 CST 2020
     */
    protected void applyWhere(SQL sql, BasProtectUserRelationshipExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}