package com.furama_management.service.facility;

import com.furama_management.model.facility.FacilityType;
import com.furama_management.repository.facility.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityTypeServiceServiceImpl implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public Page<FacilityType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<FacilityType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(FacilityType facilityType) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
