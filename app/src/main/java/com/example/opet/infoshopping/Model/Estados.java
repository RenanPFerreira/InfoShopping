package com.example.opet.infoshopping.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
/**
 * Created by opet on 23/05/2018.
 */

@Entity
public class Estados {
    private long ID;
    @ColumnInfo (name = "Nome_Estado")
    private String nome;

    public Estados(long ID, String nome){
        this.ID = ID;
        this.nome = nome;
    }
}
