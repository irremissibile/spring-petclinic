package co.winish.petclinic.services;

import co.winish.petclinic.model.Owner;

import java.util.Optional;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
