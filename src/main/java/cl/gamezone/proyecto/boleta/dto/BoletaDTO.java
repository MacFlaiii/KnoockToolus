package cl.gamezone.proyecto.boleta.dto;
/*

 * JpaIlegalArgument Not a Managed Typed
 */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
/*
 * @author Harrys Informática
 */


// JsonIgnoreProperties, Los objetos vacíos los reemplaza por null
@JsonIgnoreProperties(ignoreUnknown=true)

// @Data Agrupa las características de @ToString, @EqualsAndHashCode, @Getter / @Setter y @RequiredArgsConstructor 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class BoletaDTO{
/*
    @Range(min = 1)
    @Size(min =10,max=100,message ="emaild id must be valid")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    @Email(message = "Email should be valid")
    @AssertTrue
    @NotEmpty
    @Positive and @PositiveOrZero
    @Negative and @NegativeOrZero
    @Past and @PastOrPresent
    @Future and @FutureOrPresent
    @Email(message = "Email should be valid")
 */

    @NotNull(message = "NUMBOLETA Ob ligatorio")
    private Integer numboleta;
    @NotBlank(message = "RUTCLIENTE Ob ligatorio")
    //@Size
    private String rutcliente;
    @NotBlank(message = "RUTEMPLEADO Ob ligatorio")
    //@Size
    private String rutempleado;
    @NotBlank(message = "FECHA Ob ligatorio")
    //@Size
    private Date fecha;
    @NotBlank(message = "TOTAL Ob ligatorio")
    //@Size
    private Integer total;
    @NotBlank(message = "CODPAGO Ob ligatorio")
    //@Size
    private Integer codpago;
    @NotBlank(message = "CODBANCO Ob ligatorio")
    //@Size
    private Integer codbanco;
    @NotBlank(message = "NUM_DOCTO_PAGO Ob ligatorio")
    //@Size
    private String numDoctoPago;
    @NotBlank(message = "ESTADO Ob ligatorio")
    //@Size
    private String estado;


}