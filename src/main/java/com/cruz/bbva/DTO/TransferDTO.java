package com.cruz.bbva.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransferDTO {

    private Long idTransfer;
    private String originAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private String currency;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
    private String stateTransfer;
}
