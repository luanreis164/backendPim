package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

     void sendNewPasswordEmail(Cliente cliente, String newPass);

}
