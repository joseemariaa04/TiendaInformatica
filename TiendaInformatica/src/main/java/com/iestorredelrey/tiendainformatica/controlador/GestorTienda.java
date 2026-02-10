/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.controlador;

import com.iestorredelrey.tiendainformatica.modelo.Cliente;
import com.iestorredelrey.tiendainformatica.modelo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class GestorTienda implements Serializable {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    
    public GestorTienda(){
        clientes= new ArrayList<>();
        productos= new ArrayList<>();
    }
    
    public void addCliente(Cliente c){
        clientes.add(c);
    }
    
    public void addProducto(Producto p){
        productos.add(p);
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    public ArrayList<Producto> getProductos(){
        return productos;
    }
}
