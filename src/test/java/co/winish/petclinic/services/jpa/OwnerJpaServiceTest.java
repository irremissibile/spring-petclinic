package co.winish.petclinic.services.jpa;

import co.winish.petclinic.model.Owner;
import co.winish.petclinic.repositories.OwnerRepository;
import co.winish.petclinic.repositories.PetRepository;
import co.winish.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @InjectMocks
    OwnerJpaService ownerJpaService;

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    static final Long ID = 1L;
    static final String LAST_NAME = "Schultz";
    static final Owner OWNER = Owner.builder().id(ID).lastName(LAST_NAME).build();


    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(Optional.of(OWNER));

        Owner toBeFound = ownerJpaService.findByLastName(LAST_NAME).get();

        assertEquals(OWNER, toBeFound);
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.of(OWNER));

        Owner toBeFound = ownerJpaService.findById(ID).get();

        assertEquals(OWNER, toBeFound);
        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> ownerJpaService.findById(ID).get());
    }

    @Test
    void save() {
        Owner toBeSaved = Owner.builder().id(ID).lastName(LAST_NAME).build();

        when(ownerRepository.save(any())).thenReturn(OWNER);

        Owner savedOwner = ownerJpaService.save(toBeSaved);

        assertEquals(OWNER, savedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(23L).build());
        owners.add(Owner.builder().id(24L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> result = ownerJpaService.findAll();

        assertNotNull(result);
        assertEquals(owners, result);
    }

    @Test
    void delete() {
        ownerJpaService.delete(OWNER);
        verify(ownerRepository).delete(OWNER);
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(ID);
        verify(ownerRepository).deleteById(ID);
    }
}