package com.cruz.bbva.controler;


import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.entity.Transfer;
import com.cruz.bbva.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transac")
public class TransferControler {

    @Autowired//permite enlazar con mis servicios de TransferService
    private TransferService transferService;

    @Operation(
            summary = "Fetch all transferences",
            description = "fetches all transfer entities and their data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "cuando no le mandas el id de la transferencia")
    })

    @GetMapping// se expone el servicio
    public List<TransferDTO> getAllTran() {
        return transferService.getAllTransferences();
    }

    @GetMapping("/{id}")
    public TransferDTO getById(@PathVariable("id") Long id) {
        return transferService.getTransferencesById(id);
    }

    @PostMapping
    public void saveUpdate(@RequestBody TransferDTO transferDTO) {
        transferService.saveOrUpdateTransference(transferDTO);
    }

    @DeleteMapping("/{id}")
    public void saveUpdate(@PathVariable("id") Long id) {
        transferService.deleteTransference(id);
    }
}
