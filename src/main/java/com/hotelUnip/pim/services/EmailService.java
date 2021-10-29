package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

     void sendNewPasswordEmail(Cliente cliente, String newPass);

}
