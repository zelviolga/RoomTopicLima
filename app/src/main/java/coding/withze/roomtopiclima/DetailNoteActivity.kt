package coding.withze.roomtopiclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coding.withze.roomtopiclima.databinding.ActivityDetailNoteBinding
import coding.withze.roomtopiclima.room.DataNote

class DetailNoteActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var getDetail = intent.getSerializableExtra("detail") as DataNote

        binding.detailTitle.text = getDetail.title
        binding.detailNote.text = getDetail.content

    }
}