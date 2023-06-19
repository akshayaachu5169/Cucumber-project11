package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutTest {
	public static WebDriver wd;

	@Given("open browser as {string}")
	public void openbrowser(String browser) {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
	}

	@When("enter url as {string}")
	public void enterurl(String url) {
		wd.get(url);
	}

	@And("enter username as {string}")
	public void enterusername(String username) {
		wd.findElement(By.name("username")).sendKeys(username);
	}

	@When("enter password as {string}")
	public void enterpassword(String password) {
		wd.findElement(By.name("password")).sendKeys(password);
	}

	@And("click login button")
	public void clickbutton() {
		wd.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Then("navigate to checkout page as {string}")
	public void checkpage(String checkouturl) {
		wd.get(checkouturl);
	}

	@When("checkout place order with details")
	public void checkoutorder(DataTable table) throws InterruptedException {
		List<List<String>> data = table.asLists();
		for (int i = 0; i < data.size(); i++) {
			wd.findElement(By.id("id0")).sendKeys(data.get(i).get(0));
			wd.findElement(By.id("id1")).sendKeys(data.get(i).get(1));
			wd.findElement(By.id("id2")).sendKeys(data.get(i).get(2));
			wd.findElement(By.id("id3")).sendKeys(data.get(i).get(3));
			wd.findElement(By.id("id4")).sendKeys(data.get(i).get(4));
			wd.findElement(By.id("id5")).sendKeys(data.get(i).get(5));
			wd.findElement(By.id("idyes")).click();
			wd.findElement(By.id("cod")).click();
			wd.findElement(By.id("order")).click();
			Thread.sleep(2000);
		}

	}
	@When("checkout place order with details in map format")
	public void checkoutorder_map(DataTable table) throws InterruptedException {
		List<Map<String,String>> data = table.asMaps();
		for (int i = 0; i < data.size(); i++) {
			wd.findElement(By.id("id0")).sendKeys(data.get(i).get("PRODUCTNAME"));
			wd.findElement(By.id("id1")).sendKeys(data.get(i).get("MOBILE NUM"));
			wd.findElement(By.id("id2")).sendKeys(data.get(i).get("EMAIL"));
			wd.findElement(By.id("id3")).sendKeys(data.get(i).get("PROD CAT"));
			wd.findElement(By.id("id4")).sendKeys(data.get(i).get("PROD QUA"));
			wd.findElement(By.id("id5")).sendKeys(data.get(i).get("PURCHASER NAME"));
			wd.findElement(By.id("idyes")).click();
			wd.findElement(By.id("cod")).click();
			wd.findElement(By.id("order")).click();
			Thread.sleep(2000);
		}

	}
	@And("logout")
	public void logout() {
		wd.findElement(By.linkText("Logout")).click();
	}
}
