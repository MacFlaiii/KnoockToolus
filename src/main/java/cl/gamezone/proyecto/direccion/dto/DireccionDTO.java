package cl.gamezone.proyecto.direccion.dto;

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

@Table(name="direccion")
public class DireccionDTO {
    @Column(name="compra")
    @Id
    private int idDireccion;
    private String direccion;

}
