package com.br.MyEnterprise.repositories;

import com.br.MyEnterprise.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transaction, Long> {
}
