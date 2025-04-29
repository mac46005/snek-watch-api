package com.preciado.snek_watch_api.repository;

import java.util.List;

public interface ICRUD<T> {
    long create(T data);
    List<T> read();
    T read(long id);
    boolean update(T data);
    boolean delete(T data);
}
