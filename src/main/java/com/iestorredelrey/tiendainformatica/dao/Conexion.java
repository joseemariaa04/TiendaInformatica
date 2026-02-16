/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iestorredelrey.tiendainformatica.dao;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL ="jdbc:mysql://localhost:3306/informaticajmm?zeroDateTimeBehavior=CONVERT_TO_NULL";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

