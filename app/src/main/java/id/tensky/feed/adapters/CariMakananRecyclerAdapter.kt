package id.tensky.feed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import id.tensky.feed.CariMakananDetailFragment
import id.tensky.feed.R
import id.tensky.feed.list_item.CariMakananItemList
import kotlinx.android.synthetic.main.item_cari_makanan.view.*

class CariMakananRecyclerAdapter(private val context : Context, private val list : ArrayList<CariMakananItemList>, private val ft : FragmentTransaction) :
    RecyclerView.Adapter<CariMakananRecyclerAdapter.CariMakananViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CariMakananViewHolder {
        return CariMakananViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_cari_makanan,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CariMakananViewHolder, position: Int) {
        val itemList = list[position]
        var linkFoto = ""
        FirebaseStorage
            .getInstance()
            .getReference(itemList.linkFoto)
            .downloadUrl.addOnCompleteListener{
            Glide.with(context).load(it.result.toString()).into(holder.foto)
            linkFoto = it.result.toString()
        }

        holder.title.text = itemList.title
        holder.jarak.text = itemList.jarak
        holder.jalan.text = itemList.jalan
        holder.jumlah.text = itemList.jumlah
        holder.waktu.text = itemList.waktu

        holder.layout.setOnClickListener{
            val cariMakananDetailFragment = CariMakananDetailFragment(
                itemList.namaPengirim,
                itemList.title,
                itemList.desc,
                itemList.jalan,
                itemList.jarak,
                linkFoto,
                itemList.waktu,
                itemList.jumlah,
                itemList.latitude,
                itemList.longitude
            )
            ft.add(R.id.cari_makanan_placholder, cariMakananDetailFragment)
            ft.commit()
        }
    }

    class CariMakananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title = itemView.carimakan_item_title
        internal val jalan = itemView.carimakan_item_namaJalan
        internal val jarak = itemView.carimakan_item_jarak
        internal val foto = itemView.carimakan_item_foto
        internal val jumlah = itemView.carimakan_item_jumlah
        internal val waktu = itemView.carimakan_item_waktu
        internal val layout = itemView.carimakan_layout
    }
}