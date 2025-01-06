package org.example.examen_pacifico.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column (nullable = false , length = 80)
    private String nombre;

    @Column (nullable = false)
    private double precio;

}
