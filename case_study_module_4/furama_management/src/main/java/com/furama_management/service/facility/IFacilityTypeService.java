package com.furama_management.service.facility;

import com.furama_management.model.facility.FacilityType;
import com.furama_management.service.IGeneralService;

import java.util.List;

public interface IFacilityTypeService extends IGeneralService<FacilityType> {
    List<FacilityType> findAll();
}
