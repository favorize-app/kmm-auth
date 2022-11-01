package multi.platform.auth.shared.external.utility

import android.content.Context
import android.util.Base64
import multi.platform.auth.shared.domain.user.entity.CountryCode
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.util.Locale

object CountryCodeUtil {

    private const val FLAG_PREFIX = "flag_"
    private const val FIELD_NAME = "name"
    private const val FIELD_DIAL_CODE = "dial_code"
    private const val FIELD_CODE = "code"

    fun getCountryCodes(context: Context, base64Str: String): List<CountryCode> {
        val countryCodesJsonArray = JSONArray(decodeCountryCodes(base64Str))
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

    private fun decodeCountryCodes(base64Str: String): String {
        val data = Base64.decode(base64Str, Base64.DEFAULT)
        return String(data, StandardCharsets.UTF_8)
    }

    private fun getResId(context: Context, drawableName: String): Int =
        context.resources.getIdentifier(
            drawableName, "drawable",
            context.packageName
        )
}