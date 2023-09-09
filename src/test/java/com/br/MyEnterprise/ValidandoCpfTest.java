package com.br.MyEnterprise;

import com.br.MyEnterprise.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidandoCpfTest {
    @Test
    void ValidandoCpfDeveriaSerTrueParaUmCpfValido(){
        User joaozinho = new User();
        boolean verificaCpfValido = joaozinho.validaCpf("444.727.188-55");

        assertEquals(true, verificaCpfValido);
    }

    @Test
    void ValidandoCpfDeveriaApontarTipoDeErroParaUmCpfInvalido(){
        User joaozinho = new User();
        boolean verificaCpfValido = joaozinho.validaCpf("441.111.111-11");

        assertEquals(true, verificaCpfValido);
    }
}