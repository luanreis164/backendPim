create table categoria (
       id  serial not null,
        image_url varchar(255),
        nome varchar(255),
        preco_diaria float8,
        primary key (id)
    )

    
    create table hospedagem (
       id  serial not null,
        checkin timestamp,
        checkout timestamp,
        valor float8,
        funcionario_id int4,
        quarto_id int4,
        reserva_id int4,
        primary key (id)
    )

    
    create table pagamento (
       dtype varchar(31) not null,
        reserva_id int4 not null,
        estado int4,
        data_pagamento timestamp,
        data_vencimento timestamp,
        numero_de_parcelas int4,
        primary key (reserva_id)
    )

    
    create table perfis (
       pessoa_id int4 not null,
        perfis int4
    )

    
    create table pessoa (
       dtype varchar(31) not null,
        id  serial not null,
        bairro varchar(255),
        cep varchar(255),
        cidade varchar(255),
        cpf varchar(255),
        data_nasc timestamp,
        email varchar(255),
        estado varchar(255),
        nome varchar(255),
        numero varchar(255),
        rg varchar(255),
        rua varchar(255),
        senha varchar(255),
        telefone varchar(255),
        cargo varchar(255),
        ctps varchar(255),
        data_admissao timestamp,
        matricula varchar(255),
        salario float8,
        bonificacao float8,
        primary key (id)
    )

    
    create table quarto (
       id  serial not null,
        andar int4,
        disponibilidade_diaria boolean not null,
        numero int4,
        categoria_id int4,
        primary key (id)
    )

    
    create table reserva (
       id  serial not null,
        data_chegada timestamp,
        data_reserva timestamp,
        tempo_estadia int4,
        valor float8 not null,
        cliente_id int4,
        hospedagem_id int4,
        quarto_id int4,
        primary key (id)
    )

    
    alter table pessoa 
       add constraint UK_nlwiu48rutiltbnjle59krljo unique (cpf)

    
    alter table pessoa 
       add constraint UK_mc87q8fpvldpdyfo9o5633o5l unique (email)

    
    alter table hospedagem 
       add constraint FK4reuno983puantin3n2jyv502 
       foreign key (funcionario_id) 
       references pessoa

    
    alter table hospedagem 
       add constraint FKid8isdt4sno9cxp7bafyt0imu 
       foreign key (quarto_id) 
       references quarto

    
    alter table hospedagem 
       add constraint FKkldpxp6h3yt7yuvw0boweetl 
       foreign key (reserva_id) 
       references reserva

    
    alter table pagamento 
       add constraint FK1solgom1n0mmdkesa8k4y3d8r 
       foreign key (reserva_id) 
       references reserva

    
    alter table perfis 
       add constraint FKlnesgnyiynjyqx8ks8cyhv6il 
       foreign key (pessoa_id) 
       references pessoa

    
    alter table quarto 
       add constraint FKo3wyrs6gfgy76ake7vyesomju 
       foreign key (categoria_id) 
       references categoria

    
    alter table reserva 
       add constraint FKgipueqcywuo5jet4qj5bgtd5k 
       foreign key (cliente_id) 
       references pessoa

    
    alter table reserva 
       add constraint FKn3aymvpqwl44nqr9mosu0p4hq 
       foreign key (hospedagem_id) 
       references hospedagem

    
    alter table reserva 
       add constraint FKll90wdpmqcpwh6car9093ehxy 
       foreign key (quarto_id) 
       references quarto
2021-11-11 14:10:18.220  INFO 4776 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-11-11 14:10:18.236  INFO 4776 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-11-11 14:10:19.856  WARN 4776 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning

    insert 
    into
        pessoa
        (bairro, cep, cidade, cpf, data_nasc, email, estado, nome, numero, rg, rua, senha, telefone, dtype) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Cliente')

    insert 
    into
        pessoa
        (bairro, cep, cidade, cpf, data_nasc, email, estado, nome, numero, rg, rua, senha, telefone, dtype) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Cliente')

    insert 
    into
        perfis
        (pessoa_id, perfis) 
    values
        (?, ?)

    insert 
    into
        perfis
        (pessoa_id, perfis) 
    values
        (?, ?)

    insert 
    into
        categoria
        (image_url, nome, preco_diaria) 
    values
        (?, ?, ?)

    insert 
    into
        categoria
        (image_url, nome, preco_diaria) 
    values
        (?, ?, ?)

    insert 
    into
        quarto
        (andar, categoria_id, disponibilidade_diaria, numero) 
    values
        (?, ?, ?, ?)

    insert 
    into
        quarto
        (andar, categoria_id, disponibilidade_diaria, numero) 
    values
        (?, ?, ?, ?)

    insert 
    into
        reserva
        (cliente_id, data_chegada, data_reserva, hospedagem_id, quarto_id, tempo_estadia, valor) 
    values
        (?, ?, ?, ?, ?, ?, ?)

    insert 
    into
        reserva
        (cliente_id, data_chegada, data_reserva, hospedagem_id, quarto_id, tempo_estadia, valor) 
    values
        (?, ?, ?, ?, ?, ?, ?)

    insert 
    into
        reserva
        (cliente_id, data_chegada, data_reserva, hospedagem_id, quarto_id, tempo_estadia, valor) 
    values
        (?, ?, ?, ?, ?, ?, ?)

    insert 
    into
        pessoa
        (bairro, cep, cidade, cpf, data_nasc, email, estado, nome, numero, rg, rua, senha, telefone, cargo, ctps, data_admissao, matricula, salario, dtype) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Funcionario')

    insert 
    into
        perfis
        (pessoa_id, perfis) 
    values
        (?, ?)

    insert 
    into
        pessoa
        (bairro, cep, cidade, cpf, data_nasc, email, estado, nome, numero, rg, rua, senha, telefone, cargo, ctps, data_admissao, matricula, salario, bonificacao, dtype) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Gerente')

    insert 
    into
        perfis
        (pessoa_id, perfis) 
    values
        (?, ?)

    insert 
    into
        perfis
        (pessoa_id, perfis) 
    values
        (?, ?)

    insert 
    into
        hospedagem
        (checkin, checkout, funcionario_id, quarto_id, reserva_id, valor) 
    values
        (?, ?, ?, ?, ?, ?)

    select
        pagamentoc0_.reserva_id as reserva_2_2_0_,
        pagamentoc0_.estado as estado3_2_0_,
        pagamentoc0_.numero_de_parcelas as numero_d6_2_0_ 
    from
        pagamento pagamentoc0_ 
    where
        pagamentoc0_.reserva_id=? 
        and pagamentoc0_.dtype='PagamentoComCartao'

    select
        reserva0_.id as id1_6_5_,
        reserva0_.cliente_id as cliente_6_6_5_,
        reserva0_.data_chegada as data_che2_6_5_,
        reserva0_.data_reserva as data_res3_6_5_,
        reserva0_.hospedagem_id as hospedag7_6_5_,
        reserva0_.quarto_id as quarto_i8_6_5_,
        reserva0_.tempo_estadia as tempo_es4_6_5_,
        reserva0_.valor as valor5_6_5_,
        cliente1_.id as id2_4_0_,
        cliente1_.bairro as bairro3_4_0_,
        cliente1_.cep as cep4_4_0_,
        cliente1_.cidade as cidade5_4_0_,
        cliente1_.cpf as cpf6_4_0_,
        cliente1_.data_nasc as data_nas7_4_0_,
        cliente1_.email as email8_4_0_,
        cliente1_.estado as estado9_4_0_,
        cliente1_.nome as nome10_4_0_,
        cliente1_.numero as numero11_4_0_,
        cliente1_.rg as rg12_4_0_,
        cliente1_.rua as rua13_4_0_,
        cliente1_.senha as senha14_4_0_,
        cliente1_.telefone as telefon15_4_0_,
        hospedagem2_.id as id1_1_1_,
        hospedagem2_.checkin as checkin2_1_1_,
        hospedagem2_.checkout as checkout3_1_1_,
        hospedagem2_.funcionario_id as funciona5_1_1_,
        hospedagem2_.quarto_id as quarto_i6_1_1_,
        hospedagem2_.reserva_id as reserva_7_1_1_,
        hospedagem2_.valor as valor4_1_1_,
        quarto3_.id as id1_5_2_,
        quarto3_.andar as andar2_5_2_,
        quarto3_.categoria_id as categori5_5_2_,
        quarto3_.disponibilidade_diaria as disponib3_5_2_,
        quarto3_.numero as numero4_5_2_,
        reserva4_.id as id1_6_3_,
        reserva4_.cliente_id as cliente_6_6_3_,
        reserva4_.data_chegada as data_che2_6_3_,
        reserva4_.data_reserva as data_res3_6_3_,
        reserva4_.hospedagem_id as hospedag7_6_3_,
        reserva4_.quarto_id as quarto_i8_6_3_,
        reserva4_.tempo_estadia as tempo_es4_6_3_,
        reserva4_.valor as valor5_6_3_,
        quarto5_.id as id1_5_4_,
        quarto5_.andar as andar2_5_4_,
        quarto5_.categoria_id as categori5_5_4_,
        quarto5_.disponibilidade_diaria as disponib3_5_4_,
        quarto5_.numero as numero4_5_4_ 
    from
        reserva reserva0_ 
    left outer join
        pessoa cliente1_ 
            on reserva0_.cliente_id=cliente1_.id 
    left outer join
        hospedagem hospedagem2_ 
            on reserva0_.hospedagem_id=hospedagem2_.id 
    left outer join
        quarto quarto3_ 
            on hospedagem2_.quarto_id=quarto3_.id 
    left outer join
        reserva reserva4_ 
            on hospedagem2_.reserva_id=reserva4_.id 
    left outer join
        quarto quarto5_ 
            on reserva4_.quarto_id=quarto5_.id 
    where
        reserva0_.id=?

    select
        reserva0_.id as id1_6_8_,
        reserva0_.cliente_id as cliente_6_6_8_,
        reserva0_.data_chegada as data_che2_6_8_,
        reserva0_.data_reserva as data_res3_6_8_,
        reserva0_.hospedagem_id as hospedag7_6_8_,
        reserva0_.quarto_id as quarto_i8_6_8_,
        reserva0_.tempo_estadia as tempo_es4_6_8_,
        reserva0_.valor as valor5_6_8_,
        cliente1_.id as id2_4_0_,
        cliente1_.bairro as bairro3_4_0_,
        cliente1_.cep as cep4_4_0_,
        cliente1_.cidade as cidade5_4_0_,
        cliente1_.cpf as cpf6_4_0_,
        cliente1_.data_nasc as data_nas7_4_0_,
        cliente1_.email as email8_4_0_,
        cliente1_.estado as estado9_4_0_,
        cliente1_.nome as nome10_4_0_,
        cliente1_.numero as numero11_4_0_,
        cliente1_.rg as rg12_4_0_,
        cliente1_.rua as rua13_4_0_,
        cliente1_.senha as senha14_4_0_,
        cliente1_.telefone as telefon15_4_0_,
        perfis2_.pessoa_id as pessoa_i1_3_10_,
        perfis2_.perfis as perfis2_3_10_,
        hospedagem3_.id as id1_1_1_,
        hospedagem3_.checkin as checkin2_1_1_,
        hospedagem3_.checkout as checkout3_1_1_,
        hospedagem3_.funcionario_id as funciona5_1_1_,
        hospedagem3_.quarto_id as quarto_i6_1_1_,
        hospedagem3_.reserva_id as reserva_7_1_1_,
        hospedagem3_.valor as valor4_1_1_,
        funcionari4_.id as id2_4_2_,
        funcionari4_.bairro as bairro3_4_2_,
        funcionari4_.cep as cep4_4_2_,
        funcionari4_.cidade as cidade5_4_2_,
        funcionari4_.cpf as cpf6_4_2_,
        funcionari4_.data_nasc as data_nas7_4_2_,
        funcionari4_.email as email8_4_2_,
        funcionari4_.estado as estado9_4_2_,
        funcionari4_.nome as nome10_4_2_,
        funcionari4_.numero as numero11_4_2_,
        funcionari4_.rg as rg12_4_2_,
        funcionari4_.rua as rua13_4_2_,
        funcionari4_.senha as senha14_4_2_,
        funcionari4_.telefone as telefon15_4_2_,
        funcionari4_.cargo as cargo16_4_2_,
        funcionari4_.ctps as ctps17_4_2_,
        funcionari4_.data_admissao as data_ad18_4_2_,
        funcionari4_.matricula as matricu19_4_2_,
        funcionari4_.salario as salario20_4_2_,
        funcionari4_.bonificacao as bonific21_4_2_,
        funcionari4_.dtype as dtype1_4_2_,
        quarto5_.id as id1_5_3_,
        quarto5_.andar as andar2_5_3_,
        quarto5_.categoria_id as categori5_5_3_,
        quarto5_.disponibilidade_diaria as disponib3_5_3_,
        quarto5_.numero as numero4_5_3_,
        categoria6_.id as id1_0_4_,
        categoria6_.image_url as image_ur2_0_4_,
        categoria6_.nome as nome3_0_4_,
        categoria6_.preco_diaria as preco_di4_0_4_,
        reserva7_.id as id1_6_5_,
        reserva7_.cliente_id as cliente_6_6_5_,
        reserva7_.data_chegada as data_che2_6_5_,
        reserva7_.data_reserva as data_res3_6_5_,
        reserva7_.hospedagem_id as hospedag7_6_5_,
        reserva7_.quarto_id as quarto_i8_6_5_,
        reserva7_.tempo_estadia as tempo_es4_6_5_,
        reserva7_.valor as valor5_6_5_,
        pagamento8_.reserva_id as reserva_2_2_6_,
        pagamento8_.estado as estado3_2_6_,
        pagamento8_.data_pagamento as data_pag4_2_6_,
        pagamento8_.data_vencimento as data_ven5_2_6_,
        pagamento8_.numero_de_parcelas as numero_d6_2_6_,
        pagamento8_.dtype as dtype1_2_6_,
        reserva9_.id as id1_6_7_,
        reserva9_.cliente_id as cliente_6_6_7_,
        reserva9_.data_chegada as data_che2_6_7_,
        reserva9_.data_reserva as data_res3_6_7_,
        reserva9_.hospedagem_id as hospedag7_6_7_,
        reserva9_.quarto_id as quarto_i8_6_7_,
        reserva9_.tempo_estadia as tempo_es4_6_7_,
        reserva9_.valor as valor5_6_7_ 
    from
        reserva reserva0_ 
    left outer join
        pessoa cliente1_ 
            on reserva0_.cliente_id=cliente1_.id 
    left outer join
        perfis perfis2_ 
            on cliente1_.id=perfis2_.pessoa_id 
    left outer join
        hospedagem hospedagem3_ 
            on reserva0_.hospedagem_id=hospedagem3_.id 
    left outer join
        pessoa funcionari4_ 
            on hospedagem3_.funcionario_id=funcionari4_.id 
    left outer join
        quarto quarto5_ 
            on hospedagem3_.quarto_id=quarto5_.id 
    left outer join
        categoria categoria6_ 
            on quarto5_.categoria_id=categoria6_.id 
    left outer join
        reserva reserva7_ 
            on quarto5_.id=reserva7_.quarto_id 
    left outer join
        pagamento pagamento8_ 
            on reserva7_.id=pagamento8_.reserva_id 
    left outer join
        reserva reserva9_ 
            on hospedagem3_.reserva_id=reserva9_.id 
    where
        reserva0_.cliente_id=?

    select
        quarto0_.id as id1_5_0_,
        quarto0_.andar as andar2_5_0_,
        quarto0_.categoria_id as categori5_5_0_,
        quarto0_.disponibilidade_diaria as disponib3_5_0_,
        quarto0_.numero as numero4_5_0_ 
    from
        quarto quarto0_ 
    where
        quarto0_.id=?

    select
        categoria0_.id as id1_0_0_,
        categoria0_.image_url as image_ur2_0_0_,
        categoria0_.nome as nome3_0_0_,
        categoria0_.preco_diaria as preco_di4_0_0_ 
    from
        categoria categoria0_ 
    where
        categoria0_.id=?

    select
        reserva0_.id as id1_6_8_,
        reserva0_.cliente_id as cliente_6_6_8_,
        reserva0_.data_chegada as data_che2_6_8_,
        reserva0_.data_reserva as data_res3_6_8_,
        reserva0_.hospedagem_id as hospedag7_6_8_,
        reserva0_.quarto_id as quarto_i8_6_8_,
        reserva0_.tempo_estadia as tempo_es4_6_8_,
        reserva0_.valor as valor5_6_8_,
        cliente1_.id as id2_4_0_,
        cliente1_.bairro as bairro3_4_0_,
        cliente1_.cep as cep4_4_0_,
        cliente1_.cidade as cidade5_4_0_,
        cliente1_.cpf as cpf6_4_0_,
        cliente1_.data_nasc as data_nas7_4_0_,
        cliente1_.email as email8_4_0_,
        cliente1_.estado as estado9_4_0_,
        cliente1_.nome as nome10_4_0_,
        cliente1_.numero as numero11_4_0_,
        cliente1_.rg as rg12_4_0_,
        cliente1_.rua as rua13_4_0_,
        cliente1_.senha as senha14_4_0_,
        cliente1_.telefone as telefon15_4_0_,
        perfis2_.pessoa_id as pessoa_i1_3_10_,
        perfis2_.perfis as perfis2_3_10_,
        hospedagem3_.id as id1_1_1_,
        hospedagem3_.checkin as checkin2_1_1_,
        hospedagem3_.checkout as checkout3_1_1_,
        hospedagem3_.funcionario_id as funciona5_1_1_,
        hospedagem3_.quarto_id as quarto_i6_1_1_,
        hospedagem3_.reserva_id as reserva_7_1_1_,
        hospedagem3_.valor as valor4_1_1_,
        funcionari4_.id as id2_4_2_,
        funcionari4_.bairro as bairro3_4_2_,
        funcionari4_.cep as cep4_4_2_,
        funcionari4_.cidade as cidade5_4_2_,
        funcionari4_.cpf as cpf6_4_2_,
        funcionari4_.data_nasc as data_nas7_4_2_,
        funcionari4_.email as email8_4_2_,
        funcionari4_.estado as estado9_4_2_,
        funcionari4_.nome as nome10_4_2_,
        funcionari4_.numero as numero11_4_2_,
        funcionari4_.rg as rg12_4_2_,
        funcionari4_.rua as rua13_4_2_,
        funcionari4_.senha as senha14_4_2_,
        funcionari4_.telefone as telefon15_4_2_,
        funcionari4_.cargo as cargo16_4_2_,
        funcionari4_.ctps as ctps17_4_2_,
        funcionari4_.data_admissao as data_ad18_4_2_,
        funcionari4_.matricula as matricu19_4_2_,
        funcionari4_.salario as salario20_4_2_,
        funcionari4_.bonificacao as bonific21_4_2_,
        funcionari4_.dtype as dtype1_4_2_,
        quarto5_.id as id1_5_3_,
        quarto5_.andar as andar2_5_3_,
        quarto5_.categoria_id as categori5_5_3_,
        quarto5_.disponibilidade_diaria as disponib3_5_3_,
        quarto5_.numero as numero4_5_3_,
        categoria6_.id as id1_0_4_,
        categoria6_.image_url as image_ur2_0_4_,
        categoria6_.nome as nome3_0_4_,
        categoria6_.preco_diaria as preco_di4_0_4_,
        reserva7_.id as id1_6_5_,
        reserva7_.cliente_id as cliente_6_6_5_,
        reserva7_.data_chegada as data_che2_6_5_,
        reserva7_.data_reserva as data_res3_6_5_,
        reserva7_.hospedagem_id as hospedag7_6_5_,
        reserva7_.quarto_id as quarto_i8_6_5_,
        reserva7_.tempo_estadia as tempo_es4_6_5_,
        reserva7_.valor as valor5_6_5_,
        pagamento8_.reserva_id as reserva_2_2_6_,
        pagamento8_.estado as estado3_2_6_,
        pagamento8_.data_pagamento as data_pag4_2_6_,
        pagamento8_.data_vencimento as data_ven5_2_6_,
        pagamento8_.numero_de_parcelas as numero_d6_2_6_,
        pagamento8_.dtype as dtype1_2_6_,
        reserva9_.id as id1_6_7_,
        reserva9_.cliente_id as cliente_6_6_7_,
        reserva9_.data_chegada as data_che2_6_7_,
        reserva9_.data_reserva as data_res3_6_7_,
        reserva9_.hospedagem_id as hospedag7_6_7_,
        reserva9_.quarto_id as quarto_i8_6_7_,
        reserva9_.tempo_estadia as tempo_es4_6_7_,
        reserva9_.valor as valor5_6_7_ 
    from
        reserva reserva0_ 
    left outer join
        pessoa cliente1_ 
            on reserva0_.cliente_id=cliente1_.id 
    left outer join
        perfis perfis2_ 
            on cliente1_.id=perfis2_.pessoa_id 
    left outer join
        hospedagem hospedagem3_ 
            on reserva0_.hospedagem_id=hospedagem3_.id 
    left outer join
        pessoa funcionari4_ 
            on hospedagem3_.funcionario_id=funcionari4_.id 
    left outer join
        quarto quarto5_ 
            on hospedagem3_.quarto_id=quarto5_.id 
    left outer join
        categoria categoria6_ 
            on quarto5_.categoria_id=categoria6_.id 
    left outer join
        reserva reserva7_ 
            on quarto5_.id=reserva7_.quarto_id 
    left outer join
        pagamento pagamento8_ 
            on reserva7_.id=pagamento8_.reserva_id 
    left outer join
        reserva reserva9_ 
            on hospedagem3_.reserva_id=reserva9_.id 
    where
        reserva0_.quarto_id=?

    select
        reserva0_.id as id1_6_8_,
        reserva0_.cliente_id as cliente_6_6_8_,
        reserva0_.data_chegada as data_che2_6_8_,
        reserva0_.data_reserva as data_res3_6_8_,
        reserva0_.hospedagem_id as hospedag7_6_8_,
        reserva0_.quarto_id as quarto_i8_6_8_,
        reserva0_.tempo_estadia as tempo_es4_6_8_,
        reserva0_.valor as valor5_6_8_,
        cliente1_.id as id2_4_0_,
        cliente1_.bairro as bairro3_4_0_,
        cliente1_.cep as cep4_4_0_,
        cliente1_.cidade as cidade5_4_0_,
        cliente1_.cpf as cpf6_4_0_,
        cliente1_.data_nasc as data_nas7_4_0_,
        cliente1_.email as email8_4_0_,
        cliente1_.estado as estado9_4_0_,
        cliente1_.nome as nome10_4_0_,
        cliente1_.numero as numero11_4_0_,
        cliente1_.rg as rg12_4_0_,
        cliente1_.rua as rua13_4_0_,
        cliente1_.senha as senha14_4_0_,
        cliente1_.telefone as telefon15_4_0_,
        perfis2_.pessoa_id as pessoa_i1_3_10_,
        perfis2_.perfis as perfis2_3_10_,
        hospedagem3_.id as id1_1_1_,
        hospedagem3_.checkin as checkin2_1_1_,
        hospedagem3_.checkout as checkout3_1_1_,
        hospedagem3_.funcionario_id as funciona5_1_1_,
        hospedagem3_.quarto_id as quarto_i6_1_1_,
        hospedagem3_.reserva_id as reserva_7_1_1_,
        hospedagem3_.valor as valor4_1_1_,
        funcionari4_.id as id2_4_2_,
        funcionari4_.bairro as bairro3_4_2_,
        funcionari4_.cep as cep4_4_2_,
        funcionari4_.cidade as cidade5_4_2_,
        funcionari4_.cpf as cpf6_4_2_,
        funcionari4_.data_nasc as data_nas7_4_2_,
        funcionari4_.email as email8_4_2_,
        funcionari4_.estado as estado9_4_2_,
        funcionari4_.nome as nome10_4_2_,
        funcionari4_.numero as numero11_4_2_,
        funcionari4_.rg as rg12_4_2_,
        funcionari4_.rua as rua13_4_2_,
        funcionari4_.senha as senha14_4_2_,
        funcionari4_.telefone as telefon15_4_2_,
        funcionari4_.cargo as cargo16_4_2_,
        funcionari4_.ctps as ctps17_4_2_,
        funcionari4_.data_admissao as data_ad18_4_2_,
        funcionari4_.matricula as matricu19_4_2_,
        funcionari4_.salario as salario20_4_2_,
        funcionari4_.bonificacao as bonific21_4_2_,
        funcionari4_.dtype as dtype1_4_2_,
        quarto5_.id as id1_5_3_,
        quarto5_.andar as andar2_5_3_,
        quarto5_.categoria_id as categori5_5_3_,
        quarto5_.disponibilidade_diaria as disponib3_5_3_,
        quarto5_.numero as numero4_5_3_,
        categoria6_.id as id1_0_4_,
        categoria6_.image_url as image_ur2_0_4_,
        categoria6_.nome as nome3_0_4_,
        categoria6_.preco_diaria as preco_di4_0_4_,
        reserva7_.id as id1_6_5_,
        reserva7_.cliente_id as cliente_6_6_5_,
        reserva7_.data_chegada as data_che2_6_5_,
        reserva7_.data_reserva as data_res3_6_5_,
        reserva7_.hospedagem_id as hospedag7_6_5_,
        reserva7_.quarto_id as quarto_i8_6_5_,
        reserva7_.tempo_estadia as tempo_es4_6_5_,
        reserva7_.valor as valor5_6_5_,
        pagamento8_.reserva_id as reserva_2_2_6_,
        pagamento8_.estado as estado3_2_6_,
        pagamento8_.data_pagamento as data_pag4_2_6_,
        pagamento8_.data_vencimento as data_ven5_2_6_,
        pagamento8_.numero_de_parcelas as numero_d6_2_6_,
        pagamento8_.dtype as dtype1_2_6_,
        reserva9_.id as id1_6_7_,
        reserva9_.cliente_id as cliente_6_6_7_,
        reserva9_.data_chegada as data_che2_6_7_,
        reserva9_.data_reserva as data_res3_6_7_,
        reserva9_.hospedagem_id as hospedag7_6_7_,
        reserva9_.quarto_id as quarto_i8_6_7_,
        reserva9_.tempo_estadia as tempo_es4_6_7_,
        reserva9_.valor as valor5_6_7_ 
    from
        reserva reserva0_ 
    left outer join
        pessoa cliente1_ 
            on reserva0_.cliente_id=cliente1_.id 
    left outer join
        perfis perfis2_ 
            on cliente1_.id=perfis2_.pessoa_id 
    left outer join
        hospedagem hospedagem3_ 
            on reserva0_.hospedagem_id=hospedagem3_.id 
    left outer join
        pessoa funcionari4_ 
            on hospedagem3_.funcionario_id=funcionari4_.id 
    left outer join
        quarto quarto5_ 
            on hospedagem3_.quarto_id=quarto5_.id 
    left outer join
        categoria categoria6_ 
            on quarto5_.categoria_id=categoria6_.id 
    left outer join
        reserva reserva7_ 
            on quarto5_.id=reserva7_.quarto_id 
    left outer join
        pagamento pagamento8_ 
            on reserva7_.id=pagamento8_.reserva_id 
    left outer join
        reserva reserva9_ 
            on hospedagem3_.reserva_id=reserva9_.id 
    where
        reserva0_.cliente_id=?

    select
        quarto0_.id as id1_5_0_,
        quarto0_.andar as andar2_5_0_,
        quarto0_.categoria_id as categori5_5_0_,
        quarto0_.disponibilidade_diaria as disponib3_5_0_,
        quarto0_.numero as numero4_5_0_ 
    from
        quarto quarto0_ 
    where
        quarto0_.id=?

    select
        categoria0_.id as id1_0_0_,
        categoria0_.image_url as image_ur2_0_0_,
        categoria0_.nome as nome3_0_0_,
        categoria0_.preco_diaria as preco_di4_0_0_ 
    from
        categoria categoria0_ 
    where
        categoria0_.id=?

    select
        reserva0_.id as id1_6_8_,
        reserva0_.cliente_id as cliente_6_6_8_,
        reserva0_.data_chegada as data_che2_6_8_,
        reserva0_.data_reserva as data_res3_6_8_,
        reserva0_.hospedagem_id as hospedag7_6_8_,
        reserva0_.quarto_id as quarto_i8_6_8_,
        reserva0_.tempo_estadia as tempo_es4_6_8_,
        reserva0_.valor as valor5_6_8_,
        cliente1_.id as id2_4_0_,
        cliente1_.bairro as bairro3_4_0_,
        cliente1_.cep as cep4_4_0_,
        cliente1_.cidade as cidade5_4_0_,
        cliente1_.cpf as cpf6_4_0_,
        cliente1_.data_nasc as data_nas7_4_0_,
        cliente1_.email as email8_4_0_,
        cliente1_.estado as estado9_4_0_,
        cliente1_.nome as nome10_4_0_,
        cliente1_.numero as numero11_4_0_,
        cliente1_.rg as rg12_4_0_,
        cliente1_.rua as rua13_4_0_,
        cliente1_.senha as senha14_4_0_,
        cliente1_.telefone as telefon15_4_0_,
        perfis2_.pessoa_id as pessoa_i1_3_10_,
        perfis2_.perfis as perfis2_3_10_,
        hospedagem3_.id as id1_1_1_,
        hospedagem3_.checkin as checkin2_1_1_,
        hospedagem3_.checkout as checkout3_1_1_,
        hospedagem3_.funcionario_id as funciona5_1_1_,
        hospedagem3_.quarto_id as quarto_i6_1_1_,
        hospedagem3_.reserva_id as reserva_7_1_1_,
        hospedagem3_.valor as valor4_1_1_,
        funcionari4_.id as id2_4_2_,
        funcionari4_.bairro as bairro3_4_2_,
        funcionari4_.cep as cep4_4_2_,
        funcionari4_.cidade as cidade5_4_2_,
        funcionari4_.cpf as cpf6_4_2_,
        funcionari4_.data_nasc as data_nas7_4_2_,
        funcionari4_.email as email8_4_2_,
        funcionari4_.estado as estado9_4_2_,
        funcionari4_.nome as nome10_4_2_,
        funcionari4_.numero as numero11_4_2_,
        funcionari4_.rg as rg12_4_2_,
        funcionari4_.rua as rua13_4_2_,
        funcionari4_.senha as senha14_4_2_,
        funcionari4_.telefone as telefon15_4_2_,
        funcionari4_.cargo as cargo16_4_2_,
        funcionari4_.ctps as ctps17_4_2_,
        funcionari4_.data_admissao as data_ad18_4_2_,
        funcionari4_.matricula as matricu19_4_2_,
        funcionari4_.salario as salario20_4_2_,
        funcionari4_.bonificacao as bonific21_4_2_,
        funcionari4_.dtype as dtype1_4_2_,
        quarto5_.id as id1_5_3_,
        quarto5_.andar as andar2_5_3_,
        quarto5_.categoria_id as categori5_5_3_,
        quarto5_.disponibilidade_diaria as disponib3_5_3_,
        quarto5_.numero as numero4_5_3_,
        categoria6_.id as id1_0_4_,
        categoria6_.image_url as image_ur2_0_4_,
        categoria6_.nome as nome3_0_4_,
        categoria6_.preco_diaria as preco_di4_0_4_,
        reserva7_.id as id1_6_5_,
        reserva7_.cliente_id as cliente_6_6_5_,
        reserva7_.data_chegada as data_che2_6_5_,
        reserva7_.data_reserva as data_res3_6_5_,
        reserva7_.hospedagem_id as hospedag7_6_5_,
        reserva7_.quarto_id as quarto_i8_6_5_,
        reserva7_.tempo_estadia as tempo_es4_6_5_,
        reserva7_.valor as valor5_6_5_,
        pagamento8_.reserva_id as reserva_2_2_6_,
        pagamento8_.estado as estado3_2_6_,
        pagamento8_.data_pagamento as data_pag4_2_6_,
        pagamento8_.data_vencimento as data_ven5_2_6_,
        pagamento8_.numero_de_parcelas as numero_d6_2_6_,
        pagamento8_.dtype as dtype1_2_6_,
        reserva9_.id as id1_6_7_,
        reserva9_.cliente_id as cliente_6_6_7_,
        reserva9_.data_chegada as data_che2_6_7_,
        reserva9_.data_reserva as data_res3_6_7_,
        reserva9_.hospedagem_id as hospedag7_6_7_,
        reserva9_.quarto_id as quarto_i8_6_7_,
        reserva9_.tempo_estadia as tempo_es4_6_7_,
        reserva9_.valor as valor5_6_7_ 
    from
        reserva reserva0_ 
    left outer join
        pessoa cliente1_ 
            on reserva0_.cliente_id=cliente1_.id 
    left outer join
        perfis perfis2_ 
            on cliente1_.id=perfis2_.pessoa_id 
    left outer join
        hospedagem hospedagem3_ 
            on reserva0_.hospedagem_id=hospedagem3_.id 
    left outer join
        pessoa funcionari4_ 
            on hospedagem3_.funcionario_id=funcionari4_.id 
    left outer join
        quarto quarto5_ 
            on hospedagem3_.quarto_id=quarto5_.id 
    left outer join
        categoria categoria6_ 
            on quarto5_.categoria_id=categoria6_.id 
    left outer join
        reserva reserva7_ 
            on quarto5_.id=reserva7_.quarto_id 
    left outer join
        pagamento pagamento8_ 
            on reserva7_.id=pagamento8_.reserva_id 
    left outer join
        reserva reserva9_ 
            on hospedagem3_.reserva_id=reserva9_.id 
    where
        reserva0_.quarto_id=?

    select
        pagamento0_.reserva_id as reserva_2_2_0_,
        pagamento0_.estado as estado3_2_0_,
        pagamento0_.data_pagamento as data_pag4_2_0_,
        pagamento0_.data_vencimento as data_ven5_2_0_,
        pagamento0_.numero_de_parcelas as numero_d6_2_0_,
        pagamento0_.dtype as dtype1_2_0_ 
    from
        pagamento pagamento0_ 
    where
        pagamento0_.reserva_id=?

    select
        pagamento0_.reserva_id as reserva_2_2_0_,
        pagamento0_.estado as estado3_2_0_,
        pagamento0_.data_pagamento as data_pag4_2_0_,
        pagamento0_.data_vencimento as data_ven5_2_0_,
        pagamento0_.numero_de_parcelas as numero_d6_2_0_,
        pagamento0_.dtype as dtype1_2_0_ 
    from
        pagamento pagamento0_ 
    where
        pagamento0_.reserva_id=?

    select
        pagamento0_.reserva_id as reserva_2_2_0_,
        pagamento0_.estado as estado3_2_0_,
        pagamento0_.data_pagamento as data_pag4_2_0_,
        pagamento0_.data_vencimento as data_ven5_2_0_,
        pagamento0_.numero_de_parcelas as numero_d6_2_0_,
        pagamento0_.dtype as dtype1_2_0_ 
    from
        pagamento pagamento0_ 
    where
        pagamento0_.reserva_id=?

    select
        hospedagem0_.id as id1_1_5_,
        hospedagem0_.checkin as checkin2_1_5_,
        hospedagem0_.checkout as checkout3_1_5_,
        hospedagem0_.funcionario_id as funciona5_1_5_,
        hospedagem0_.quarto_id as quarto_i6_1_5_,
        hospedagem0_.reserva_id as reserva_7_1_5_,
        hospedagem0_.valor as valor4_1_5_,
        quarto1_.id as id1_5_0_,
        quarto1_.andar as andar2_5_0_,
        quarto1_.categoria_id as categori5_5_0_,
        quarto1_.disponibilidade_diaria as disponib3_5_0_,
        quarto1_.numero as numero4_5_0_,
        reserva2_.id as id1_6_1_,
        reserva2_.cliente_id as cliente_6_6_1_,
        reserva2_.data_chegada as data_che2_6_1_,
        reserva2_.data_reserva as data_res3_6_1_,
        reserva2_.hospedagem_id as hospedag7_6_1_,
        reserva2_.quarto_id as quarto_i8_6_1_,
        reserva2_.tempo_estadia as tempo_es4_6_1_,
        reserva2_.valor as valor5_6_1_,
        cliente3_.id as id2_4_2_,
        cliente3_.bairro as bairro3_4_2_,
        cliente3_.cep as cep4_4_2_,
        cliente3_.cidade as cidade5_4_2_,
        cliente3_.cpf as cpf6_4_2_,
        cliente3_.data_nasc as data_nas7_4_2_,
        cliente3_.email as email8_4_2_,
        cliente3_.estado as estado9_4_2_,
        cliente3_.nome as nome10_4_2_,
        cliente3_.numero as numero11_4_2_,
        cliente3_.rg as rg12_4_2_,
        cliente3_.rua as rua13_4_2_,
        cliente3_.senha as senha14_4_2_,
        cliente3_.telefone as telefon15_4_2_,
        hospedagem4_.id as id1_1_3_,
        hospedagem4_.checkin as checkin2_1_3_,
        hospedagem4_.checkout as checkout3_1_3_,
        hospedagem4_.funcionario_id as funciona5_1_3_,
        hospedagem4_.quarto_id as quarto_i6_1_3_,
        hospedagem4_.reserva_id as reserva_7_1_3_,
        hospedagem4_.valor as valor4_1_3_,
        quarto5_.id as id1_5_4_,
        quarto5_.andar as andar2_5_4_,
        quarto5_.categoria_id as categori5_5_4_,
        quarto5_.disponibilidade_diaria as disponib3_5_4_,
        quarto5_.numero as numero4_5_4_ 
    from
        hospedagem hospedagem0_ 
    left outer join
        quarto quarto1_ 
            on hospedagem0_.quarto_id=quarto1_.id 
    left outer join
        reserva reserva2_ 
            on hospedagem0_.reserva_id=reserva2_.id 
    left outer join
        pessoa cliente3_ 
            on reserva2_.cliente_id=cliente3_.id 
    left outer join
        hospedagem hospedagem4_ 
            on reserva2_.hospedagem_id=hospedagem4_.id 
    left outer join
        quarto quarto5_ 
            on reserva2_.quarto_id=quarto5_.id 
    where
        hospedagem0_.id=?

    select
        funcionari0_.id as id2_4_6_,
        funcionari0_.bairro as bairro3_4_6_,
        funcionari0_.cep as cep4_4_6_,
        funcionari0_.cidade as cidade5_4_6_,
        funcionari0_.cpf as cpf6_4_6_,
        funcionari0_.data_nasc as data_nas7_4_6_,
        funcionari0_.email as email8_4_6_,
        funcionari0_.estado as estado9_4_6_,
        funcionari0_.nome as nome10_4_6_,
        funcionari0_.numero as numero11_4_6_,
        funcionari0_.rg as rg12_4_6_,
        funcionari0_.rua as rua13_4_6_,
        funcionari0_.senha as senha14_4_6_,
        funcionari0_.telefone as telefon15_4_6_,
        funcionari0_.cargo as cargo16_4_6_,
        funcionari0_.ctps as ctps17_4_6_,
        funcionari0_.data_admissao as data_ad18_4_6_,
        funcionari0_.matricula as matricu19_4_6_,
        funcionari0_.salario as salario20_4_6_,
        funcionari0_.bonificacao as bonific21_4_6_,
        funcionari0_.dtype as dtype1_4_6_,
        hospedagen1_.funcionario_id as funciona5_1_8_,
        hospedagen1_.id as id1_1_8_,
        hospedagen1_.id as id1_1_0_,
        hospedagen1_.checkin as checkin2_1_0_,
        hospedagen1_.checkout as checkout3_1_0_,
        hospedagen1_.funcionario_id as funciona5_1_0_,
        hospedagen1_.quarto_id as quarto_i6_1_0_,
        hospedagen1_.reserva_id as reserva_7_1_0_,
        hospedagen1_.valor as valor4_1_0_,
        quarto2_.id as id1_5_1_,
        quarto2_.andar as andar2_5_1_,
        quarto2_.categoria_id as categori5_5_1_,
        quarto2_.disponibilidade_diaria as disponib3_5_1_,
        quarto2_.numero as numero4_5_1_,
        reserva3_.id as id1_6_2_,
        reserva3_.cliente_id as cliente_6_6_2_,
        reserva3_.data_chegada as data_che2_6_2_,
        reserva3_.data_reserva as data_res3_6_2_,
        reserva3_.hospedagem_id as hospedag7_6_2_,
        reserva3_.quarto_id as quarto_i8_6_2_,
        reserva3_.tempo_estadia as tempo_es4_6_2_,
        reserva3_.valor as valor5_6_2_,
        cliente4_.id as id2_4_3_,
        cliente4_.bairro as bairro3_4_3_,
        cliente4_.cep as cep4_4_3_,
        cliente4_.cidade as cidade5_4_3_,
        cliente4_.cpf as cpf6_4_3_,
        cliente4_.data_nasc as data_nas7_4_3_,
        cliente4_.email as email8_4_3_,
        cliente4_.estado as estado9_4_3_,
        cliente4_.nome as nome10_4_3_,
        cliente4_.numero as numero11_4_3_,
        cliente4_.rg as rg12_4_3_,
        cliente4_.rua as rua13_4_3_,
        cliente4_.senha as senha14_4_3_,
        cliente4_.telefone as telefon15_4_3_,
        hospedagem5_.id as id1_1_4_,
        hospedagem5_.checkin as checkin2_1_4_,
        hospedagem5_.checkout as checkout3_1_4_,
        hospedagem5_.funcionario_id as funciona5_1_4_,
        hospedagem5_.quarto_id as quarto_i6_1_4_,
        hospedagem5_.reserva_id as reserva_7_1_4_,
        hospedagem5_.valor as valor4_1_4_,
        quarto6_.id as id1_5_5_,
        quarto6_.andar as andar2_5_5_,
        quarto6_.categoria_id as categori5_5_5_,
        quarto6_.disponibilidade_diaria as disponib3_5_5_,
        quarto6_.numero as numero4_5_5_ 
    from
        pessoa funcionari0_ 
    left outer join
        hospedagem hospedagen1_ 
            on funcionari0_.id=hospedagen1_.funcionario_id 
    left outer join
        quarto quarto2_ 
            on hospedagen1_.quarto_id=quarto2_.id 
    left outer join
        reserva reserva3_ 
            on hospedagen1_.reserva_id=reserva3_.id 
    left outer join
        pessoa cliente4_ 
            on reserva3_.cliente_id=cliente4_.id 
    left outer join
        hospedagem hospedagem5_ 
            on reserva3_.hospedagem_id=hospedagem5_.id 
    left outer join
        quarto quarto6_ 
            on reserva3_.quarto_id=quarto6_.id 
    where
        funcionari0_.id=? 
        and funcionari0_.dtype in (
            'Funcionario', 'Gerente'
        )

    select
        perfis0_.pessoa_id as pessoa_i1_3_0_,
        perfis0_.perfis as perfis2_3_0_ 
    from
        perfis perfis0_ 
    where
        perfis0_.pessoa_id=?

    insert 
    into
        pagamento
        (estado, numero_de_parcelas, dtype, reserva_id) 
    values
        (?, ?, 'PagamentoComCartao', ?)

    update
        reserva 
    set
        cliente_id=?,
        data_chegada=?,
        data_reserva=?,
        hospedagem_id=?,
        quarto_id=?,
        tempo_estadia=?,
        valor=? 
    where
        id=?