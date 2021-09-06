package com.elliot.studying

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.elliot.studying.ui.theme.StudyingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Log.d("a", "a1")
                    HelloScreen()
                    Log.d("a", "a2")

                }
            }
        }
    }
}

class HelloViewModel : ViewModel() {
    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")

    val name: LiveData<String> = _name

    // onNameChange is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChange(newName: String) {
        _name.value = newName
        Log.d("a", "a3")

    }
}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel = viewModel()) {
    // by default, viewModel() follows the Lifecycle as the Activity or Fragment
    // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

    // name is the current value of [helloViewModel.name]
    // with an initial value of ""
    Log.d("a", "a4")

    val name: String by helloViewModel.name.observeAsState("")
    Log.d("a", "a5")

    HelloContent(name = name, onNameChange = { helloViewModel.onNameChange(it) })
    Log.d("a", "a6")

}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Log.d("a", "a7")

    Column(modifier = Modifier.padding(16.dp)) {
        Log.d("a", "a8")

        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
        Log.d("a", "a9")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudyingTheme {
        HelloScreen()
    }
}