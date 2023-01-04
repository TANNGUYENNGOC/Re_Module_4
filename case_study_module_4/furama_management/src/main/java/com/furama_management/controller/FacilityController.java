package com.furama_management.controller;

import com.furama_management.dto.facility.FacilityDTO;
import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;

import com.furama_management.service.facility.IFacilityRentTypeService;
import com.furama_management.service.facility.IFacilityService;
import com.furama_management.service.facility.IFacilityTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IFacilityRentTypeService facilityRentTypeService;

    @GetMapping("/list")
    public String showListFacility(@RequestParam(defaultValue = "") String nameFacility,
                                   @RequestParam(defaultValue = "") String facilityType,
                                   Model model,
                                   @PageableDefault(size = 4, page = 0) Pageable pageable) {
        Page<FacilityDTO1> listFacility = facilityService.listFacility(pageable, nameFacility, facilityType);
        model.addAttribute("listFacilityType", facilityTypeService.findAll());
        model.addAttribute("listFacility", listFacility);
        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model, Pageable pageable) {
        model.addAttribute("facilityDTO", new FacilityDTO());
        model.addAttribute("listRentType", facilityRentTypeService.findAll(pageable));
        model.addAttribute("listFacilityType", facilityTypeService.findAll(pageable));
        return "facility/create";
    }

    @PostMapping("/createFacility")
    public String createFacility(@Validated @ModelAttribute("facilityDTO") FacilityDTO facilityDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model,
                                 Pageable pageable) {
        Facility facility = new Facility();
        facilityDTO.validate(facilityDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listRentType", facilityRentTypeService.findAll(pageable));
            model.addAttribute("listFacilityType", facilityTypeService.findAll(pageable));
            return "facility/create";
        }
        BeanUtils.copyProperties(facilityDTO, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(@PathVariable("id") int id, Model model, Pageable pageable) {
        Facility facility = facilityService.findById(id).get();
        FacilityDTO facilityDTO = new FacilityDTO();
        BeanUtils.copyProperties(facility, facilityDTO);
        model.addAttribute("facilityDTO", facilityDTO);
        model.addAttribute("listRentType", facilityRentTypeService.findAll(pageable));
        model.addAttribute("listFacilityType", facilityTypeService.findAll(pageable));
        return "facility/update";
    }

    @PostMapping("/updateFacility")
    public String updateFacility(@Validated @ModelAttribute("facilityDTO") FacilityDTO facilityDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model,
                                 Pageable pageable) {
        facilityDTO.validate(facilityDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityDTO", facilityDTO);
            model.addAttribute("listRentType", facilityRentTypeService.findAll(pageable));
            model.addAttribute("listFacilityType", facilityTypeService.findAll(pageable));
            return "facility/update";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/facility/list";
    }

    @PostMapping("/removeFacility")
    public String removeFacility(@RequestParam("idRemove") int id, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id).get();
        facility.setFlag(true);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công dịch vụ " + facility.getName());
        return "redirect:/facility/list";
    }
}
