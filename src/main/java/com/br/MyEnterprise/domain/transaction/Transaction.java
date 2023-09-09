package com.br.MyEnterprise.domain.transaction;

import com.br.MyEnterprise.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @JoinColumn(name = "sender_id")
    @ManyToOne
    private User sender;
    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private User receiver;
    private LocalDateTime timestamp;
}
