/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  eduar
 * Created: 21 de nov. de 2024
 */

create database Almoxarifado

use Almoxarifado;

CREATE TABLE CAD_FORNECEDOR
(
    cnpj BIGINT PRIMARY KEY NOT NULL,
    nome_forn VARCHAR(40) NOT NULL,
    nome_fan VARCHAR(40) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    telefone BIGINT NOT NULL,
    email VARCHAR(30)
);

CREATE TABLE CAD_EQUIPAMENTOS
(
    cod INT PRIMARY KEY NOT NULL,
    nome_equipamento VARCHAR(40) NOT NULL,
    qtde INT NOT NULL,
    data_aq DATE NOT NULL,
    categ VARCHAR(30) NOT NULL,
    cnpj_cliente BIGINT,
    FOREIGN KEY (cnpj_cliente) REFERENCES CAD_FORNECEDOR(cnpj)
);

CREATE TABLE RET_EQUIP_ALMO
(
    cod_ret INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome_fun VARCHAR(40) NOT NULL,
    num_registro INT NOT NULL,
    data_ret DATE NOT NULL,
    qtde_ret INT NOT NULL,
    cod_equip INT,
    FOREIGN KEY (cod_equip) REFERENCES CAD_EQUIPAMENTOS(cod)
);
