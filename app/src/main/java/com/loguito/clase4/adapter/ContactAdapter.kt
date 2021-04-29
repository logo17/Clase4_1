package com.loguito.clase4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.loguito.clase4.R
import com.loguito.clase4.extensions.mapToVisibility
import com.loguito.clase4.models.Contact
import kotlinx.android.synthetic.main.contact_cell.view.*

//    TODO Paso 4, Creamos el Adapter
class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    //TODO Paso 5, creamos el set para la lista que va a alimentar el adapter (datasource)
    var contacts: List<Contact> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //    TODO Paso 3, Creamos el ViewHolder
    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(name: String, imageUrl: String, description: String) {
            itemView.textView.text = name
            itemView.textView2.text = description

            // TODO Click listener de la celda
            itemView.setOnClickListener {
                itemView.textView2.visibility = itemView.textView2.isVisible.not().mapToVisibility()
            }

//            Picasso.get().load(imageUrl).into(itemView.imageView)
            Glide.with(itemView.context)
                .load(imageUrl)
                .circleCrop()
                .into(itemView.imageView)

        }
    }

    //TODO Metodo encargado de inflar el layout/xml en cada celda
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // Inflamos la celda que creamos en el xml y se la pasamos al viewholder, para que tenga la referencia de los componentes
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_cell, parent, false)
        return ContactViewHolder(view)
    }

    // TODO Metodo encargado de pintar los datos para cada celda, dependiendo de la posicion
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        // Llamamos al metodo bind para la posicion especifica
        val contact = contacts[position]
        holder.bind(contact.name, contact.imageURL, contact.description)
    }

    // TODO Metodo que determina la cantidad de elementos en la lista
    override fun getItemCount(): Int = contacts.size
}