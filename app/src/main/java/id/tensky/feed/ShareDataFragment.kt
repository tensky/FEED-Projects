package id.tensky.feed

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_share_data.view.*

class ShareDataFragment(val lokasi : LatLng, val tipe: String) : Fragment() {

    private lateinit var root: View
    private lateinit var db : FirebaseFirestore
    private lateinit var storageRef : StorageReference
    private val FILE_REQUEST_CODE = 6969
    private lateinit var docref : DocumentReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root =  inflater.inflate(R.layout.fragment_share_data, container, false)
        db = FirebaseFirestore.getInstance()
        if(tipe == "makanan"){
            makanan()
        }else{
            bantuan()
        }

        root.share_data_upload.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, FILE_REQUEST_CODE)
        }
        root.share_data_bagikan.setOnClickListener{
            Toast.makeText(context, "Silahkan menambahkan foto dahulu", Toast.LENGTH_SHORT).show()
        }
        root.map_backButton.setOnClickListener{
            activity?.onBackPressed()
        }
        return root
    }

    fun makanan(){
        root.share_data_title.text = "Bagikan Makanan"
        docref = db.collection("makanan").document()
        storageRef = FirebaseStorage.getInstance().reference.child(docref.id)
    }

    fun bantuan(){
        root.share_data_title.text = "Carikan Bantuan"
        root.share_data_makananLayout.visibility = View.GONE
        root.share_data_namaText.text = "Upload foto yang ingin dibantu"
        root.share_data_namaText2.text = "Siapa yang ingin dibantu?"
        docref = db.collection("bantuan").document()
        storageRef = FirebaseStorage.getInstance().reference.child(docref.id)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK){
            root.share_data_bagikan.setOnClickListener{
                val uploadTask = data?.data?.let { storageRef.putFile(it) }
                uploadTask?.addOnSuccessListener {
                    val uploadData = hashMapOf(
                        "namaPengirim" to "example",
                        "lokasi" to GeoPoint(lokasi.latitude, lokasi.longitude),
                        "catatan" to root.share_data_catatan.text.toString()
                    )
                    if(tipe == "makanan"){
                        uploadData["namaMakanan"] = root.share_data_nama.text.toString()
                        uploadData["jumlahMakanan"] = root.share_data_jumlah.text.toString()
                        uploadData["tanggal"] = root.share_data_tanggal.text.toString()
                    }else{
                        uploadData["namaPenerima"] = root.share_data_nama.text.toString()
                    }
                    uploadData["imageID"] = docref.id

                    docref.set(uploadData)
                    activity?.onBackPressed()
                    Toast.makeText(context, "TERIMAKASIH!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
