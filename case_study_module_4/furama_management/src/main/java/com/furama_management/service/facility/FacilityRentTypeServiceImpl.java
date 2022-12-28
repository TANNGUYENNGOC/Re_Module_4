package com.furama_management.service.facility;

import com.furama_management.model.facility.RentType;
import com.furama_management.repository.facility.IFacilityRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FacilityRentTypeServiceImpl implements IFacilityRentTypeService{
    @Autowired
    IFacilityRentTypeRepository facilityRentTypeRepository;
    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return facilityRentTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RentType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(int id) {

    }
}
