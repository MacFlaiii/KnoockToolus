package cl.gamezone.proyecto.boleta.controller;
/*
 * Objetivo
 *      Demostrar el funcionamiento de un controlador utilizando: 
 *          Controller  ==> Llama Al Servicio Interface
 *          Servicio  Interface  ==> Llama al Servicio Imp(Es para que comprenda)
 *          Servicio que implementa los métodos ==> LLama al Repository
 *          Repositorio Interface ==> Utiliza los métodos ya existente
 * 
 *      RestFull, generalmente devuelve el objeto de la tabla
 *      Ejemplo de Respuesta
 * 
                    [
                        {
                            "id": 104,
                            "nombre": "Harrys",
                            "apellido": "El simpatico",
                            "edad": 217
                        },
                    ]
 * 
 *      
 */
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

import java.util.List;
import jakarta.validation.constraints.Min;

import cl.gamezone.proyecto.boleta.dto.BoletaDTO;
import cl.gamezone.proyecto.boleta.model.Boleta;
import cl.gamezone.proyecto.boleta.service.IBoletaService;

/*
 * @author Harrys Informática
 */

// Especificamos que es un Controller
@RestController  
// Todas las rutas de la clase tienen prefijo => /api/crud/boleta
@RequestMapping("/api/crud/obj/boleta")       
public class BoletaObjController {

    // Creamos un Logger
    private static final Logger logger = LoggerFactory.getLogger(BoletaController.class);


	@Autowired    // Inyectar el servicio, Se utiliza la interfaz, no la implementación
	IBoletaService serviceBoleta;

    // Para poder convertir de una entidad a otra (DTO a Entity o al revez)
    //Si queremos utilizar AutoWired debemos crea la clase AppConfiguration con @Configuration, especificando que es un Bean
    @Autowired
    private ModelMapper modelMapper;


/*  Para recordar
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }
 */


    //  http://localhost:8090/api/crud/boleta
    //  En RestFull el Método Get sin parámetros es listar todos los registros
    //  Debemos tener precaución que cuando sean muchos registros debieramos tener paginación
    @GetMapping      
    public ResponseEntity<List<Boleta>> getAllBoleta(){
        logger.info("Get All");
        // Devolvemos el arreglo completo
        // Utilizamos la interface Servicio
        return new ResponseEntity<>(serviceBoleta.listarBoletaAll(), HttpStatus.OK) ;
    }

    
    // http://localhost:8090/api/crud/boleta/100
    // En RestFull existe el método Get/x/x/x/, con un parámetros en la ruta (URL),
    // @PathVariable especifíca que la variable idHarrys viene por parámetro, en el ejemplo sería 767,78 y 897
    // este permite realizar una consulta de un registro en particular
    //              Ej  http://localhost:8090/api/crud/Boleta/767
    //                  http://localhost:8090/api/crud/Boleta/78
    //                  http://localhost:8090/api/crud/Boleta/897
    @GetMapping("/{numboleta}")
    public ResponseEntity<Boleta> getBoletaByKey(@PathVariable  @Min(1) Integer numboleta    ){
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        Optional<Boleta> objetoData = serviceBoleta.listarBoletaByKey(numboleta);      
        
        // Si Existe el Objeto lo agregamos  a la lista
        if (objetoData.isPresent()) {
                logger.info("Mensaje de Prueba");
                // Devolvemos el objeto 
                return new ResponseEntity<>(objetoData.get(), HttpStatus.OK);
            }
            else{
                // Si no Existe devolvemos Status Not_Content, cuando envio not_content,no envia respuesta
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }

    // http://localhost:8090/api/crud/boleta
    // En RestFull,  el Método Post, nos permite realizar un insert
    // Viene sin parámetros en la ruta (URL)
    // los datos vienen en el cuerpo del mensaje
    //  @RequestBody Nos permite especificar, que la variable viene por el cuerpo del mensaje
    //  Observe que ahora especificámos que es un objeto del tipo Boleta
    @PostMapping
    public ResponseEntity<Boleta> createBoleta(@RequestBody BoletaDTO boletaObj){
        // Devolvemos el objeto por medio de Response Entity
        Boleta aux = modelMapper.map(boletaObj, Boleta.class);
        return new ResponseEntity<>(serviceBoleta.crearBoleta(aux), HttpStatus.OK) ;
    }

    // http://localhost:8090/api/crud/boleta/100
    // En RestFull, el método Put, permite modificar un registro
    // Se utiliza el parámetro de la Url para enviar la key a modificar
    // Se utiliza el cuerpo para enviar los datos a modificar
    @PutMapping("/{numboleta}")
    public ResponseEntity<Boleta> updateBoleta(@PathVariable  @Min(1) Integer numboleta        , @RequestBody BoletaDTO boletaObj){
            Boleta aux = modelMapper.map(boletaObj, Boleta.class);
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        return new ResponseEntity<>(serviceBoleta.actualizarBoleta(numboleta,aux), HttpStatus.OK) ;        
    }


    // En RestFull, El método delete, nos permite eliminar un registro
    //            http://localhost:8090/Banco/v1/100
    @DeleteMapping("/{numboleta}")
    public ResponseEntity<Boolean> deleteBoleta(@PathVariable  @Min(1) Integer numboleta    ){
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        return new ResponseEntity<>(serviceBoleta.borrarBoletaByKey(numboleta), HttpStatus.OK) ;    }

    //************************************************************************** */
    /*
    // Probar
	public List<SucursalDTO> listarSucursales(@RequestParam(name = "nombreSucursal", required = false, defaultValue = "") String nombreSucursal) {
    public ResponseEntity<SucursalResponse> borrarSucursal(@PathVariable("idSucursal") String idSucursal) {

    import org.springframework.http.HttpHeaders;
    import org.springframework.http.ResponseEntity;
    return new ResponseEntity<SucursalResponse>(retorno, new HttpHeaders(), HttpStatus.OK);

     */
}
