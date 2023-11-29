package com.cruz.bbva.mapper;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    TransferDTO transferToTransferDTO(Transfer transfer);
    Transfer TransferDTOTotransfer(TransferDTO transferDTO);
}
