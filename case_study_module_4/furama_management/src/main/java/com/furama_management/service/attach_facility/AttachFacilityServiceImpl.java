package com.furama_management.service.attach_facility;

import com.furama_management.model.contract.AttachFacility;
import com.furama_management.repository.attach_facility.IAttachFacilityReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService{
    @Autowired
    IAttachFacilityReposotory attachFacilityReposotory;
    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<AttachFacility> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityReposotory.findAll();
    }
}
