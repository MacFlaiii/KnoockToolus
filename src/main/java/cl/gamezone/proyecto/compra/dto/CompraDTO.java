package cl.gamezone.proyecto.compra.dto;


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
public class CompraDTO {
    @Column(name="compra")
    @Id
    private int idCompra;
    private int cantidad_cc;

}
