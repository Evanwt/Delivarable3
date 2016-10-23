import com.google.common.base.Predicate;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

  //@author Tong Wei.

/*
 * As a user,
 * I want to login the webSite,
 * So that I can buy products from the webSite using my account name.
 * 
 */


public class Test1 {
	
	
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){
    	
        System.setProperty("webdriver.chrome.driver", "/users/tongwei/Documents/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 50);
        driver.get("http://store.demoqa.com/products-page/your-account/");

    }

    /**
     * Login in with nothing
     * User will not be allowed to log in;
     */

    @Test
    public void nothing(){
    	
        driver.findElement(By.id("login")).submit();
        
        wait.until((Predicate<WebDriver>) d -> {
            
        	try {
            	
                return d.findElement(By.tagName("Strong")).isDisplayed();
                
            } catch (Exception e) {
            	
                return false;
                
            }
            
        });
        
        String response = driver.findElement(By.tagName("strong")).getText();
        assertEquals("ERROR", response);
    }

    /**
     * Login in with valid username and invalid password
     * User will not be allowed to log in;
     * return null
     */

    @Test
    public void invalidpass(){
        
    	driver.findElement(By.name("log")).sendKeys("evanwei");
        driver.findElement(By.name("pwd")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();
       
        wait.until((Predicate<WebDriver>) d -> {
           
        	try {
                return d.findElement(By.tagName("Strong")).isDisplayed();
                
            } catch (Exception e) {
              
            	return false;
            }
        });
        
        String response  = driver.findElement(By.tagName("strong")).getText();
       
        assertEquals("ERROR", response);
    }

    /**
     * Login in with invalid username and valid password
     * User will not be allowed to log in;
     */

    @Test
    public void invaliduser(){
        driver.findElement(By.name("log")).sendKeys("wtong");
        driver.findElement(By.name("pwd")).sendKeys("Wt@2212599");
        driver.findElement(By.name("submit")).click();
        
        wait.until((Predicate<WebDriver>) d -> {
        	
            try {
                return d.findElement(By.tagName("Strong")).isDisplayed();
                
            } catch (Exception e) {
                return false;
            }
        });
        
        String response  = driver.findElement(By.tagName("strong")).getText();
        assertEquals("ERROR", response);
        
    }

    @After
    public void teardown(){
        driver.quit();
    }

}