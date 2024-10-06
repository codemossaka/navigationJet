package ru.godsonpeya.navigationjet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.godsonpeya.navigationjet.navigation.AppNavigation.PAGE_ONE
import ru.godsonpeya.navigationjet.navigation.AppNavigation.PAGE_TWO
import ru.godsonpeya.navigationjet.screens.PageOne
import ru.godsonpeya.navigationjet.screens.PageTwo

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = PAGE_ONE) {
        composable(PAGE_ONE) {
            PageOne(navController)
        }
        composable(
            "$PAGE_TWO/{id}/{title}",
            arguments = listOf(
                navArgument("id") { type = androidx.navigation.NavType.LongType },
                navArgument("title") { type = androidx.navigation.NavType.StringType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong("id")
            requireNotNull(id) { "id parameter wasn't found. Please make sure it's set!" }
            PageTwo(navController, songId = id)
        }

    }
}