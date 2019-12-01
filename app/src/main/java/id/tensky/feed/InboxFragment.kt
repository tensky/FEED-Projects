package id.tensky.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.feed.adapters.InboxAdapter
import kotlinx.android.synthetic.main.fragment_inbox.view.*

class InboxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_inbox, container, false)
        root.inbox_recyclerView.adapter = InboxAdapter()
        root.inbox_recyclerView.layoutManager = LinearLayoutManager(context)
        return root
    }
}