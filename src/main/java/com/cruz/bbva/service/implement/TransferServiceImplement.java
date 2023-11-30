package com.cruz.bbva.service.implement;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import com.cruz.bbva.mapper.TransferMapper;
import com.cruz.bbva.repository.TransferRepository;
import com.cruz.bbva.service.TransferService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImplement implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    TransferMapper transferMapper;


    @Override
    public List<TransferDTO> getAllTransferences() {
        List<Transfer> transfers = transferRepository.findAll();
        return transfers.stream()
                .map(transferMapper::transferToTransferDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransferDTO getTransferencesById(Long idTransac) {
        Transfer transfer = transferRepository.findById(idTransac)
                .orElseThrow(() -> new EntityNotFoundException("Transference not found by id: " + idTransac));
        return transferMapper.transferToTransferDTO(transfer);
    }

    @Override
    public void saveOrUpdateTransference(TransferDTO transferDTO) {
        Transfer transfer = transferMapper.TransferDTOTotransfer(transferDTO);
        transferRepository.save(transfer);
    }

    @Override
    public void deleteTransference(Long idTransfer) {
        transferRepository.deleteById(idTransfer);
    }
}
