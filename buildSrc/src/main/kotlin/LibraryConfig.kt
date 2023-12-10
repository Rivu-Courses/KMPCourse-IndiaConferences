import java.text.SimpleDateFormat
import java.util.*

object LibraryConfig {

  val version = "1.0.0-"+getCalver()

  const val groupId = "dev.rivu.courses.indiaconferences.sdk"
  const val artifactIdSdk = "core"
}

private fun getCalver(): String {
  val date = Date(System.currentTimeMillis())
  val calver = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date)
  return calver
}
