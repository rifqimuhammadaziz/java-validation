package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData() {
        Person person = new Person();
        person.setFirstName("Xenosty");
        person.setLastName("Theord");
        person.setAddress(new Address());
        person.getAddress().setCity("Tegal");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Mintaragen");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("   ");
        person.getHobbies().add("Playing CSGO");

        validate(person);
    }
}
