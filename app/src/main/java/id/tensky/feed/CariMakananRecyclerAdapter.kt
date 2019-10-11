package id.tensky.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tensky.feed.list_item.CariMakananItemList
import kotlinx.android.synthetic.main.item_cari_makanan.view.*

class CariMakananRecyclerAdapter(private val context : Context, private val list : ArrayList<CariMakananItemList>) :
    RecyclerView.Adapter<CariMakananRecyclerAdapter.CariMakananViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CariMakananViewHolder {
        return CariMakananViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cari_makanan, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CariMakananViewHolder, position: Int) {
        val itemList = list[position]
        Glide.with(context).load(itemList.linkFoto).into(holder.foto)
        holder.title.text = itemList.title
        holder.jarak.text = itemList.jarak
        holder.jalan.text = itemList.jalan
        holder.jumlah.text = itemList.jumlah
        holder.waktu.text = itemList.waktu
    }

    class CariMakananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title = itemView.carimakan_item_title
        internal val jalan = itemView.carimakan_item_namaJalan
        internal val jarak = itemView.carimakan_item_jarak
        internal val foto = itemView.carimakan_item_foto
        internal val jumlah = itemView.carimakan_item_jumlah
        internal val waktu = itemView.carimakan_item_waktu
    }
}