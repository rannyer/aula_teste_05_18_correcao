package POM_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By menuCatalog = By.linkText("Catalog");

    private By produtoGreyJacket = By.id("product-4");


    public void abrirPagina(){
        driver.get("https://sauce-demo.myshopify.com/");
    }

    public void clicarCatalog(){
        driver.findElement(menuCatalog).click();
    }

    public void clicarProdutoGreyJacket(){
        wait.until(ExpectedConditions.elementToBeClickable(produtoGreyJacket)).click();

    }


}
