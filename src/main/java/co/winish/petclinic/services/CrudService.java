package co.winish.petclinic.services;

import java.util.Optional;
import java.util.Set;

public interface CrudService <T, ID> {
    Optional<T> findById(ID id);
    T save(T t);
    Set<T> findAll();
    void delete(T t);
    void deleteById(ID id);
}
