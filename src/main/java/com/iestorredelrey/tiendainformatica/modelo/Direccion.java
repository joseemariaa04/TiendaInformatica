package com.iestorredelrey.tiendainformatica.modelo;

public class Direccion{
    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion(String calle, String ciudad, String codidoPostal){
        this.calle=calle;
        this.ciudad=ciudad;
        this.codigoPostal=codidoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodidoPostal() {
        return codigoPostal;
    }
    
    
}
