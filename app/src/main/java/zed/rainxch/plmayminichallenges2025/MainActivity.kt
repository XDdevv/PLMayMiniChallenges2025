package zed.rainxch.plmayminichallenges2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import zed.rainxch.plmayminichallenges2025.core.ui.theme.PLMayMiniChallenges2025Theme
import zed.rainxch.plmayminichallenges2025.scrollable_study_content.presentation.navigation.ScrollableStudyAppNavigation
import zed.rainxch.plmayminichallenges2025.searchable_study_list.presentation.SearchableStudyListScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLMayMiniChallenges2025Theme {
                SearchableStudyListScreen()
            }
        }
    }

}