package com.exercise_1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Size;

public class UserDTO implements Validator {
    private int id;
//    @Size(min = 5,max = 45,message = "firstName có độ dài từ 5 đến 45 kí tự")
    private String firstName;
//    @Size(min = 5,max = 45,message = "lastName có độ dài từ 5 đến 45 kí tự")
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        if (userDTO.getFirstName().matches("")){
            errors.rejectValue("firstName","firstName","First name không được để trống");
        } else if(!userDTO.getFirstName().matches("^([A-Z][a-z]+[ ]+)*([A-Z][a-z]*)$")){
            errors.rejectValue("firstName","firstName","Vui lòng nhập đúng định dạng");
        }

        if (userDTO.getLastName().matches("")){
            errors.rejectValue("lastName","lastName","Last name không được để trống");
        } else if(!userDTO.getLastName().matches("^[A-Z][a-z]+$")){
            errors.rejectValue("lastName","lastName","Vui lòng nhập đúng định dạng");
        }

        if(userDTO.getPhoneNumber().matches("")){
            errors.rejectValue("phoneNumber","phoneNumber","Vui lòng nhập số điện thoại");
        } else if(!userDTO.getPhoneNumber().matches("[0][1-9]{9}")){
            errors.rejectValue("phoneNumber","phoneNumber","Số điện thoại phải có 10 số và bắt đầu bằng 0");
        }

        if(userDTO.getAge()==0){
            errors.rejectValue("age","age","Vui lòng nhập tuổi");
        } else if(userDTO.getAge()<18){
            errors.rejectValue("age","age","Bạn phải đủ 18 tuổi");
        }

        if(userDTO.getEmail().matches("")){
           errors.rejectValue("email","email","Email không được để trống");
        } else if(!userDTO.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errors.rejectValue("email","email","Email sai định dạng");
        }

    }
}
