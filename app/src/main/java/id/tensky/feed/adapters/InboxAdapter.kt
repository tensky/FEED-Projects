package id.tensky.feed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.tensky.feed.R

class InboxAdapter : RecyclerView.Adapter<InboxAdapter.InboxViewHolder>() {
    class InboxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder {
        return InboxViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_inbox, parent, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        //Nothing.
    }
}