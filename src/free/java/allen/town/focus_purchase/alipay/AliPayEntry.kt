package allen.town.focus_purchase.alipay

import android.os.Parcel
import android.os.Parcelable

data class AliPayEntry(val subId: String?, val subject: String?, val body: String?, val totalAmount: String?, val expiredTime: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(subId)
        parcel.writeString(subject)
        parcel.writeString(body)
        parcel.writeString(totalAmount)
        parcel.writeString(expiredTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AliPayEntry> {
        override fun createFromParcel(parcel: Parcel): AliPayEntry {
            return AliPayEntry(parcel)
        }

        override fun newArray(size: Int): Array<AliPayEntry?> {
            return arrayOfNulls(size)
        }


    }
}