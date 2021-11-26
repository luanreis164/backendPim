package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

     void sendNewPasswordEmail(Cliente cliente, String newPass);

     void sendFileEmail(Gerente gerente, String file);


}
