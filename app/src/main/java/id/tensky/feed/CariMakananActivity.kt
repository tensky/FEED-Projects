package id.tensky.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.OnSuccessListener
import id.tensky.feed.list_item.CariMakananItemList
import kotlinx.android.synthetic.main.activity_cari_makanan.*

class CariMakananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cari_makanan)

        cari_makanan_recyclerView.layoutManager = LinearLayoutManager(this)

        val cariMakananList = ArrayList<CariMakananItemList>()
        val cariMakananRecyclerAdapter = CariMakananRecyclerAdapter(this, cariMakananList)
        cari_makanan_recyclerView.adapter = cariMakananRecyclerAdapter

    }
}
