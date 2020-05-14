package com.example.translate.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.translate.R
import com.example.translate.model.Definition
import com.example.translate.model.Model

class ModelAdapter() : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    private val definitions = ArrayList<Definition>()
    private var _emoji = ""

    fun changeWord(model: Model){
        definitions.clear()
        definitions.addAll(model.definitions!!.asIterable())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_view, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount() = definitions.size

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = definitions[position]
        _emoji = definitions[0].emoji!!
        holder.bind(model, _emoji)
    }

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val word_type: TextView = itemView.findViewById(R.id.word_type)
        private val word_definition: TextView = itemView.findViewById(R.id.word_definition)
        private val word_example: TextView = itemView.findViewById(R.id.word_example)
        private val emoji: TextView = itemView.findViewById(R.id.emoji)

        fun bind(definition: Definition, _emoji: String){
            word_type.text = definition.type
            word_definition.text = definition.definition
            word_example.text = definition.example
            emoji.text = definition.emoji ?: _emoji

        }
    }

}