package com.cruz.bbva;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

public class TransferServiceImplementTest {
/*

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private TransferMapper transferMapper;

    @InjectMocks
    private TransferServiceImplement transferService;

    @ExtendWith(MockitoExtension.class)
    void getAllTransferences() {
        // Given
        Transfer transfer1 = new Transfer();
        Transfer transfer2 = new Transfer();
        List<Transfer> transfers = Arrays.asList(transfer1, transfer2);

        TransferDTO transferDTO1 = new TransferDTO();
        TransferDTO transferDTO2 = new TransferDTO();
        List<TransferDTO> transferDTOs = Arrays.asList(transferDTO1, transferDTO2);*/

        /*when(transferRepository.findAll()).thenReturn(transfers);
        when(transferMapper.transferToTransferDTO(any(Transfer.class))).thenReturn(transferDTO1, transferDTO2);

        // When
        List<TransferDTO> result = transferService.getAllTransferences();

        // Then
        assertEquals(2, result.size());
        verify(transferRepository, times(1)).findAll();
        verify(transferMapper, times(2)).transferToTransferDTO(any(Transfer.class));
    }*/
}
