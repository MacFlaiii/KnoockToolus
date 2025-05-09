package cl.gamezone.proyecto.persona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gamezone.proyecto.persona.dto.PersonaDTO;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaDTO,Integer> 
{
    // No es necesario agregar métodos adicionales, ya que CrudRepository proporciona los métodos básicos de CRUD.
}


