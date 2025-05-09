package cl.gamezone.proyecto.persona.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="persona")
public class PersonaDTO {
    
    @Column(name="rut")
    
    @Id
    
    private int rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
}
