package com.furama_management.controller.rest;

import com.furama_management.dto.attach_facility.IAttachFacilityCustomer;
import com.furama_management.dto.attach_facility.IAttachFacilityDTO;
import com.furama_management.service.contract.IContractService;
import com.furama_management.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-attachFacility")
@CrossOrigin("*")
public class AttachFacilityRestController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    //Của contract
    @GetMapping("/showListAttachFacility/{id}")
    public ResponseEntity<List<IAttachFacilityDTO>> getList(
             @PathVariable("id") int id) {
        List<IAttachFacilityDTO> attachFacilityDTOS = contractService.listAttachFacility(id);
        if (attachFacilityDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityDTOS, HttpStatus.OK);
    }
    //của customer đang sử dụng dịch vụ
    @GetMapping("showListAttachFacilityCustomer/{id}")
    public ResponseEntity<List<IAttachFacilityCustomer>> listAttachFacilityCustomer(@PathVariable("id") int id){
        List<IAttachFacilityCustomer> attachFacilityCustomers = customerService.listAttachFacility(id);
        if (attachFacilityCustomers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityCustomers, HttpStatus.OK);
    }
}
