package co.winish.petclinic.bootstrap;

import co.winish.petclinic.model.Owner;
import co.winish.petclinic.model.Vet;
import co.winish.petclinic.services.OwnerService;
import co.winish.petclinic.services.PetService;
import co.winish.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Owner owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .build();
        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Fiona")
                .lastName("Gleganne")
                .build();
        ownerService.save(owner2);

        log.debug("Loaded owners...");


        Vet vet1 = Vet.builder()
                .firstName("Sam")
                .lastName("Axe")
                .build();
        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Jack")
                .lastName("Ripper")
                .build();
        vetService.save(vet2);

        log.debug("Loaded vets...");
    }
}
