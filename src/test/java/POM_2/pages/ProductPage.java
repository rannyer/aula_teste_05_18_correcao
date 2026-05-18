package POM_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By botaoAddCarrinho = By.id("add");

    private By quantidadeCarrinho = By.id("cart-target-desktop");

    private By nomeProduto = By.cssSelector("h1[itemprop='name'");

    public String obterNomeProduto(){
        return driver.findElement(nomeProduto).getText();
    }

    public void adicionarAoCarrinho(){
        driver.findElement(botaoAddCarrinho).click();
    }
    public void esperarCarrinhoAtualizar(){
        wait.until(ExpectedConditions.not(
                        ExpectedConditions.textToBe(
                                quantidadeCarrinho, "(0)")
                )
        );
    }

    public String obterQuantidadeCarrinho(){
       return driver.findElement(quantidadeCarrinho).getText();

    }











}
