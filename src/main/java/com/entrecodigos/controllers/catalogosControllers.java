/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecodigos.controllers;

import com.entrecodigos.dao.productosDao;
import com.entrecodigos.repositorio.productos;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samv
 */
@RestController
@RequestMapping("/catalogos")
public class catalogosControllers {

    @Autowired
    @Qualifier("objProductosDao")
    private productosDao objProductos;

    @GetMapping("/productos")
    public Object obtenerProductos() {
        return objProductos.getProductos();
    }

    @PostMapping("/productos")
    public Object insertarProductos(@RequestBody productos obj, HttpServletRequest request) {
        Object respuesta = objProductos.insertar(obj);
        return respuesta;
    }

    @DeleteMapping("/productos/{identificador}")
    public Object eliminarRol(@PathVariable(value = "identificador") String id) {
        productos obj = new productos();
        obj.setId(Integer.parseInt(id));
        Object respuesta = objProductos.eliminar(obj);
        return respuesta;
    }

    @PutMapping("/productos/{identificador}")
    public Object actualizarRol(@PathVariable(value = "identificador") String id, @RequestBody productos obj, HttpServletRequest request) {
        obj.setId(Integer.parseInt(id));
        Object respuesta = objProductos.actualizar(obj);
        return respuesta;
    }

}