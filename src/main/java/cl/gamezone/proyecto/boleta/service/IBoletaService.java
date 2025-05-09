package cl.gamezone.proyecto.boleta.service;
/*
 *  En esta Interface solo declaramos los métodos a utilizar,
 *  NOOOO , los implementamos(El Cuerpo) 
 * 
 *      
 */
import java.util.List;
import java.sql.Date;
import java.util.Optional;
import cl.gamezone.proyecto.boleta.model.Boleta;



public interface IBoletaService {
    // Implementamos los métodos que estime conveniente
    
    // Buscar todos los registros
    // Cuidado cuando existan muchos registros, debe paginar
    List<Boleta> listarBoletaAll();

    //Buscar un registro por PK, por lógica solo devolverá un registro
    Optional<Boleta> listarBoletaByKey(Integer key);

    // Crear un registro, devolverá solo si funciono o no  (true or false)
	Boleta crearBoleta(Boleta boletaObj);
    
    // actualizar un registro, devolverá solo si funciono o no  (true or false)
          public Boleta actualizarBoleta(Integer key,Boleta boletaObj);

	// Eliminar un registro, devolverá solo si funciono o no  (true or false)
    boolean borrarBoletaByKey(Integer key);

    // *************************************************************
    // Agregamos métodos por cada campo, si es que los necesitamos
    // Solo debieramos agregar las búsquedas de las claves, únicas o dúplicadas
    List<Boleta> findBynumboleta(Integer numboleta);
    List<Boleta> findByrutcliente(String rutcliente);
    List<Boleta> findByrutempleado(String rutempleado);
    List<Boleta> findByfecha(Date fecha);
    List<Boleta> findBytotal(Integer total);
    List<Boleta> findBycodpago(Integer codpago);
    List<Boleta> findBycodbanco(Integer codbanco);
    List<Boleta> findBynumDoctoPago(String numDoctoPago);
    List<Boleta> findByestado(String estado);
}
