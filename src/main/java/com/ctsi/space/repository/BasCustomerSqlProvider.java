package com.ctsi.space.repository;

import com.ctsi.space.domain.BasCustomer;
import com.ctsi.space.domain.BasCustomerExample;
import com.ctsi.space.domain.BasCustomerExample.Criteria;
import com.ctsi.space.domain.BasCustomerExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author ctsi-biyi-generator
*/
public class BasCustomerSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String countByExample(BasCustomerExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("bas_customer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String deleteByExample(BasCustomerExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("bas_customer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String insertSelective(BasCustomer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bas_customer");
        
        if (record.getCusId() != null) {
            sql.VALUES("cus_id", "#{cusId,jdbcType=DECIMAL}");
        }
        
        if (record.getCusNum() != null) {
            sql.VALUES("cus_num", "#{cusNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCusName() != null) {
            sql.VALUES("cus_name", "#{cusName,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNameAb() != null) {
            sql.VALUES("cus_name_ab", "#{cusNameAb,jdbcType=VARCHAR}");
        }
        
        if (record.getCusType() != null) {
            sql.VALUES("cus_type", "#{cusType,jdbcType=DECIMAL}");
        }
        
        if (record.getCusLevel() != null) {
            sql.VALUES("cus_level", "#{cusLevel,jdbcType=TINYINT}");
        }
        
        if (record.getCusAddr() != null) {
            sql.VALUES("cus_addr", "#{cusAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getCusPerson() != null) {
            sql.VALUES("cus_person", "#{cusPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCusTel() != null) {
            sql.VALUES("cus_tel", "#{cusTel,jdbcType=VARCHAR}");
        }
        
        if (record.getCusEmail() != null) {
            sql.VALUES("cus_email", "#{cusEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNote() != null) {
            sql.VALUES("cus_note", "#{cusNote,jdbcType=VARCHAR}");
        }
        
        if (record.getCusIsLease() != null) {
            sql.VALUES("cus_is_lease", "#{cusIsLease,jdbcType=TINYINT}");
        }
        
        if (record.getCusCircuitPostfix() != null) {
            sql.VALUES("cus_circuit_postfix", "#{cusCircuitPostfix,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAdminDistrict() != null) {
            sql.VALUES("cus_admin_district", "#{cusAdminDistrict,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPostfixType() != null) {
            sql.VALUES("cus_postfix_type", "#{cusPostfixType,jdbcType=INTEGER}");
        }
        
        if (record.getIsValid() != null) {
            sql.VALUES("is_valid", "#{isValid,jdbcType=TINYINT}");
        }
        
        if (record.getCusBelong() != null) {
            sql.VALUES("cus_belong", "#{cusBelong,jdbcType=TINYINT}");
        }
        
        if (record.getCusServiceLevel() != null) {
            sql.VALUES("cus_service_level", "#{cusServiceLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCusAttribute1() != null) {
            sql.VALUES("cus_attribute1", "#{cusAttribute1,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute2() != null) {
            sql.VALUES("cus_attribute2", "#{cusAttribute2,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute3() != null) {
            sql.VALUES("cus_attribute3", "#{cusAttribute3,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute4() != null) {
            sql.VALUES("cus_attribute4", "#{cusAttribute4,jdbcType=VARCHAR}");
        }
        
        if (record.getParentCusId() != null) {
            sql.VALUES("parent_cus_id", "#{parentCusId,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPath() != null) {
            sql.VALUES("cus_path", "#{cusPath,jdbcType=VARCHAR}");
        }
        
        if (record.getInnerOrder() != null) {
            sql.VALUES("inner_order", "#{innerOrder,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String selectByExample(BasCustomerExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("cus_id");
        } else {
            sql.SELECT("cus_id");
        }
        sql.SELECT("cus_num");
        sql.SELECT("cus_name");
        sql.SELECT("cus_name_ab");
        sql.SELECT("cus_type");
        sql.SELECT("cus_level");
        sql.SELECT("cus_addr");
        sql.SELECT("cus_person");
        sql.SELECT("cus_tel");
        sql.SELECT("cus_email");
        sql.SELECT("cus_note");
        sql.SELECT("cus_is_lease");
        sql.SELECT("cus_circuit_postfix");
        sql.SELECT("cus_admin_district");
        sql.SELECT("cus_postfix_type");
        sql.SELECT("is_valid");
        sql.SELECT("cus_belong");
        sql.SELECT("cus_service_level");
        sql.SELECT("cus_attribute1");
        sql.SELECT("cus_attribute2");
        sql.SELECT("cus_attribute3");
        sql.SELECT("cus_attribute4");
        sql.SELECT("parent_cus_id");
        sql.SELECT("cus_path");
        sql.SELECT("inner_order");
        sql.FROM("bas_customer");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasCustomer record = (BasCustomer) parameter.get("record");
        BasCustomerExample example = (BasCustomerExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("bas_customer");
        
        if (record.getCusId() != null) {
            sql.SET("cus_id = #{record.cusId,jdbcType=DECIMAL}");
        }
        
        if (record.getCusNum() != null) {
            sql.SET("cus_num = #{record.cusNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCusName() != null) {
            sql.SET("cus_name = #{record.cusName,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNameAb() != null) {
            sql.SET("cus_name_ab = #{record.cusNameAb,jdbcType=VARCHAR}");
        }
        
        if (record.getCusType() != null) {
            sql.SET("cus_type = #{record.cusType,jdbcType=DECIMAL}");
        }
        
        if (record.getCusLevel() != null) {
            sql.SET("cus_level = #{record.cusLevel,jdbcType=TINYINT}");
        }
        
        if (record.getCusAddr() != null) {
            sql.SET("cus_addr = #{record.cusAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getCusPerson() != null) {
            sql.SET("cus_person = #{record.cusPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCusTel() != null) {
            sql.SET("cus_tel = #{record.cusTel,jdbcType=VARCHAR}");
        }
        
        if (record.getCusEmail() != null) {
            sql.SET("cus_email = #{record.cusEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNote() != null) {
            sql.SET("cus_note = #{record.cusNote,jdbcType=VARCHAR}");
        }
        
        if (record.getCusIsLease() != null) {
            sql.SET("cus_is_lease = #{record.cusIsLease,jdbcType=TINYINT}");
        }
        
        if (record.getCusCircuitPostfix() != null) {
            sql.SET("cus_circuit_postfix = #{record.cusCircuitPostfix,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAdminDistrict() != null) {
            sql.SET("cus_admin_district = #{record.cusAdminDistrict,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPostfixType() != null) {
            sql.SET("cus_postfix_type = #{record.cusPostfixType,jdbcType=INTEGER}");
        }
        
        if (record.getIsValid() != null) {
            sql.SET("is_valid = #{record.isValid,jdbcType=TINYINT}");
        }
        
        if (record.getCusBelong() != null) {
            sql.SET("cus_belong = #{record.cusBelong,jdbcType=TINYINT}");
        }
        
        if (record.getCusServiceLevel() != null) {
            sql.SET("cus_service_level = #{record.cusServiceLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCusAttribute1() != null) {
            sql.SET("cus_attribute1 = #{record.cusAttribute1,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute2() != null) {
            sql.SET("cus_attribute2 = #{record.cusAttribute2,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute3() != null) {
            sql.SET("cus_attribute3 = #{record.cusAttribute3,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute4() != null) {
            sql.SET("cus_attribute4 = #{record.cusAttribute4,jdbcType=VARCHAR}");
        }
        
        if (record.getParentCusId() != null) {
            sql.SET("parent_cus_id = #{record.parentCusId,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPath() != null) {
            sql.SET("cus_path = #{record.cusPath,jdbcType=VARCHAR}");
        }
        
        if (record.getInnerOrder() != null) {
            sql.SET("inner_order = #{record.innerOrder,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("bas_customer");
        
        sql.SET("cus_id = #{record.cusId,jdbcType=DECIMAL}");
        sql.SET("cus_num = #{record.cusNum,jdbcType=VARCHAR}");
        sql.SET("cus_name = #{record.cusName,jdbcType=VARCHAR}");
        sql.SET("cus_name_ab = #{record.cusNameAb,jdbcType=VARCHAR}");
        sql.SET("cus_type = #{record.cusType,jdbcType=DECIMAL}");
        sql.SET("cus_level = #{record.cusLevel,jdbcType=TINYINT}");
        sql.SET("cus_addr = #{record.cusAddr,jdbcType=VARCHAR}");
        sql.SET("cus_person = #{record.cusPerson,jdbcType=VARCHAR}");
        sql.SET("cus_tel = #{record.cusTel,jdbcType=VARCHAR}");
        sql.SET("cus_email = #{record.cusEmail,jdbcType=VARCHAR}");
        sql.SET("cus_note = #{record.cusNote,jdbcType=VARCHAR}");
        sql.SET("cus_is_lease = #{record.cusIsLease,jdbcType=TINYINT}");
        sql.SET("cus_circuit_postfix = #{record.cusCircuitPostfix,jdbcType=VARCHAR}");
        sql.SET("cus_admin_district = #{record.cusAdminDistrict,jdbcType=DECIMAL}");
        sql.SET("cus_postfix_type = #{record.cusPostfixType,jdbcType=INTEGER}");
        sql.SET("is_valid = #{record.isValid,jdbcType=TINYINT}");
        sql.SET("cus_belong = #{record.cusBelong,jdbcType=TINYINT}");
        sql.SET("cus_service_level = #{record.cusServiceLevel,jdbcType=INTEGER}");
        sql.SET("cus_attribute1 = #{record.cusAttribute1,jdbcType=VARCHAR}");
        sql.SET("cus_attribute2 = #{record.cusAttribute2,jdbcType=VARCHAR}");
        sql.SET("cus_attribute3 = #{record.cusAttribute3,jdbcType=VARCHAR}");
        sql.SET("cus_attribute4 = #{record.cusAttribute4,jdbcType=VARCHAR}");
        sql.SET("parent_cus_id = #{record.parentCusId,jdbcType=DECIMAL}");
        sql.SET("cus_path = #{record.cusPath,jdbcType=VARCHAR}");
        sql.SET("inner_order = #{record.innerOrder,jdbcType=VARCHAR}");
        
        BasCustomerExample example = (BasCustomerExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    public String updateByPrimaryKeySelective(BasCustomer record) {
        SQL sql = new SQL();
        sql.UPDATE("bas_customer");
        
        if (record.getCusNum() != null) {
            sql.SET("cus_num = #{cusNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCusName() != null) {
            sql.SET("cus_name = #{cusName,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNameAb() != null) {
            sql.SET("cus_name_ab = #{cusNameAb,jdbcType=VARCHAR}");
        }
        
        if (record.getCusType() != null) {
            sql.SET("cus_type = #{cusType,jdbcType=DECIMAL}");
        }
        
        if (record.getCusLevel() != null) {
            sql.SET("cus_level = #{cusLevel,jdbcType=TINYINT}");
        }
        
        if (record.getCusAddr() != null) {
            sql.SET("cus_addr = #{cusAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getCusPerson() != null) {
            sql.SET("cus_person = #{cusPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCusTel() != null) {
            sql.SET("cus_tel = #{cusTel,jdbcType=VARCHAR}");
        }
        
        if (record.getCusEmail() != null) {
            sql.SET("cus_email = #{cusEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCusNote() != null) {
            sql.SET("cus_note = #{cusNote,jdbcType=VARCHAR}");
        }
        
        if (record.getCusIsLease() != null) {
            sql.SET("cus_is_lease = #{cusIsLease,jdbcType=TINYINT}");
        }
        
        if (record.getCusCircuitPostfix() != null) {
            sql.SET("cus_circuit_postfix = #{cusCircuitPostfix,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAdminDistrict() != null) {
            sql.SET("cus_admin_district = #{cusAdminDistrict,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPostfixType() != null) {
            sql.SET("cus_postfix_type = #{cusPostfixType,jdbcType=INTEGER}");
        }
        
        if (record.getIsValid() != null) {
            sql.SET("is_valid = #{isValid,jdbcType=TINYINT}");
        }
        
        if (record.getCusBelong() != null) {
            sql.SET("cus_belong = #{cusBelong,jdbcType=TINYINT}");
        }
        
        if (record.getCusServiceLevel() != null) {
            sql.SET("cus_service_level = #{cusServiceLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCusAttribute1() != null) {
            sql.SET("cus_attribute1 = #{cusAttribute1,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute2() != null) {
            sql.SET("cus_attribute2 = #{cusAttribute2,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute3() != null) {
            sql.SET("cus_attribute3 = #{cusAttribute3,jdbcType=VARCHAR}");
        }
        
        if (record.getCusAttribute4() != null) {
            sql.SET("cus_attribute4 = #{cusAttribute4,jdbcType=VARCHAR}");
        }
        
        if (record.getParentCusId() != null) {
            sql.SET("parent_cus_id = #{parentCusId,jdbcType=DECIMAL}");
        }
        
        if (record.getCusPath() != null) {
            sql.SET("cus_path = #{cusPath,jdbcType=VARCHAR}");
        }
        
        if (record.getInnerOrder() != null) {
            sql.SET("inner_order = #{innerOrder,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("cus_id = #{cusId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bas_customer
     *
     * @mbg.generated Fri Sep 11 16:07:21 CST 2020
     */
    protected void applyWhere(SQL sql, BasCustomerExample example, boolean includeExamplePhrase) {
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