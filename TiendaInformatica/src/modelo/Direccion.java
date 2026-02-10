package modelo;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String calle;
    private String ciudad;
    private String codidoPostal;

    public Direccion(String calle, String ciudad, String codidoPostal){
        this.calle=calle;
        this.ciudad=ciudad;
        this.codidoPostal=codidoPostal;
    }
}
