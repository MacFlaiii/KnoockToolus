package cl.gamezone.proyecto.producto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gamezone.proyecto.producto.dto.ProductoDTO;

@Repository
public interface IProductoRepository extends CrudRepository<ProductoDTO, Integer> {
    // No es necesario agregar métodos adicionales, ya que CrudRepository proporciona los métodos básicos de CRUD.

}
