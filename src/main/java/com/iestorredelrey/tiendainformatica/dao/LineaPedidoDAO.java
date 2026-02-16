/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.dao;

import com.iestorredelrey.tiendainformatica.modelo.LineaPedido;
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
public class LineaPedidoDAO {

    public List<LineaPedido> listarPorPedido(int pedidoId) {

        List<LineaPedido> lista = new ArrayList<>();

        String sql = "SELECT lp.id as idlp,lp.cantidad, pr.id, pr.nombre, pr.precio, pr.descripcion, pr.stock FROM linea_pedido lp JOIN producto pr ON lp.producto_id = pr.id WHERE lp.pedido_id = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto p = new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getString("descripcion"),
                            rs.getInt("stock")
                    );

                    LineaPedido linea = new LineaPedido(p, rs.getInt("cantidad"));
                    linea.setId(rs.getInt("idlp"));
                    lista.add(linea);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertarLinea(int pedidoId, LineaPedido linea) {
        String sql = "INSERT INTO linea_pedido(pedido_id, producto_id, cantidad) VALUES (?,?,?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            ps.setInt(2, linea.getProducto().getId());
            ps.setInt(3, linea.getCantidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarLinea(int id) {
        String sql = "DELETE FROM linea_pedido WHERE id = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LineaPedido obtenerPorId(int id) {
        String sql = "SELECT lp.id as idlp,lp.cantidad, pr.id, pr.nombre, pr.precio, pr.descripcion, pr.stock FROM linea_pedido lp JOIN producto pr ON lp.producto_id = pr.id WHERE lp.id = ?";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getString("descripcion"),
                            rs.getInt("stock")
                    );

                    LineaPedido linea = new LineaPedido(p, rs.getInt("cantidad"));
                    linea.setId(rs.getInt("idlp"));
                    return linea;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
