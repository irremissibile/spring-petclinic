package co.winish.petclinic.services.map;

import co.winish.petclinic.model.BaseEntity;
import co.winish.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.of(map.get(id));
    }

    public T save(T t) {
        if (t != null) {
            if (t.getId() == null)
                t.setId(getNextId());
            map.put(t.getId(), t);
        } else
            throw new RuntimeException("Object cannot be null");

        return t;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
