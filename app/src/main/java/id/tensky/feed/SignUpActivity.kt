package id.tensky.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        signup_backButton.setOnClickListener {
            super.onBackPressed()
        }

        signup_signupButton.setOnClickListener{
            if(signup_nama.text.isEmpty() or signup_email.text.isEmpty() or signup_noHP.text.isEmpty() or signup_password.text.isEmpty()){
                Toast.makeText(this, "Silahkan mengisi semua Field dengan benar", Toast.LENGTH_LONG).show()
            }else if(signup_passwordConfirm.text.toString() != signup_password.text.toString()){
                Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_LONG).show()
            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(signup_email.text.toString(), signup_password.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK and Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Terjadi Kesalahan!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
