/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.daoimp;

import com.entrecodigos.dao.ventaDao;
import com.entrecodigos.repositorio.mesa;
import com.entrecodigos.repositorio.productos;
import java.util.HashMap;
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
@Component("objVentasDao")
@Transactional
public class ventaDaoImp implements ventaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object getVentasCliente(boolean historico) {
        List<Map<String,Object>> consulta = jdbcTemplate.queryForList("select * from cliente where pagado = ?;",new Object[]{historico});
        return consulta;
    }

    @Override
    public Object insertar(mesa p) {
           Map<String, Object> respuesta = new HashMap<String, Object>();

        try {
           
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al insertar");
        }

        return respuesta;
    }

}
