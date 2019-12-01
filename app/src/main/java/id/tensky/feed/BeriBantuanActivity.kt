package id.tensky.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import id.tensky.feed.adapters.AbRecyclerAdapter
import id.tensky.feed.list_item.AbItemList
import kotlinx.android.synthetic.main.activity_beri_bantuan.*

class BeriBantuanActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beri_bantuan)

        beri_bantuan_recyclerView.layoutManager = LinearLayoutManager(this)

        val beriBantuanList = ArrayList<AbItemList>()
        val beriBantuanRecyclerAdapter =
            AbRecyclerAdapter(
                beriBantuanList,
                supportFragmentManager.beginTransaction(),
                false
            )

        beri_bantuan_recyclerView.adapter = beriBantuanRecyclerAdapter

        supportActionBar?.hide()

        beri_bantuan_backButton.setOnClickListener{
            super.onBackPressed()
        }

        db.collection("bantuan").get().addOnCompleteListener{
            if(it.isSuccessful){
                it.result?.forEach { results ->
                    val listItem = AbItemList(
                        results.getString("namaPenerima")!!,
                        "100m",
                        "Jl. Diponegoro",
                        results.getString("imageID")!!,
                        results.getGeoPoint("lokasi")!!.latitude,
                        results.getGeoPoint("lokasi")!!.longitude,
                        results.getString("namaPengirim")!!,
                        results.getString("catatan")!!
                    )
                    beriBantuanList.add(listItem)
                    beriBantuanRecyclerAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}
