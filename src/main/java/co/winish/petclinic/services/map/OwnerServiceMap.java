package co.winish.petclinic.services.map;

import co.winish.petclinic.model.Owner;
import co.winish.petclinic.services.OwnerService;
import co.winish.petclinic.services.PetService;
import co.winish.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() != null)
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                } else
                    throw new RuntimeException("PetType is required");

                if (pet.getId() == null)
                    pet.setId(petService.save(pet).getId());
            });

            return super.save(owner);
        } else
            return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return findAll().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }
}
