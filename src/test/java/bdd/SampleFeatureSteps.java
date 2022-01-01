package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SampleFeatureSteps {

	@Autowired
	PetService petService;

	@Autowired
	OwnerRepository ownerRepository;

	@Autowired
	PetRepository petRepository;

	@Autowired
	PetTypeRepository petTypeRepository;

	private Owner gholam;
	private PetType petType;

	@Before("@sample_annotation")
	public void setup() {
		// sample setup code
	}

	@Given("There is a pet owner called {string}")
	public void thereIsAPetOwnerCalled(String name) {
		gholam = new Owner();
		gholam.setFirstName("Amu");
		gholam.setLastName("Gholam");
		gholam.setAddress("Najibie - Kooche shahid abbas alavi");
		gholam.setCity("Tehran");
		gholam.setTelephone("09191919223");
		ownerRepository.save(gholam);
	}
	@When("He performs save pet service to add a pet to his list")
	public void hePerformsSavePetService() {
		Pet pet = new Pet();
		pet.setType(petType);
		petService.savePet(pet, gholam);
	}

	@Then("The pet is saved successfully")
	public void petIsSaved() {
		assertNotNull(petService.findPet(petType.getId()));
	}

	@Given("There is some predefined pet types like {string}")
	public void thereIsSomePredefinedPetTypesLike(String petTypeName) {
		petType = new PetType();
		petType.setName(petTypeName);
		petTypeRepository.save(petType);
	}



	@Given("There is at least one pet owner")
	public void thereIsAPetOwnerCalled() {
		gholam = new Owner();
		gholam.setFirstName("Amu");
		gholam.setLastName("Gholam");
		gholam.setAddress("Najibie - Kooche shahid abbas alavi");
		gholam.setCity("Tehran");
		gholam.setTelephone("09191919223");
		ownerRepository.save(gholam);
	}
	@When("Someone open id {string} profile")
	public void someoneSearchFor(String string) {
		int num = Integer.parseInt(string);
		petService.findOwner(num);
	}

	@Then("{string} id owner will be found")
	public void idOwnerDetaile(String string) {
		int num = Integer.parseInt(string);
		assertNotNull(petService.findOwner(num));
	}

	@When("He performs new pet service to add a pet on his list")
	public void hePerformNewPetServiceToAddAPetOnHisList() {
		petService.newPet(gholam);
	}
	@Given("There is at least one pet with name like {string}")
	public void ThereIsAtLeastOnePetWithNameLike(String string) {
		gholam = new Owner();
		gholam.setFirstName("Amu");
		gholam.setLastName("Gholam");
		gholam.setAddress("Najibie - Kooche shahid abbas alavi");
		gholam.setCity("Tehran");
		gholam.setTelephone("09191919223");
		ownerRepository.save(gholam);

		Pet pet = new Pet();
		pet.setType(petType);
		petService.savePet(pet, gholam);
	}


	@When("Someone performs find pet service to find a pet with id {string}")
	public void hePerformFindPetServiceToFindAPetWithID(String string) {
		petService.findPet(1);
	}

	@Then("The pet is found successfully")
	public void petIsFound() {

		assertNotNull(petService.findPet(1));
	}

}
