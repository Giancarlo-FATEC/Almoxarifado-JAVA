/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

public class RetiradaEquipamento {

    private int codRet;
    private String nomeFun;
    private int numRegistro;
    private String dataRet;
    private int qtdeRet;
    private int codEquip;

    // Construtor
    public RetiradaEquipamento(int codRet, String nomeFun, int numRegistro, String dataRet, int qtdeRet, int codEquip) {
        this.codRet = codRet;
        this.nomeFun = nomeFun;
        this.numRegistro = numRegistro;
        this.dataRet = dataRet;
        this.qtdeRet = qtdeRet;
        this.codEquip = codEquip;
    }

    // Getters e Setters
    public int getCodRet() {
        return codRet;
    }

    public void setCodRet(int codRet) {
        this.codRet = codRet;
    }

    public String getNomeFun() {
        return nomeFun;
    }

    public void setNomeFun(String nomeFun) {
        this.nomeFun = nomeFun;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getDataRet() {
        return dataRet;
    }

    public void setDataRet(String dataRet) {
        this.dataRet = dataRet;
    }

    public int getQtdeRet() {
        return qtdeRet;
    }

    public void setQtdeRet(int qtdeRet) {
        this.qtdeRet = qtdeRet;
    }

    public int getCodEquip() {
        return codEquip;
    }

    public void setCodEquip(int codEquip) {
        this.codEquip = codEquip;
    }
}
