/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.daoimp;

import com.entrecodigos.dao.mesasDao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samv
 */
@Component("objMesasDao")
@Transactional
public class mesasDaoImp implements mesasDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Object getMesas() {
         List<Map<String,Object>> consulta = jdbcTemplate.queryForList("select * from mesa;");
        return consulta;
    }
    
}
