package melvin.gerritsen.myrecipeapp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.hasTextExactly
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.navigation.compose.rememberNavController
import melvin.gerritsen.myrecipeapp.ui.theme.MyRecipeAppTheme
import org.junit.Rule
import org.junit.Test

//make some changes feature_branche_2 github
//make a new branch in NS language
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
//        composeTestRule
//            .onAllNodesWithContentDescription("Beef").assertAny(hasTestTag("Beef"))

        composeTestRule.waitUntilExactlyOneExists(hasTextExactly("Beef"))
        composeTestRule.onNodeWithText("Beef").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(Test_Tag_Front_Screen) and hasText("Beef"))
            .performClick()
//            composeTestRule.temp_wait_function()
        composeTestRule.waitUntilExactlyOneExists(hasText("meat", true))
        composeTestRule.onNodeWithText("meat", true).assertIsDisplayed()


    }

    class Scroll_To_Breakfast {

        @get:Rule
        val composeTestRule = createComposeRule()
        private val viewIdToScrollTo = Scroll_To_Breakfast()

        @OptIn(ExperimentalTestApi::class)
        @Test
        fun my_second_recipe_test() {
            composeTestRule.setContent {
                val navController = rememberNavController()
                MyRecipeAppTheme {
                    RecipeApp(navController = navController)
                }
            }
            composeTestRule.onNodeWithText("Breakfast").performScrollTo()
            composeTestRule.waitUntilExactlyOneExists(hasTextExactly("Breakfast"))
            composeTestRule.onNodeWithText("Breakfast").assertIsDisplayed()
            composeTestRule.onNode(hasTestTag(Test_Tag_Front_Screen) and hasText("Breakfast"))
                .performClick()
            composeTestRule.waitUntilExactlyOneExists(hasText("meal", true))
            composeTestRule.onNodeWithText("meal", true).assertIsDisplayed()


        }
    }
}




//private fun ComposeTestRule.temp_wait_function(duration: Long = 50_000) {
//    waitUntil(duration) { true == false }
//}






