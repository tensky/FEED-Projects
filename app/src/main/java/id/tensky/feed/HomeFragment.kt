package id.tensky.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val intent = Intent(context, ShareActivity::class.java)

        root.home_bagimakanButton.setOnClickListener {
            intent.putExtra("tipe", "makanan")
            startActivity(intent)
        }
        root.home_caribantuanButton.setOnClickListener{
            intent.putExtra("tipe", "bantuan")
            startActivity(intent)
        }

        root.home_carimakanButton.setOnClickListener {
            val cariMakananIntent = Intent(context, CariMakananActivity::class.java)
            startActivity(cariMakananIntent)
        }

        root.home_beribantuanButton.setOnClickListener {
            val beriBantuanIntent = Intent(context, BeriBantuanActivity::class.java)
            startActivity(beriBantuanIntent)
        }

        return root
    }
}