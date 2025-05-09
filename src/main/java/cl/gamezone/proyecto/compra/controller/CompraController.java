package cl.gamezone.proyecto.compra.controller;

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

import cl.gamezone.proyecto.compra.dto.CompraDTO;
import cl.gamezone.proyecto.compra.service.impl.ICompraService;



@RestController
@RequestMapping("/api/crud/compra")
public class CompraController {

    @Autowired
    ICompraService compraService;
    @GetMapping
    public List<CompraDTO> getAll(){

        return compraService.getAll();
    }
    @GetMapping("/{id}")
    public CompraDTO getById(@PathVariable Integer id){
        return compraService.getById(id);
    }
    @DeleteMapping("/{id}")
    public CompraDTO deleteById(@PathVariable Integer id){
        return compraService.deleteById(id);
    }
    @PostMapping
    public CompraDTO insert(@RequestBody CompraDTO compraDTO){
        return compraService.insert(compraDTO   );
    }
    @PutMapping("/{id}")
    public CompraDTO update(@PathVariable Integer id,@RequestBody CompraDTO compraDTO){
        compraDTO.setIdCompra(id);
        return compraService.update(compraDTO);
    }

}
