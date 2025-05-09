package cl.gamezone.proyecto.boleta.exception;


import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import cl.gamezone.proyecto.boleta.dto.ResponseDTO;

import org.springframework.http.*;
//import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/*
    Actúa como un controlador global para las excepciones lanzadas por cualquier método del controlador.
    Permite especificar manejadores de excepciones globales para los controladores.
    Evita repetir código en cada controlador.
    Permite gestionar excepciones personalizadas y proporcionar respuestas consistentes.
 */
/*
 * @author Harrys Informática
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    // Cada vez que provoquemos un error con BoletaException.class
    // Pasa por esta función
    @ExceptionHandler(BoletaException.class)
    public ResponseEntity<ResponseDTO> handleBoleta(BoletaException ex) {
        System.out.println("BoletaException :" + ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(ex.getMessage(),null), ex.getHttpError());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGeneric(Exception ex) {
        System.out.println("Ex.class : " + ex.getMessage() + ":"+ ex); 
        Map<String, Object> error = buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error Exception ");
        Map<String, String> fieldErrors = new HashMap<>();
        fieldErrors.put("err",ex.getMessage());
        error.put("errors", fieldErrors);
        return new ResponseEntity<>(new ResponseDTO("EX-001","Error interno del servidor" ,error), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Estructura de respuesta estándar
    private Map<String, Object> buildErrorResponse(HttpStatus status, String message) {
        System.out.println("buildErrorResponse : " + message);    
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", status.value());
        error.put("error", status.getReasonPhrase());
        error.put("message", message);
        return error;
    }

    // // Excepción personalizada
    // @ExceptionHandler(UserNotFoundException.class)
    // public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
    //     return new ResponseEntity<>(buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    // }

    // Error en validaciones con @Valid @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
        System.out.println("handleValidationErrors.class : " + ex.getMessage() + ":"+ ex);    
        Map<String, Object> error = buildErrorResponse(HttpStatus.BAD_REQUEST, "Errores de validación");
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->
                fieldErrors.put(err.getField(), err.getDefaultMessage())
        );
        error.put("errors", fieldErrors);
        return new ResponseEntity<>(new ResponseDTO("ERR-001","Error",error), HttpStatus.BAD_REQUEST);
    }

    // Error al acceder a la base de datos
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDatabaseError(DataAccessException ex) {
        System.out.println("handleDatabaseError.class : " + ex.getMessage() + ":"+ ex);    
        Map<String, Object> error = buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error al acceder a la base de datos");
        Map<String, String> fieldErrors = new HashMap<>();
        fieldErrors.put("err",ex.getMessage());
        error.put("errors", fieldErrors);
        return new ResponseEntity<>(new ResponseDTO("EBD-001","Error BD",error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     Map<String, String> errors = new HashMap<>();
    //     ex.getBindingResult().getAllErrors().forEach((error) -> {
    //         String fieldName = ((FieldError) error).getField();
    //         String errorMessage = error.getDefaultMessage();
    //         errors.put(fieldName, errorMessage);
    //     });
    //     return errors;
    // }


    // Error en tipo de argumento (por ejemplo, pasar texto en lugar de número)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        System.out.println("handleTypeMismatch.class : " + ex.getMessage() + ":"+ ex);    
        String message = "Parámetro inválido: " + ex.getName() + " debe ser de tipo " + ex.getRequiredType().getSimpleName();
        return new ResponseEntity<>(buildErrorResponse(HttpStatus.BAD_REQUEST, message), HttpStatus.BAD_REQUEST);
    }


    // Ruta o recurso no encontrado
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNotFound(NoHandlerFoundException ex) {
        System.out.println("handleNotFound.class : " + ex.getMessage() + ":"+ ex);    
        return new ResponseEntity<>(buildErrorResponse(HttpStatus.NOT_FOUND, "Recurso no encontrado"), HttpStatus.NOT_FOUND);
    }

    // // Cualquier otra excepción no manejada
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Object> handleGenericException(Exception ex) {
    //     return new ResponseEntity<>(buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
    // }    
}