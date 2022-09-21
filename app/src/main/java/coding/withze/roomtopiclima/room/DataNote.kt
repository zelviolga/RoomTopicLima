package coding.withze.roomtopiclima.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class DataNote(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var content : String
):Serializable
