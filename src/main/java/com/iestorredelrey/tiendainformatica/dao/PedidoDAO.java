/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.dao;

import com.iestorredelrey.tiendainformatica.modelo.Cliente;
import com.iestorredelrey.tiendainformatica.modelo.EstadoPedido;
import com.iestorredelrey.tiendainformatica.modelo.LineaPedido;
import com.iestorredelrey.tiendainformatica.modelo.Pedido;
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
public class PedidoDAO {

    public void insertarPedido(Pedido pedido) {

        String sql = "INSERT INTO pedido(cliente_id, estado) VALUES (?,?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pedido.getCliente().getId());
            ps.setString(2, pedido.getEstadoPedido().name());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarLinea(int pedidoId, LineaPedido linea) {

        String sqlLinea = "INSERT INTO linea_pedido(pedido_id, producto_id, cantidad) VALUES (?,?,?)";


        try (Connection con = Conexion.getConexion()) {
            try (PreparedStatement psLinea = con.prepareStatement(sqlLinea);) {

                // Insertar línea
                psLinea.setInt(1, pedidoId);
                psLinea.setInt(2, linea.getProducto().getId());
                psLinea.setInt(3, linea.getCantidad());
                psLinea.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> listar() {

        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.estado, c.id AS cliente_id, c.nombre FROM pedido p JOIN cliente c ON p.cliente_id = c.id";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("nombre"), null);
                c.setId(rs.getInt("cliente_id"));
                Pedido p = new Pedido(c);
                p.setId(rs.getInt("id"));
                p.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estado")));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Pedido obtenerPorId(int id) {

        String sql = "SELECT p.id, p.estado, c.id AS cliente_id, c.nombre FROM pedido p JOIN cliente c ON p.cliente_id = c.id WHERE p.id = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente(rs.getString("nombre"), null);
                    c.setId(rs.getInt("cliente_id"));
                    // Crear pedido
                    Pedido p = new Pedido(c);
                    p.setId(rs.getInt("id"));
                    p.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estado")));

                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(Pedido p) {
        String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getEstadoPedido().name());
            ps.setInt(2, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double calcularTotal(int pedidoId) {

        String sql = "SELECT SUM(p.precio * lp.cantidad) AS total FROM linea_pedido lp JOIN producto p ON p.id = lp.producto_id WHERE lp.pedido_id = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public double calcularTotalTodos() {

        String sql = "SELECT SUM(p.precio * lp.cantidad) AS total FROM linea_pedido lp JOIN producto p ON p.id = lp.producto_id";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

}
