package cl.gamezone.proyecto.boleta.repository;
/*
 *  Al crear la interface CrudRepository
 *  automáticamente existen varios métodos
 *  Usted, puede agregar más métodos, si los necesita
 * 
 */
//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.sql.Date;
import cl.gamezone.proyecto.boleta.model.Boleta;// Dependiendo de la version no preocuparse del error 
//               ==> Expected Domain ID type is 'cl.harrys.aseo.dto.BoletaKey'
// Puede Ser con JpaRepository,  CrudRepository
public interface BoletaRepository extends CrudRepository<Boleta , Integer> {
    // Automáticamente existen los métodos
    //      findAll()
    //      findAllById(Long Id)
    //      save(Entity)
    //      saveAll(Iterator<Entity>)
    //      delete(Entity)
    //      deleteAll()
    //      deleteAllById(Iterator)
    //      deleteById(Log id)
    //      Otros, Otros, Otros



    // **********************************************************************
    // Podemos crear todos los findByXXXXXXXX
    // En donde el XXXXXX debe ser el nombre de uno de los campos de la tabla
    // Debieramos agregar solo los que tienen claves únicas o duplicadas
/*

    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    List<PetType> findPetTypes();

    @Query("FROM PetType ptype WHERE ptype.id = :typeId")
    Optional<PetType> findPetTypeById(@Param("typeId") int typeId);
 */    List<Boleta> findBynumboleta(Integer numboleta);
    List<Boleta> findByrutcliente(String rutcliente);
    List<Boleta> findByrutempleado(String rutempleado);
    List<Boleta> findByfecha(Date fecha);
    List<Boleta> findBytotal(Integer total);
    List<Boleta> findBycodpago(Integer codpago);
    List<Boleta> findBycodbanco(Integer codbanco);
    List<Boleta> findBynumDoctoPago(String numDoctoPago);
    List<Boleta> findByestado(String estado);
}
