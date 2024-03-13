package melvin.gerritsen.myrecipeapp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.hasTextExactly
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import androidx.navigation.compose.rememberNavController
import melvin.gerritsen.myrecipeapp.ui.theme.MyRecipeAppTheme
import org.junit.Rule
import org.junit.Test


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

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun my_second_recipe_test() {
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
//        scrollToItemInLazyColumn("Breakfast")
        composeTestRule.onNodeWithTag(Test_Tag_LazyVerticalGrid).performTouchInput { swipeUp() }
        //composeTestRule.temp_wait_function()
        composeTestRule.onNodeWithText("Breakfast").performScrollTo().performClick()

        //lazy column
//        composeTestRule.onRoot().printToLog("Hanna2")
//        composeTestRule.waitUntilExactlyOneExists(hasTextExactly("Breakfast"))
//        composeTestRule.onNodeWithText("Breakfast").assertIsDisplayed()
//        composeTestRule.onNode(hasTestTag(Test_Tag_Front_Screen) and hasText("Breakfast"))
//            .performClick()
//
        composeTestRule.waitUntilExactlyOneExists(hasText("meal", true))
//        composeTestRule.onNodeWithText("meal", true).assertIsDisplayed()
//
//
//    }
//
//    fun scrollToItemInLazyColumn(itemText: String) {
//        composeTestRule.onNodeWithContentDescription("Breakfast").performScrollTo()
//        composeTestRule.waitForIdle()
//        composeTestRule.onNodeWithText(itemText).performTouchInput { swipeUp() }
//    }
    }
}

// Testtag voor lazy column



//private fun ComposeTestRule.temp_wait_function(duration: Long = 50_000) {
// waitUntil(duration) { true == false }
//}






