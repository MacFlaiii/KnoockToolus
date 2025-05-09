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
 *                Nosotros devolveremos un Objeto ResponseDTO, el cual contiene 
 *                la respuesta y registro en su interior 
 *      Ejemplo de Respuesta
 * 
                {
                    "ok": true,
                    "status": "OKE000",
                    "detalle": "Ok Registro enviados",
                    "count": 1,
                    "registros": [
                        {
                            "id": 104,
                            "nombre": "Harrys",
                            "apellido": "El simpatico",
                            "edad": 217
                        },
                    ]
                }
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
import org.springframework.web.bind.annotation.ResponseStatus;

//import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

import java.util.List;
import java.util.ArrayList;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import cl.gamezone.proyecto.boleta.dto.BoletaDTO;
import cl.gamezone.proyecto.boleta.model.Boleta;
import cl.gamezone.proyecto.boleta.dto.ResponseDTO;
import cl.gamezone.proyecto.boleta.service.IBoletaService;

/*
 * @author Harrys Informática
 */

//@CrossOrigin(origins = "http://localhost:8081")
// Especificamos que es un Controller
@RestController  
// Todas las rutas de la clase tienen prefijo => /api/crud/boleta
@RequestMapping("/api/crud/boleta")       
public class BoletaController {
    // @PostMapping("owners/*/pets/{petId}/visits")
    // Creamos un Logger
    private static final Logger logger = LoggerFactory.getLogger(BoletaController.class);


	@Autowired    // Inyectar el servicio, Se utiliza la interfaz, no la implementación
	IBoletaService serviceBoleta;

    // Para poder convertir de una entidad a otra (DTO a Entity o al revez)
    //Si queremos utilizar AutoWired debemos crea la clase config, especificando que es un Bean
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
    public ResponseEntity<ResponseDTO> getAllBoleta(){
        logger.info("Get All");
        // Devolvemos el arreglo completo,utilizando una clase (ResponseDTO)
        // Utilizamos la interface Servicio
        return new ResponseEntity<>(new ResponseDTO("Ok Registro enviados",serviceBoleta.listarBoletaAll()), HttpStatus.OK) ;
    }

    
    // http://localhost:8090/api/crud/boleta/100
    // En RestFull existe el método Get/x/x/x/, con un parámetros en la ruta (URL),
    // @PathVariable especifíca que la variable idHarrys viene por parámetro, en el ejemplo sería 767,78 y 897
    // este permite realizar una consulta de un registro en particular
    //              Ej  http://localhost:8090/api/crud/Boleta/767
    //                  http://localhost:8090/api/crud/Boleta/78
    //                  http://localhost:8090/api/crud/Boleta/897
    @GetMapping("/{numboleta}")
    public ResponseEntity<ResponseDTO> getBoletaByKey(@PathVariable  @Min(1) Integer numboleta    ){
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        Optional<Boleta> objetoData = serviceBoleta.listarBoletaByKey(numboleta);      
        
        // Si Existe el Objeto lo agregamos  a la lista
        if (objetoData.isPresent()) {
                logger.info("Mensaje de Prueba");
                // Creamos un contenedor para enviarlo por la WEB
                List<Boleta> listObjeto = new ArrayList<>();
                listObjeto.add(objetoData.get());
                // Devolvemos el objeto que se encuentra dentro del arreglo
                return new ResponseEntity<>(new ResponseDTO("Busqueda By ID",listObjeto), HttpStatus.OK);
            }
            else{
                // Si no Existe devolvemos Status Not_Content, cuando envio not_content,no envia respuesta
                // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                // Ojo Prefiero que reciba El Objeto sin data, 
                return new ResponseEntity<>(new ResponseDTO("Busqueda By ID",null), HttpStatus.OK);
            }
    }

    // http://localhost:8090/api/crud/boleta
    // En RestFull,  el Método Post, nos permite realizar un insert
    // Viene sin parámetros en la ruta (URL)
    // los datos vienen en el cuerpo del mensaje
    //  @RequestBody Nos permite especificar, que la variable viene por el cuerpo del mensaje
    //  Observe que ahora especificámos que es un objeto del tipo Boleta

    //@Valid , automáticamente inicia la implementación JSR 380 predeterminada (Hibernate Validator) y valida el argumento.
    //Cuando el argumento de destino no pasa la validación, Spring Boot lanza una excepción MethodArgumentNotValidException .
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<ResponseDTO> createBoleta(@Valid @RequestBody BoletaDTO boletaObj){
            // Llamamos al Servicio Interface, y utilizamos ResponseDTO
            Boleta aux = modelMapper.map(boletaObj, Boleta.class);
            return new ResponseEntity<>(new ResponseDTO("Agregar Registro"
                   ,serviceBoleta.crearBoleta(aux)!=null), HttpStatus.OK) ;
    }

    // http://localhost:8090/api/crud/boleta/100
    // En RestFull, el método Put, permite modificar un registro
    // Se utiliza el parámetro de la Url para enviar la key a modificar
    // Se utiliza el cuerpo para enviar los datos a modificar
    @PutMapping("/{numboleta}")
    public ResponseEntity<ResponseDTO> updateBoleta(@PathVariable  @Min(1) Integer numboleta        ,@Valid  @RequestBody BoletaDTO boletaObj){
            Boleta aux = modelMapper.map(boletaObj, Boleta.class);
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        return new ResponseEntity<>(new ResponseDTO("Actualizar Registro"
                        ,serviceBoleta.actualizarBoleta(numboleta,aux)!=null), HttpStatus.OK) ;            
    }


    // En RestFull, El método delete, nos permite eliminar un registro
    //            http://localhost:8090/Banco/v1/100
    @DeleteMapping("/{numboleta}")
    public ResponseEntity<ResponseDTO> deleteBoleta(@PathVariable  @Min(1) Integer numboleta    ){
        // Ejecutamos el servicio el cual nos devuelve un Objeto      
        return new ResponseEntity<>(new ResponseDTO("Eliminar Registro",serviceBoleta.borrarBoletaByKey(numboleta)), HttpStatus.OK) ;       
    }

    //************************************************************************** */


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
