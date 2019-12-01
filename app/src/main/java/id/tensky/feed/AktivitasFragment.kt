package id.tensky.feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.feed.adapters.AbRecyclerAdapter
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.fragment_aktivitas.view.*

class AktivitasFragment : Fragment() {

    var abItemLists = mutableListOf<AbItemList>()
    var abRecyclerAdapter= AbRecyclerAdapter(abItemLists, null, true)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_aktivitas, container, false)

        root.aktivitas_historyRecycler.layoutManager = LinearLayoutManager(context)
        root.aktivitas_historyRecycler.adapter = abRecyclerAdapter
        for (i in 0..1){
            Log.d("Ahnn", "Masuk kok: ")
            val item = AbItemList("Membantu Ibu", "300m", "Jl. Lapar Bos", "85Hw6RvczTa9lG87ZScE", 3.0,7.0, "Rifqi", "Dia lapar bos" )
            abItemLists.add(item)
            val item2 = AbItemList("Banyak Makana disini!", "301m", "Jl. Kenyang Bos", "34SxVCbvR01YEoMgeOHL", 4.0,5.0, "Rifqi", "Ada banyak makanan bos" )
            abItemLists.add(item2)
            abRecyclerAdapter.notifyDataSetChanged()
        }

        return root
    }
}