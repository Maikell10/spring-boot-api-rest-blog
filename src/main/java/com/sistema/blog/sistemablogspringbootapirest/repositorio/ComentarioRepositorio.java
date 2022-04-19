package com.sistema.blog.sistemablogspringbootapirest.repositorio;

import java.util.List;

import com.sistema.blog.sistemablogspringbootapirest.entidades.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByPublicacionId(long publicacionId);
}
