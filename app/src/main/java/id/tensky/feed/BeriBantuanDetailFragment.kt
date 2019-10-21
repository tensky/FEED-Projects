package id.tensky.feed


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_beri_bantuan_detail.*
import kotlinx.android.synthetic.main.fragment_beri_bantuan_detail.view.*

class BeriBantuanDetailFragment(val namaPengirim:String, val namaPenerima:String, val desc:String, val namaJalan:String, val jarak:String, val linkFoto:String, val latitude:Double, val longitude: Double) : Fragment() {

    class BeriBantuanDetailFragment constructor()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_beri_bantuan_detail, container, false)
        root.bantuan_detail_backButton.setOnClickListener{
            activity?.onBackPressed()
        }

        root.bantuan_detail_nama.text = namaPengirim
        root.bantuan_detail_title.text = namaPenerima
        root.bantuan_detail_deskripsi.text = desc
        root.bantuan_detail_namaJalan.text = namaJalan
        root.bantuan_detail_jarak.text = jarak
        context?.let { Glide.with(it).load(linkFoto).into(root.bantuan_detail_foto) }

        root.bantuan_detail_bantuButton.setOnClickListener{
            val intent = Intent(context, MapActivity::class.java)
            intent.putExtra("title", namaPenerima)
            intent.putExtra("namaPengirim", namaPengirim)
            intent.putExtra("linkFoto", linkFoto)
            intent.putExtra("jalan", namaJalan)
            intent.putExtra("jarak", jarak)
            intent.putExtra("desc", desc)
            intent.putExtra("latitude", latitude)
            intent.putExtra("longitude", longitude)
            startActivity(intent)
        }

        return root
    }


}
