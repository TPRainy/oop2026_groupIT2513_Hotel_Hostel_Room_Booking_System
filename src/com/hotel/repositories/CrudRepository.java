package com.hotel.repositories;

public interface CrudRepository<T> {
    T getById(int id);
}