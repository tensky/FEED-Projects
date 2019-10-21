package id.tensky.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.fragment_aktivitas.view.*

class AktivitasFragment : Fragment() {

    var abItemLists : List<AbItemList> = ArrayList()
    var abRecyclerAdapter = context?.let { AbRecyclerAdapter(it, abItemLists, activity?.supportFragmentManager!!.beginTransaction(), true) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_aktivitas, container, false)

        root.aktivitas_historyRecycler.layoutManager = LinearLayoutManager(context)
        root.aktivitas_historyRecycler.adapter = abRecyclerAdapter


        return root
    }
}