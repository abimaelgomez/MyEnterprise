package com.br.MyEnterprise.domain.empresa;


import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TB_EMPRESAS")
public class EmpresaModel implements Serializable {
    private UUID idEmpresa;
    private String nome;
    private String cnpj;
    private BigDecimal saldo;

    public boolean validaCnpj(String cnpj) {

        CNPJValidator cnpjValidator = new CNPJValidator();
        List<ValidationMessage> erros = cnpjValidator.invalidMessagesFor(cnpj);
        if (erros.size() > 0) {
            System.out.println(erros);
            return false;
        } else {
            return true;
        }
    }


}

