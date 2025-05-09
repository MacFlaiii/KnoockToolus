package cl.gamezone.proyecto.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.gamezone.proyecto.producto.dto.ProductoDTO;
import cl.gamezone.proyecto.producto.service.impl.IProductoService;

@RestController
@RequestMapping("/api/crud/producto")
public class ProductoController {   
    @Autowired
    IProductoService productoService;
    @GetMapping
    public List<ProductoDTO> getAll(){
        return productoService.getAll();
    }
    @GetMapping("/{id}")
    public ProductoDTO getById(@PathVariable Integer id){
        return productoService.getById(id);

    }
    @DeleteMapping("/{id}")
    public ProductoDTO deleteById(@PathVariable Integer id){

        return productoService.deleteById(id);
    }

    @PostMapping
    public ProductoDTO insert(@RequestBody ProductoDTO productoDTO){
        return productoService.insert(productoDTO);
    }
    @PutMapping
    public ProductoDTO update(@PathVariable Integer id,@RequestBody ProductoDTO productoDTO){
        productoDTO.setId(id);
        return productoService.update(productoDTO);
    }
}
