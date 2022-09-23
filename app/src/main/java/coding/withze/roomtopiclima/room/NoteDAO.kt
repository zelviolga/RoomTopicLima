package coding.withze.roomtopiclima.room

import androidx.room.*

@Dao
interface NoteDAO {

    @Insert
    fun insertNote(note: DataNote)

    @Query("SELECT * FROM DataNote ORDER BY id DESC ")
    fun getDataNote() : List<DataNote>

    @Delete
    fun deleteNote(note: DataNote)

    @Update
    fun updateNote(note: DataNote)

}