package coding.withze.roomtopiclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coding.withze.roomtopiclima.databinding.ActivityAddNoteBinding
import coding.withze.roomtopiclima.room.DataNote
import coding.withze.roomtopiclima.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddNoteBinding
    var dbNote : NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initiate db note
        dbNote =NoteDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener{
            addNote()
        }
    }

    fun addNote(){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var note = binding.noteContent.text.toString()

            dbNote!!.noteDao().insertNote(DataNote(0,title, note))
        }
        finish()
    }
}