package id.tensky.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map.*
import kotlinx.android.synthetic.main.bottomsheet_ambil.*

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var googleMap : GoogleMap
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        bundle = intent.extras!!

        map_backButton.setOnClickListener{
            onBackPressed()
        }
        supportActionBar?.hide()

        bottom_ambil_nama.text = bundle.getString("namaPengirim", "example")
        bottom_ambil_title.text = bundle.getString("title", "example")
        bottom_ambil_deskripsi.text = bundle.getString("desc", "")
        bottom_ambil_namaJalan.text = bundle.getString("jalan", "Jl. Diponegoro")
        bottom_ambil_jarak.text = bundle.getString("jarak", "100m")
        Glide.with(this).load(bundle.getString("linkFoto")).into(bottom_ambil_foto)

    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0!!
        googleMap.setMaxZoomPreference(20.0f)
        googleMap.setMinZoomPreference(6.0f)
        val jogjaLatLng = LatLng(-7.797068, 110.370529)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(jogjaLatLng))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(18.0f))
        googleMap.isMyLocationEnabled = true
        val itemPos = LatLng(bundle.getDouble("latitude"), bundle.getDouble("longitude"))
        googleMap.addMarker(MarkerOptions().position(itemPos).title(bundle.getString("title")))
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(itemPos))
    }
}
