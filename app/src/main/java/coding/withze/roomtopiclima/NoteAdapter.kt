package coding.withze.roomtopiclima

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coding.withze.roomtopiclima.databinding.ItemNoteBinding
import coding.withze.roomtopiclima.room.DataNote
import coding.withze.roomtopiclima.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NoteAdapter(var listNote : List<DataNote>):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    var DBNote : NoteDatabase? = null
    class ViewHolder(var binding : ItemNoteBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.binding.noteId.text = listNote[position].id.toString()
        holder.binding.noteTitle.text = listNote[position].content
        holder.binding.btnDeleteNote.setOnClickListener{
            DBNote = NoteDatabase.getInstance(it.context)

            GlobalScope.async {
                val del = DBNote?.noteDao()?.deleteNote(listNote[position])
                (holder.itemView.context as MainActivity).runOnUiThread{
                    (holder.itemView.context as MainActivity).getAllNote()
                }

            }
        }

        holder.binding.btnEditNote.setOnClickListener {
            var move = Intent(it.context, MainActivity::class.java)
            move.putExtra("data", listNote[position])
            it.context.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return  listNote.size
    }
}