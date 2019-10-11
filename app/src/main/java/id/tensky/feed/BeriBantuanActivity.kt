package id.tensky.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.activity_beri_bantuan.*

class BeriBantuanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beri_bantuan)

        beri_bantuan_recyclerView.layoutManager = LinearLayoutManager(this)

        val beriBantuanList = ArrayList<AbItemList>()
        val beriBantuanRecyclerAdapter = AbRecyclerAdapter(this, beriBantuanList)

        beri_bantuan_recyclerView.adapter = beriBantuanRecyclerAdapter
    }
}
