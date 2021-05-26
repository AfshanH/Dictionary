package com.example.momsdictionary.other

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.momsdictionary.R
import kotlinx.android.synthetic.main.history_items.view.*

class WordsAdapter(val context : Context ,val wordList : ArrayList<String?>,val mean : ArrayList<String?> ,val interaction: Interaction?) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

//    val wordsList : MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        return WordsViewHolder(LayoutInflater.from(context).inflate(R.layout.history_items,parent , false))
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {

        val words = wordList.get(position)
        val meaning = mean.get(position)

        holder.itemView.apply {
            words?.let{
                his_word.setText(words)
                his_mean.setText(meaning)
            }

            holder.itemView.setOnClickListener{
                interaction?.onItemSelected(position)
            }

        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    class WordsViewHolder constructor(itemView: View ) : RecyclerView.ViewHolder(itemView) {
//        val parent : View = itemView

    }

    interface Interaction{
        fun onItemSelected(position : Int)
    }

}