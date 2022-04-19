package com.sistema.blog.sistemablogspringbootapirest.dto;

import java.util.Date;

public class ErrorDetalles {

    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;

    public Date getMarcaDeTiempo() {
        return this.marcaDeTiempo;
    }

    public void setMarcaDeTiempo(Date marcaDeTiempo) {
        this.marcaDeTiempo = marcaDeTiempo;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return this.detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        super();
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

}
