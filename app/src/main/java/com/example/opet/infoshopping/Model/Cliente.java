package com.example.opet.infoshopping.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 06/06/2018.
 */

@Entity
public class Cliente {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "Nome_Cliente")
    private String nome;

    private long CPF;

    private String email;

    private String senha;

    public Cliente(long ID, String nome, long CPF, String email, String senha) {
        this.ID = ID;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.senha = senha;
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

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
