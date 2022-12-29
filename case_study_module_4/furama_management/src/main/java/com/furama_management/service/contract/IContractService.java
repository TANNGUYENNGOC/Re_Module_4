package com.furama_management.service.contract;

import com.furama_management.dto.contract.ContractDTO1;
import com.furama_management.model.contract.Contract;
import com.furama_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {
    Page<ContractDTO1> listContract(Pageable pageable);
}
