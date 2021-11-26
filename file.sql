
    alter table hospedagem
       drop constraint FK4reuno983puantin3n2jyv502


    alter table hospedagem
       drop constraint FKkldpxp6h3yt7yuvw0boweetl
 

    alter table pagamento
       drop constraint FK1solgom1n0mmdkesa8k4y3d8r


    alter table perfis
       drop constraint FKlnesgnyiynjyqx8ks8cyhv6il


    alter table quarto
       drop constraint FKo3wyrs6gfgy76ake7vyesomju


    alter table reserva
       drop constraint FKgipueqcywuo5jet4qj5bgtd5k


    alter table reserva
       drop constraint FKn3aymvpqwl44nqr9mosu0p4hq


    alter table reserva
       drop constraint FKll90wdpmqcpwh6car9093ehxy


    drop table if exists categoria cascade


    drop table if exists hospedagem cascade


    drop table if exists manutencao cascade


    drop table if exists pagamento cascade


    drop table if exists perfis cascade


    drop table if exists pessoa cascade


    drop table if exists quarto cascade


    drop table if exists reserva cascade


    create table categoria (
       id  serial not null,
        descricao varchar(255),
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
        reserva_id int4,
        primary key (id)
    )


    create table manutencao (
       id  serial not null,
        custos float8,
        data_fim timestamp,
        data_inicio timestamp,
        descricao varchar(255),
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
        numero varchar(255),
        categoria_id int4,
        primary key (id)
    )


    create table reserva (
       id  serial not null,
        data_reserva timestamp,
        data_saida timestamp,
        status_checked boolean not null,
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
        (descricao, image_url, nome, preco_diaria)
    values
        (?, ?, ?, ?)

    insert
    into
        categoria
        (descricao, image_url, nome, preco_diaria)
    values
        (?, ?, ?, ?)

    insert
    into
        quarto
        (andar, categoria_id, numero)
    values
        (?, ?, ?)

    insert
    into
        quarto
        (andar, categoria_id, numero)
    values
        (?, ?, ?)

    insert
    into
        reserva
        (cliente_id, data_reserva, data_saida, hospedagem_id, quarto_id, status_checked, tempo_estadia, valor)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)

    insert
    into
        reserva
        (cliente_id, data_reserva, data_saida, hospedagem_id, quarto_id, status_checked, tempo_estadia, valor)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)

    insert
    into
        reserva
        (cliente_id, data_reserva, data_saida, hospedagem_id, quarto_id, status_checked, tempo_estadia, valor)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)

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
        (checkin, checkout, funcionario_id, reserva_id, valor)
    values
        (?, ?, ?, ?, ?)

    select
        pagamentoc0_.reserva_id as reserva_2_3_0_,
        pagamentoc0_.estado as estado3_3_0_,
        pagamentoc0_.numero_de_parcelas as numero_d6_3_0_
    from
        pagamento pagamentoc0_
    where
        pagamentoc0_.reserva_id=?
        and pagamentoc0_.dtype='PagamentoComCartao'

    select
        reserva0_.id as id1_7_4_,
        reserva0_.cliente_id as cliente_7_7_4_,
        reserva0_.data_reserva as data_res2_7_4_,
        reserva0_.data_saida as data_sai3_7_4_,
        reserva0_.hospedagem_id as hospedag8_7_4_,
        reserva0_.quarto_id as quarto_i9_7_4_,
        reserva0_.status_checked as status_c4_7_4_,
        reserva0_.tempo_estadia as tempo_es5_7_4_,
        reserva0_.valor as valor6_7_4_,
        cliente1_.id as id2_5_0_,
        cliente1_.bairro as bairro3_5_0_,
        cliente1_.cep as cep4_5_0_,
        cliente1_.cidade as cidade5_5_0_,
        cliente1_.cpf as cpf6_5_0_,
        cliente1_.data_nasc as data_nas7_5_0_,
        cliente1_.email as email8_5_0_,
        cliente1_.estado as estado9_5_0_,
        cliente1_.nome as nome10_5_0_,
        cliente1_.numero as numero11_5_0_,
        cliente1_.rg as rg12_5_0_,
        cliente1_.rua as rua13_5_0_,
        cliente1_.senha as senha14_5_0_,
        cliente1_.telefone as telefon15_5_0_,
        hospedagem2_.id as id1_1_1_,
        hospedagem2_.checkin as checkin2_1_1_,
        hospedagem2_.checkout as checkout3_1_1_,
        hospedagem2_.funcionario_id as funciona5_1_1_,
        hospedagem2_.reserva_id as reserva_6_1_1_,
        hospedagem2_.valor as valor4_1_1_,
        reserva3_.id as id1_7_2_,
        reserva3_.cliente_id as cliente_7_7_2_,
        reserva3_.data_reserva as data_res2_7_2_,
        reserva3_.data_saida as data_sai3_7_2_,
        reserva3_.hospedagem_id as hospedag8_7_2_,
        reserva3_.quarto_id as quarto_i9_7_2_,
        reserva3_.status_checked as status_c4_7_2_,
        reserva3_.tempo_estadia as tempo_es5_7_2_,
        reserva3_.valor as valor6_7_2_,
        quarto4_.id as id1_6_3_,
        quarto4_.andar as andar2_6_3_,
        quarto4_.categoria_id as categori4_6_3_,
        quarto4_.numero as numero3_6_3_
    from
        reserva reserva0_
    left outer join
        pessoa cliente1_
            on reserva0_.cliente_id=cliente1_.id
    left outer join
        hospedagem hospedagem2_
            on reserva0_.hospedagem_id=hospedagem2_.id
    left outer join
        reserva reserva3_
            on hospedagem2_.reserva_id=reserva3_.id
    left outer join
        quarto quarto4_
            on reserva3_.quarto_id=quarto4_.id
    where
        reserva0_.id=?

    select
        quarto0_.id as id1_6_0_,
        quarto0_.andar as andar2_6_0_,
        quarto0_.categoria_id as categori4_6_0_,
        quarto0_.numero as numero3_6_0_
    from
        quarto quarto0_
    where
        quarto0_.id=?

    select
        categoria0_.id as id1_0_0_,
        categoria0_.descricao as descrica2_0_0_,
        categoria0_.image_url as image_ur3_0_0_,
        categoria0_.nome as nome4_0_0_,
        categoria0_.preco_diaria as preco_di5_0_0_
    from
        categoria categoria0_
    where
        categoria0_.id=?

    select
        pagamento0_.reserva_id as reserva_2_3_0_,
        pagamento0_.estado as estado3_3_0_,
        pagamento0_.data_pagamento as data_pag4_3_0_,
        pagamento0_.data_vencimento as data_ven5_3_0_,
        pagamento0_.numero_de_parcelas as numero_d6_3_0_,
        pagamento0_.dtype as dtype1_3_0_
    from
        pagamento pagamento0_
    where
        pagamento0_.reserva_id=?

    select
        perfis0_.pessoa_id as pessoa_i1_4_0_,
        perfis0_.perfis as perfis2_4_0_
    from
        perfis perfis0_
    where
        perfis0_.pessoa_id=?

    select
        reservas0_.cliente_id as cliente_7_7_0_,
        reservas0_.id as id1_7_0_,
        reservas0_.id as id1_7_1_,
        reservas0_.cliente_id as cliente_7_7_1_,
        reservas0_.data_reserva as data_res2_7_1_,
        reservas0_.data_saida as data_sai3_7_1_,
        reservas0_.hospedagem_id as hospedag8_7_1_,
        reservas0_.quarto_id as quarto_i9_7_1_,
        reservas0_.status_checked as status_c4_7_1_,
        reservas0_.tempo_estadia as tempo_es5_7_1_,
        reservas0_.valor as valor6_7_1_,
        hospedagem1_.id as id1_1_2_,
        hospedagem1_.checkin as checkin2_1_2_,
        hospedagem1_.checkout as checkout3_1_2_,
        hospedagem1_.funcionario_id as funciona5_1_2_,
        hospedagem1_.reserva_id as reserva_6_1_2_,
        hospedagem1_.valor as valor4_1_2_,
        funcionari2_.id as id2_5_3_,
        funcionari2_.bairro as bairro3_5_3_,
        funcionari2_.cep as cep4_5_3_,
        funcionari2_.cidade as cidade5_5_3_,
        funcionari2_.cpf as cpf6_5_3_,
        funcionari2_.data_nasc as data_nas7_5_3_,
        funcionari2_.email as email8_5_3_,
        funcionari2_.estado as estado9_5_3_,
        funcionari2_.nome as nome10_5_3_,
        funcionari2_.numero as numero11_5_3_,
        funcionari2_.rg as rg12_5_3_,
        funcionari2_.rua as rua13_5_3_,
        funcionari2_.senha as senha14_5_3_,
        funcionari2_.telefone as telefon15_5_3_,
        funcionari2_.cargo as cargo16_5_3_,
        funcionari2_.ctps as ctps17_5_3_,
        funcionari2_.data_admissao as data_ad18_5_3_,
        funcionari2_.matricula as matricu19_5_3_,
        funcionari2_.salario as salario20_5_3_,
        funcionari2_.bonificacao as bonific21_5_3_,
        funcionari2_.dtype as dtype1_5_3_,
        reserva3_.id as id1_7_4_,
        reserva3_.cliente_id as cliente_7_7_4_,
        reserva3_.data_reserva as data_res2_7_4_,
        reserva3_.data_saida as data_sai3_7_4_,
        reserva3_.hospedagem_id as hospedag8_7_4_,
        reserva3_.quarto_id as quarto_i9_7_4_,
        reserva3_.status_checked as status_c4_7_4_,
        reserva3_.tempo_estadia as tempo_es5_7_4_,
        reserva3_.valor as valor6_7_4_,
        quarto4_.id as id1_6_5_,
        quarto4_.andar as andar2_6_5_,
        quarto4_.categoria_id as categori4_6_5_,
        quarto4_.numero as numero3_6_5_,
        categoria5_.id as id1_0_6_,
        categoria5_.descricao as descrica2_0_6_,
        categoria5_.image_url as image_ur3_0_6_,
        categoria5_.nome as nome4_0_6_,
        categoria5_.preco_diaria as preco_di5_0_6_,
        pagamento6_.reserva_id as reserva_2_3_7_,
        pagamento6_.estado as estado3_3_7_,
        pagamento6_.data_pagamento as data_pag4_3_7_,
        pagamento6_.data_vencimento as data_ven5_3_7_,
        pagamento6_.numero_de_parcelas as numero_d6_3_7_,
        pagamento6_.dtype as dtype1_3_7_
    from
        reserva reservas0_
    left outer join
        hospedagem hospedagem1_
            on reservas0_.hospedagem_id=hospedagem1_.id
    left outer join
        pessoa funcionari2_
            on hospedagem1_.funcionario_id=funcionari2_.id
    left outer join
        reserva reserva3_
            on hospedagem1_.reserva_id=reserva3_.id
    left outer join
        quarto quarto4_
            on reserva3_.quarto_id=quarto4_.id
    left outer join
        categoria categoria5_
            on quarto4_.categoria_id=categoria5_.id
    left outer join
        pagamento pagamento6_
            on reserva3_.id=pagamento6_.reserva_id
    where
        reservas0_.cliente_id=?

    select
        hospedagem0_.id as id1_1_4_,
        hospedagem0_.checkin as checkin2_1_4_,
        hospedagem0_.checkout as checkout3_1_4_,
        hospedagem0_.funcionario_id as funciona5_1_4_,
        hospedagem0_.reserva_id as reserva_6_1_4_,
        hospedagem0_.valor as valor4_1_4_,
        reserva1_.id as id1_7_0_,
        reserva1_.cliente_id as cliente_7_7_0_,
        reserva1_.data_reserva as data_res2_7_0_,
        reserva1_.data_saida as data_sai3_7_0_,
        reserva1_.hospedagem_id as hospedag8_7_0_,
        reserva1_.quarto_id as quarto_i9_7_0_,
        reserva1_.status_checked as status_c4_7_0_,
        reserva1_.tempo_estadia as tempo_es5_7_0_,
        reserva1_.valor as valor6_7_0_,
        cliente2_.id as id2_5_1_,
        cliente2_.bairro as bairro3_5_1_,
        cliente2_.cep as cep4_5_1_,
        cliente2_.cidade as cidade5_5_1_,
        cliente2_.cpf as cpf6_5_1_,
        cliente2_.data_nasc as data_nas7_5_1_,
        cliente2_.email as email8_5_1_,
        cliente2_.estado as estado9_5_1_,
        cliente2_.nome as nome10_5_1_,
        cliente2_.numero as numero11_5_1_,
        cliente2_.rg as rg12_5_1_,
        cliente2_.rua as rua13_5_1_,
        cliente2_.senha as senha14_5_1_,
        cliente2_.telefone as telefon15_5_1_,
        hospedagem3_.id as id1_1_2_,
        hospedagem3_.checkin as checkin2_1_2_,
        hospedagem3_.checkout as checkout3_1_2_,
        hospedagem3_.funcionario_id as funciona5_1_2_,
        hospedagem3_.reserva_id as reserva_6_1_2_,
        hospedagem3_.valor as valor4_1_2_,
        quarto4_.id as id1_6_3_,
        quarto4_.andar as andar2_6_3_,
        quarto4_.categoria_id as categori4_6_3_,
        quarto4_.numero as numero3_6_3_
    from
        hospedagem hospedagem0_
    left outer join
        reserva reserva1_
            on hospedagem0_.reserva_id=reserva1_.id
    left outer join
        pessoa cliente2_
            on reserva1_.cliente_id=cliente2_.id
    left outer join
        hospedagem hospedagem3_
            on reserva1_.hospedagem_id=hospedagem3_.id
    left outer join
        quarto quarto4_
            on reserva1_.quarto_id=quarto4_.id
    where
        hospedagem0_.id=?

    select
        funcionari0_.id as id2_5_5_,
        funcionari0_.bairro as bairro3_5_5_,
        funcionari0_.cep as cep4_5_5_,
        funcionari0_.cidade as cidade5_5_5_,
        funcionari0_.cpf as cpf6_5_5_,
        funcionari0_.data_nasc as data_nas7_5_5_,
        funcionari0_.email as email8_5_5_,
        funcionari0_.estado as estado9_5_5_,
        funcionari0_.nome as nome10_5_5_,
        funcionari0_.numero as numero11_5_5_,
        funcionari0_.rg as rg12_5_5_,
        funcionari0_.rua as rua13_5_5_,
        funcionari0_.senha as senha14_5_5_,
        funcionari0_.telefone as telefon15_5_5_,
        funcionari0_.cargo as cargo16_5_5_,
        funcionari0_.ctps as ctps17_5_5_,
        funcionari0_.data_admissao as data_ad18_5_5_,
        funcionari0_.matricula as matricu19_5_5_,
        funcionari0_.salario as salario20_5_5_,
        funcionari0_.bonificacao as bonific21_5_5_,
        funcionari0_.dtype as dtype1_5_5_,
        hospedagen1_.funcionario_id as funciona5_1_7_,
        hospedagen1_.id as id1_1_7_,
        hospedagen1_.id as id1_1_0_,
        hospedagen1_.checkin as checkin2_1_0_,
        hospedagen1_.checkout as checkout3_1_0_,
        hospedagen1_.funcionario_id as funciona5_1_0_,
        hospedagen1_.reserva_id as reserva_6_1_0_,
        hospedagen1_.valor as valor4_1_0_,
        reserva2_.id as id1_7_1_,
        reserva2_.cliente_id as cliente_7_7_1_,
        reserva2_.data_reserva as data_res2_7_1_,
        reserva2_.data_saida as data_sai3_7_1_,
        reserva2_.hospedagem_id as hospedag8_7_1_,
        reserva2_.quarto_id as quarto_i9_7_1_,
        reserva2_.status_checked as status_c4_7_1_,
        reserva2_.tempo_estadia as tempo_es5_7_1_,
        reserva2_.valor as valor6_7_1_,
        cliente3_.id as id2_5_2_,
        cliente3_.bairro as bairro3_5_2_,
        cliente3_.cep as cep4_5_2_,
        cliente3_.cidade as cidade5_5_2_,
        cliente3_.cpf as cpf6_5_2_,
        cliente3_.data_nasc as data_nas7_5_2_,
        cliente3_.email as email8_5_2_,
        cliente3_.estado as estado9_5_2_,
        cliente3_.nome as nome10_5_2_,
        cliente3_.numero as numero11_5_2_,
        cliente3_.rg as rg12_5_2_,
        cliente3_.rua as rua13_5_2_,
        cliente3_.senha as senha14_5_2_,
        cliente3_.telefone as telefon15_5_2_,
        hospedagem4_.id as id1_1_3_,
        hospedagem4_.checkin as checkin2_1_3_,
        hospedagem4_.checkout as checkout3_1_3_,
        hospedagem4_.funcionario_id as funciona5_1_3_,
        hospedagem4_.reserva_id as reserva_6_1_3_,
        hospedagem4_.valor as valor4_1_3_,
        quarto5_.id as id1_6_4_,
        quarto5_.andar as andar2_6_4_,
        quarto5_.categoria_id as categori4_6_4_,
        quarto5_.numero as numero3_6_4_
    from
        pessoa funcionari0_
    left outer join
        hospedagem hospedagen1_
            on funcionari0_.id=hospedagen1_.funcionario_id
    left outer join
        reserva reserva2_
            on hospedagen1_.reserva_id=reserva2_.id
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
        funcionari0_.id=?
        and funcionari0_.dtype in (
            'Funcionario', 'Gerente'
        )

    select
        perfis0_.pessoa_id as pessoa_i1_4_0_,
        perfis0_.perfis as perfis2_4_0_
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
        data_reserva=?,
        data_saida=?,
        hospedagem_id=?,
        quarto_id=?,
        status_checked=?,
        tempo_estadia=?,
        valor=?
    where
        id=?

    insert
    into
        manutencao
        (custos, data_fim, data_inicio, descricao)
    values
        (?, ?, ?, ?)