package com.example.opet.infoshopping.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 06/06/2018.
 */

@Entity
public class Endereco {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "Rua")
    private String rua;

    @ColumnInfo(name = "Numero")
    private int numero;

    @ColumnInfo(name = "Bairro")
    private String bairro;

    @ColumnInfo(name = "Complemento")
    private String complemento;

    @ColumnInfo(name = "CEP")
    private long cep;

    public Endereco(long ID, String rua, int numero, String bairro, String complemento, long cep) {
        this.ID = ID;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }
}
