package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends parameters {
	
	
	WebDriver driver = new ChromeDriver();
	@BeforeTest()
	public void mySetup() {
		
		driver.manage().window().maximize();
		// انو ضمنيا استنى 3 ثواني لا تجي تحكيلي ايرور لحتى يخلصو ال 3 ثواني  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	   
	@Test(priority = 1, enabled = true)
	public void myFirstTest() throws InterruptedException {
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		
		//driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
		//driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
		driver.findElement(By.linkText("Create an Account")).click();
		
		// find the elements 
		WebElement FirstName= driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email =driver.findElement(By.id("email_address"));
		WebElement Password =driver.findElement(By.id("password"));
		WebElement confirmPassword =driver.findElement(By.id("password-confirmation"));
		
        WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
		
        // interact with the elements  
        
        FirstName.sendKeys(FirstNames[randomIndex]);
        LastName.sendKeys(LastNames[randomIndex]);
        Email.sendKeys(Emailid);
        Password.sendKeys(CommonPassword);
        confirmPassword.sendKeys(CommonPassword);
        
         createAccountButton.click();
         
        String WelcomeMsg = driver.findElement(By.className("message-success")).getText();
        
        assertEquals(WelcomeMsg, "Thank you for registering with Main Website Store.");
        
		
	}
	
	@Test(priority = 2, enabled = true)
	public void LogOut () {
		
		//interact with web site
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		// test web site
		// لانو ال log out رجعني ع ال home page مشان هيك عملت من خلال الموقع
		System.out.println(driver.getCurrentUrl());
		//contains بترجع صح او غلط 
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
		
	}
	
	@Test( priority = 3, enabled = true)
	public void LogInProcess () throws InterruptedException {
		// لما تشوف هاي الكلمة انقر 
	   driver.findElement(By.linkText("Sign In")).click();
	   driver.findElement(By.id("email")).sendKeys(Emailid);
	   driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		
		  driver.findElement(By.id("send2")).click();
		
		  driver.findElement(By.cssSelector(".greet.welcome")).getText();
		  
		     
		  System.out.println(driver.findElement(By.cssSelector(".greet.welcome")).getText());
		
		  Thread.sleep(2000);
		 String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		  
		 assertEquals(WelcomeMessage.contains("Welcome"),true);
		
		
	}
	
	@Test( priority = 4, enabled = true)
	public void addOneRandomItem () {
		
		driver.get("https://magento.softwaretestingboard.com/");
		// انا هيك طلعت عدد التاغ a بس بنهاية الصفحة footer                    name class had
		//WebElement footer = driver.findElement(By.cssSelector(".footer.content"));
		//int theNumberOfTagA = footer.findElements(By.tagName("a")).size();
		//System.out.println(theNumberOfTagA);
		//بدي اطلع عدد ال h1 بكل الصفحة 
		//int theNumberOfH1Tag = driver.findElements(By.tagName("h1")).size();
		//System.out.println(theNumberOfH1Tag + "this is the total h1 tags inside the page ");
		
		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int numberOfItems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(numberOfItems);
		
		int randomItemToSelect =rand.nextInt(4); 
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		
		
	}

}
