create database Aquece;

use Aquece;

create table produto(codProduto int not null primary key , descricao varchar(50) not null, preco double, quantidade int);

create table perfil(codPerfil int not null primary key , nomePerfil varchar(50) not null, usuario varchar(30), senha varchar(30));

create table mesa(codMesa int not null primary key, horaAbertura timestamp not null ,horaFechamento timestamp not null , codProduto int not null,
FOREIGN KEY (codProduto) REFERENCES produto(codProduto));

create table vendas(codVenda int not null primary key, codMesa int not null ,codProduto int not null , codPerfil int not null,
  FOREIGN KEY (codMesa) REFERENCES mesa(codMesa),
 FOREIGN KEY (codProduto) REFERENCES produto(codProduto),
 FOREIGN KEY (codPerfil) REFERENCES perfil(codPerfil));


create database AqueceArquivoMorto;

use AqueceArquivoMorto;

create table produto(codProduto int not null primary key , descricao varchar(50) not null, preco double, quantidade int);

create table perfil(codPerfil int not null primary key , nomePerfil varchar(50) not null, usuario varchar(30), senha varchar(30));

create table mesa(codMesa int not null primary key, horaAbertura timestamp not null ,horaFechamento timestamp not null , codProduto int not null,
FOREIGN KEY (codProduto) REFERENCES produto(codProduto));

create table vendas(codVenda int not null primary key, codMesa int not null ,codProduto int not null , codPerfil int not null,
  FOREIGN KEY (codMesa) REFERENCES mesa(codMesa),
 FOREIGN KEY (codProduto) REFERENCES produto(codProduto),
 FOREIGN KEY (codPerfil) REFERENCES perfil(codPerfil));


