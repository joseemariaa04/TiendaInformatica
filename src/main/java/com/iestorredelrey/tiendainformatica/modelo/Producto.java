package com.iestorredelrey.tiendainformatica.modelo;

public class Producto{
    private final int id;
    private final String nombre;
    private final String descripcion;
    private int stock;
    private double precio;

    public Producto(int id,String nombre, double precio,String descripcion,int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.stock=stock;
        this.precio = precio;
    }
    
    
    public double getPrecio(){
        return precio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getId(){
        return this.id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setPrecio(Double precio){
        this.precio=precio;
    }


}
