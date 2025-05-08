//package zed.rainxch.plmayminichallenges2025
//
//import android.os.Bundle
//import android.speech.tts.TextToSpeech
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import zed.rainxch.plmayminichallenges2025.daily_word_challenge.domain.speaker.TTSManager
//import zed.rainxch.plmayminichallenges2025.daily_word_challenge.presentation.DailyWordChallenge
//import zed.rainxch.plmayminichallenges2025.ui.theme.PLMayMiniChallenges2025Theme
//
//class MainActivity : ComponentActivity() {
//
//    lateinit var ttsManager: TTSManager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        ttsManager = TTSManager(this)
//        setContent {
//            PLMayMiniChallenges2025Theme {
//                DailyWordChallenge(onSpeakClicked = {
//                    ttsManager.speak(it)
//                })
//            }
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        ttsManager.shutdown()
//    }
//}