package id.seedgrow.hmps_si_unisbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listClub = ArrayList<ClubModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list_club.setHasFixedSize(true)

        listClub.addAll(getListClubs())

        showRecyclerList()
    }

    private fun getListClubs(): ArrayList<ClubModel> {
        val image = resources.getStringArray(R.array.image_club)
        val name = resources.getStringArray(R.array.club_name)
        val createDate = resources.getStringArray(R.array.date_club)
        val description = resources.getStringArray(R.array.desc_club)

        val listClub = ArrayList<ClubModel>()

        for (position in image.indices){
            val dataClub = ClubModel(
                image[position],
                name[position],
                createDate[position],
                description[position]
            )
            listClub.add(dataClub)
        }
        return listClub
    }

    private fun showRecyclerList() {
        rv_list_club.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(listClub)
        rv_list_club.adapter = listClubAdapter
    }

}
