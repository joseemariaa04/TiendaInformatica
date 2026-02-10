package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private static int contador=0;
    private final int id;
    private final String nombre;
    private final Direccion direccion;
    private final ArrayList<Pedido> pedidos;

    public Cliente(String nombre, Direccion direccion) {
        this.id = contador++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = new ArrayList<>();
    }

    public void aniadirPedido(Pedido pedido){
        pedidos.add(pedido);
    }
}
