package com.furama_management.service.facility;

import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;
import com.furama_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IFacilityService extends IGeneralService<Facility> {
    Page<FacilityDTO1> listFacility(Pageable pageable,String nameFacility, String facilityType);

}
