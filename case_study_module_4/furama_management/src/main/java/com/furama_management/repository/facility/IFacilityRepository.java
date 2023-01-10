package com.furama_management.repository.facility;

import com.furama_management.dto.facility.FacilityDTO1;
import com.furama_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and facility.name like concat('%',:nameFacility,'%') and ft.name like concat('%',:facilityType,'%')"
            , countQuery = "select * from (select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and facility.name like concat('%',:nameFacility,'%') and ft.name like concat('%',:facilityType,'%'))facility"
            , nativeQuery = true)
    Page<FacilityDTO1> listFacility(Pageable pageable, @Param("nameFacility") String nameFacility, @Param("facilityType") String facilityType);

    @Query(value = "select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0"
            , countQuery = "select * from (select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0)facility"
            , nativeQuery = true)
    List<FacilityDTO1> listFacility();

    List<Facility> findAll();

    @Query(value = "select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and facility.name like concat('%',:nameFacility,'%')"
            , countQuery = "select * from (select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and facility.name like concat('%',:nameFacility,'%'))abc"
            ,nativeQuery = true)
    Page<FacilityDTO1> searchName(@Param("nameFacility") String nameFacility,Pageable pageable);

    @Query(value = "select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and ft.name = :facilityType"
            , countQuery = "select * from (select facility.id,facility.name as name,facility.area,facility.cost,facility.max_people as maxPeople,rt.name as rentType,ft.name as facilityType,facility.standard_room as standardRoom,facility.description_other_convenience as descriptionOtherConvenience,facility.pool_area as poolArea,facility.number_of_floors as numberOfFloors,facility.facility_free as facilityFree from facility join facility_type ft on facility.facility_type_id = ft.id join  rent_type rt on facility.rent_type_id = rt.id where facility.flag=0 and ft.name = :facilityType)abc"
            ,nativeQuery = true)
    Page<FacilityDTO1> searchFacilityType(@Param("facilityType")String facilityType,Pageable pageable);
}
