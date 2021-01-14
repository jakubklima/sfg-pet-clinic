package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int petSize = petTypeService.findAll().size();

        if (petSize == 0) loadData();
        
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(radiology);

        Speciality dentist = new Speciality();
        radiology.setDescription("Dentist");
        Speciality savedDentist = specialityService.save(radiology);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("zamiejska");
        owner1.setCity("wawa");
        owner1.setTelephone("123");


        Pet michaleDog = new Pet();
        michaleDog.setPetType(saveDogPetType);
        michaleDog.setOwner(owner1);
        owner1.getPets().add(michaleDog);
        michaleDog.setBirthDate(LocalDate.now());
        michaleDog.setName("Rosco");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Giename");
        owner2.setAddress("jerozolismke");
        owner2.setCity("wawa");
        owner2.setTelephone("999");


        Pet fionaCat = new Pet();
        fionaCat.setPetType(saveCatPetType);
        fionaCat.setOwner(owner2);
        owner2.getPets().add(fionaCat);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("just cat");

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessy");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}
