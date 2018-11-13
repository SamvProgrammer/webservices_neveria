/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.daoimp;

import com.entrecodigos.dao.ventaDao;
import com.entrecodigos.repositorio.cliente;
import com.entrecodigos.repositorio.detalle_productocliente;
import com.entrecodigos.repositorio.mesa;
import com.entrecodigos.repositorio.productos;
import java.time.LocalDate;
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
        List<Map<String, Object>> consulta = jdbcTemplate.queryForList("select * from cliente where pagado = ? order by id;", new Object[]{historico});
        return consulta;
    }

    @Override
    public Object insertar(cliente p) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        try {
            String fecha = p.getFecha();
            int id_mesa = p.getId_mesa();
            
            String query = "insert into cliente (fecha_venta,pagado,id_mesa) values(?,?,?);";

            int res = jdbcTemplate.update(query, new Object[]{LocalDate.parse(fecha), false, id_mesa});
            respuesta.put("respuesta", "Registro insertado");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al insertar");
        }

        return respuesta;
    }

    @Override
    public Object insertarDetalle(detalle_productocliente p) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        try {
            int id_producto = p.getId_producto();
            int id_mesa = p.getId_mesa();
            int cantidad = p.getCantidad();
            
            String query = "insert into detalle_productocliente  values(?,?,?);";

            int res = jdbcTemplate.update(query, new Object[]{id_producto, id_mesa, cantidad});
            respuesta.put("respuesta", "Registro insertado");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al insertar");
        }

        return respuesta;
    }

    @Override
    public Object getDetalleVentasCliente(int id_mesa) {
        String query = "select d1.id_producto,p1.nombre,p1.precio,sum(d1.cantidad) as cantidad from detalle_productocliente d1 inner join productos p1 on p1.id = d1.id_producto inner join cliente c1 on c1.id = d1.id_mesa where d1.id_mesa = ? and c1.pagado = false group by d1.id_producto,p1.precio,p1.nombre;";
        List<Map<String, Object>> consulta = jdbcTemplate.queryForList(query, new Object[]{id_mesa});
        return consulta;
    }

    @Override
    public Object cuentaCerrada(cliente p) {
            Map<String, Object> respuesta = new HashMap<String, Object>();
        try {
            double ventaTotal = p.getTotal();
            int id = p.getId();
            int id_mesa = p.getId_mesa();
            
            String query = "update cliente set pagado = true,total = ? where pagado = false and id = ?;";

            int res = jdbcTemplate.update(query, new Object[]{ventaTotal,id});
            respuesta.put("respuesta", "Cuenta cerrada");
        } catch (Exception e) {
            respuesta.put("respuesta", "Error al cerrar la cuenta");
        }

        return respuesta;
    }

}
