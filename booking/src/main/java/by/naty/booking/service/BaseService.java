package by.naty.booking.service;

import java.util.List;

public interface BaseService<T> {

    T create(T dto);

    List<T> findAll();

    T findById(Long id);

    void delete(Long id);

}
