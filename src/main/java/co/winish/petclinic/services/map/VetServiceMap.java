package co.winish.petclinic.services.map;

import co.winish.petclinic.model.Vet;
import co.winish.petclinic.services.SpecialtyService;
import co.winish.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        vet.getSpecialties().forEach(specialty -> {
            if (specialty.getId() == null)
                specialty.setId(specialtyService.save(specialty).getId());
        });

        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}
