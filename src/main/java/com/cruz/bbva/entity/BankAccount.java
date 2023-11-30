package com.cruz.bbva.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_bankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_BankAccount")
    private Long idBankAccount;

    @Column(unique = true,nullable = false)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    private BigDecimal balance;
    private String accountType;
    private String currency;
    private LocalDateTime openingDateAccount;
    private String stateAccount;
    private String bankingEntity;
    private Integer associatedCards;
}
