package org.example.examen_pacifico.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.examen_pacifico.dto.GenericResponse;
import org.example.examen_pacifico.dto.VentaDto;
import org.example.examen_pacifico.model.Venta;
import org.example.examen_pacifico.service.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final IVentaService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<VentaDto>> getAllAtencioness() {
        List<VentaDto> list= service.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VentaDto ventaDto) {
        Venta obj= service.save(converToEntity(ventaDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<VentaDto>> getVentasById(@PathVariable("id") int id) {
        Venta obj= service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<VentaDto>> update(@Valid @PathVariable("id") int id,@RequestBody VentaDto ventaDto) {
        ventaDto.setIdVenta(id);
        Venta obj= service.update(id, converToEntity(ventaDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private VentaDto converToDto(Venta venta) {
        return modelMapper.map(venta,VentaDto.class);
    }
        private Venta converToEntity(VentaDto VentaDto) {
        return modelMapper.map(VentaDto,Venta.class);
    }
}
