
import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author Tong Wei
 */
public class Test3 {
	
	
    private WebDriver driver;
    private WebDriverWait wait;

    
    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "/users/tongwei/Documents/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 50);
        driver.get("http://store.demoqa.com/");
    }

    /**
     * Search any words
     * There will be no result
     */

    @Test
    public void searchAnywords() {
    	
        driver.findElement(By.className("search")).sendKeys("any words");
        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
        
        wait.until((Predicate<WebDriver>) d -> {
           
        	try {
                return d.findElement(By.id("content")).isDisplayed();
          
        	} catch (Exception e) {
             
        		return false;
            }
        });
        
        String response = driver.findElement(By.id("content")).getText();
        assertEquals(response, "Sorry, but nothing matched your search criteria. Please try again with some different keywords.");
    }

    /**
     * Search iPad There will be 3 results
     * 
     */

    @Test
    public void searchiPad() {
        
    	driver.findElement(By.className("search")).sendKeys("iPad");
        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
        
        wait.until((Predicate<WebDriver>) d -> {
         
        	try {
                return d.findElement(By.id("grid_view_products_page_container")).isDisplayed();
           
        	} catch (Exception e) {
               
        		return false;
            }
        });
        
        
        List<WebElement> allItems;
        allItems = driver.findElement(By.id("grid_view_products_page_container")).findElements(By.className("grid_product_info"));
      
        for (WebElement option : allItems) {
           
        	option.findElement(By.tagName("a"));
        	
        }
        assertTrue(allItems.size() == 3);
    }

    /**
     * Search iPhone, there will be 5 results
     */

    @Test
    public void searchIphone() {
    	
        driver.findElement(By.className("search")).sendKeys("iphone");
        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
        
        wait.until((Predicate<WebDriver>) d -> {
        	
            try {
               
            	return d.findElement(By.id("grid_view_products_page_container")).isDisplayed();
            
            }
              
           catch (Exception e) {
                
            	return false;
            }
            
        });
        
        List<WebElement> allItems;
        
        allItems = driver.findElement(By.id("grid_view_products_page_container")).findElements(By.className("grid_product_info"));
        
        for (WebElement option : allItems) {
           
        	option.findElement(By.tagName("a"));
        	
        }
        
        assertTrue(allItems.size() == 5);
    }

    @After
    public void teardown() {
    	
        driver.quit();
    }
}
