package com.cruz.bbva.DTO;

import com.cruz.bbva.entity.BankAccount;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
public class CustomerDTO {

    private Long idCustomer;

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String civilState;
    private List<BankAccount> bankAccounts;
}
