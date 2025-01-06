package org.example.examen_pacifico.service.impl;

import org.example.examen_pacifico.exception.ModelNotFoundException;
import org.example.examen_pacifico.repo.IGenericRepo;
import org.example.examen_pacifico.service.ICRUD;

import java.util.List;

public abstract class CRUDimpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) {

        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("El Id no existe: "+ id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("El Id no existe: "+ id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("El Id no existe: "+ id));
        getRepo().deleteById(id);
    }
}
