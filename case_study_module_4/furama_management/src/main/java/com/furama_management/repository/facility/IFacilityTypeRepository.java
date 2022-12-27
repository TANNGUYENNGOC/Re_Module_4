package com.furama_management.repository.facility;

import com.furama_management.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
    List<FacilityType> findAll();
}
