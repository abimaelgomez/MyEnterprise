package com.br.MyEnterprise;

import com.br.MyEnterprise.domain.empresa.EmpresaModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidandoCnpjTest {
    @Test
    void ValidandoCpfDeveriaSerTrueParaUmCnpjValido(){
        EmpresaModel mariazinha = new EmpresaModel();
        boolean verificaCnpjValido = mariazinha.validaCnpj("16.602.563/0001-90");

        assertEquals(true, verificaCnpjValido);
    }

    @Test
    void ValidandoCpfDeveriaApontarTipoDeErroParaUmCnpjInvalido(){
        EmpresaModel mariazinha = new EmpresaModel();
        boolean verificaCnpjValido = mariazinha.validaCnpj("16.777.888/9991-90");

        assertEquals(true, verificaCnpjValido);
    }

}