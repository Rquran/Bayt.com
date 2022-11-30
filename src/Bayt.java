import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bayt {
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	String email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
	@BeforeTest()
	public void before_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.bayt.com/en/jordan/");

	}
	@Test(priority = 0)
	public void registration_test() throws InterruptedException, IOException {
		
		 
		//open the bayt.com
		driver.manage().window().maximize();
		driver.get("https://www.bayt.com/en/jordan/");
		Thread.sleep(3000);

		 //scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)", "");
		Thread.sleep(3000);

		
		//about page
		driver.findElement(By.xpath("//*[@id=\"yw3\"]/li[1]/a")).click();
		Thread.sleep(3000);

		
		//scroll down
		js.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(3000);

		
		//click on the job
		driver.findElement(By.xpath("//html/body/section/div[2]/div/div[1]/div[1]/div/div[1]/h5/a")).click();
		Thread.sleep(3000);
		 Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
	}
	
	@Test(priority = 1)
	public void easy_apply() throws InterruptedException, IOException {
		driver.get("https://www.bayt.com/en/jordan/jobs/quality-assurance-engineer-qa-engineer-4625333/");
		//apply
		driver.findElement(By.linkText("Easy apply")).click();

		//register
	        driver.get("https://www.bayt.com/en/register-j/applicant-register/?jb_id=4625333");
			driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_firstName']")).sendKeys("Razan");
			driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_lastName']")).sendKeys("Alquran");
			driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_password']")).sendKeys("Hello@123456789");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(3000);
			driver.findElement(By.id("register")).click();
			Date currentDate =new Date();
			 String theActualDate = currentDate.toString().replace(":", "-");

		     TakesScreenshot src =((TakesScreenshot) driver);
		     File srcFile =src.getScreenshotAs(OutputType.FILE);
		     File dest = new File("./mypics/"+theActualDate+".png");
		     FileUtils.copyFile(srcFile, dest);
		     
		     //mobile phone
			
		     driver.findElement(By.xpath("//input[@id='phoneVerificationForm_cellPhone']")).sendKeys("1234567899");
		     driver.findElement(By.xpath("//form[@id='phoneVerificationID']//button[@id='submitCVForm']")).click();
		     
		     Date currentDate1 =new Date();
			 String theActualDate1 = currentDate1.toString().replace(":", "-");

		     TakesScreenshot src1 =((TakesScreenshot) driver);
		     File srcFile1 =src1.getScreenshotAs(OutputType.FILE);
		     File dest1 = new File("./mypics/"+theActualDate1+".png");
		     FileUtils.copyFile(srcFile1, dest1);
	}
	
	@Test(priority= 2)
	public void pref_job() throws IOException {
		 //preferred job
	     WebElement prejob = driver.findElement(By.xpath("//input[@id='targetJobForm_positionSought']"));
			prejob.click();		prejob.sendKeys("Quality Assurance Engineer");
			prejob.sendKeys(Keys.ARROW_DOWN);
			prejob.sendKeys(Keys.ENTER);  
			
		 WebElement loc = driver.findElement(By.xpath("//input[@id='targetJobForm_jobLocation__r']"));
		    loc.click();
			loc.sendKeys("Jordan");
			loc.sendKeys(Keys.ARROW_DOWN);
			loc.sendKeys(Keys.ENTER); 
			
			WebElement careerl = driver.findElement(By.xpath("//input[@id='targetJobForm_jobLocation__r']"));
		    careerl.click();
			careerl.sendKeys("ENTRY LEVEL");
			careerl.sendKeys(Keys.ARROW_DOWN);
			careerl.sendKeys(Keys.ENTER);
			Date currentDate =new Date();
			 String theActualDate = currentDate.toString().replace(":", "-");

		     TakesScreenshot src =((TakesScreenshot) driver);
		     File srcFile =src.getScreenshotAs(OutputType.FILE);
		     File dest = new File("./mypics/"+theActualDate+".png");
		     FileUtils.copyFile(srcFile, dest);
	     driver.findElement(By.xpath("//footer[@class='form-footer m0t p0l']//button[@id='submitCVForm']")).click();
		
		
		
	}
	@Test(priority = 3)
	public void edu_recentJob() throws IOException {
	     driver.findElement(By.xpath("//a[@id='noExp']")).click();
	     
	     //education info
	     WebElement degree = driver.findElement(By.xpath("//input[@id='EducationForm_degree__r']"));
		    degree.click();
			degree.sendKeys("Ba");
			degree.sendKeys(Keys.ARROW_DOWN);
			degree.sendKeys(Keys.ENTER);
			
			WebElement uni = driver.findElement(By.xpath("//input[@id='EducationForm_institution']"));
		    uni.click();
			uni.sendKeys("The world");
			uni.sendKeys(Keys.ARROW_DOWN);
			uni.sendKeys(Keys.ENTER);
			
			WebElement degreeLoc = driver.findElement(By.xpath("//input[@id='EducationForm_educationCountry__r']"));
		    degreeLoc.click();
			degreeLoc.sendKeys("Jo");
			degreeLoc.sendKeys(Keys.ARROW_DOWN);
			degreeLoc.sendKeys(Keys.ENTER);
			
			WebElement major = driver.findElement(By.xpath("//input[@id='EducationForm_major']"));
		    major.click();
			major.sendKeys("Business Administration");
			major.sendKeys(Keys.ARROW_DOWN);
			major.sendKeys(Keys.ENTER);
			
			WebElement gradDate = driver.findElement(By.xpath("//input[@id='EducationForm_completionMonth__r']"));
		    gradDate.click();
			gradDate.sendKeys("Ja");
			gradDate.sendKeys(Keys.ARROW_DOWN);
			gradDate.sendKeys(Keys.ENTER);
			
			WebElement gradYear = driver.findElement(By.xpath("//input[@id='EducationForm_completionYear__r']"));
		    gradYear.click();
			gradYear.sendKeys("2021");
			gradYear.sendKeys(Keys.ARROW_DOWN);
			gradYear.sendKeys(Keys.ENTER);
			Date currentDate =new Date();
			 String theActualDate = currentDate.toString().replace(":", "-");

		     TakesScreenshot src =((TakesScreenshot) driver);
		     File srcFile =src.getScreenshotAs(OutputType.FILE);
		     File dest = new File("./mypics/"+theActualDate+".png");
		     FileUtils.copyFile(srcFile, dest);
			driver.findElement(By.xpath("//footer[@class='form-footer m20t p0']//button[@id='submitCVForm']")).click();
	  

	}
	@Test(priority = 4)
	public void personal_info() throws IOException {
		WebElement birthDay = driver.findElement(By.xpath("//input[@id='personalInformationForm_birthDay__r']"));
	    birthDay.click();
		birthDay.sendKeys("4");
		birthDay.sendKeys(Keys.ARROW_DOWN);
		birthDay.sendKeys(Keys.ENTER);
		
		WebElement birthMo = driver.findElement(By.xpath("//input[@id='personalInformationForm_birthMonth__r']"));
		birthMo.click();
		birthMo.sendKeys("Ja");
		birthMo.sendKeys(Keys.ARROW_DOWN);
		birthMo.sendKeys(Keys.ENTER);
		
		WebElement birthYe = driver.findElement(By.xpath("//input[@id='personalInformationForm_birthYear__r']"));
		birthYe.click();
		birthYe.sendKeys("2000");
		birthYe.sendKeys(Keys.ARROW_DOWN);
		birthYe.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
		
		WebElement Nationalty = driver.findElement(By.xpath("//input[@id='personalInformationForm_nationalityCitizenAc__r']"));
		Nationalty.click();
		Nationalty.sendKeys("Jo");
		Nationalty.sendKeys(Keys.ARROW_DOWN);
		Nationalty.sendKeys(Keys.ENTER);
		
		WebElement resCountry = driver.findElement(By.xpath("//footer[@class='form-footer m0t p0l']//button[@id='submitCVForm']"));
		resCountry.click();
		resCountry.sendKeys("Jo");
		resCountry.sendKeys(Keys.ARROW_DOWN);
		resCountry.sendKeys(Keys.ENTER);
		Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
		driver.findElement(By.xpath("//div[@id='cSection']//div[@class='m']//button[@id='submitCVForm']")).click();

		
	}
	
	@Test()
	public void login() throws InterruptedException, IOException {
		String email ="razanalquran4411@gmail.com";
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		driver.findElement(By.xpath("//input[@id='LoginForm_username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='LoginForm_password']")).sendKeys("123456789");
		Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
		driver.findElement(By.xpath("//button[@id='login-button']")).click();
		Thread.sleep(3000);

		    //check the email
		driver.findElement(By.xpath("//a[normalize-space()='Dashboard']")).click();
		Thread.sleep(3000);
		String checkEmail = driver.findElement(By.xpath("//*[@id=\"email_verified\"]/p")).getText();
		Assert.assertEquals(email, checkEmail);
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void delete_acc() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//li[@data-popover='{\"trigger\":\"click\"}']//a[@href='#']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Account Settings']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(2000);
		Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
		driver.findElement(By.xpath("//a[normalize-space()='Delete My Account']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete My Account']")).click();
		Date currentDate1 =new Date();
		 String theActualDate1 = currentDate1.toString().replace(":", "-");

	     TakesScreenshot src1 =((TakesScreenshot) driver);
	     File srcFile1 =src1.getScreenshotAs(OutputType.FILE);
	     File dest1 = new File("./mypics/"+theActualDate1+".png");
	     FileUtils.copyFile(srcFile1, dest1);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();

	}
	
	@Test(priority=6)
	public void check_delete() throws IOException {
		
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		driver.findElement(By.xpath("//input[@id='LoginForm_username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='LoginForm_password']")).sendKeys("123456789");
		Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
		driver.findElement(By.xpath("//button[@id='login-button']")).click();
		String expMsg = "You've entered an incorrect email or password, please try again.";
		String deleteTheAcc = driver.findElement(By.xpath("//*[@id=\"yw1_es_\"]/ul/li")).getText();
		Assert.assertEquals(deleteTheAcc, expMsg);
		
		
	}
	
	
	@Test(priority=7)
	public void mobile_site() throws IOException {
		
		WebElement jobTitle = driver.findElement(By.xpath("//form[@class='t-left m']//input[@placeholder='Enter job title, skills, etc.']"));
		jobTitle.click();
		jobTitle.sendKeys("Quality Assurance Engineer");
		jobTitle.sendKeys(Keys.ARROW_DOWN);
		jobTitle.sendKeys(Keys.ENTER);
		
		WebElement jobLoc = driver.findElement(By.xpath("//div[@class='select in-pack searchable popover-owner']//input[@placeholder='Select Country']"));
		jobLoc.click();
		jobLoc.sendKeys("United");
		jobLoc.sendKeys(Keys.ARROW_DOWN);
		jobLoc.sendKeys(Keys.ENTER);
		Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
		driver.findElement(By.xpath("//button[@class='btn is-large in-pack']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Quality Assurance Engineer- Sharjah']")).click();
		
		driver.findElement(By.xpath("//section//div//div//div//div//div//a[@rel='nofollow'][normalize-space()='Apply on company site']")).click();
		String expMsg ="Register now and apply to thousands of jobs in the Middle East ";
		String actMsg = driver.findElement(By.xpath("//p[contains(text(),'Register now and apply to thousands of jobs in the')]")).getText();
		Assert.assertEquals(actMsg, expMsg);
		Date currentDate1 =new Date();
		 String theActualDate1 = currentDate1.toString().replace(":", "-");

	     TakesScreenshot src1 =((TakesScreenshot) driver);
	     File srcFile1 =src1.getScreenshotAs(OutputType.FILE);
	     File dest1 = new File("./mypics/"+theActualDate1+".png");
	     FileUtils.copyFile(srcFile1, dest1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
