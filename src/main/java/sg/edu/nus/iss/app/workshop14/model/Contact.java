package sg.edu.nus.iss.app.workshop14.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact implements Serializable{

    @NotNull(message="Name cannot be null")
    @Size(min = 3 , max=64 , message="Name must be between 3 and 64 characters")
    private String name;

    @Email(message="Invalid email")
    private String email;

    @Size(min = 7, message="Phone number must be at least 7 digit")
    private String phoneNumber;

    private String id;

    @Past(message="Date of birth must not be future")
    @NotNull(message="Date of birth must be mandatory")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    @Min(value=10, message="Must be above 10 years old")
    @Max(value=100, message="Must be below 100 years old")
    private int age;

    public Contact(){

    }

    

    public Contact(String name, String email, String phoneNumber,
        LocalDate dateOfBirth){
        this.id = generateId(8);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Contact(String id, String name, String email, String phoneNumber,
        LocalDate dateOfBirth){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    private synchronized String generateId(int numOfChars){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numOfChars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numOfChars);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        int calculateAge = 0;
        if(null != dateOfBirth){
            calculateAge = Period.between(dateOfBirth, LocalDate.now()).getYears();
        }
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
