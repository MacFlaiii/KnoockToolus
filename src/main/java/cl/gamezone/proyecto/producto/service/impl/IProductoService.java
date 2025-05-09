package cl.gamezone.proyecto.producto.service.impl;

import java.util.List;


import cl.gamezone.proyecto.producto.dto.ProductoDTO;

public interface IProductoService {

    List<ProductoDTO> getAll();

    ProductoDTO getById(Integer id);

    ProductoDTO deleteById(Integer id);

    ProductoDTO insert(ProductoDTO productoDTO);

    ProductoDTO update(ProductoDTO productoDTO);

}
