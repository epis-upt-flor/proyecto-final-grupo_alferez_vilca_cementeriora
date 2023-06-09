package com.example.mapsbasics2.obituario

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cursoradapter.widget.CursorAdapter
import com.example.mapsbasics2.R
import com.example.mapsbasics2.databinding.ActivityListaBinding
import com.example.mapsbasics2.databinding.ActivityMainBinding
import com.example.mapsbasics2.databinding.ItemListviewBinding

class ActivityLista : AppCompatActivity() {

    lateinit var binding: ActivityListaBinding
    lateinit var obituarioDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obituarioDBHelper = miSQLiteHelper(this)

        val db : SQLiteDatabase = obituarioDBHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM obituario",
            null)

        val adaptador = CursorAdapterListView(this, cursor)
        binding.lvDatos.adapter = adaptador
        db.close()
    }

    inner class CursorAdapterListView(context: Context, cursor: Cursor) :
        CursorAdapter(context, cursor, FLAG_REGISTER_CONTENT_OBSERVER) {

        override fun newView(context: Context?,
                             cursor: Cursor?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(context)
            return inflater.inflate(
                R.layout.item_listview,
                parent, false )
        }

        override fun bindView(view: View?,
                              context: Context?, cursor: Cursor?) {
            val bindingItems = ItemListviewBinding.bind(view!!)
            bindingItems.tvItemNombre.text = cursor!!.getString(1)
            bindingItems.tvItemApellidos.text = cursor!!.getString(2)
            bindingItems.tvItemFecha.text = cursor!!.getString(3)
            bindingItems.tvItemLugar.text = cursor!!.getString(4)
            bindingItems.tvItemInfo.text = cursor!!.getString(5)

            view.setOnClickListener {
                Toast.makeText(this@ActivityLista,
                    "${bindingItems.tvItemNombre.text}, " +
                            "${bindingItems.tvItemApellidos.text}, " +
                            "${bindingItems.tvItemFecha.text}, " +
                            "${bindingItems.tvItemLugar.text}, " +
                            "${bindingItems.tvItemInfo.text}",
                    Toast.LENGTH_SHORT).show()
            }

        }

    }
}