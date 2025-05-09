package cl.gamezone.proyecto.direccion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gamezone.proyecto.direccion.dto.DireccionDTO;

@Repository
public interface IDireccionRepository extends CrudRepository<DireccionDTO,Integer> {

}
