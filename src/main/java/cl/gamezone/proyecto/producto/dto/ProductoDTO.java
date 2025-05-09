package cl.gamezone.proyecto.producto.dto;

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
@Table(name = "producto")   
public class ProductoDTO {

    @Column(name="id")
    
    @Id
    

    private int id;
    private String nombre;  
    private String descripcion;
    private String Precio;
    private int stock;

}
