package co.winish.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialty",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();


    @Builder
    public Vet(Long id, String firstName, String lastName,
               Set<Specialty> specialties) {
        super(id, firstName, lastName);
        this.specialties = specialties;
    }


    public Vet addSpecialty(Specialty specialty) {
        specialties.add(specialty);
        return this;
    }
}
