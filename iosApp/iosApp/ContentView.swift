import SwiftUI
import analyticssdk

struct ContentView: View {
	let greet = "Hello iOS"
    let analyticsSdk = AnalyticsSDK()

	var body: some View {
		Text(greet)
	}
    
    init() {

        analyticsSdk.sendHeartbeat(heartbeat: Heartbeat(clientTimeStamp: InstantModel(epochSeconds: 100000, nanos: 1), profileId: "Some id"), onSuccess: {
            debugPrint("Success")
        }, onError: { error in debugPrint("Errors \(error)")})
    }
    
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
