package id.tensky.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import id.tensky.feed.adapters.CariMakananRecyclerAdapter
import id.tensky.feed.list_item.CariMakananItemList
import kotlinx.android.synthetic.main.activity_cari_makanan.*

class CariMakananActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cari_makanan)

        cari_makanan_recyclerView.layoutManager = LinearLayoutManager(this)

        val cariMakananList = ArrayList<CariMakananItemList>()
        val cariMakananRecyclerAdapter = CariMakananRecyclerAdapter(
            this,
            cariMakananList,
            supportFragmentManager.beginTransaction()
        )
        cari_makanan_recyclerView.adapter = cariMakananRecyclerAdapter

        supportActionBar?.hide()
        cari_makanan_backButton.setOnClickListener{
            super.onBackPressed()
        }
        //Database. Be careful
        db.collection("makanan").get().addOnCompleteListener{
            if(it.isSuccessful){
                it.result?.forEach {
                    val listItem = CariMakananItemList(
                        it.getString("namaMakanan")!!,
                        "100m",
                        "Jl. Diponegoro",
                        it.getString("imageID")!!,
                        it.getString("jumlahMakanan")!!,
                        it.getString("tanggal")!!,
                        it.getString("namaPengirim")!!,
                        it.getString("catatan")!!,
                        it.getGeoPoint("lokasi")!!.latitude,
                        it.getGeoPoint("lokasi")!!.longitude
                    )
                    cariMakananList.add(listItem)
                    cariMakananRecyclerAdapter.notifyDataSetChanged()
                }
            }
        }

    }
}
