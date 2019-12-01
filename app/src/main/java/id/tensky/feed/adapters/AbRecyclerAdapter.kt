package id.tensky.feed.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import id.tensky.feed.BeriBantuanDetailFragment
import id.tensky.feed.R
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.item_aktiv_bantuan_list.view.*

class AbRecyclerAdapter(private var abItemLists: List<AbItemList>, private var ft: FragmentTransaction?, private val isAktivitas: Boolean) :
    RecyclerView.Adapter<AbRecyclerAdapter.AbViewHolder>() {
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbViewHolder {
        context = parent.context
        Log.d("FEED", "Hatiku terpanggil: ")
        return AbViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_aktiv_bantuan_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return abItemLists.size
    }

    override fun onBindViewHolder(holder: AbViewHolder, position: Int) {

        val item = abItemLists[position]
        var linkFoto :String = ""
        holder.title.text = item.title
        holder.jalan.text = item.jalan
        holder.jarak.text = item.jarak

        FirebaseStorage
            .getInstance()
            .getReference(item.linkFoto)
            .downloadUrl.addOnCompleteListener{
            Glide.with(context).load(it.result.toString()).into(holder.foto)
            linkFoto = it.result.toString()
        }
        if(!isAktivitas) {
            holder.layout.setOnClickListener {
                val beriBantuanDetailFragment =
                    BeriBantuanDetailFragment(
                        item.namaPengirim,
                        item.title,
                        item.desc,
                        item.jalan,
                        item.jarak,
                        linkFoto,
                        item.latitude,
                        item.longitude
                    )
                ft?.add(R.id.beri_bantuan_placholder, beriBantuanDetailFragment)
                ft?.commit()
            }
        }
    }

    class AbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal val title = itemView.ab_title
        internal val jalan = itemView.ab_namaJalan
        internal val jarak = itemView.ab_jarak
        internal val foto = itemView.ab_foto
        internal val layout = itemView.ab_layout
    }
}