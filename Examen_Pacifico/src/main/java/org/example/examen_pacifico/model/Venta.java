package org.example.examen_pacifico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "IdProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_VENTA_PRODUCTO"))
    private Producto producto;

    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private double total;

    @Column (nullable = false)
    private boolean estado;

    @Column (nullable = false)
    private LocalDateTime fecha;

}
