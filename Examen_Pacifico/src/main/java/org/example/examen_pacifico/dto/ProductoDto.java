package org.example.examen_pacifico.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDto {
    private Integer idProducto;

    @NotNull
    @Size(min = 1, max = 80)
    private String nombre;

    @NotNull
    private double precio;

}
