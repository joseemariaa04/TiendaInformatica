/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.dao;

/**
 *
 * @author Usuario
 */
import com.iestorredelrey.tiendainformatica.modelo.Cliente;
import com.iestorredelrey.tiendainformatica.modelo.Direccion;
import com.iestorredelrey.tiendainformatica.modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insertar(Cliente c) {

        String sql = "INSERT INTO cliente(nombre, calle, ciudad, codigo_postal) VALUES (?,?,?,?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion().getCalle());
            ps.setString(3, c.getDireccion().getCiudad());
            ps.setString(4, c.getDireccion().getCodidoPostal());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Direccion d = new Direccion(
                        rs.getString("calle"),
                        rs.getString("ciudad"),
                        rs.getString("codigo_postal")
                );

                Cliente c = new Cliente(rs.getString("nombre"),d);
                c.setId(rs.getInt("id"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void borrar(int id) {

        String sql = "DELETE FROM cliente WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente obtenerPorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Direccion d = new Direccion(
                            rs.getString("calle"),
                            rs.getString("ciudad"),
                            rs.getString("codigo_postal")
                    );

                    Cliente c = new Cliente(rs.getString("nombre"),d);
                    c.setId(rs.getInt("id"));

                    return c;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void actualizar(Cliente c) {

        String sql = "UPDATE cliente SET nombre=?, calle=?, ciudad=?, codigo_postal=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion().getCalle());
            ps.setString(3, c.getDireccion().getCiudad());
            ps.setString(4, c.getDireccion().getCodidoPostal());
            ps.setInt(5, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getPedidos(int id){
        String sql = "SELECT COUNT(*) AS cuentaPedidos FROM pedido WHERE cliente_id = ?";
        
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("cuentaPedidos");
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}

