package com.sistema.blog.sistemablogspringbootapirest.servicio;

import java.util.List;

import com.sistema.blog.sistemablogspringbootapirest.dto.ComentarioDTO;

public interface ComentarioServicio {

    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);

    public List<ComentarioDTO> obteneComentariosPorPublicacionId(long publicacionId);

    public ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId);

    public ComentarioDTO actualizarComentario(Long publicacionId, Long comentarioId,
            ComentarioDTO solicitudDeComentario);

    public void eliminarComentario(long publicacionId, long comentarioId);
}
