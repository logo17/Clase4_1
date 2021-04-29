package com.loguito.clase4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.loguito.clase4.R
import com.loguito.clase4.adapter.ContactAdapter
import com.loguito.clase4.models.Contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // TODO Creamos variable de tipo adapter (ContactAdapter)
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO Recuerden agregar ya sea BindView o findViewById
        contactsRecyclerView.adapter = adapter
        contactsRecyclerView.addItemDecoration(DividerItemDecoration(this, VERTICAL))

        adapter.contacts = getDummyContacts()
    }

    private fun getDummyContacts() : List<Contact> {
        return mutableListOf(
            Contact("Heriberto Urena", "https://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c325.png", "San Pedro"),
            Contact("Pedro Lopez", "https://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c32a.png", "San Jose"),
            Contact("John Doe", "https://assets.stickpng.com/images/580b57fcd9996e24bc43c31a.png", "Heredia")
        )
    }
}