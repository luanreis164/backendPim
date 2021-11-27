package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import org.springframework.mail.SimpleMailMessage;

import java.util.Optional;


public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

     void sendNewPasswordEmail(Cliente cliente, String newPass);

     void sendFileEmail(Integer id, String msg);


}
