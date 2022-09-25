package com.danilkinkin.buckwheat.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.danilkinkin.buckwheat.data.entities.Spent

@Dao
interface SpentDao {
    @Query("SELECT * FROM spent")
    fun getAll(): LiveData<List<Spent>>

    @Query("SELECT * FROM spent WHERE uid = :uid")
    fun getById(uid: Int): Spent

    @Insert
    fun insert(vararg spent: Spent)

    @Update(entity = Spent::class, onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg spent: Spent)

    @Query("UPDATE spent SET deleted = :deleted WHERE uid = :uid")
    fun updateDelete(uid: Int, deleted: Boolean)

    @Delete
    fun delete(spent: Spent)

    @Query("DELETE FROM spent")
    fun deleteAll()
}
