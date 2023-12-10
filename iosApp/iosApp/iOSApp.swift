import SwiftUI
import shared
import analyticssdk

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
    
    init() {
        AnalyticsSDK().doInit(deviceProperties: DeviceProperties(deviceId: "aea9d1ee-b52", deviceType: DeviceType.smartphone, osType: "iOS", osVersion: "0000", platformType: PlatformType.mobile))
    }
}
