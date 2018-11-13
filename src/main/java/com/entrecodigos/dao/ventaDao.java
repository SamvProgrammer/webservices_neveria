/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.dao;

import com.entrecodigos.repositorio.cliente;
import com.entrecodigos.repositorio.detalle_productocliente;
import com.entrecodigos.repositorio.mesa;
import com.entrecodigos.repositorio.productos;

/**
 *
 * @author samv
 */
public interface ventaDao {
    public Object getVentasCliente(boolean historico);
    public Object insertar(cliente p);
    public Object insertarDetalle(detalle_productocliente p);
    public Object getDetalleVentasCliente(int id_mesa);
    public Object cuentaCerrada(cliente p);
}
