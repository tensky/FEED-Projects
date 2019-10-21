package id.tensky.feed


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import id.tensky.feed.R
import kotlinx.android.synthetic.main.fragment_cari_makanan_detail.view.*

/**
 * A simple [Fragment] subclass.
 */
class CariMakananDetailFragment(val namaPengirim:String, val namaMakanan:String, val desc:String, val namaJalan:String, val jarak:String, val linkFoto:String, val waktu:String, val jumlah:String, val latitude:Double, val longitude:Double) : Fragment() {

    class CariMakanDetailFragment constructor()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_cari_makanan_detail, container, false)
        root.makanan_detail_backButton.setOnClickListener{
            activity?.onBackPressed()
        }

        root.makanan_detail_nama.text = namaPengirim
        root.makanan_detail_title.text = namaMakanan
        root.makanan_detail_deskripsi.text = desc
        root.makanan_detail_namaJalan.text = namaJalan
        root.makanan_detail_jarak.text = jarak
        root.makanan_detail_jumlah.text = jumlah
        root.makanan_detail_waktu.text = waktu
        context?.let { Glide.with(it).load(linkFoto).into(root.makanan_detail_foto) }

        root.makanan_detail_ambilButton.setOnClickListener{
            val intent = Intent(context, MapActivity::class.java)
            intent.putExtra("title", namaMakanan)
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
