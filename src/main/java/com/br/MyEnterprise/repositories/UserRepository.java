package com.br.MyEnterprise.repositories;


import com.br.MyEnterprise.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findUserByDocument(String Document);
    Optional<com.br.MyEnterprise.domain.user.User> findUserById(Long id);

}