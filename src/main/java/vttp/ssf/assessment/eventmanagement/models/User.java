package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=4, max=25)
    private String fullName;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DOB;

    @Email
    @Size(max=50)
    private String email;



    @Size(min=8, max=8)
    private Integer phoneNo;

    @NotBlank
    private char gender;
    
    @Min(1)
    @Max(3)
    private int tixpax;

    public User(@NotNull @Size(min = 4, max = 25) String fullName, @Past Date dOB, @Email @Size(max = 50) String email,
            int phoneNo, char gender, @Min(1) @Max(3) int tixpax) {
        this.fullName = fullName;
        DOB = dOB;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.tixpax = tixpax;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date dOB) {
        DOB = dOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }



    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getTixpax() {
        return tixpax;
    }

    public void setTixpax(int tixpax) {
        this.tixpax = tixpax;
    }
}
