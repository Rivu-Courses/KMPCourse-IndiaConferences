import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object SDKConfig {
    val sdkName = "india-conferences"
    val version = "0.0.1-"+getCalVer()

    object Android {
        val minSdk = 21
        val targetSdk = 33
        val compileSdk = 33
    }

    private fun getCalVer(): String {
        val date = Date()
        val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val calver = formatter.format(date)
        println("Version $calver")
        return calver
    }
}