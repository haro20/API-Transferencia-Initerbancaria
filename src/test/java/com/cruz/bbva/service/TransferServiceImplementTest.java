package com.cruz.bbva.service;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import com.cruz.bbva.mapper.TransferMapper;
import com.cruz.bbva.repository.TransferRepository;
import com.cruz.bbva.service.implement.TransferServiceImplement;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransferServiceImplementTest {

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private TransferMapper transferMapper;

    @InjectMocks
    private TransferServiceImplement transferServiceImplement;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    //Prueba 1
    @Test
    void getAllTransferences(){
        // Given
        Transfer transfer = new Transfer();
        TransferDTO transferDTO = new TransferDTO();
        when(transferRepository.findAll()).thenReturn(Collections.singletonList(transfer));
        when(transferMapper.transferToTransferDTO(any(Transfer.class))).thenReturn(transferDTO);

        // When
        List<TransferDTO> result = transferServiceImplement.getAllTransferences();

        // Then
        assertEquals(1, result.size());
        verify(transferRepository, times(1)).findAll();
        verify(transferMapper, times(1)).transferToTransferDTO(any(Transfer.class));
    }


    //Prueba 2
    @Test
    void getTransferencesById() {
        // Given
        Long id = 1L;
        Transfer transfer = new Transfer();
        TransferDTO transferDTO = new TransferDTO();
        when(transferRepository.findById(id)).thenReturn(Optional.of(transfer));
        when(transferMapper.transferToTransferDTO(transfer)).thenReturn(transferDTO);

        // When
        TransferDTO result = transferServiceImplement.getTransferencesById(id);

        // Then
        assertEquals(transferDTO, result);
        verify(transferRepository, times(1)).findById(id);
        verify(transferMapper, times(1)).transferToTransferDTO(transfer);
    }


    //prueba 3
    @Test
    void getTransferencesById_ThrowsEntityNotFoundException() {
        // Given
        Long id = 1L;
        when(transferRepository.findById(id)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> transferServiceImplement.getTransferencesById(id));
        verify(transferRepository, times(1)).findById(id);
    }


    //prueba 4
    @Test
    void saveOrUpdateTransference() {
        // Given
        TransferDTO transferDTO = new TransferDTO();
        Transfer transfer = new Transfer();
        when(transferMapper.TransferDTOTotransfer(transferDTO)).thenReturn(transfer);

        // When
        transferServiceImplement.saveOrUpdateTransference(transferDTO);

        // Then
        verify(transferMapper, times(1)).TransferDTOTotransfer(transferDTO);
        verify(transferRepository, times(1)).save(transfer);
    }


    //Prueba 5
    @Test
    void deleteTransference() {
        // Given
        Long id = 1L;
        // When
        transferServiceImplement.deleteTransference(id);
        // Then
        verify(transferRepository, times(1)).deleteById(id);
    }
}
