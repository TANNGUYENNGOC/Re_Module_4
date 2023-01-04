package com.furama_management.dto.contract;
import com.furama_management.model.customer.Customer;
import com.furama_management.model.employee.Employee;
import com.furama_management.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDto implements Validator {

    private int id;
    private String startDate;
    private String endDate;
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(String startDate, String endDate, double deposit, Employee employee, Customer customer, Facility facility) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public ContractDto(int id, String startDate, String endDate, double deposit, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto =(ContractDto) target;

        if (contractDto.getStartDate().equals("")){
            errors.rejectValue("startDate","startDate","Vui lòng chọn ngày bắt đầu");
        }
        if (contractDto.getEndDate().equals("")){
            errors.rejectValue("endDate","endDate","Vui lòng chọn ngày kết thúc");
        }

        if (contractDto.getDeposit()<=0){
            errors.rejectValue("deposit","deposit","Tiền đặt cọc phải lớn hơn 0");
        }else {
            String deposit = String.valueOf(contractDto.getDeposit());
            if (deposit.equals("")){
                errors.rejectValue("deposit","deposit","Vui lòng nhập tiền đặt cọc");
            }
        }

    }
}
