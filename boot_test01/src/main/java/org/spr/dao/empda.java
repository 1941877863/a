package org.spr.dao;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class empda implements Impos {

    @Resource
    private JdbcTemplate jt;

    /*
     * @Resource public void setJt(JdbcTemplate jt) { this.jt = jt; }
     */

    @Override
    public List<Map<String,Object>> queryAll(String sql) {
        List<Map<String,Object>> el = jt.query(sql,new ColumnMapRowMapper());
        return el;
    }

    public void dele(String sql){
        jt.update(sql);
    }
}