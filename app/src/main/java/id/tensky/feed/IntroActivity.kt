package id.tensky.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()
        val loginIntent = Intent(this, IntroPagerActivity::class.java)
        Handler().postDelayed({startActivity(loginIntent)}, 2000)


    }
}
