package cl.gamezone.proyecto.boleta.model;
/*

 * JpaIlegalArgument Not a Managed Typed
 */
//import javax.persistence.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
/*
 * @author Harrys Informática
 */


// Indica que uns entidad JPA
@Entity   

// Nombre real de la tabla en la base de datos
@Table(name="Boleta")   

// JsonIgnoreProperties, Los objetos vacíos los reemplaza por null
@JsonIgnoreProperties(ignoreUnknown=true)

// @IdClass Nos permite definir cuando la Pk, contiene más de una columna
// Como tenemos un generador de programa, lo realizo para todas las clases
// En JPA se puede utiliza @IdClass or @EmbeddedId
//         @IdClass se definen los campos en ambas clases, podemos acceder campo por campo
//         @EmbeddedId solo se definen en la segunda clase, se ve todo como un objeto completo

// @Data Agrupa las características de @ToString, @EqualsAndHashCode, @Getter / @Setter y @RequiredArgsConstructor 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boleta{

/*   Ver más adelante
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Digits(fraction = 0, integer = 12)

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Pet> pets;    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId")
    private Address address;    @ManyToOne(fetch = FetchType.LAZY)


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Email> emails;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="ADDR_ID", referencedColumnName="ID"),
        @JoinColumn(name="ADDR_ZIP", referencedColumnName="ZIP")
    })
    private Address address;    
 */    

    //   Nombre,Acepta Nullos, Largo de la variable
    //@Column(name="CAR_ENGINE", nullable = true, length = 6)
    //@Getter @Setter   // Podemos especificar Getter y Setter pos separados para cada campo

    // Ejemplo Decoradores 
	// @GeneratedValue(generator = "CAR_SEQ", strategy = GenerationType.SEQUENCE) 
	// @SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize=1)    
    // Especifica que es la PK, si existe más de una columna se debe crear otra clase con los campos (idClass) 
    @Id         
    // Nombre real de la columna 
    @Column(name = "NUMBOLETA")     
    private Integer numboleta;
    @Column(name = "RUTCLIENTE")    // Nombre Real de la columna 
    private String rutcliente;
    @Column(name = "RUTEMPLEADO")    // Nombre Real de la columna 
    private String rutempleado;
    @Column(name = "FECHA")    // Nombre Real de la columna 
    private Date fecha;
    @Column(name = "TOTAL")    // Nombre Real de la columna 
    private Integer total;
    @Column(name = "CODPAGO")    // Nombre Real de la columna 
    private Integer codpago;
    @Column(name = "CODBANCO")    // Nombre Real de la columna 
    private Integer codbanco;
    @Column(name = "NUM_DOCTO_PAGO")    // Nombre Real de la columna 
    private String numDoctoPago;
    @Column(name = "ESTADO")    // Nombre Real de la columna 
    private String estado;

/*  No Es necesario si utilizamos Decoradores

    // Creamos el constructor para el JPA, observe que esta protecter
    protected BoletaDTO(){}

    // Creamos el constructor con todos los parámetros para Insertar y actualizar
    // Debe ser público
    public BoletaDTO( Integer numboleta, String rutcliente, String rutempleado, Date fecha, Integer total, Integer codpago, Integer codbanco, String numDoctoPago, String estado    ){
        setNumboleta(numboleta);
        setRutcliente(rutcliente);
        setRutempleado(rutempleado);
        setFecha(fecha);
        setTotal(total);
        setCodpago(codpago);
        setCodbanco(codbanco);
        setNumDoctoPago(numDoctoPago);
        setEstado(estado);
    }
 */
    // Crearemos los mismos campos(Atributos) en todas las clases

    // Creamos los Constructores y los Accesadores

    /*   con @Getter y @Setter no es necesario crear
    public Integer getNumboleta(){
        return numboleta;
    }
    public void setNumboleta(Integer numboleta){
        this.numboleta=numboleta;
    }
    public String getRutcliente(){
        return rutcliente;
    }
    public void setRutcliente(String rutcliente){
        this.rutcliente=rutcliente;
    }
    public String getRutempleado(){
        return rutempleado;
    }
    public void setRutempleado(String rutempleado){
        this.rutempleado=rutempleado;
    }
    public Date getFecha(){
              return fecha;
     }
    public void setFecha(Date fecha){
              this.fecha=fecha;
     }
    public Integer getTotal(){
        return total;
    }
    public void setTotal(Integer total){
        this.total=total;
    }
    public Integer getCodpago(){
        return codpago;
    }
    public void setCodpago(Integer codpago){
        this.codpago=codpago;
    }
    public Integer getCodbanco(){
        return codbanco;
    }
    public void setCodbanco(Integer codbanco){
        this.codbanco=codbanco;
    }
    public String getNumDoctoPago(){
        return numDoctoPago;
    }
    public void setNumDoctoPago(String numDoctoPago){
        this.numDoctoPago=numDoctoPago;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }

     */

/* 
    $$XFK$$_fk_column.java
DetalleBoleta

*/
}