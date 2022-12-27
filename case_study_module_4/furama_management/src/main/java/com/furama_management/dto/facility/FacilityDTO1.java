package com.furama_management.dto.facility;

import com.furama_management.model.facility.FacilityType;
import com.furama_management.model.facility.RentType;

public interface FacilityDTO1 {

    int getId();

    String getName();

    int getArea();

    double getCost();

    int getMaxPeople();

    String getRentType();

    String getFacilityType();

    String getStandardRoom();

    String getDescriptionOtherConvenience();

    double getPoolArea();

    int getNumberOfFloors();

    String getFacilityFree();

    boolean isFlag();
}
