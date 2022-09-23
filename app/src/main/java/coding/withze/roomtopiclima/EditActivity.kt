package coding.withze.roomtopiclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coding.withze.roomtopiclima.databinding.ActivityEditBinding
import coding.withze.roomtopiclima.room.DataNote
import coding.withze.roomtopiclima.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EditActivity : AppCompatActivity() {

    lateinit var binding : ActivityEditBinding
    var dbNote: NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbNote = NoteDatabase.getInstance(this)

        //        ambil data yg dikirim dari adapter
        var getDataNote = intent.getSerializableExtra("dataedit") as DataNote
//        set data yang dikirim ke dalam editText
        binding.editTitle.setText(getDataNote.title)
        binding.editNotee.setText(getDataNote.content)
        binding.idNote.setText(getDataNote.id.toString())

        //        klik edit, data akan diedit
        binding.btnEditNote.setOnClickListener {
            editNote()
        }
    }

    fun editNote() {
        var idNote = binding.idNote.text.toString().toInt()
        var title = binding.editTitle.text.toString()
        var note = binding.editNotee.text.toString()


        GlobalScope.async {
            var edit = dbNote?.noteDao()?.updateNote(DataNote(idNote, title, note))
            runOnUiThread {
                Toast.makeText(this@EditActivity, "Dat berhasil di Edit", Toast.LENGTH_LONG)
                    .show()
            }
            finish()
        }
    }
}