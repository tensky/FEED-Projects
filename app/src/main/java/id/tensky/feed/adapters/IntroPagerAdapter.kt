package id.tensky.feed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import id.tensky.feed.R

class IntroPagerAdapter(val context : Context) : PagerAdapter() {
    val layoutInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val imageList = intArrayOf(
        R.drawable.ic_intropager_1,
        R.drawable.ic_intropager_2,
        R.drawable.ic_intropager_3,
        R.drawable.ic_intropager_4
    )
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return 4
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.item_intro_pager, container, false)
        val imageView = itemView.findViewById(R.id.intro_item) as ImageView
        Glide.with(context).load(imageList[position]).into(imageView)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}