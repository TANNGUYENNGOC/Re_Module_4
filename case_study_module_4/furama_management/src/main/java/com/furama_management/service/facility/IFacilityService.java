package com.furama_management.service.facility;

import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;
import com.furama_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IFacilityService extends IGeneralService<Facility> {
    Page<FacilityDTO1> listFacility(Pageable pageable,String nameFacility, String facilityType);
    List<FacilityDTO1> listFacility();
    List<Facility> findAll();
    Page<FacilityDTO1> searchName(String nameFacility,Pageable pageable);
    Page<FacilityDTO1> searchFacilityType(String facilityType,Pageable pageable);

}
