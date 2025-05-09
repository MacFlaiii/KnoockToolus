package cl.gamezone.proyecto.producto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.gamezone.proyecto.producto.dto.ProductoDTO;
import cl.gamezone.proyecto.producto.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getAll() {
        
        return (List<ProductoDTO>) productoRepository.findAll();
    }

    @Override
    public ProductoDTO getById(Integer id) {
        
        return productoRepository.findById(id).get();
    }

    @Override
    public ProductoDTO deleteById(Integer id) {
        
        productoRepository.deleteById(id);
        return null;
    }

    @Override
    public ProductoDTO insert(ProductoDTO productoDTO) {
        
        return productoRepository.save(productoDTO); 
    }

    @Override
    public ProductoDTO update(ProductoDTO productoDTO) {
    
        return productoRepository.save(productoDTO);
    }

    // Implementación de los métodos de IPersonaService aquí


    // Otros métodos y lógica de la clase

}
