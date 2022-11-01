package multi.platform.auth.shared.domain.user.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep

@Keep
data class CountryCode(
    val code: String,
    val dialCode: String,
    val countryName: String,
    @DrawableRes val drawableRes: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(dialCode)
        parcel.writeString(countryName)
        parcel.writeInt(drawableRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryCode> {
        override fun createFromParcel(parcel: Parcel): CountryCode {
            return CountryCode(parcel)
        }

        override fun newArray(size: Int): Array<CountryCode?> {
            return arrayOfNulls(size)
        }
    }
}