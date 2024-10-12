
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.medicare.auth.login.Login
import com.medicare.auth.login.LoginUiState
import org.junit.Rule
import org.junit.Test


class LoginTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun uiComponentsExist(){
        val initialState = LoginUiState(userName = "")

        composeTestRule.setContent {
            Login(state = initialState,
                onEvent = {})
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("usernameTextField").assertExists()

        composeTestRule.onNodeWithText("Login").assertExists()



    }
}