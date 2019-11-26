package id.seedgrow.hmps_si_unisbank

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_football_club.view.*

class ListClubAdapter (private val listClubs: ArrayList<ClubModel>): RecyclerView.Adapter<ListClubAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_football_club, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listClubs[position])
    }

    override fun getItemCount(): Int = listClubs.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(clubModel: ClubModel){
            with(itemView){
                GlideApp.with(itemView.context)
                    .load(clubModel.image)
                    .apply(RequestOptions().override(120, 120))
                    .into(iv_logo_club)

                tv_name_club.text = clubModel.name
                tv_create_club.text = clubModel.createdate

                cv_item_football_club.setOnClickListener {
                    val intent = Intent(itemView.context, DetailClubActivity::class.java)
                    intent.putExtra(Constans.IMAGE, clubModel.image)
                    intent.putExtra(Constans.NAME, clubModel.name)
                    intent.putExtra(Constans.CREATEDATE, clubModel.createdate)
                    intent.putExtra(Constans.DESCRIPTION, clubModel.description)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

}