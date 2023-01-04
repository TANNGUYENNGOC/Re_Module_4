package com.furama_management.service.contract;

import com.furama_management.dto.attach_facility.IAttachFacilityDTO;
import com.furama_management.dto.contract.ContractDTO1;
import com.furama_management.model.contract.Contract;
import com.furama_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    Page<ContractDTO1> listContract(Pageable pageable);
    List<IAttachFacilityDTO> listAttachFacility(int id);

}
