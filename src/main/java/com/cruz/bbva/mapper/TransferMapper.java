package com.cruz.bbva.mapper;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TransferMapper {

    @Mapping(target = "idTransfer", source = "transfer.idTransfer")
    TransferDTO transferToTransferDTO(Transfer transfer);

    Transfer TransferDTOTotransfer(TransferDTO transferDTO);
}
