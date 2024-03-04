package melvin.gerritsen.myrecipeapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.jupiter.api.Test

// file: app/src/androidTest/java/com/package/MyComposeTest.kt

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun my_first_recipe_test() {
        composeTestRule.setContent {
            MyComposeTest()
            composeTestRule.onNode(hasText("Dessert")).performClick()

            composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
        }
    }
}



