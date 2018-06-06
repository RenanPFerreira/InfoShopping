package com.example.opet.infoshopping.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 06/06/2018.
 */

@Entity
public class Shoppings {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "Nome_Shopping")
    private String nome;

    @ColumnInfo(name = "CNPJ_Shopping")
    private long CNPJ;

    public Shoppings(long ID, String nome, long CNPJ) {
        this.ID = ID;
        this.nome = nome;
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

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }
}
