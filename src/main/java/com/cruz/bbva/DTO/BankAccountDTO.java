package com.cruz.bbva.DTO;

import com.cruz.bbva.entity.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccountDTO {

    private Long idBankAccount;

    private String accountNumber;
    private Customer customer;
    private BigDecimal balance; // saldo
    private String accountType; // Ahorro o Corriente
    private String currency;
    private LocalDateTime openingDateAccount;
    private String stateAccount;
    private String bankingEntity;
    private Integer associatedCards;
}
