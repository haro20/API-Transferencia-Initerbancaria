package com.cruz.bbva.service;

import com.cruz.bbva.DTO.TransferDTO;
import java.util.List;

public interface TransferService {

    List<TransferDTO> getAllTransferences();

    TransferDTO getTransferencesById(Long idTransac);

    void saveOrUpdateTransference (TransferDTO transferDTO);

    void deleteTransference(Long idTransfer);
}
