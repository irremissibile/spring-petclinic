package co.winish.petclinic.services.map;

import co.winish.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long id = 1L;
    final String lastName = "Schultz";
    final Owner owner = Owner.builder().id(id).lastName(lastName).build();


    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(owner);
    }


    @Test
    void findById() {
        Owner toBeFound = ownerServiceMap.findById(id).get();

        assertEquals(owner, toBeFound);
    }


    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());

        assertEquals(id, savedOwner.getId());
    }


    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
        assertEquals(owner, owners.iterator().next());
    }


    @Test
    void delete() {
        ownerServiceMap.delete(owner);

        assertEquals(0, ownerServiceMap.findAll().size());
    }


    @Test
    void deleteById() {
        ownerServiceMap.deleteById(owner.getId());

        assertEquals(0, ownerServiceMap.findAll().size());
    }


    @Test
    void findByLastName() {
        Owner toBeFound = ownerServiceMap.findByLastName(lastName).get();

        assertNotNull(toBeFound);
        assertEquals(id, toBeFound.getId());
    }
}