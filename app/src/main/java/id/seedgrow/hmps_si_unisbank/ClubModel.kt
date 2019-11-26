package id.seedgrow.hmps_si_unisbank

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubModel(
        var image: String? = null,
        var name: String? = null,
        var createdate: String? = null,
        var description: String? = null
): Parcelable