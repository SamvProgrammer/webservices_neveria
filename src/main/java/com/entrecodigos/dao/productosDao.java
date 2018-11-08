/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.dao;

import com.entrecodigos.repositorio.productos;

/**
 *
 * @author samv
 */
public interface productosDao {
    public Object getProductos();    
    public Object insertar(productos p);
    public Object eliminar(productos p);
    public Object actualizar(productos p);
}
