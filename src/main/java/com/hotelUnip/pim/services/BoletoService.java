package com.hotelUnip.pim.services;

import com.hotelUnip.pim.dto.PagamentoComBoletoDTO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoletoDTO pagto, Date instanteDoPagamento){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPagamento);
        cal.add(Calendar.DAY_OF_MONTH,7);
        pagto.setDataVencimento(cal.getTime());
    }





}
