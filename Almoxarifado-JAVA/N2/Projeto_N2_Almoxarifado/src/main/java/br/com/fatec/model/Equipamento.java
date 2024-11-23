/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

public class Equipamento {

    private int cod;
    private String nomeEquipamento;
    private int qtde;
    private String dataAq;
    private String categ;
    private long cnpjCliente;

    // Construtor
    public Equipamento(int cod, String nomeEquipamento, int qtde, String dataAq, String categ, long cnpjCliente) {
        this.cod = cod;
        this.nomeEquipamento = nomeEquipamento;
        this.qtde = qtde;
        this.dataAq = dataAq;
        this.categ = categ;
        this.cnpjCliente = cnpjCliente;
    }

    // Getters e Setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getDataAq() {
        return dataAq;
    }

    public void setDataAq(String dataAq) {
        this.dataAq = dataAq;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public long getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(long cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }
}
