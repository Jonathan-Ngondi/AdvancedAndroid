package com.example.advancedandroid.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.advancedandroid.database.favorites.FavoriteContributor;
import com.example.advancedandroid.database.favorites.FavoriteContributorDao;

/**
 * @author Mugiwara_Munyi
 * @date 11/06/2019
 */

@Database(entities = FavoriteContributor.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavoriteContributorDao favoriteContributorDao();
}
