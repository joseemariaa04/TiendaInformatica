package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private static int contador=0;
    private final int id;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
    }


}
