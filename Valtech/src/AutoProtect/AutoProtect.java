package AutoProtect;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtils;
import utility.Constant;


public class AutoProtect {

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		WebDriver driver;
		//int i = get(ExcelUtils.Cell);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Run_Test\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//String appUrl = "https://www.moneysupermarket.com/shop/car-insurance/questionset/#?step=highimpactquestions";
		driver.get(Constant.URL);
		System.out.println("Successfully opened the website MoneySuperMarket" + "\n");

		String HouseNumber = ExcelUtils.getCellData(1, 1);
		//String PostCode = ExcelUtils.getCellData(1, 2);
		
		driver.findElement(By.xpath("//*[@id=\"knownRegnumber\"]/div[2]/div[2]/span[2]/label")).click();

		System.out.println("Successfully Clicked 1" + "\n");

		driver.findElement(By.xpath("//*[@id=\"makeSelection\"]/div[2]/div/label[2]")).click();
		System.out.println("Successfully Clicked 2" + "\n");

		driver.findElement(By.xpath("//*[@id=\"modelSelection\"]/div[2]/div/label[1]")).click();
		System.out.println("Successfully Clicked 3" + "\n");

		driver.findElement(By.xpath("//*[@id=\"fuelSelection\"]/div[2]/div/label[1]")).click();
		System.out.println("Successfully Clicked 4" + "\n");

		driver.findElement(By.xpath("//*[@id=\"transmissionSelection\"]/div[2]/div/label[1]")).click();
		System.out.println("Successfully Clicked 5" + "\n");

		Select value1 = new Select(driver.findElement(By.xpath("//*[@id=\"registrationYearSelection\"]/div[2]/div/div/select")));
		value1.selectByVisibleText("2016 (65, 16, 66)");
		System.out.println("Drop Down Registration Year Selected" + "\n");

		driver.findElement(By.xpath("//*[@id=\"engineSizeSelection\"]/div[2]/div/label[1]")).click();
		System.out.println("Engine Size Selection Selected" + "\n");

		driver.findElement(By.xpath("//*[@id=\"vehicleSelection\"]/div[2]/div/label[1]")).click();
		System.out.println("Vehicle Selected" + "\n");

		driver.findElement(By.xpath("//*[@id=\"findCar\"]")).click();
		System.out.println("Car Confirmed" + "\n");

		driver.findElement(By.xpath("//*[@id=\"houseNumber\"]")).sendKeys(HouseNumber);
		System.out.println("House Number Entered" + "\n");
		
		//driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(PostCode);
		//System.out.println("Post Code Entered" + "\n");
		ExcelUtils.setCellData("Pass", 1, 3);
		
		driver.close();

	}

}
