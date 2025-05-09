package cl.gamezone.proyecto.direccion.service.impl;

import java.util.List;

import cl.gamezone.proyecto.direccion.dto.DireccionDTO;

public interface IDireccionService {

    List<DireccionDTO> getAll();

    DireccionDTO getById(Integer id);

    DireccionDTO deleteById(Integer id);

    DireccionDTO insert(DireccionDTO direccionDTO);

    DireccionDTO update(DireccionDTO direccionDTO);

}
