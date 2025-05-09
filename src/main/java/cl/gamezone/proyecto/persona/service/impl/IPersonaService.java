package cl.gamezone.proyecto.persona.service.impl;

import java.util.List;



import cl.gamezone.proyecto.persona.dto.PersonaDTO;


public interface IPersonaService {

    List<PersonaDTO> getAll();

    PersonaDTO getByRut(Integer rut);

    PersonaDTO insert(PersonaDTO personaDTO);

    PersonaDTO update(PersonaDTO personaDTO);

    PersonaDTO deleteByRut(Integer rut);


}
