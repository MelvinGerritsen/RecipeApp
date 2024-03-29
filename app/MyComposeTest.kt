

class MyComposeTest {

        @get:Rule
        val composeTestRule = createComposeRule()
        // use createAndroidComposeRule<YourActivity>() if you need access to
        // an activity

        @Test
        fun myTest() {
            // Start the app
            composeTestRule.setContent {
                MyAppTheme {
                    MainScreen(uiState = fakeUiState, /*...*/)
                }
            }

            composeTestRule.onNodeWithText("Continue").performClick()

            composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
        }
    }
}