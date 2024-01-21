package dev.rivu.courses.indiaconferences.sdk

@OptIn(ExperimentalJsExport::class)
@JsExport
data class Users(
    val address: Address,
    val company: Company,
    val email: String, // Sincere@april.biz
    val id: Int, // 1
) {
    data class Address(
        val city: String, // Gwenborough
        val geo: Geo,
        val street: String, // Kulas Light
    ) {
        data class Geo(
            val lat: String, // -37.3159
            val lng: String // 81.1496
        )
    }

    data class Company(
        val name: String // Romaguera-Crona
    )
}

@OptIn(ExperimentalJsExport::class)
@JsExport
object JsSDK {
//    private val sdk = SDKCore()

    fun loadUsers(
        onSuccess: (Array<Users>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        /*sdk.loadUsers(
            onSuccess = {
                val array = it.map { user ->
                    Users(
                        address = Users.Address(
                            city = user.address.city,
                            geo = Users.Address.Geo(
                                lat = user.address.geo.lat,
                                lng = user.address.geo.lng
                            ),
                            street = user.address.street
                        ),
                        company = Users.Company(
                            name = user.company.name
                        ),
                        email = user.email,
                        id = user.id
                    )
                }.toTypedArray()
                onSuccess(array)
            },
            onError = onError
        )*/
    }
}