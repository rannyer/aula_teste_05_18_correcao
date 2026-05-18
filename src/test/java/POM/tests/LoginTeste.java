package POM.tests;

import POM.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTeste {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage =  new LoginPage(driver);
    }

    @AfterEach
    void close(){
        driver.quit();
    }
    @Test
    void deveFAzerLoginComSucesso(){
        loginPage.abrirPagina();

        loginPage.preencherUsuario("tomsmith");

        loginPage.preencherSenha("SuperSecretPassword!");

        loginPage.clicarLogin();

        assertTrue(loginPage.obterMensagem().contains("You logged into a secure area!"));
    }
}
