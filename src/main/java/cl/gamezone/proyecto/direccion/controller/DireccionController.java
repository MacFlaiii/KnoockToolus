package cl.gamezone.proyecto.direccion.controller;

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
import cl.gamezone.proyecto.direccion.dto.DireccionDTO;
import cl.gamezone.proyecto.direccion.service.impl.IDireccionService;

@RestController
@RequestMapping("/api/crud/direccion")
public class DireccionController {
    @Autowired
    IDireccionService direccionService;
    @GetMapping
    public List<DireccionDTO> getAll(){

        return direccionService.getAll();
    }
    @GetMapping("/{id}")
    public DireccionDTO getById(@PathVariable Integer id){
        return direccionService.getById(id);
    }
    @DeleteMapping("/{id}")
    public DireccionDTO deleteById(@PathVariable Integer id){
        return direccionService.deleteById(id);
    }
    @PostMapping
    public DireccionDTO insert(@RequestBody DireccionDTO direccionDTO){
        return direccionService.insert(direccionDTO );
    }
    @PutMapping("/{id}")
    public DireccionDTO update(@PathVariable Integer id,@RequestBody DireccionDTO direccionDTO){
        direccionDTO.setIdDireccion(id);
        return direccionService.update(direccionDTO); 
           

    }
}