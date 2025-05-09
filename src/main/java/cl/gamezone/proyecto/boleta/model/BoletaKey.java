package cl.gamezone.proyecto.boleta.model;
/*

 * Debe cumplir con lo siguiente
 *      Debe ser pública
 *      Tener un Constructor sin parámetros
 *      Definiri métodos equals y hashCode
 *      Debe ser Serializable
 */
import java.io.Serializable;
import java.util.Objects;
public class BoletaKey implements Serializable{

    // Definimos solo los campos que pertenecen a la clave única
    private Integer numboleta;
    // Constructor sin Parmámetros dbe ser obligatorio
    public BoletaKey(){}

    // Constructor con todos los campos que son parte de la clave
    public BoletaKey( Integer numboleta    ){
        setNumboleta(numboleta);
    }

    // Creamos los mutadores y Accesadores que son parte de la clave
        public Integer getNumboleta(){
        return numboleta;
    }
    public void setNumboleta(Integer numboleta){
        this.numboleta=numboleta;
    }

    // Configuramos el igual
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final BoletaKey aux = (BoletaKey) obj;
        if (!Objects.equals(this.numboleta,aux.numboleta)){          return false;        }
        return true;
    }

    // Configuramos el hashCode
    public int hashCode() {
        int hash=7;
        hash = 59* hash +  Objects.hashCode(this.numboleta);
        return hash;
    }
}