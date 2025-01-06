package org.example.examen_pacifico.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.examen_pacifico.dto.GenericResponse;
import org.example.examen_pacifico.dto.ProductoDto;
import org.example.examen_pacifico.model.Producto;
import org.example.examen_pacifico.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor

public class ProductoController {
    private final IProductoService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<ProductoDto>> getAllProductos() {
        List<ProductoDto> list= service.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProductoDto productoDto) {
        Producto obj= service.save(converToEntity(productoDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ProductoDto>> getProductoById(@PathVariable("id") int id) {
        Producto obj= service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ProductoDto>> update(@Valid @PathVariable("id") int id,@RequestBody ProductoDto productoDto) {
        productoDto.setIdProducto(id);
        Producto obj= service.update(id, converToEntity(productoDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private ProductoDto converToDto(Producto producto) {
        return modelMapper.map(producto,ProductoDto.class);
    }
    private Producto converToEntity(ProductoDto productoDto) {
        return modelMapper.map(productoDto, Producto.class);
    }
}
