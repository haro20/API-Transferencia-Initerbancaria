package com.cruz.bbva.controler;

import com.cruz.bbva.DTO.TransferDTO;
import com.cruz.bbva.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transac")
public class TransferControler {

    @Autowired
    private TransferService transferService;

    @Operation(
            summary = "Fetch all transferences",
            description = "fetches all transfer entities and their data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "cuando no le mandas el id de la transferencia")
    })

    @GetMapping
    public List<TransferDTO> getAllTran() {
        return transferService.getAllTransferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferDTO> getById(@PathVariable("id") Long id){
        TransferDTO transferDTO;
        try {
             transferDTO = transferService.getTransferencesById(id);
            return  new ResponseEntity<>(transferDTO, HttpStatus.OK);
        }catch (EntityNotFoundException exe){
            return new ResponseEntity(exe.getMessage(), HttpStatus.NOT_FOUND);
        }
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
