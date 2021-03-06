package co.winish.petclinic.services.map;

import co.winish.petclinic.model.Specialty;
import co.winish.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

    @Override
    public Optional<Specialty> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
