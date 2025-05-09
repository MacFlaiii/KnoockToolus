package cl.gamezone.proyecto.boleta.service.impl;
/*
 *  Sericio Impl, se implementan los métodos que utilizaremos
 *  Recuerde que el Controller llama a la interfaz
 *  Esta clase es como si fuera el Negocio, el cual llama a las DAO'S (Repository)
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Optional;
import org.springframework.http.*;
import cl.gamezone.proyecto.boleta.model.Boleta;
import cl.gamezone.proyecto.boleta.service.IBoletaService;
import cl.gamezone.proyecto.boleta.repository.BoletaRepository;
import cl.gamezone.proyecto.boleta.exception.BoletaException;


@Service
//@Transactional(readOnly = true)
public class BoletaServiceImpl implements IBoletaService {

    // Creamos un Logger
    private static final Logger logger = LoggerFactory.getLogger(BoletaServiceImpl.class);


    // @Autowired 
	@Autowired
	BoletaRepository repositoryBoleta;


    // Implementamos los métodos a utilizar
    // Este método devuelve todos los registros
    //    implementar paginación, solo si fuera necesario
    // @Transactional(timeout = 10)
    @Override
    public List<Boleta> listarBoletaAll(){
        logger.info("Servicio Impl Listar");
        // // Arreglo de Paso
        // List<Boleta> aux = new ArrayList<>();
        // // traspasamo desde el repositorio a la lista
        // repositoryBoleta.findAll().forEach(aux::add);
        // // devolvemos la nueva lista
        // return aux;

        // Realizamos un Casting( conversión de un tipo de objeto a otro)
        return (List<Boleta>) repositoryBoleta.findAll();
        
    }
    
    //Buscar un registro por PK, por lógica solo devolverá un registro
    @Override
    public Optional<Boleta> listarBoletaByKey(Integer key){
            return repositoryBoleta.findById(key);
    }

    // Crear un registro, devolverá solo si funciono o no  (true or false)
    @Override
    public Boleta crearBoleta(Boleta boletaObj){
        logger.info("Servicio Impl Crear");
        
        //if (repositoryBoleta.existsById(key))
        //    throw new BoletaException(HttpStatus.NOT_FOUND,"ORA-672","Registro ya existe");
        return repositoryBoleta.save(boletaObj);
    }


    // actualizar un registro, devolverá solo si funciono o no  (true or false)
    @Override
      public Boleta actualizarBoleta(Integer key,Boleta boletaObj){
        logger.info("Servicio Impl Actualizar");
        if (!repositoryBoleta.existsById(key))
             throw new BoletaException(HttpStatus.NOT_FOUND,"ORA-672","Registro no existe");
        return repositoryBoleta.save(boletaObj);
    }

    // Eliminar un registro, devolverá solo si funciono o no  (true or false)
    @Override
      public boolean borrarBoletaByKey(Integer key){
        logger.info("Servicio Impl Borrar");
        if (!repositoryBoleta.existsById(key))
             //return false;
             throw new BoletaException(HttpStatus.NOT_FOUND,"ORA-672","Registro no existe");
        repositoryBoleta.deleteById(key);
        return true;
    }

    // ***********************************************************
    // Agregamos métodos para cada campos si es que lo necesitamos
    // Solo debieramos agregar los que tencja claves únicas o duplicadas
    public List<Boleta> findBynumboleta(Integer numboleta){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findByrutcliente(String rutcliente){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findByrutempleado(String rutempleado){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findByfecha(Date fecha){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findBytotal(Integer total){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findBycodpago(Integer codpago){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findBycodbanco(Integer codbanco){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findBynumDoctoPago(String numDoctoPago){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
    public List<Boleta> findByestado(String estado){
        // Arreglo de Paso
        List<Boleta> aux = new ArrayList<>();
        // traspasamo desde el repositorio a la lista
        repositoryBoleta.findAll().forEach(aux::add);
        // devolvemos la nueva lista
        return aux; 
    }
}
