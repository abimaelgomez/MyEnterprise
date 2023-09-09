package com.br.MyEnterprise.repositories;

import com.br.MyEnterprise.domain.empresa.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, UUID> {
}
