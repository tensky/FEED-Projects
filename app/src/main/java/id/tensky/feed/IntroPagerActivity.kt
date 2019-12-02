package id.tensky.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.tensky.feed.adapters.IntroPagerAdapter
import kotlinx.android.synthetic.main.activity_intro_pager.*

class IntroPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_pager)
        val introPagerAdapter = IntroPagerAdapter(this)
        intro_viewPager.adapter = introPagerAdapter
        supportActionBar?.hide()

        intro_loginButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        intro_signupButton.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
