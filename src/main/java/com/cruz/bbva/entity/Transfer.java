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
@Table(name = "tb_transference")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfer")
    private Long idTransfer;

    private String originAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime date;
    private String stateTransfer;
}
