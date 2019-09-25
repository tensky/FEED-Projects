package id.tensky.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.item_aktiv_bantuan_list.view.*

class AbRecyclerAdapter(private var context: Context, private var abItemLists: List<AbItemList>) :
    RecyclerView.Adapter<AbRecyclerAdapter.AbViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbViewHolder {
        return AbViewHolder(LayoutInflater.from(context).inflate(R.layout.item_aktiv_bantuan_list, parent, false))
    }

    override fun getItemCount(): Int {
        return abItemLists.size
    }

    override fun onBindViewHolder(holder: AbViewHolder, position: Int) {
        val item = abItemLists[position]

        holder.title.text = item.title
        holder.jalan.text = item.jalan
        holder.jarak.text = item.jarak

        Glide.with(context)
            .load(item.linkFoto)
            .into(holder.foto)

    }

    class AbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal val title = itemView.ab_title
        internal val jalan = itemView.ab_namaJalan
        internal val jarak = itemView.ab_jarak
        internal val foto = itemView.ab_foto
    }
}