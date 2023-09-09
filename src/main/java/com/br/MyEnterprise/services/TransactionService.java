package com.br.MyEnterprise.services;

import com.br.MyEnterprise.domain.transaction.Transaction;
import com.br.MyEnterprise.domain.user.User;
import com.br.MyEnterprise.dtos.TransactionDTO;
import com.br.MyEnterprise.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransacoesRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receptorId());

        userService.validateTransaction(sender, transaction.value());

        Boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());
        if (!isAuthorized){
          throw new Exception("Transação não Autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(newTransaction.getAmount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(sender.getBalance().add(transaction.value()));

        repository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

        this.notificationService.sendNotification(sender,"Transação Realizada com sucesso");
        this.notificationService.sendNotification(receiver,"Transação Recebida com sucesso");

        return newTransaction;

    }

    public boolean authorizeTransaction(User user, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity
                ("https://webhook.site/6e9b3c3a-3bb0-4601-9793-ef9f132639d7", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else
            return false;
    }

}
