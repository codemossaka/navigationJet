package ru.godsonpeya.navigationjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import ru.godsonpeya.navigationjet.navigation.AppNavHost
import ru.godsonpeya.navigationjet.ui.theme.NavigationJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavigationJetTheme {
                AppNavHost(navController = navController)
            }
        }
    }
}
