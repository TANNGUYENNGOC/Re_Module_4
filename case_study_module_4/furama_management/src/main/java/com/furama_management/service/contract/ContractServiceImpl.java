package com.furama_management.service.contract;

import com.furama_management.dto.contract.ContractDTO1;
import com.furama_management.model.contract.Contract;
import com.furama_management.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractServiceImpl implements IContractService{
    @Autowired
    IContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Contract> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Page<ContractDTO1> listContract(Pageable pageable) {
        return contractRepository.listContract(pageable);
    }
}
