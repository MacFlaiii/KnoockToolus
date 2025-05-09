package cl.gamezone.proyecto.persona.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gamezone.proyecto.persona.dto.PersonaDTO;
import cl.gamezone.proyecto.persona.repository.IPersonaRepository;
@Service
public class PersonaService implements IPersonaService{
    @Autowired 
    IPersonaRepository personaRepository;

    @Override
    public List<PersonaDTO> getAll() {
        return (List<PersonaDTO>) personaRepository.findAll();
    }

    @Override
    public PersonaDTO getByRut(Integer rut) {
        
        return personaRepository.findById(rut).get();
    }

    @Override
    public PersonaDTO insert(PersonaDTO personaDTO) {

        return personaRepository.save(personaDTO); 
    }

    @Override
    public PersonaDTO update(PersonaDTO personaDTO) {
        
        return personaRepository.save(personaDTO);
    }

    @Override
    public PersonaDTO deleteByRut(Integer rut) {
    
        personaRepository.deleteById(rut);
        return null;

    }
}
