/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.daoimp;

import com.entrecodigos.dao.productosDao;
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

@Component("objProductosDao")
@Transactional
public class productosDaoImp implements productosDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object getProductos() {
        List<Map<String,Object>> consulta = jdbcTemplate.queryForList("select * from productos;");
        return consulta;
    }

    @Override
    public Object insertar(productos p) {
         Map<String, Object> respuesta = new HashMap<String, Object>();

        try {
            String nombre = p.getNombre();
            String descripcion = p.getDescripcion();
            double precio = p.getPrecio();
            String rutaimagen = p.getRutaimagen();
            
            
            String query = "insert into productos (nombre,descripcion,precio,rutaimagen) values(?,?,?,?);";
            int res = jdbcTemplate.update(query, new Object[]{nombre,descripcion,precio,rutaimagen});
            respuesta.put("respuesta", "Registro insertado");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al insertar");
        }

        return respuesta;
    }

    @Override
    public Object eliminar(productos p) {
        Map<String, Object> respuesta = new HashMap<String, Object>();

        try {
            int id = p.getId();
            String query = "delete from productos where id = ?";
            int res = jdbcTemplate.update(query, new Object[]{id});
            respuesta.put("respuesta", "Registro eliminado");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al eliminar");
        }
        return respuesta;
    }

    @Override
    public Object actualizar(productos p) {
         Map<String, Object> respuesta = new HashMap<String, Object>();

        try {
            int id = p.getId();
            String nombre = p.getNombre();
            String descripcion = p.getDescripcion();
            String rutaimagen = p.getRutaimagen();
            double precio = p.getPrecio();
            
            String query = "update productos set nombre=?,descripcion=?,rutaimagen=?,precio = ? where id = ?;";
            int res = jdbcTemplate.update(query, new Object[]{
                nombre,
                descripcion,
                rutaimagen,
                precio,
                id
            });
            respuesta.put("respuesta", "Registro actualizado");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al actualizar");
        }

        return respuesta;
    }

    @Override
    public Object getEspecifico(productos p) {
        

        int id = p.getId();
        List<Map<String,Object>> consulta = jdbcTemplate.queryForList("select * from productos where id=?;",new Object[]{
         id
        });
        return consulta;
    }
}
