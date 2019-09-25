package id.tensky.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.fragment_aktivitas.*

class AktivitasFragment : Fragment() {

    var abItemLists : List<AbItemList> = ArrayList()
    var abRecyclerAdapter : AbRecyclerAdapter = context?.let { AbRecyclerAdapter(it, abItemLists) }!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_aktivitas, container, false)

        aktivitas_historyRecycler.layoutManager = LinearLayoutManager(context)
        aktivitas_historyRecycler.adapter = abRecyclerAdapter


        return root
    }
}