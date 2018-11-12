/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.controllers;

import com.entrecodigos.dao.productosDao;
import com.entrecodigos.dao.ventaDao;
import com.entrecodigos.repositorio.mesa;
import com.entrecodigos.repositorio.productos;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samv
 */
@RestController
@RequestMapping("/ventas")
public class ventaController {
    
    @Autowired
    @Qualifier("objVentasDao")
    private ventaDao objVentas;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/clienteventas")
    public Object obtenerMesas() {
        return objVentas.getVentasCliente(false);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping("/clienteventas")
    public Object insertarMesa(@RequestBody mesa obj, HttpServletRequest request) {
        Object respuesta = objVentas.insertar(obj);
        return respuesta;
    }
}
