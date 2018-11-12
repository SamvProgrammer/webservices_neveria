/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.dao;

import com.entrecodigos.repositorio.mesa;
import com.entrecodigos.repositorio.productos;

/**
 *
 * @author samv
 */
public interface ventaDao {
    public Object getVentasCliente(boolean historico);
    public Object insertar(mesa p);
}
