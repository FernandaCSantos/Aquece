create database Aquece;

use Aquece;

create table produto(codProduto int not null primary key , descricao varchar(50) not null, preco double, quantidade int);

create table perfil(codPerfil int not null primary key , nomePerfil varchar(50) not null, usuario varchar(30), senha varchar(30));

create table mesa(codMesa int not null primary key, situacao int);

create table vendas(codVenda int not null , codMesa int not null ,codProduto int , codPerfil int not null,
horaAbertura timestamp not null ,horaFechamento timestamp , quantidade double);



insert into mesa values(1);
insert into mesa values(2);
insert into mesa values(3);
insert into mesa values(4);
insert into mesa values(5);
insert into mesa values(6);
insert into mesa values(7);
insert into mesa values(8);
insert into mesa values(9);
insert into mesa values(10);
insert into mesa values(11);
insert into mesa values(12);
insert into mesa values(13);
insert into mesa values(14);
insert into mesa values(15);
insert into mesa values(16);
insert into mesa values(17);
insert into mesa values(18);

insert into produto values(001,'Coca Lata',null,null);
insert into produto values(002,'Coca Zero Lata',null,null);
insert into produto values(003,'Guarana Antartica Lata',null,null);
insert into produto values(004,'Fanta Uva Lata',null,null);
insert into produto values(005,'Del Vale Uva',null,null);
insert into produto values(006,'Del Vale Manga',null,null);

create database AqueceArquivoMorto;

use AqueceArquivoMorto;

create table produto(codProduto int not null primary key , descricao varchar(50) not null, preco double, quantidade int);

create table perfil(codPerfil int not null primary key , nomePerfil varchar(50) not null, usuario varchar(30), senha varchar(30));

create table mesa(codMesa int not null primary key);

/**
 * REFORMULAR SQL
 */
create table vendas(codVenda int not null primary key, codMesa int not null ,codProduto int , codPerfil int not null,
horaAbertura timestamp not null ,horaFechamento timestamp , total double);