package com.br.MyEnterprise.dtos;

import com.br.MyEnterprise.domain.user.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public record UserDTO<Usertype>(Long id,String nome, String document, String email, String password, BigDecimal balance, UserType userType) {

}
