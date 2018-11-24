package winAdmin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Constants;

public class Supplier extends Constants{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	GeneralClass call = new GeneralClass();
	
	@BeforeClass
	public void Login()
	{		
		System.setProperty("webdriver.chrome.driver", "D:/Balaji Testing/Browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(config.getProperty("Admin_Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Excegution() {

	///  Adding new Product	
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ArrayList<String> ProductTitle = this.Languagechange(config.getProperty("Prod_ProdNameEng"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ArrayList<String> ProductDesc = this.Languagechange(config.getProperty("Prod_ProdDescEng"));
		this.loginadmin();
		this.AddProduct( ProductTitle,ProductDesc );
	
	//// Creating New Auction	
		
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		ArrayList<String> AuctionTitle = this.Languagechange(config.getProperty("Auc_AucTitle"));
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		ArrayList<String> AuctionDesc = this.Languagechange(config.getProperty("Auc_AucDescr"));
//		this.loginadmin();
//		this.CreateAuction( AuctionTitle,AuctionDesc );

	///// Adding New Supplier
//		
//		this.loginadmin();
//		this.AddSupplier();
		
		
		
	}
	
	@Test(enabled = false)
	public ArrayList<String> Languagechange(String langchange){
		ArrayList<String> numbers = new ArrayList<String>();

	    driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("english to russian translation  ");
		driver.findElement(By.name("btnK")).click();
		
		Select dropdownlang = new Select(driver.findElement(By.id("tw-sl")));
		dropdownlang.selectByVisibleText("English");
		driver.findElement(By.id("tw-source-text-ta")).sendKeys(langchange);
		numbers.add(langchange);
		Select dropdownlangtr = new Select(driver.findElement(By.id("tw-tl")));
		dropdownlangtr.selectByVisibleText("Russian");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		numbers.add(driver.findElement(By.id("tw-target-text")).getText());
		
		dropdownlangtr.selectByVisibleText("German");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		numbers.add(driver.findElement(By.id("tw-target-text")).getText());
		
		dropdownlangtr.selectByVisibleText("French");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		numbers.add(driver.findElement(By.id("tw-target-text")).getText());
		
		dropdownlangtr.selectByVisibleText("Italian");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		numbers.add(driver.findElement(By.id("tw-target-text")).getText());
		
		dropdownlangtr.selectByVisibleText("Spanish");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		numbers.add(driver.findElement(By.id("tw-target-text")).getText());
		
		return(numbers);
	}
	
	
	@Test(enabled = false)
	public void AddProduct(ArrayList<String>LangProductTitle , ArrayList<String> LangProductDesc){
		
		driver.findElement(By.xpath(".//*[@id='menu-content']/li[4]/a")).click();
		driver.findElement(By.xpath(".//*[@id='10']/a[1]/li")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("product_name")).sendKeys(LangProductTitle.get(0));
		driver.findElement(By.name("product_name_ru")).sendKeys(LangProductTitle.get(1));
		driver.findElement(By.name("product_name_ge")).sendKeys(LangProductTitle.get(2));
		driver.findElement(By.name("product_name_fr")).sendKeys(LangProductTitle.get(3));
		driver.findElement(By.name("product_name_it")).sendKeys(LangProductTitle.get(4));
		driver.findElement(By.name("product_name_sp")).sendKeys(LangProductTitle.get(5));
		Select Category = new Select(driver.findElement(By.id("category")));
		Category.selectByVisibleText(config.getProperty("Prod_SelCategory"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("images")).sendKeys(config.getProperty("Prod_Image"));
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_1_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(0));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_2_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(1));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_3_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(2));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_4_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(3));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_5_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(4));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_6_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangProductDesc.get(5));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		driver.findElement(By.xpath(".//*[@id='divsupplier']/div/div/button")).click();
		driver.findElement(By.xpath(".//*[@id='divsupplier']/div/div/div/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.name("retail_price")).sendKeys(config.getProperty("Prod_RetPrice"));
		driver.findElement(By.name("handling_fee")).sendKeys(config.getProperty("Prod_HandFee"));
		driver.findElement(By.id("start_date")).sendKeys(config.getProperty("Prod_AvilStatDate"));
		driver.findElement(By.id("end_date")).sendKeys(config.getProperty("Prod_AvilEndDate"));
		driver.findElement(By.id("end_date")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("btnaddProduct")).click();
	}
	
	@Test(enabled = false)
	public void loginadmin(){
		
		driver.get(config.getProperty("Admin_Url"));
		driver.manage().window().maximize();	
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(config.getProperty("Admin_email"));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(config.getProperty("Admin_Password"));
		driver.findElement(By.name("id")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void CreateAuction(ArrayList<String>LangAuctionTitle , ArrayList<String> LangAuctionDesc){
		
		driver.findElement(By.xpath(".//*[@id='menu-content']/li[5]/a")).click();
		driver.findElement(By.xpath(".//*[@id='13']/a[1]/li")).click();
		driver.findElement(By.id("product_name")).sendKeys(LangAuctionTitle.get(0));
		driver.findElement(By.id("product_name_ru")).sendKeys(LangAuctionTitle.get(1));
		driver.findElement(By.id("product_name_ge")).sendKeys(LangAuctionTitle.get(2));
		driver.findElement(By.id("product_name_fr")).sendKeys(LangAuctionTitle.get(3));
		driver.findElement(By.id("product_name_it")).sendKeys(LangAuctionTitle.get(4));
		driver.findElement(By.id("product_name_sp")).sendKeys(LangAuctionTitle.get(5));
		driver.findElement(By.id("date_added")).sendKeys(config.getProperty("Auc_StartDate"));
		driver.findElement(By.id("date_added")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("date_closed")).sendKeys(config.getProperty("Auc_EndDate"));
		driver.findElement(By.id("date_closed")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[8]/div/div/button")).click();
//		Select Category = new Select(driver.findElement(By.id("product_category")));
//		Category.selectByVisibleText(config.getProperty("Auc_SelCateg"));
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[8]/div/div/div/div[2]/div/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[8]/div/div/button")).click();
		
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[9]/div/div/button")).click();
//		Select Products = new Select(driver.findElement(By.id("products")));
//		Products.selectByVisibleText(config.getProperty("Auc_SelProduct"));
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[9]/div/div/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/form/div/div[9]/div/div/button")).click();
		driver.findElement(By.id("mprice")).clear();
		driver.findElement(By.id("mprice")).sendKeys(config.getProperty("Auc_RetlPrice"));
		driver.findElement(By.id("handling_fees")).clear();
		driver.findElement(By.id("handling_fees")).sendKeys(config.getProperty("Auc_HandFee"));
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_1_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(0));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_2_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(1));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_3_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(2));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_4_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(3));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_5_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(4));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		try{
			WebElement frame = driver.findElement(By.xpath(".//*[@id='cke_6_contents']/iframe"));
			driver.switchTo().frame(frame);
			driver.findElement(By.tagName("body")).sendKeys(LangAuctionDesc.get(5));
			driver.switchTo().defaultContent();
			}catch(Exception e){
				System.out.println(e);
			}
		
		driver.findElement(By.id("images")).sendKeys(config.getProperty("Auc_Image"));
		driver.findElement(By.id("reset_time")).sendKeys(config.getProperty("Auc_ResetTime"));
		driver.findElement(By.id("bid_increment")).sendKeys(config.getProperty("Auc_BidIncrement"));
		driver.findElement(By.id("bid_multiplier")).sendKeys(config.getProperty("Auc_BidMultipliler"));
		driver.findElement(By.id("rprice")).sendKeys(config.getProperty("Auc_ReservePrice"));
		driver.findElement(By.name("max_asp")).sendKeys(config.getProperty("Auc_MaxiASP"));
		driver.findElement(By.name("sprice")).sendKeys(config.getProperty("Auc_Startprice"));
		Select FeaAuction = new Select(driver.findElement(By.id("feature")));
		FeaAuction.selectByVisibleText(config.getProperty("Auc_FeatureAuction"));
		
		driver.findElement(By.name("lock_bid")).sendKeys(config.getProperty("Auc_LockOutBid"));
		driver.findElement(By.id("lock_time")).sendKeys(config.getProperty("Auc_LockOutTime"));
		driver.findElement(By.id("lock_time")).sendKeys(Keys.ENTER);
		boolean i;
		i = true;
		if(i == true){
		driver.findElement(By.id("buynow")).click();
		driver.findElement(By.id("bqty")).sendKeys(config.getProperty("Auc_BuynowQuantity"));
		driver.findElement(By.id("bprice")).sendKeys(config.getProperty("Auc_BuynowPrice"));
		}
		driver.findElement(By.id("btnsubmitAuction")).click();
		
		
	}
	
	
	
	@Test(enabled = false)
	public void AddSupplier(){
		
		driver.findElement(By.xpath(".//*[@id='menu-content']/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='2']/a[1]/li")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("company_name")).clear();
		driver.findElement(By.name("company_name")).sendKeys(config.getProperty("Supp_CompName"));
		driver.findElement(By.name("first_name")).sendKeys(config.getProperty("Supp_FirstName"));
		driver.findElement(By.name("last_name")).sendKeys(config.getProperty("Supp_LastName"));
		driver.findElement(By.name("email")).sendKeys(config.getProperty("Supp_Email"));
		driver.findElement(By.name("phone")).sendKeys(config.getProperty("Supp_Phone"));
		driver.findElement(By.name("fax")).sendKeys(config.getProperty("Supp_FaxNum"));
		driver.findElement(By.name("bank_name")).sendKeys(config.getProperty("Supp_BankName"));
		driver.findElement(By.name("acc_number")).sendKeys(config.getProperty("Supp_AccNumber"));
		driver.findElement(By.name("ifsc_code")).sendKeys(config.getProperty("Supp_IFSCCode"));
		driver.findElement(By.name("address")).sendKeys(config.getProperty("Supp_Address"));
		driver.findElement(By.name("comment")).sendKeys(config.getProperty("Supp_Comment"));
		
		Select dropdown = new Select(driver.findElement(By.id("country")));
		dropdown.selectByVisibleText(config.getProperty("Supp_SelCountry"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select dropdownstate = new Select(driver.findElement(By.id("state")));
		dropdownstate.selectByVisibleText(config.getProperty("Supp_SelState"));
		
		driver.findElement(By.name("city")).sendKeys(config.getProperty("Supp_City"));
		driver.findElement(By.name("zipcode")).sendKeys(config.getProperty("Supp_Zipcode"));
		driver.findElement(By.name("add_supplier_btn")).click();
		
		
	}
	
	@AfterClass
	public void logout(){
	
		// driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/nav/div/div/ul/li[2]/a/button")).click();
		// driver.quit();
	}
	
	
}
