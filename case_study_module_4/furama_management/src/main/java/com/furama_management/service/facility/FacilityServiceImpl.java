package com.furama_management.service.facility;

import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;
import com.furama_management.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Page<FacilityDTO1> listFacility(Pageable pageable, String nameFacility, String facilityType) {
        return facilityRepository.listFacility(pageable, nameFacility, facilityType);
    }

    @Override
    public List<FacilityDTO1> listFacility() {
        return facilityRepository.listFacility();
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<FacilityDTO1> searchName(String nameFacility, Pageable pageable) {
        return facilityRepository.searchName(nameFacility,pageable);
    }

    @Override
    public Page<FacilityDTO1> searchFacilityType(String facilityType, Pageable pageable) {
        return facilityRepository.searchFacilityType(facilityType,pageable);
    }
}
