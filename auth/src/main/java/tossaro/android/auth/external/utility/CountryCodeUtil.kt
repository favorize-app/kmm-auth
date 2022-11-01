package tossaro.android.auth.external.utility

import android.content.Context
import android.util.Base64
import org.json.JSONArray
import org.json.JSONObject
import tossaro.android.auth.R
import tossaro.android.auth.domain.user.entity.CountryCode
import java.nio.charset.StandardCharsets
import java.util.*

object CountryCodeUtil {

    const val FLAG_PREFIX = "flag_"
    const val FIELD_NAME = "name"
    const val FIELD_DIAL_CODE = "dial_code"
    const val FIELD_CODE = "code"

    fun getCountryCodes(context: Context): List<CountryCode> {
        val countryCodesJsonArray = JSONArray(decodeCountryCodes(context))
        val sizeofCountryCodes: Int = countryCodesJsonArray.length()
        return (0 until sizeofCountryCodes).map { index ->
            val jsonObject: JSONObject = countryCodesJsonArray.getJSONObject(index)
            val countryName = jsonObject.getString(FIELD_NAME)
            val countryDialCode = jsonObject.getString(FIELD_DIAL_CODE)
            val countryCode = jsonObject.getString(FIELD_CODE)
            val drawableName =
                "$FLAG_PREFIX${countryCode.lowercase(Locale.ENGLISH)}"
            CountryCode(
                countryCode,
                countryDialCode,
                countryName,
                getResId(context, drawableName)
            )
        }
    }

    private fun decodeCountryCodes(context: Context): String {
        val base64 = context.resources.getString(R.string.country_codes_list)
        val data = Base64.decode(base64, Base64.DEFAULT)
        return String(data, StandardCharsets.UTF_8)
    }

    private fun getResId(context: Context, drawableName: String): Int =
        context.resources.getIdentifier(
            drawableName, "drawable",
            context.packageName
        )
}