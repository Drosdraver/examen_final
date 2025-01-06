package org.example.examen_pacifico.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.examen_pacifico.model.Venta;
import org.example.examen_pacifico.repo.IGenericRepo;
import org.example.examen_pacifico.repo.IVentaRepo;
import org.example.examen_pacifico.service.IVentaService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaServiceimpl extends CRUDimpl<Venta,Integer> implements IVentaService {
    private final IVentaRepo repo;

    @Override
    protected IGenericRepo<Venta, Integer> getRepo() {
        return repo;
    }
}
