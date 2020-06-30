package co.winish.petclinic.services.map;

import co.winish.petclinic.model.Visit;
import co.winish.petclinic.services.VisitService;

import java.util.Optional;
import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        return super.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }
}
