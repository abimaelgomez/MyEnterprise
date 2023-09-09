package com.br.MyEnterprise.services;

import com.br.MyEnterprise.domain.user.User;
import com.br.MyEnterprise.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);


/*        ResponseEntity<String> notificationReponse = restTemplate.postForEntity
                ("https://webhook.site/6e9b3c3a-3bb0-4601-9793-ef9f132639d7", notificationRequest, String.class);

        if(!(notificationReponse.getStatusCode() == HttpStatus.OK )){
            System.out.println("Erro ao enviar notificão");
            throw new Exception("Serviço de notificação esta fora do ar");
            }*/
        System.out.println("notificao erro 109");
    }

}
