package id.tensky.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.bottomsheet_maps.*
import kotlinx.android.synthetic.main.fragment_share_data.*

class ShareActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var googleMap : GoogleMap
    private lateinit var bundle: Bundle
    private lateinit var bottomMapsBehavior : BottomSheetBehavior<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        supportActionBar?.hide()

        bundle = intent.extras!!
        bottomMapsBehavior = BottomSheetBehavior.from(share_bottomsheet_maps as LinearLayout)
        bottomMapsBehavior.state = BottomSheetBehavior.STATE_EXPANDED


        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        bottom_maps_lokasi.setOnClickListener{
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.share_placholder, ShareDataFragment(googleMap.cameraPosition.target, bundle.getString("tipe", "makanan")))
            fragmentTransaction.commit()
        }

        if(bundle.getString("tipe", "makanan").equals("makanan")){
            bottom_maps_title.text = "Mau berbagi dimana hari ini?"
        }else{
            bottom_maps_title.text = "Butuh bantuan dimana?"
        }
    }


    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0!!
        googleMap.setMaxZoomPreference(20.0f)
        googleMap.setMinZoomPreference(6.0f)
        val jogjaLatLng = LatLng(-7.797068, 110.370529)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(jogjaLatLng))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(18.0f))
        googleMap.isMyLocationEnabled = true
    }
}
