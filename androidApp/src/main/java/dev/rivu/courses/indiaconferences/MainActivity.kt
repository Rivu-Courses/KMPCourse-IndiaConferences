package dev.rivu.courses.indiaconferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import dev.rivu.courses.indiaconferences.sdk.AndroidCode
import dev.rivu.courses.indiaconferences.sdk.SDK
import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem

class MainActivity : ComponentActivity() {

    var usersState = mutableStateOf(emptyList<UsersResponseItem>())

    val sdk: SDK by lazy {
        SDK()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidCode.doSomething()

        sdk.sdkCore.loadUsers(
            onSuccess = {
                usersState.value = it
            },
            onError = {

            }
        )

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    LazyColumn {
                        items(usersState.value) {
                            Text(it.name, color = Color.White)
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
