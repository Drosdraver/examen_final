package org.example.examen_pacifico.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.examen_pacifico.model.Producto;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VentaDto {
    private Integer idVenta;

    @NotNull
    private Producto producto;

    @NotNull
    private double total;

    @NotNull
    private boolean estado;

    @NotNull
    private LocalDateTime fecha;

}
