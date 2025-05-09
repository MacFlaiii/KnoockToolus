package cl.gamezone.proyecto.persona.controller;

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

import cl.gamezone.proyecto.persona.dto.PersonaDTO;
import cl.gamezone.proyecto.persona.service.impl.IPersonaService;


@RestController
@RequestMapping("/api/crud/persona")
public class PersonaController {
    @Autowired
    IPersonaService personaService;
    @GetMapping
    public List<PersonaDTO>getAll(){
        return personaService.getAll();
    }
    @GetMapping("/{rut}")
    public PersonaDTO getByRut(@PathVariable Integer rut){
        return personaService.getByRut(rut);    
}
    
    @DeleteMapping("/{rut}")
    public PersonaDTO deleteByRut(@PathVariable Integer rut){

        return personaService.deleteByRut(rut);
    
    }
    @PostMapping
    public PersonaDTO insert(@RequestBody PersonaDTO personaDTO){
        return personaService.insert(personaDTO);
    }
    @PutMapping
    public PersonaDTO update(@PathVariable Integer rut,@RequestBody PersonaDTO personaDTO){
        personaDTO.setRut(rut);
        return personaService.update(personaDTO);
    }

}