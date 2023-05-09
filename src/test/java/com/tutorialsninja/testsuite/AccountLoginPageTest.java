package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountLoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.MyAccountRegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {

    MyAccountPage myAccountPage = new MyAccountPage();
    MyAccountRegisterPage accountRegisterPage = new MyAccountRegisterPage();
    MyAccountLoginPage accountLoginPage = new MyAccountLoginPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
        accountRegisterPage = new MyAccountRegisterPage();
        accountLoginPage = new MyAccountLoginPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        Assert.assertEquals(myAccountPage.getReturningCustomerText(), "Returning Customer", "Returning Customer Text not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link
        myAccountPage.clickOnMyAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "login"
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        accountLoginPage.enterEmailAddress();
        //4.5 Enter Password
        accountLoginPage.enterValidPassword();
        //4.6 Click on Login button
        accountLoginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        Assert.assertEquals(accountLoginPage.getMyAccountText(), "My Account", "Error Message");
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccount1();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.selectMyAccountOptions("Logout");
        // 4.10 Verify the text “Account Logout”
        Assert.assertEquals(accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        //4.11 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
    }
}
