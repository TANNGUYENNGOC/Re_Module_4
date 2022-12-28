package com.furama_management.repository.facility;

import com.furama_management.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRentTypeRepository extends JpaRepository<RentType,Integer> {
}
