package com.example.advancedandroid.database.favorites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author Mugiwara_Munyi
 * @date 11/06/2019
 */
@Entity
public class FavoriteContributor {

    @PrimaryKey
    private final long id;

    public FavoriteContributor(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

}
