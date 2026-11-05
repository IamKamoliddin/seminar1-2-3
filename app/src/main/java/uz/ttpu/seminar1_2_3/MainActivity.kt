package uz.ttpu.seminar1_2_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.seminar1_2_3.ui.theme.Seminar123Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val seminarOutput = runSeminar1Demos()
        setContent {
            Seminar123Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        SeminarScreen(output = seminarOutput)
                    }
                }
            }
        }
    }
}

@Composable
fun SeminarScreen(output: String, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Text(
        text = output,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    )
}
