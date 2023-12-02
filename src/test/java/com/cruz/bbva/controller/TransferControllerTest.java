package com.cruz.bbva.controller;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.controler.TransferControler;
import com.cruz.bbva.service.TransferService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TransferControllerTest {

    @Mock
    private TransferService transferService;
    @InjectMocks
    private TransferControler transferControler;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
//test 1
    @Test
    void testGetAllTrans() {

        TransferDTO transfer1 = new TransferDTO();

        transfer1.setOriginAccountNumber("1111574125478456");
        transfer1.setDestinationAccountNumber("0000574125478456");
        transfer1.setAmount(new BigDecimal(1800.25));
        transfer1.setCurrency("USD");
        transfer1.setDate(LocalDateTime.parse("2023-11-28T12:30:45"));
        transfer1.setStateTransfer("Pendiente");

        TransferDTO transfer2 = new TransferDTO();

        transfer2.setOriginAccountNumber("1111574125478456");
        transfer2.setDestinationAccountNumber("0000574125478456");
        transfer2.setAmount(new BigDecimal(1800.25));
        transfer2.setCurrency("USD");
        transfer2.setDate(LocalDateTime.parse("2023-11-28T12:30:45"));
        transfer2.setStateTransfer("Pendiente");

        List<TransferDTO> expectedTransfers = Arrays.asList(transfer1, transfer2);

        when(transferService.getAllTransferences()).thenReturn(expectedTransfers);

        List<TransferDTO> result = transferControler.getAllTran();

        assertEquals(expectedTransfers, result);
    }

    @Test
    void testGetTransByIdSuccess() {

        Long id = 1L;
        TransferDTO expectedTransfer = new TransferDTO();
        when(transferService.getTransferencesById(id)).thenReturn(expectedTransfer);

        ResponseEntity<TransferDTO> responseEntity = transferControler.getById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTransfer, responseEntity.getBody());
    }


    @Test
    void testGetTransByIdNotFound() {
        Long id = 1L;
        when(transferService.getTransferencesById(id)).thenThrow(new EntityNotFoundException("Transfer not found"));

        assertThrows(EntityNotFoundException.class, () -> transferControler.getById(id));
    }


    @Test
    void testSaveOrUpdateTransference() {

        TransferDTO transferDTO = new TransferDTO();

        transferControler.saveUpdate(transferDTO);

        verify(transferService, times(1)).saveOrUpdateTransference((transferDTO));
    }


    @Test
    void testDeleteTransference() {

        Long id = 1L;

        transferControler.saveUpdate(id);

        verify(transferService, times(1)).deleteTransference((id));
    }
}
