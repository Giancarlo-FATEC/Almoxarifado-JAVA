/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

public class Fornecedor {
    
    private long cnpj;
    private String nomeForn;
    private String nomeFan;
    private String endereco;
    private long telefone;
    private String email;

    // Construtor
    public Fornecedor(long cnpj, String nomeForn, String nomeFan, String endereco, long telefone, String email) {
        this.cnpj = cnpj;
        this.nomeForn = nomeForn;
        this.nomeFan = nomeFan;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeForn() {
        return nomeForn;
    }

    public void setNomeForn(String nomeForn) {
        this.nomeForn = nomeForn;
    }

    public String getNomeFan() {
        return nomeFan;
    }

    public void setNomeFan(String nomeFan) {
        this.nomeFan = nomeFan;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

