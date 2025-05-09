package cl.gamezone.proyecto.compra.service.impl;

import java.util.List;

import cl.gamezone.proyecto.compra.dto.CompraDTO;

public interface ICompraService{
    List<CompraDTO> getAll();

    CompraDTO getById(Integer id);

    CompraDTO deleteById(Integer id);

    CompraDTO insert(CompraDTO productoDTO);

    CompraDTO update(CompraDTO productoDTO);

}
