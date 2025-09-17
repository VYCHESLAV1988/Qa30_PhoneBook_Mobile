package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;

    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOption;

    @FindBy(xpath = "//*[@text='Logout']")
    AndroidElement logoutButton;

//================= Added for create new contact ===========================

    @FindBy(xpath = "//*[@content-desc = 'add']")
    AndroidElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<AndroidElement> contactNameList;


    public boolean isActivityTitleDisplayed(String text) {
        // return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView, text, 8);
    }


    public AuthenticationScreen logout(){
        //Added checking to text Contact list
        if(activityTextView.getText().equals("Contact list")) {
        menuOption.click();
        logoutButton.click();
        }
        return new AuthenticationScreen(driver);
    }

    public ContactListScreen isContactOpened(){
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return this;
    }

    public AddNewContactScreen openContactForm() {
        if(activityTextView.getText().equals("Contact list")) {
            plusBtn.click();
        }
        return new AddNewContactScreen(driver);
    }

    public ContactListScreen isContactAddedByName(String name, String lastName) {
        //List<AndroidElement> list = driver.findElements(By.xpath(""));
        isShouldHave(activityTextView,"Contact list",5);
        System.out.println("size of list" + contactNameList.size());
        boolean isPresent = false;

        for (AndroidElement el:contactNameList){
            if(el.getText().equals(name + " "+lastName)){
                isPresent=true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }

}
