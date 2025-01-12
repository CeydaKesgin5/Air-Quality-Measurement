package com.example.intern2.service;

import java.util.List;

public interface IService<T> {
    T save(T t);
    T getById(Integer id);

    List<T> getAll();

    void delete(Integer id);


    T update(Integer id,T existingEntity);

    public void add();
}
