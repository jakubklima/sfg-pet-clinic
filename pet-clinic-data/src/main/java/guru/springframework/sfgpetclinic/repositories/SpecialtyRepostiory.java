package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepostiory extends CrudRepository<Speciality, Long> {
}
