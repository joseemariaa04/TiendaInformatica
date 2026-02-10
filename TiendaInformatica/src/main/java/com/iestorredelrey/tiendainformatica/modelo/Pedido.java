/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Pedido implements Serializable{
    private final int id;
    private static int contador=1;
    private ArrayList<LineaPedido> lineas;
    private final Cliente cliente;
    private EstadoPedido estadoPedido;
    
    public Pedido(Cliente cliente){
        this.id=contador++;
        this.estadoPedido=EstadoPedido.PENDIENTE;
        this.cliente=cliente;
        this.lineas=new ArrayList();
    }
    
    public void addLinea(Producto p, int cantidad){
        lineas.add(new LineaPedido(p,cantidad));
    }
    
    public void setEstadoPedido(EstadoPedido e){
        this.estadoPedido=e;
    }

    public int getId() {
        return id;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    
    public static void setContador(int c){
        contador=c;
    }
    
    public void removeLinea(int indice){
        Producto p =lineas.get(indice).getProducto();
        p.setStock(p.getStock()+lineas.get(indice).getCantidad());//Vuelve a reponer el stock
        lineas.remove(indice);
    }
    
    public double getTotal(){
        double total=0.0;
        for(LineaPedido l:lineas){
            total+=l.getSubtotal();
        }
        return total;
    }
}
