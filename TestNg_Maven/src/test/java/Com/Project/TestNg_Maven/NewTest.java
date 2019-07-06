package Com.Project.TestNg_Maven;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class NewTest {
  WebDriver driver;
	
  @BeforeTest
  public void LaunchtheBrowser(){
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }
  
  @Test
  public void launch_the_WebSite(){
  
	  	 driver.get("http://www.shop.demoqa.com");// enter the Url
		 
		 driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");//navigate to product page
		 
		 
		 List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		 items.get(0).click();// select the first product in the
		 
		//select the color
		 WebElement color_ss= driver.findElement(By.id("pa_color"));
		 Select color= new Select(color_ss);
		 color.selectByVisibleText("White");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
  }
  
  @Test
  public void select_the_item()
  {
		 
	  	System.out.println(driver.getTitle());
	  	
		 // select the Size
		 WebElement size_ss= driver.findElement(By.id("pa_size"));
		 Select size= new Select(size_ss);
		 size.selectByVisibleText("Medium");
		 
		 // click on add to cart
		 WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		 addToCart.click(); 
		 
		 // click on view cart button
		 WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		 cart.click();
		 
		// click on proceed to checkout
		 driver.findElement(By.cssSelector(".checkout-button.alt"));
		 
  }
  
  @Test
  public void payment_details(){
		// enter first name
		 WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		 firstName.sendKeys("Lakshay");
			 
		// enter last name
		 WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
			 lastName.sendKeys("Sharma");
			 
			 // enter email
			 WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
			 emailAddress.sendKeys("test@gmail.com");
			 
			 // entermobilenumber
			 WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
			 phone.sendKeys("07438862327");
			 
			// enter city name
			 WebElement city = driver.findElement(By.cssSelector("#billing_city"));
			 city.sendKeys("Delhi");
			 
			 // enter the address 
			 WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
			 address.sendKeys("Shalimar Bagh");
			 
			 // enter the pincode
			 WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
			 postcode.sendKeys("110088"); 
			 /*
			 WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
			 shipToDifferetAddress.click();
			 Thread.sleep(3000);
			 
			 List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
			 paymentMethod.get(0).click();
			 */
			 // click on terms and conditions check box
			 WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
			 acceptTC.click();
			 
			 // click on place order button
			 WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
			 placeOrder.submit();
  }
  
  @Test
  public void title_validation()
  {
	  System.out.println(driver.getTitle());
  }
  
  @Test
  public void print_the_Url()
  {
	  System.out.println(driver.getCurrentUrl());
  }
  
  @AfterTest
  public void TearDown()
  {
  
  driver.quit();
  
  }

}
