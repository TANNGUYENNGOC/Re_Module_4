package com.furama_management.controller;

import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;
import com.furama_management.model.facility.FacilityType;
import com.furama_management.service.facility.IFacilityService;
import com.furama_management.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @GetMapping("/list")
    public String showListFacility(@RequestParam(defaultValue = "")String nameFacility,
                                   @RequestParam(defaultValue = "")String facilityType,
                                   Model model,
                                   Pageable pageable){
        Page<FacilityDTO1> listFacility = facilityService.listFacility(pageable,nameFacility,facilityType);
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        model.addAttribute("listFacility",listFacility);
        return "facility/list";
    }

}
