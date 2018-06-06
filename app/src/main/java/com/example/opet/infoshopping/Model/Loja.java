package com.example.opet.infoshopping.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 06/06/2018.
 */

public class Loja {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "Nome_Loja")
    private String nome;

    @ColumnInfo(name = "Nome_Fantasia")
    private String nomeFantasia;

    @ColumnInfo(name = "CNPJ_Loja")
    private long CNPJ;

    public Loja(long ID, String nome, String nomeFantasia, long CNPJ) {
        this.ID = ID;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.CNPJ = CNPJ;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }
}
