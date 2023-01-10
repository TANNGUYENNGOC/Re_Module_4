package com.furama_management.dto.customer;

import com.furama_management.dto.facility.FacilityDTO;
import com.furama_management.model.customer.Customer;
import com.furama_management.model.customer.CustomerType;
import com.furama_management.model.facility.Facility;
import com.furama_management.service.customer.ICustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CustomerDTO implements Validator {
    private int id;
    private CustomerType customerType;
    private String name;
    private String dateOfBirth;

    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean flag;


    public CustomerDTO() {
    }

    public CustomerDTO(CustomerType customerType, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address) {
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public CustomerDTO(int id, CustomerType customerType, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, boolean flag) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public void checkPhoneNumber(List<Customer> list, CustomerDTO customerDTO, Errors errors) {
        for (Customer x : list) {
            if (x.getPhoneNumber().equals(customerDTO.phoneNumber)) {
                errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại " + customerDTO.getPhoneNumber() + " đã có người dùng rồi");
            }
        }
    }

    public void checkIDCard(List<Customer> list, CustomerDTO customerDTO, Errors errors) {
        for (Customer x : list) {
            if (x.getIdCard().equals(customerDTO.idCard)) {
                errors.rejectValue("idCard", "idCard", "Số CMND " + customerDTO.getIdCard() + " đã tồn tại");
            }
        }
    }


    public void checkDuplicate(List<Customer> listCustomer, CustomerDTO customerDto, Errors errors) {

        if (customerDto.getName().matches("")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được để trống.");
        } else if (!customerDto.getName().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.");
        }

        //Validate age of birth day
        String birthdayVal = customerDto.getDateOfBirth();
        if (birthdayVal.matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Vui lòng chọn ngày sinh");
        } else {
            LocalDate dayOfBirth = LocalDate.parse(birthdayVal);
            LocalDate now = LocalDate.now();
            Period checkAge = Period.between(dayOfBirth, now);
            if (checkAge.getYears() < 18 | checkAge.getYears() > 100) {
                errors.rejectValue("dateOfBirth", "dateOfBirth", "Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn 100");
            }
        }

        //Validate số điện thoại
        if (customerDto.getPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else if (!customerDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại phải bắt đầu bằng 0 và có 10 số");
        } else {
            for (int i = 0; i < listCustomer.size(); i++) {
                if (customerDto.getPhoneNumber().equals(listCustomer.get(i).getPhoneNumber())) {
                    errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại đã có người sử dụng");
                    break;
                }
            }
        }
//

        //Validate số CMND
        if (customerDto.getIdCard().matches("")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải không được để trống");
        } else if (!customerDto.getIdCard().matches("[0-9]{10}")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải là 10 số và không được chứa bất kì kí tự nào khác");
        } else {
            for (int i = 0; i < listCustomer.size(); i++) {
                if (customerDto.getIdCard().equals(listCustomer.get(i).getIdCard())) {
                    errors.rejectValue("idCard", "idCard", "Số CMND đã có người xử dụng");
                    break;
                }
            }
        }
        //Validate email
        if (customerDto.getEmail().matches("")) {
            errors.rejectValue("email", "email", "Email không được để trống");
        } else if (!customerDto.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email", "Email không đúng định dạng");
        } else {
            for (int i = 0; i < listCustomer.size(); i++) {
                if (customerDto.getEmail().equals(listCustomer.get(i).getEmail())) {
                    errors.rejectValue("email", "email", "Email đã có người xử dụng");
                    break;
                }
            }
        }

        // Validate địa chỉ
        if (customerDto.getAddress().matches("")) {
            errors.rejectValue("address", "address", "Bạn quịt nợ tôi biết tìm đâu");
        } else if (!customerDto.getAddress().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("address", "address", "Ghi hoa chữ cái đầu");

        }
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDTO customerDto = (CustomerDTO) target;
        //Validate name
        if (customerDto.getName().matches("")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được để trống.");
        } else if (!customerDto.getName().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.");
        }

        //Validate age of birth day
        String birthdayVal = customerDto.getDateOfBirth();
        if (birthdayVal.matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Vui lòng chọn ngày sinh");
        } else {
            LocalDate dayOfBirth = LocalDate.parse(birthdayVal);
            LocalDate now = LocalDate.now();
            Period checkAge = Period.between(dayOfBirth, now);
            if (checkAge.getYears() < 18 | checkAge.getYears() > 100) {
                errors.rejectValue("dateOfBirth", "dateOfBirth", "Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn 100");
            }
        }

        //Validate số điện thoại
        if (customerDto.getPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else if (!customerDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại phải bắt đầu bằng 0 và có 10 số");
        }
//

        //Validate số CMND
        if (customerDto.getIdCard().matches("")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải không được để trống");
        } else if (!customerDto.getIdCard().matches("[0-9]{10}")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải là 10 số và không được chứa bất kì kí tự nào khác");
        }
        //Validate email
        if (customerDto.getEmail().matches("")) {
            errors.rejectValue("email", "email", "Email không được để trống");
        } else if (!customerDto.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email", "Email không đúng định dạng");
        }

        // Validate địa chỉ
        if (customerDto.getAddress().matches("")) {
            errors.rejectValue("address", "address", "Bạn quịt nợ tôi biết tìm đâu");
        } else if (!customerDto.getAddress().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("address", "address", "Ghi hoa chữ cái đầu");
        }
    }
}
