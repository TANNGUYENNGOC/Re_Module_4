package com.furama_management.repository.attach_facility;


import com.furama_management.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachFacilityReposotory extends JpaRepository<AttachFacility,Integer> {
    List<AttachFacility> findAll();
}
