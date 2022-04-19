package com.sistema.blog.sistemablogspringbootapirest.servicio;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.blog.sistemablogspringbootapirest.dto.PublicacionDTO;
import com.sistema.blog.sistemablogspringbootapirest.dto.PublicacionRespuesta;
import com.sistema.blog.sistemablogspringbootapirest.entidades.Publicacion;
import com.sistema.blog.sistemablogspringbootapirest.excepciones.ResourceNotFoundException;
import com.sistema.blog.sistemablogspringbootapirest.repositorio.PublicacionRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServicioImpl implements PublicacionServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {
        // Convertimos de DTO a entidad
        Publicacion publicacion = mapearEntidad(publicacionDTO);

        Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

        // Convertimos de entidad a DTO
        PublicacionDTO publicacionRespuesta = mapearDTO(nuevaPublicacion);

        return publicacionRespuesta;
    }

    @Override
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina,
            String ordenarPor, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
                : Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);

        List<Publicacion> listaDePublicaciones = publicaciones.getContent();
        List<PublicacionDTO> contenido = listaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion))
                .collect(Collectors.toList());

        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();

        publicacionRespuesta.setContenido(contenido);
        publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
        publicacionRespuesta.setMedidaPagina(publicaciones.getSize());
        publicacionRespuesta.setTotalElementos(publicaciones.getTotalElements());
        publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
        publicacionRespuesta.setUltima(publicaciones.isLast());

        return publicacionRespuesta;
    }

    @Override
    public PublicacionDTO obtenerPublicacionPorId(long id) {
        Publicacion publicacion = publicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
        return mapearDTO(publicacion);
    }

    @Override
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id) {
        Publicacion publicacion = publicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);

        return mapearDTO(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
        publicacionRepositorio.delete(publicacion);
    }

    // Convierte entidad a DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion) {
        // PublicacionDTO publicacionDTO = new PublicacionDTO();

        // publicacionDTO.setId(publicacion.getId());
        // publicacionDTO.setTitulo(publicacion.getTitulo());
        // publicacionDTO.setDescripcion(publicacion.getDescripcion());
        // publicacionDTO.setContenido(publicacion.getContenido());
        PublicacionDTO publicacionDTO = modelMapper.map(publicacion, PublicacionDTO.class);

        return publicacionDTO;
    }

    // Convierte DTO a entidad
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
        // Publicacion publicacion = new Publicacion();

        // publicacion.setTitulo(publicacionDTO.getTitulo());
        // publicacion.setDescripcion(publicacionDTO.getDescripcion());
        // publicacion.setContenido(publicacionDTO.getContenido());
        Publicacion publicacion = modelMapper.map(publicacionDTO, Publicacion.class);

        return publicacion;
    }

}
