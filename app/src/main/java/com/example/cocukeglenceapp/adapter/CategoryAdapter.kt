package com.example.cocukeglenceapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
//import com.example.cocukeglenceapp.databinding.CardTasarimBinding
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cocukeglenceapp.R
import com.example.cocukeglenceapp.model.Categories
import com.example.cocukeglenceapp.view.CategoryFragment

class CategoryAdapter(
    private val mContext: Context,
    private val categoryList: List<Categories>)
//bir alttakis atırı ekledikten sonra KategorilerAdapteri implement etmemizi istiyor
//onCreateViewHolder / getItemCount / onBindViewHolder kednisi ekliyor bunları
    : RecyclerView.Adapter<CategoryAdapter.CardViewHolder>() {

    inner class CardViewHolder(view:View) : RecyclerView.ViewHolder(view){
        //activity main xml'deki  kategori_card ile textViewKategoriAd'i temsil eder
        var kategori_card: CardView
        var textViewKategoriAd:TextView
        init {
            kategori_card = view.findViewById(R.id.kategori_card)
            textViewKategoriAd = view.findViewById(R.id.textViewKategoriAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.cartegory_card_design,parent,false)//burada tasarim nedir--> LayoutInflaterdan alıp kategori_card_tasarim(recycler_row)ile bagladık.
        //her bir oluşturulan kategori_card_tasarim(recycler_row)'a tasarim (itemView)diyoruz.
        return CardViewHolder(view)
    }
    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val category = categoryList.get(position)

        holder.textViewKategoriAd.text = category.category_name
        //tıklanma özelliğini de bir alt satırda verdik
        holder.kategori_card.setOnClickListener{

            val intent = Intent(mContext, CategoryFragment::class.java)
            intent.putExtra("kategoriNesne",category)
            //intent.putExtra("kategoriNesne",kategori)//veriyi diğer sayfaya göndermeye yarıyor
            mContext.startActivity(intent)// mContext yazmak yerine itemView.context de ayzarsan çalışır. tasarim kullandıgımız yerlerde itemView kullanabilirdik.


        }
    }


}