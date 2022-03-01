package rifqimuhammadaziz.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    // validate on Collection (container type data), add annotation in generic type
    private List<@NotBlank(message = "Hobby can not blank") String> hobbies;

    @Size(max = 20, message = "First Name length max length is 20 characters")
    @NotBlank(message = "First Name can not blank!")
    private String firstName;

    @Size(max = 20, message = "Last Name length max length is 20 characters")
    @NotBlank(message = "Last Name can not blank!")
    private String lastName;

    @NotNull(message = "Address can not null")
    @Valid
    private Address address;

    @Valid
    public Person() {
    }

    @Valid
    public Person(
            @NotBlank(message = "First Name can not blank") String firstName,
            @NotBlank(message = "Last Name can not blank") String lastName,
            @NotNull(message = "Address can not null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "Name can not blank") String name) {
        System.out.println("Hello " + name + ", my name is " + firstName);
    }

    @NotBlank(message = "Full Name can not blank")
    public String fullName() {
        return firstName + " " + lastName;
    }


}
