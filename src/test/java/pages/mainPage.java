package pages;

import static org.junit.Assert.assertTrue;

import java.awt.List.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.checkerframework.checker.units.qual.Current;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class mainPage {
	
	protected WebDriver driver;
	
	private ArrayList<Float> inputValues;

//	private By txt_username = By.id("name");
//	
//	private By txt_password = By.id("password");
//	
//	private By btn_login = By.id("login");
//	
//	private By btn_logout = By.id("logout");
	
	 By textValue1 = By.id("//*[@id='txt_val_1']");
	  By textValue2 = By.id("//*[@id='txt_val_2']");
	  By textValue3 = By.id("//*[@id='txt_val_4']");
	  By textValue4 = By.id("//*[@id='txt_val_5']");
	  By textValue5 = By.id("//*[@id='txt_val_6']");
	  String totalBalance = "//*[@id='txt_ttl_5']";
	  public String getTotalBalance() {
		return totalBalance;
	}

	String labelValue1 = "//*[@id='lbl_val_1']";
	  String labelValue2 = "//*[@id='lbl_val_2']";
	  String labelValue3 = "//*[@id='lbl_val_3']";
	  String labelValue4 = "//*[@id='lbl_val_4']";
	  String labelValue5 = "//*[@id='lbl_val_5']";
	  String labeltotalBalance = "//*[@id='lbl_ttl_val']";
	  
	
	public mainPage(WebDriver driver) {
	
		this.driver = driver;
		
	}
	
	
	public void enterValues(String s1,String s2, String s3,String s4, String s5) {
		
		driver.findElement(textValue1).sendKeys(s1);
		driver.findElement(textValue2).sendKeys(s2);
		driver.findElement(textValue3).sendKeys(s3);
		driver.findElement(textValue4).sendKeys(s4);
		driver.findElement(textValue5).sendKeys(s5);
		
      	  inputValues.add(Float.parseFloat(s1.substring(1)));
      	inputValues.add(Float.parseFloat(s2.substring(1)));
      	inputValues.add(Float.parseFloat(s3.substring(1)));
      	inputValues.add(Float.parseFloat(s4.substring(1)));
      	inputValues.add(Float.parseFloat(s5.substring(1)));
      	 
        }
	
	public boolean CheckCurrency(String value)
    {
		char i= value.charAt(0);
		
		Pattern p=Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\.\\d{3})*),\\d{2}$");
		Matcher m=p.matcher(value);
		if (m.matches() && i=='$')return true;
		else return false;
		
    	
    }
	
	
	public ArrayList<Float> getInputValues() {
		return inputValues;
	}


	public void setInputValues(ArrayList<Float> inputValues) {
		this.inputValues = inputValues;
	}


	public float checkTotalSum() {
		float sum=0;
		for(Float i:inputValues)
		{
			sum=sum+i;
		}
		return sum;
	}
	
	public boolean isValPresent(String val) {
		
		List<WebElement> dynamicElement = driver.findElements(By.id("val"));
		return dynamicElement.size() != 0;
		
	
	}
	
	
	
}
