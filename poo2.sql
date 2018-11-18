create database TrabalhoDePoo2;
use TrabalhoDePoo2;

create table Caixa(
	id int auto_increment not null,
    descricao varchar(45),
    primary key (id)
);

create table Historico(
	id int auto_increment not null,
    descricao varchar(45),
    operacao enum("Credito","Debito"),
    primary key (id)
);

create table Lancamento(
	id int auto_increment not null,
    caixa_id int,
    historico_id int,
    valor decimal(9,2),
    data datetime,
    observacao varchar(255),
    primary key (id),
    FOREIGN KEY (caixa_id) REFERENCES Caixa (id),
    FOREIGN KEY (historico_id) REFERENCES Historico (id)
);

