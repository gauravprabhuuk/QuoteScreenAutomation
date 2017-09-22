package ValtechTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValtechTest {
	
	public static void main(String[] args) 
	{
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Run_Test\\chromedriver.exe");
 		driver =new ChromeDriver();
 		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String appUrl = "https://www.valtech.com/";
		driver.get(appUrl);
		System.out.println("Successfully opened the website www.valtech.com"+"\n");

		//Question 1 Is News Displayed
		
		//verify whether 'Latest news' text is present in the web page or not
        String expText = "Latest news"; 
        
        String pageSource = driver.getPageSource();
        if(pageSource.contains(expText)){
            System.out.println("Expected text '"+expText+"' is present on the web page."+"\n");
        }else{
            System.out.println("Expected text '"+expText+"' is not present on the web page."+"\n");
        }


        //Question 2 Click Links
        String a[] = { "ABOUT", "WORK", "SERVICES"};
		for (int i = 1; i < 4; i++) 
		{
			driver.findElement(By.xpath(".//*[@id='navigationMenuWrapper']/div/ul/li[" + i + "]/a/span")).click();
			org.junit.Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='container']//following::h1")).getText().equalsIgnoreCase(a[i - 1]));
			System.out.println("Click Succesful & the H1 Tage is Present for  "+a[i-1]);
		}
        
		//Question 3 Count of the total Offices
		 driver.findElement(By.xpath(".//*[@id='contacticon']/div/div/div[1]/i")).click();
		 List<WebElement> totaloffices = driver.findElements(By.xpath("//*[@id=\"contactbox\"]/div/div/ul/li"));
		 System.out.println("Total Offices "+totaloffices.size());
 
 
		driver.navigate().back();
		
 
		driver.close();
	}

	
	
}
