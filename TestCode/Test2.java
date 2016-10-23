import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

	//@author Tong Wei
 
   /*
    * As a user,
    * I want to select the products that I want to buy, and put it in the shopping cart,
    * So that I know how much money I should pay.
    * 
    */
   
	 
	public class Test2 {
		
	    private WebDriver driver;
	    private WebDriverWait wait;

	    @Before
	    public void initialization(){
	    	
	        System.setProperty("webdriver.gecko.driver", "/users/tongwei/Documents/chromedriver");
	       
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver,80);
	        driver.get("http://store.demoqa.com/");
	        
	        driver.findElement(By.className("search")).sendKeys("iphone");
	        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div[3]/div[3]/form/div/div[1]/span/input")).click();
	        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	    }

	    /**
	     * 
	     * 
	     * I add a iPhone5 in my cart
	     * Click go to checkout
	     * Change Quantity to 5 and click update, Total will be 60
	     * 
	     */

	    @Test
	    public void totalCost(){
	    	
	        driver.findElement(By.className("go_to_checkout")).click();
	        
	        wait.until((Predicate<WebDriver>) d -> d.findElement(By.name("submit")).isDisplayed());
	        
	        driver.findElement(By.name("quantity")).clear();
	        driver.findElement(By.name("quantity")).sendKeys("5");
	        driver.findElement(By.name("submit")).click();
	        
	        wait.until((Predicate<WebDriver>) d -> {
	        	
	            try {
	            	
	                return d.findElement(By.name("quantity")).isDisplayed();
	                
	            } catch (Exception e) {
	            	
	                return false;
	            }
	        });
	        
	        String response = driver.findElement(By.className("pricedisplay")).getText();
	        
	        assertEquals("$60.00", response);
	    }

	    /**
	     * I add a iphone5 to my cart
	     * Click go to checkout
	     * I remove it so that cart should be empty
	     */

	    @Test
	    public void removeItems(){
	        
	    	driver.findElement(By.className("go_to_checkout")).click();
	        wait.until((Predicate<WebDriver>) d -> d.findElement(By.name("submit")).isDisplayed());
	        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[6]/form/input[4]")).click();
	       
	        wait.until((Predicate<WebDriver>) d -> {
	           
	        	try {
	        		
	                return d.findElement(By.className("entry-content")).isDisplayed();
	            } 
	        	catch (Exception e){
	                
	        		return false;
	            }
	        });
	        
	        String response = driver.findElement(By.className("entry-content")).getText();
	        assertEquals("Oops, there is nothing in your cart.", response);
	    }

	    /**
	     * 
	     * I add a iPhone5 in my cart.
	     * Click continue shopping. 
	     * I should stay at the page
	     * 
	     */

	    @Test
	    public void stay(){
	    	
	        driver.findElement(By.className("continue_shopping")).click();
	        
	        wait.until((Predicate<WebDriver>) d -> {
	            
	        	try {
	        		
	                return d.findElement(By.name("Buy")).isDisplayed();
	                
	            } catch (Exception e){
	            	
	                return false;
	            }
	        });
	        
	        String response = "String url = http://store.demoqa.com/?s=iphone&post_type=wpsc-product \n";
	        assertEquals("String url = http://store.demoqa.com/?s=iphone&post_type=wpsc-product \n", response);
	    }

	    @After
	    public void teardown(){
	    	
	        driver.quit();
	    }

	}

