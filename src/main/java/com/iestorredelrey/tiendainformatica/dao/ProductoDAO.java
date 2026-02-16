/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.dao;

import com.iestorredelrey.tiendainformatica.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDAO {
    
    public void insertar(Producto p) {

    String sql = "INSERT INTO producto(nombre, descripcion, precio, stock) VALUES (?,?,?,?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getDescripcion());
        ps.setDouble(3, p.getPrecio());
        ps.setInt(4, p.getStock());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List<Producto> listar() {

    List<Producto> lista = new ArrayList<>();
    String sql = "SELECT * FROM producto";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion"),
                    rs.getInt("stock")
            );

            lista.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
    
    public void borrar(int id) {

    String sql = "DELETE FROM producto WHERE id=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void actualizar(Producto p) {

    String sql = "UPDATE producto SET nombre=?, descripcion=?, precio=?, stock=? WHERE id=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getDescripcion());
        ps.setDouble(3, p.getPrecio());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getId());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
public Producto obtenerPorId(int id) {

    String sql = "SELECT * FROM producto WHERE id = ?";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("descripcion"),
                        rs.getInt("stock")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}




}
