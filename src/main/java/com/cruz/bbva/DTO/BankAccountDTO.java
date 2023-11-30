package com.cruz.bbva.DTO;

import com.cruz.bbva.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BankAccountDTO {

    private Long idBankAccount;
    private String accountNumber;
    private Customer customer;
    private BigDecimal balance;
    private String accountType;
    private String currency;
    private LocalDateTime openingDateAccount;
    private String stateAccount;
    private String bankingEntity;
    private Integer associatedCards;
}
