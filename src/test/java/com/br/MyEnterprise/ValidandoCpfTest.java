package com.br.MyEnterprise;

import com.br.MyEnterprise.domain.cliente.ClienteModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidandoCpfTest {
    @Test
    void ValidandoCpfDeveriaSerTrueParaUmCpfValido(){
        ClienteModel joaozinho = new ClienteModel();
        boolean verificaCpfValido = joaozinho.validaCpf("444.727.188-55");

        assertEquals(true, verificaCpfValido);
    }

    @Test
    void ValidandoCpfDeveriaApontarTipoDeErroParaUmCpfInvalido(){
        ClienteModel joaozinho = new ClienteModel();
        boolean verificaCpfValido = joaozinho.validaCpf("441.111.111-11");

        assertEquals(true, verificaCpfValido);
    }
}