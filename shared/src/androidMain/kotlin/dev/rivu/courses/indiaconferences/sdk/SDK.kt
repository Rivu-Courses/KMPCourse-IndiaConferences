package dev.rivu.courses.indiaconferences.sdk

import dev.rivu.courses.indiaconferences.sdk.network.NetworkComponent
import dev.rivu.courses.indiaconferences.sdk.network.create
import me.tatarka.inject.annotations.Component


@Component
internal abstract class SDKComponentAndroid(
    @Component val networkComponent: NetworkComponent
): SDKComponent {

}

public class SDK {
    val sdkCore: SDKCore

    init {
        sdkCore = SDKComponentAndroid::class.create(
            NetworkComponent::class.create()
        ).sdk
    }
}