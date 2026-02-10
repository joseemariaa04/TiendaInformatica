/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class LineaPedido implements Serializable{
    private Producto producto;
    private int cantidad;
    
    public LineaPedido(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }
    
    public double getSubtotal(){
        return producto.getPrecio()*cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
}
