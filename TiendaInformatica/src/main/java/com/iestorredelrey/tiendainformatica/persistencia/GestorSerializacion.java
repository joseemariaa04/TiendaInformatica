/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class GestorSerializacion {
    
    public static void guardar(String fichero,Object o) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        oos.writeObject(o);
        oos.close();
    }
    
    public static Object cargar(String fichero) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}
