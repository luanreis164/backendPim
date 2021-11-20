package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;
import com.hotelUnip.pim.domain.enums.Perfil;
import com.hotelUnip.pim.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ManutencaoRepository manutencaoRepository;


    public void instantiateTestDatabase() throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Cliente cli1 = new Cliente(null, "Fulano","luanreis2202@gmail.com", passwordEncoder.encode("123"), "78588738066","Rua Anchieta","Vila Mirim", "5217", "11332330",
                "Praia Grande", "São Paulo", "13996735588", "556481550",sdf.parse("22/02/1999 18:35"));

        Cliente cli2 = new Cliente(null, "Ciclano","exemplo@gmail.com", passwordEncoder.encode("1234"), "59795386077", "Rua Josefina Bakhita","Vila Sonia", "527", "11722330",
                "Praia Grande", "São Paulo", "13996735588", "556481550",sdf.parse("22/02/1999 13:30"));


        clienteRepository.saveAll(Arrays.asList(cli1,cli2));


        Categoria cat1 = new Categoria(null,"Suite Royal 01",205.00,"Quarto com 2 camas e sacada");
        Categoria cat2 = new Categoria(null,"Suite Royal Deluxe 01",260.00,"Quarto com a Tigreza VIP");

        Quarto quarto1 = new Quarto(null,11,1,cat1);
        Quarto quarto2 = new Quarto(null,12,1,cat2);

        quarto1.setCategoria(cat1);
        quarto2.setCategoria(cat2);

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        quartoRepository.saveAll(Arrays.asList(quarto1,quarto2));

        Reserva reserva1 = new Reserva(null,sdf.parse("25/11/2021 11:37"),sdf.parse("22/12/2021 19:30"),35,cli1,quarto1);
        Reserva reserva2 = new Reserva(null,sdf.parse("25/11/2021 21:44"),sdf.parse("22/12/2021 14:40"),35,cli2,quarto2);
        Reserva reserva3 = new Reserva(null,sdf.parse("25/11/2021 22:44"),sdf.parse("22/12/2021 14:40"),35,cli2,quarto1);


        reservaRepository.saveAll(Arrays.asList(reserva1,reserva2,reserva3));

        Funcionario funcionario1 = new Funcionario(null,"Ednaldo Pereira","ed@gmail.com", passwordEncoder.encode("123456"), "21177857006","Rua Campos Gemeos","Ponta da Praia","131",
                "11722330","Santos","São Paulo","13981313431","5564488877",sdf.parse("08/09/1999 13:30"),"487D87A",
                "655778-8",sdf.parse("22/04/2021 19:30"),"Atendente",1.7500);

        funcionarioRepository.saveAll(Arrays.asList(funcionario1));

        Gerente gerente1 = new Gerente(null,"Ricardo Milos","ricardomilos@gmail.com", passwordEncoder.encode("123"), "19830592006","Josefina Bakhita","vila Sonia","527",
                "11722330","Praia Grande","São Paulo","13981313431","5564488877",sdf.parse("08/09/1999 09:48"),"99F77841",
                "6466774-8",sdf.parse("22/08/2019 19:30"),"Gerente",2.7500,350.00);

        gerenteRepository.saveAll(Arrays.asList(gerente1));

        Hospedagem hospedagem1 = new Hospedagem(null,sdf.parse("21/10/2021 12:45"),sdf.parse("22/10/2021 18:45"),1.750,funcionario1,reserva1,quarto1);
        funcionario1.setHospedagens(Arrays.asList(hospedagem1));
        reserva1.setHospedagem(hospedagem1);


        hospedagemRepository.saveAll(Arrays.asList(hospedagem1));

        Pagamento pgto1 = new PagamentoComCartao(reserva1.getId(), EstadoPagamento.PENDENTE,reserva1,3);
        reserva1.setPagamento(pgto1);

        pagamentoRepository.saveAll(Arrays.asList(pgto1));


        Manutencao manutencao1 = new Manutencao(null,"Ajuste no Teto do Quarto 501",sdf.parse("21/11/2021 12:11)"),sdf.parse("22/11/2021 14:44"),1.900);

        manutencaoRepository.save(manutencao1);

    }
}
