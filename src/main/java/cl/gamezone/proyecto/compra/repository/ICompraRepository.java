package cl.gamezone.proyecto.compra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gamezone.proyecto.compra.dto.CompraDTO;

@Repository
public interface ICompraRepository extends CrudRepository<CompraDTO,Integer>
{
}
