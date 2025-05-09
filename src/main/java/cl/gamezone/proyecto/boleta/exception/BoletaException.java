package cl.gamezone.proyecto.boleta.exception;
import org.springframework.http.*;
/*
 https://www.baeldung.com/exception-handling-for-rest-with-spring  
 */
//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * @author Harrys Informática
 */

// import lombok.Data;
// @Data
//@AllArgsConstructor   // Crea un Constructor con todos los parámetros
@Getter   // Crea un Constructor con todos los parámetros
@Setter   // Crea un Constructor con todos los parámetros
public class BoletaException  extends RuntimeException   {
    private static final long serialVersionUID = 1L;
    private HttpStatus httpError;
    private String codigo;
    private String detalle;
    public BoletaException(HttpStatus httpError,String codigo,String detalle) {
        super("( " + codigo +" ) " + detalle);
        this.httpError=httpError;
        this.codigo=codigo;
        this.detalle=detalle;
    }
}
