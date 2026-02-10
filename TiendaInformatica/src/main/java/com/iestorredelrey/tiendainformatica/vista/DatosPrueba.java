/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.vista;

import com.iestorredelrey.tiendainformatica.controlador.GestorTienda;
import com.iestorredelrey.tiendainformatica.modelo.Cliente;
import com.iestorredelrey.tiendainformatica.modelo.Direccion;
import com.iestorredelrey.tiendainformatica.modelo.LineaPedido;
import com.iestorredelrey.tiendainformatica.modelo.Pedido;
import com.iestorredelrey.tiendainformatica.modelo.Producto;
import com.iestorredelrey.tiendainformatica.persistencia.GestorSerializacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class DatosPrueba {

    public static void main(String[] args) {

        GestorTienda gestor = new GestorTienda();

    gestor.getProductos().add(new Producto(
        "Portátil Lenovo IdeaPad 3",
        599.99,
        "Portátil 15.6'' Ryzen 5, 8GB RAM, 512GB SSD",
        25
    ));

    gestor.getProductos().add(new Producto(
        "Monitor LG 24'' Full HD",
        149.99,
        "Monitor IPS 24 pulgadas, resolución 1920x1080",
        40
    ));

    gestor.getProductos().add(new Producto(
        "Teclado mecánico Logitech G413",
        89.99,
        "Teclado mecánico con retroiluminación roja",
        60
    ));

    gestor.getProductos().add(new Producto(
        "Ratón gaming Razer DeathAdder",
        49.99,
        "Ratón óptico 16000 DPI ergonómico",
        80
    ));

    gestor.getProductos().add(new Producto(
        "Auriculares Sony WH-1000XM4",
        299.99,
        "Auriculares inalámbricos con cancelación de ruido",
        15
    ));

    gestor.getProductos().add(new Producto(
        "Disco SSD Samsung 970 EVO 1TB",
        119.99,
        "SSD NVMe M.2 alta velocidad",
        50
    ));

    gestor.getProductos().add(new Producto(
        "Memoria RAM Corsair 16GB DDR4",
        74.99,
        "Kit 2x8GB DDR4 3200MHz",
        70
    ));

    gestor.getProductos().add(new Producto(
        "Impresora HP DeskJet 2720e",
        69.99,
        "Impresora multifunción WiFi",
        30
    ));

    gestor.getProductos().add(new Producto(
        "Router TP-Link Archer C6",
        59.99,
        "Router WiFi AC1200 doble banda",
        45
    ));

    gestor.getProductos().add(new Producto(
        "Tablet Samsung Galaxy Tab A8",
        229.99,
        "Tablet 10.5'' 4GB RAM 64GB",
        20
    ));

    gestor.getProductos().add(new Producto(
        "Smartphone Xiaomi Redmi Note 12",
        199.99,
        "Smartphone 6.67'' AMOLED 128GB",
        35
    ));

    gestor.getProductos().add(new Producto(
        "Cargador USB-C 65W Anker",
        39.99,
        "Cargador rápido para portátil y móvil",
        90
    ));

    gestor.getProductos().add(new Producto(
        "Webcam Logitech C920",
        79.99,
        "Webcam Full HD con micrófono",
        55
    ));

    gestor.getProductos().add(new Producto(
        "Altavoz Bluetooth JBL Flip 6",
        129.99,
        "Altavoz portátil resistente al agua",
        25
    ));

    gestor.getProductos().add(new Producto(
        "Base refrigeradora portátil",
        24.99,
        "Base con ventiladores para laptop",
        100
    ));

    gestor.getProductos().add(new Producto(
        "Cable HDMI 2.1 2m",
        12.99,
        "Cable HDMI 8K alta velocidad",
        200
    ));

    gestor.getProductos().add(new Producto(
        "Disco duro externo Seagate 2TB",
        89.99,
        "HDD USB 3.0 portátil",
        40
    ));

    gestor.getProductos().add(new Producto(
        "Micrófono USB Blue Yeti",
        109.99,
        "Micrófono profesional para streaming",
        18
    ));

    gestor.getProductos().add(new Producto(
        "Silla gaming Drift DR50",
        189.99,
        "Silla ergonómica reclinable",
        12
    ));

    gestor.getProductos().add(new Producto(
        "Regleta con protección 6 tomas",
        19.99,
        "Regleta con interruptor y protección",
        150
    ));


        // ==== CLIENTES ====
        Cliente c1 = new Cliente("Juan Pérez", 
            new Direccion("Calle Mayor 1", "Madrid", "28001"));
        Cliente c2 = new Cliente("Ana López", 
            new Direccion("Gran Vía 22", "Madrid", "28013"));
        Cliente c3 = new Cliente("Pedro Gómez", 
            new Direccion("Diagonal 100", "Barcelona", "08019"));
        Cliente c4 = new Cliente("Laura Ruiz", 
            new Direccion("Colón 5", "Valencia", "46001"));
        Cliente c5 = new Cliente("Carlos Martín", 
            new Direccion("Alameda 12", "Sevilla", "41001"));

        gestor.getClientes().add(c1);
        gestor.getClientes().add(c2);
        gestor.getClientes().add(c3);
        gestor.getClientes().add(c4);
        gestor.getClientes().add(c5);

        // ==== PEDIDOS ====
        Random r = new Random();
        ArrayList<Producto> productos = gestor.getProductos();
        ArrayList<Cliente> clientes = gestor.getClientes();

        for (int i = 0; i < 20; i++) {
            Cliente cliente = clientes.get(r.nextInt(clientes.size()));
            Pedido pedido = new Pedido(cliente);

            // 5 líneas por pedido
            for (int j = 0; j < 5; j++) {
                Producto prod = productos.get(r.nextInt(productos.size()));
                int cantidad = 1 + r.nextInt(5); // entre 1 y 5

                LineaPedido lp = new LineaPedido(prod, cantidad);
                pedido.getLineas().add(lp);
            }

            cliente.getPedidos().add(pedido);
        }
        try{
            GestorSerializacion.guardar(FrmInicio.RUTA_FICHERO, gestor);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

