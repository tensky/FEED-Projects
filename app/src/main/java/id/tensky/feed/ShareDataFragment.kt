package id.tensky.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_share_data.view.*

class ShareDataFragment(val lokasi : LatLng, val tipe: String) : Fragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root =  inflater.inflate(R.layout.fragment_share_data, container, false)

        if(tipe == "makanan"){
            makanan()
        }else{
            bantuan()
        }

        return root
    }

    fun makanan(){
        root.share_data_title.text = "Bagikan Makanan"
    }

    fun bantuan(){
        root.share_data_title.text = "Carikan Bantuan"
        root.share_data_makananLayout.visibility = View.GONE
    }

}
