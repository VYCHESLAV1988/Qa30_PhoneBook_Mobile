package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;


public class LoginTestsSecond extends AppiumConfig {

    @Test
    public void loginSusses(){
    new AuthenticationScreen(driver)
        .fillEmail("margo@gmail.com")
        .fillPassword("Mmar123456$")
            .submitLogin()
                .isContactOpened()
            .logout();
    }

        @Test
        public void loginModelSusses(){
            new AuthenticationScreen(driver)
                    .fillLoginRegistrationForm(Auth.builder()
                            .email("margo@gmail.com")
                            .password("Mmar123456$").build()) //Auth and to  building
                    .submitLogin()
                    .isContactOpened()
                    .logout();
        }

}
