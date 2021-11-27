package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Cliente;
import com.hotelUnip.pim.domain.Gerente;
import com.hotelUnip.pim.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;
import java.util.Optional;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private GerenteRepository gerenteRepository;

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(cliente,newPass);
        sendEmail(sm);
    }

    @Override
    public void sendFileEmail(Integer id, String msg) {
        SimpleMailMessage sm = prepareFileEmail(id,msg);
        sendEmail(sm);
    }

    protected  SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha:" + newPass);
        return sm;
    }

    protected  SimpleMailMessage prepareFileEmail(Integer id, String msg){


        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo();
        sm.setFrom(sender);
        sm.setSubject("Relatório");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Arquivo:" + msg);
        return sm;
    }

}
