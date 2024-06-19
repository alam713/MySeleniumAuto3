package factory3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory3 {

	private WebDriver driver;
	  
	  @FindBy(id = "username")
	    private WebElement usernameField;

	    @FindBy(id = "password")
	    private WebElement passwordField;

	    @FindBy(id = "submit")  
	    private WebElement loginButton;
	    
	    //below is the constructor so that object of the class is created.    
	    
	    public PageFactory3(WebDriver driver) {
	        this.driver = driver;
	        // Initialize elements with PageFactory this is built in 
	        PageFactory.initElements(driver, this);
	    }
	    
	    // Page Actions
	    public void enterUsername(String username) {
	        usernameField.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        loginButton.click();
	    }

	    public String getCurrentUrl() {
	        return driver.getCurrentUrl();
	    }
	
}
