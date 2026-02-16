package com.iestorredelrey.tiendainformatica.modelo;

import java.util.ArrayList;

public class Cliente{
    private static int contador=1;
    private int id;
    private final String nombre;
    private final Direccion direccion;
    private final ArrayList<Pedido> pedidos;

    public Cliente(String nombre, Direccion direccion) {
        this.id =contador++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void aniadirPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Direccion getDireccion(){
        return this.direccion;
    }
    
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public static void setContador(int c){
        contador=c;
    }
}
