package com.furama_management.service.contract_detail;

import com.furama_management.model.contract.ContractDetail;
import com.furama_management.repository.contract_detail.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractDetailServiceImpl implements IContractDetailService{
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int id) {

    }
}
