package com.furama_management.service.attach_facility;

import com.furama_management.model.contract.AttachFacility;
import com.furama_management.service.IGeneralService;

import java.util.List;

public interface IAttachFacilityService extends IGeneralService<AttachFacility> {
    List<AttachFacility> findAll();
}
