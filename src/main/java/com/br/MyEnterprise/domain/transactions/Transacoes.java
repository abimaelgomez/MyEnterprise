package com.br.MyEnterprise.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "TB_TRANSACOES")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    @JoinColumn(name="emissor_id")
    @ManyToOne
    private User emissor;
    @JoinColumn(name="remetente_id")
    @ManyToOne
    private User remetente;
    private LocalDateTime timestamp;



}
