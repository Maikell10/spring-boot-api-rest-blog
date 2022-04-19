package com.sistema.blog.sistemablogspringbootapirest.dto;

import java.util.List;

public class PublicacionRespuesta {

    private List<PublicacionDTO> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;

    public List<PublicacionDTO> getContenido() {
        return this.contenido;
    }

    public void setContenido(List<PublicacionDTO> contenido) {
        this.contenido = contenido;
    }

    public int getNumeroPagina() {
        return this.numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getMedidaPagina() {
        return this.medidaPagina;
    }

    public void setMedidaPagina(int medidaPagina) {
        this.medidaPagina = medidaPagina;
    }

    public long getTotalElementos() {
        return this.totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public boolean isUltima() {
        return this.ultima;
    }

    public boolean getUltima() {
        return this.ultima;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

    public PublicacionRespuesta() {
        super();
    }

}
