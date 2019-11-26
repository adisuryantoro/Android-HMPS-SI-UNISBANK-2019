package id.seedgrow.hmps_si_unisbank

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.ColorRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_detail_club.*
import kotlinx.android.synthetic.main.content_detail_club.*

class DetailClubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_club)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(intent.getStringExtra(Constans.NAME))
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.MAGENTA)
        toolbar.setNavigationOnClickListener { view -> finish()  }

        GlideApp.with(this)
            .load(intent.getStringExtra(Constans.IMAGE))
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_activity_detail)


        tv_content_detail_description.text = intent.getStringExtra(Constans.DESCRIPTION)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
