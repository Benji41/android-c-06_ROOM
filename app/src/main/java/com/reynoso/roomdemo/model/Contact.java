package com.reynoso.roomdemo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Noé Benjamín Reynoso Aguirre on 9/30/2022.
 */

//compiles it into a table using ROOM
@Entity(tableName = "contact_tb")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    private int id;
    @ColumnInfo(name = "contact_name")
    private String name;
    @ColumnInfo(name = "contact_occupation")
    private String occupation;

    public Contact(@NotNull String name, @NotNull("Llenar por favor") String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}
