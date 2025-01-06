package org.example.examen_pacifico.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.examen_pacifico.model.Producto;
import org.example.examen_pacifico.repo.IGenericRepo;
import org.example.examen_pacifico.repo.IProductoRepo;
import org.example.examen_pacifico.service.IProductoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceimpl extends CRUDimpl<Producto,Integer> implements IProductoService{

    private final IProductoRepo repo;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }


}
