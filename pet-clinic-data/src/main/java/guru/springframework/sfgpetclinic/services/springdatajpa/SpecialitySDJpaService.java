package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepostiory;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialtyRepostiory specialtyRepostiory;

    public SpecialitySDJpaService(SpecialtyRepostiory specialtyRepostiory) {
        this.specialtyRepostiory = specialtyRepostiory;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet = new HashSet<>();
        specialtyRepostiory.findAll().forEach(specialitySet::add);

        return specialitySet;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyRepostiory.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialtyRepostiory.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepostiory.deleteById(id);
    }
}
