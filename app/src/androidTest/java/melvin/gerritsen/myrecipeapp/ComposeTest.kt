package melvin.gerritsen.myrecipeapp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.hasTextExactly
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.navigation.compose.rememberNavController
import melvin.gerritsen.myrecipeapp.ui.theme.MyRecipeAppTheme
import org.junit.Rule
import org.junit.Test


// file: app/src/androidTest/java/com/package/MyComposeTest.kt

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun my_first_recipe_test() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            MyRecipeAppTheme {
                RecipeApp(navController = navController)
            }
        }

//            composeTestRule.temp_wait_function()
            composeTestRule.waitUntilExactlyOneExists(hasTextExactly("Beef"))
            composeTestRule.onNodeWithText("Beef").assertIsDisplayed()
            composeTestRule.onNodeWithText("Beef").assertHasClickAction().performClick()
//            composeTestRule.temp_wait_function()
            composeTestRule.onRoot().printToLog("Hanna")
            composeTestRule.waitUntilExactlyOneExists(hasText("meat", true))

            composeTestRule.onNodeWithText("meat", true).assertIsDisplayed()


    }
}

private fun ComposeTestRule.temp_wait_function(duration: Long = 50_000) {
    waitUntil(duration) { true == false }
}






