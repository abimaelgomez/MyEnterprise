package com.br.MyEnterprise.repositories;

import com.br.MyEnterprise.domain.transactions.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
