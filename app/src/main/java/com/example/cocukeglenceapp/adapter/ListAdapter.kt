package com.example.cocukeglenceapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocukeglenceapp.R
import com.example.cocukeglenceapp.model.Categories
import com.example.cocukeglenceapp.model.Contents
import com.example.cocukeglenceapp.view.CategoryFragment

class ListAdapter(
    private val mContext: Context,
    private val listList: List<Contents>)
//bir alttakis atırı ekledikten sonra KategorilerAdapteri implement etmemizi istiyor
//onCreateViewHolder / getItemCount / onBindViewHolder kednisi ekliyor bunları
    : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(view:View) : RecyclerView.ViewHolder(view){
        //activity main xml'deki  kategori_card ile textViewKategoriAd'i temsil eder
        var kategori_card: CardView
        var textViewKategoriAd:TextView
        init {
            kategori_card = view.findViewById(R.id.kategori_card)
            textViewKategoriAd = view.findViewById(R.id.textViewKategoriAd)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.fragment_content,parent,false)//burada tasarim nedir--> LayoutInflaterdan alıp kategori_card_tasarim(recycler_row)ile bagladık.
        //her bir oluşturulan kategori_card_tasarim(recycler_row)'a tasarim (itemView)diyoruz.
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val contents = listList.get(position)

        holder.textViewKategoriAd.text = contents.content_name
        //tıklanma özelliğini de bir alt satırda verdik
        holder.kategori_card.setOnClickListener{

            val intent = Intent(mContext, CategoryFragment::class.java)
            intent.putExtra("kategoriNesne",contents)
            //intent.putExtra("kategoriNesne",kategori)//veriyi diğer sayfaya göndermeye yarıyor
            mContext.startActivity(intent)// mContext yazmak yerine itemView.context de ayzarsan çalışır. tasarim kullandıgımız yerlerde itemView kullanabilirdik.


        }

    }


}